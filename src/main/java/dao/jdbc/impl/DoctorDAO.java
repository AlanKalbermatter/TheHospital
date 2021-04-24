package dao.jdbc.impl;

import dao.connections.Connections;
import dao.domain.Doctor;
import dao.interfaces.IDoctorDAO;
import dao.jdbc.AbstractJdbcDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorDAO extends AbstractJdbcDAO implements IDoctorDAO {

    private static final Logger logger = Logger.getLogger(DoctorDAO.class);

    private Connection transactionalConnection;

    private final static String SQL_INSERT =    "INSERT INTO doctors(name, specialty) VALUES(?, ?)";
    private final static String SQL_UPDATE =    "UPDATE doctors SET name=?, specialty=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM doctors WHERE id = ?";
    private final static String SQL_DELETE =    "DELETE FROM doctors WHERE id = ?";

    public void save(Doctor doctor) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.transactionalConnection != null ? this.transactionalConnection : Connections.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1,doctor.getName());
            ps.setString(2,doctor.getSpecialty());

            logger.debug("Query been executed " + SQL_INSERT);
            ps.executeUpdate();
        }finally{
            if(this.transactionalConnection == null){
                Connections.close(conn);
            }
            if(ps != null)
                ps.close();
            if(conn != null)
                conn.close();
        }
    }

    @Override
    public void update(Doctor doctor) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.transactionalConnection != null ? this.transactionalConnection : Connections.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1,doctor.getName());
            ps.setString(2,doctor.getSpecialty());
            ps.setLong(3, doctor.getId());

            logger.debug("Query been executed " + SQL_UPDATE);
            ps.executeUpdate();
            logger.info("The doctor "+ doctor.toString() + " has been updated");
        }finally{
            if(this.transactionalConnection == null){
                Connections.close(conn);
            }
            if(ps != null)
                ps.close();
            if(conn != null)
                conn.close();
        }
    }

    @Override
    public Doctor getById(long id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Doctor doctor;

        try {
            conn = this.transactionalConnection != null ? this.transactionalConnection : Connections.getConnection();
            ps = conn.prepareStatement(SQL_GET_BY_ID);
            logger.debug("Query been executed " + SQL_GET_BY_ID);
            rs = ps.executeQuery();

            doctor = new Doctor();
            doctor.setId(rs.getLong("id"));
            doctor.setName(rs.getString("name"));

            logger.info(doctor.toString());
        }finally{
            if (this.transactionalConnection == null) {
                Connections.close(conn);
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

        return doctor;
    }
    @Override
    public void delete(Doctor doctor) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = this.transactionalConnection != null ? this.transactionalConnection : Connections.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            logger.debug("Query been executed " + SQL_DELETE);

            logger.info(doctor.toString() + " deleted");
            ps.setLong(1, doctor.getId());
            ps.executeUpdate();
        } finally {
            if(this.transactionalConnection == null){
                Connections.close(conn);
            }
            if(ps != null)
                ps.close();
            if(conn != null)
                conn.close();
        }
    }
}
