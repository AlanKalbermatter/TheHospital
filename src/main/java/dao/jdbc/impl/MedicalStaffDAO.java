package dao.jdbc.impl;

import dao.connections.DBConnection;
import dao.domain.people.MedicalStaffDTO;
import dao.interfaces.IMedicalStaffDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicalStaffDAO extends AbstractJdbcDAO implements IMedicalStaffDAO {
    private static final Logger logger = Logger.getLogger(MedicalStaffDAO.class);

    private Connection conn;

    private final static String SQL_INSERT =    "INSERT INTO Medical_staff(name, specialty) VALUES(?, ?)";
    private final static String SQL_UPDATE =    "UPDATE Medical_staff SET name=?, specialty=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Medical_staff WHERE id = ?";
    private final static String SQL_DELETE =    "DELETE FROM Medical_staff WHERE id = ?";

    public MedicalStaffDAO(){}

    public MedicalStaffDAO(DBConnection conn) throws SQLException {
        this.conn = conn.getConnection();
    }


    @Override
    public void save(MedicalStaffDTO ms) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, ms.getName());
            ps.setString(1, ms.getSpecialty());
            logger.debug("Query been executed " + SQL_INSERT);
            ps.executeUpdate();
        }finally{
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }

    @Override
    public void update(MedicalStaffDTO ms) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, ms.getName());
            ps.setString(2, ms.getSpecialty());
            ps.setLong(3, ms.getId());

            logger.debug("Query been executed " + SQL_UPDATE);
            ps.executeUpdate();
            logger.info("The medical staff "+ ms.toString() + " has been updated");
        }finally{
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }

    @Override
    public MedicalStaffDTO getById(long id) throws SQLException {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MedicalStaffDTO ms;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_GET_BY_ID);
            logger.debug("Query been executed " + SQL_GET_BY_ID);
            rs = ps.executeQuery();

            ms = new MedicalStaffDTO();
            ms.setId(rs.getLong("id"));
            ms.setName(rs.getString("name"));
            ms.setSpecialty(rs.getString("specialty"));

            logger.info(ms.toString());
        }finally{
            if(conn != null)
                conn.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();

        }

        return ms;
    }
    @Override
    public void delete(MedicalStaffDTO ms) throws SQLException{
        java.sql.Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            logger.debug("Query been executed " + SQL_DELETE);

            ps.setLong(1, ms.getId());
            ps.executeUpdate();
            logger.info(ms.toString() + " deleted");
        } finally {
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }
}
