package dao.jdbc.impl;

import dao.connections.DBConnection;
import dao.domain.people.PatientDTO;
import dao.interfaces.IPatientDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDAO extends AbstractJdbcDAO implements IPatientDAO{
    private static final Logger logger = Logger.getLogger(PatientDAO.class);

    private Connection conn;

    private final static String SQL_INSERT =    "INSERT INTO patient(name, last_name, symptom) VALUES(?, ?, ?)";
    private final static String SQL_UPDATE =    "UPDATE patient SET name=?, last_name=?, symptom=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Patients WHERE id = ?";
    private final static String SQL_DELETE =    "DELETE FROM Patients WHERE id = ?";

    public PatientDAO(){}

    public PatientDAO(DBConnection conn) throws SQLException {
        this.conn = conn.getConnection();
    }


    @Override
    public void save(PatientDTO patientDTO) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //  if the object of transactionalConnection is different of null, then utilize transactionalConnection,
            //  else get a new connection from the pool
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, patientDTO.getName());
            ps.setString(2, patientDTO.getLastName());
            ps.setString(3, patientDTO.getSymptom());

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
    public void update(PatientDTO patientDTO) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, patientDTO.getName());
            ps.setString(2, patientDTO.getLastName());
            ps.setString(3, patientDTO.getSymptom());
            ps.setLong(4, patientDTO.getId());

            logger.debug("Query been executed " + SQL_UPDATE);
            ps.executeUpdate();
            logger.info("The patient "+ patientDTO.toString() + " has been updated");
        }finally{
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }

    @Override
    public PatientDTO getById(long id) throws SQLException {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PatientDTO patientDTO;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_GET_BY_ID);
            logger.debug("Query been executed " + SQL_GET_BY_ID);
            rs = ps.executeQuery();

            patientDTO = new PatientDTO();
            patientDTO.setId(rs.getLong("id"));
            patientDTO.setName(rs.getString("name"));
            patientDTO.setLastName(rs.getString("last_name"));
            patientDTO.setSymptom(rs.getString("symptom"));

            logger.info(patientDTO.toString());
        }finally{
            if(conn != null)
                conn.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();

        }

        return patientDTO;
    }
    @Override
    public void delete(PatientDTO patientDTO) throws SQLException{
        java.sql.Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            logger.debug("Query been executed " + SQL_DELETE);

            ps.setLong(1, patientDTO.getId());
            ps.executeUpdate();
            logger.info(patientDTO.toString() + " deleted");
        } finally {
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }
}
