package dao.jdbc.impl;

import dao.connections.PoolConnection;
import dao.domain.misc.MedicalInsurance;
import dao.interfaces.IMedicalInsuranceDAO;
import jaxb.model.MedicalStaff;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicalInsuranceDAO extends AbstractJdbcDAO implements IMedicalInsuranceDAO {
    private static final Logger logger = Logger.getLogger(EventDAO.class);

    private final static String SQL_INSERT =    "INSERT INTO Medical_insurances(partner_name, ssn) VALUES(?, ?)";
    private final static String SQL_UPDATE =    "UPDATE Medical_insurances SET partner_name=?, ssn=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Medical_insurances WHERE id = ?";
    private final static String SQL_DELETE =    "DELETE FROM Medical_insurances WHERE id = ?";

    public MedicalInsuranceDAO() {}

    @Override
    public void save(MedicalInsurance mi) throws SQLException {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, mi.getPartnerName());
            ps.setInt(2, mi.getSsn());

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
    public void update(MedicalInsurance mi) throws SQLException{
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, mi.getPartnerName());
            ps.setInt(2, mi.getSsn());

            logger.info("The Medical insurance "+ mi.toString() + " has been updated");
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
        MedicalInsurance mi = null;

        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_GET_BY_ID);
            logger.debug("Query been executed " + SQL_GET_BY_ID);
            rs = ps.executeQuery();

            mi = new MedicalInsurance();
            mi.setId(rs.getLong("id"));
            mi.setPartnerName(rs.getString("partner_name"));
            mi.setSsn(rs.getInt("ssn"));
            logger.info(mi.toString());
        } finally{
            if (conn != null)
                conn.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();

        }

        return mi;
    }
    @Override
    public void delete(MedicalInsurance mi) throws SQLException{
        java.sql.Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            logger.debug("Query been executed " + SQL_DELETE);

            logger.info(mi.toString() + " deleted");
            ps.setLong(1, mi.getId());
            ps.executeUpdate();
        } finally {
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }
}
