package dao.jdbc.impl;

import dao.connections.PoolConnection;
import dao.domain.misc.Prescription;
import dao.interfaces.IPrescriptionDAO;
import jaxb.model.MedicalStaff;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrescriptionDAO extends AbstractJdbcDAO implements IPrescriptionDAO {
    private static final Logger logger = Logger.getLogger(OperationDAO.class);

    private final static String SQL_INSERT =    "INSERT INTO Prescriptions(details) VALUES(?)";
    private final static String SQL_UPDATE =    "UPDATE Prescriptions SET details WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Prescriptions WHERE id = ?";
    private final static String SQL_DELETE =    "DELETE FROM Prescriptions WHERE id = ?";

    public PrescriptionDAO() {}

    @Override
    public void save(Prescription prescription) throws SQLException {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, prescription.getDetails());

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
    public void update(Prescription prescription) throws SQLException{
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, prescription.getDetails());
            ps.setLong(2, prescription.getId());

            logger.info("The patient "+ prescription.toString() + " has been updated");
            logger.debug("Query been executed " + SQL_UPDATE);
            ps.executeUpdate();
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
        Prescription prescription = null;

        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_GET_BY_ID);
            logger.debug("Query been executed " + SQL_GET_BY_ID);
            rs = ps.executeQuery();

            prescription = new Prescription();
            prescription.setId(rs.getLong("id"));
            prescription.setDetails(rs.getString("reason"));

            logger.info(prescription.toString());
        } finally{
            if (conn != null)
                conn.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();

        }

        return prescription;
    }
    @Override
    public void delete(Prescription prescription) throws SQLException{
        java.sql.Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            logger.debug("Query been executed " + SQL_DELETE);

            logger.info(prescription.toString() + " deleted");
            ps.setLong(1, prescription.getId());
            ps.executeUpdate();
        } finally {
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }
}
