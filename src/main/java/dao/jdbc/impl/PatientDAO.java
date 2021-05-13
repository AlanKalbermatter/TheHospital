package dao.jdbc.impl;

import dao.connections.PoolConnection;
import dao.domain.people.Patient;
import dao.interfaces.IPatientDAO;
import jaxb.model.MedicalStaff;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDAO extends AbstractJdbcDAO implements IPatientDAO{
    private static final Logger logger = Logger.getLogger(PatientDAO.class);

    private final static String SQL_INSERT =    "INSERT INTO patient(name, last_name, symptom) VALUES(?, ?, ?)";
    private final static String SQL_UPDATE =    "UPDATE patient SET name=?, last_name=?, symptom=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Patients WHERE id = ?";
    private final static String SQL_DELETE =    "DELETE FROM Patients WHERE id = ?";

    public PatientDAO(){}

    @Override
    public void save(Patient patient) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getLastName());
            ps.setString(3, patient.getSymptom());

            logger.debug("Query been executed " + SQL_INSERT);
            ps.executeUpdate();
        } finally{
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }

    @Override
    public void update(Patient patient) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getLastName());
            ps.setString(3, patient.getSymptom());
            ps.setLong(4, patient.getId());

            logger.debug("Query been executed " + SQL_UPDATE);
            ps.executeUpdate();
            logger.info("The patient "+ patient.toString() + " has been updated");
        } finally{
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }

    @Override
    public MedicalStaff getById(long id) throws SQLException {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Patient patient = null;

        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_GET_BY_ID);
            logger.debug("Query been executed " + SQL_GET_BY_ID);
            rs = ps.executeQuery();

            patient = new Patient();
            patient.setId(rs.getLong("id"));
            patient.setName(rs.getString("name"));
            patient.setLastName(rs.getString("last_name"));
            patient.setSymptom(rs.getString("symptom"));

            logger.info(patient.toString());
        } finally{
            if(conn != null)
                conn.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();

        }

        return patient;
    }
    @Override
    public void delete(Patient patient) throws SQLException{
        java.sql.Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            logger.debug("Query been executed " + SQL_DELETE);

            ps.setLong(1, patient.getId());
            ps.executeUpdate();
            logger.info(patient.toString() + " deleted");
        } finally {
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }
}
