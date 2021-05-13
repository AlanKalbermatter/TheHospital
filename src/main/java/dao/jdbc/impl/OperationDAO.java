package dao.jdbc.impl;

import dao.connections.PoolConnection;
import dao.domain.misc.Operation;
import dao.interfaces.IOperationDAO;
import jaxb.model.MedicalStaff;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OperationDAO extends AbstractJdbcDAO implements IOperationDAO{
    private static final Logger logger = Logger.getLogger(OperationDAO.class);

    private final static String SQL_INSERT =    "INSERT INTO patient(name, last_name, reason) VALUES(?, ?, ?)";
    private final static String SQL_UPDATE =    "UPDATE patient SET name=?, last_name=?, reason=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Patients WHERE id = ?";
    private final static String SQL_DELETE =    "DELETE FROM patient WHERE id = ?";

    public OperationDAO() {}

    @Override
    public void save(Operation operation) throws SQLException {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setDate(1, operation.getDate());
            ps.setString(2, operation.getReason());

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
    public void update(Operation operation) throws SQLException{
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setDate(1, operation.getDate());
            ps.setString(2, operation.getReason());
            ps.setLong(3, operation.getId());

            logger.info("The patient "+ operation.toString() + " has been updated");
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
        Operation operation = null;

        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_GET_BY_ID);
            logger.debug("Query been executed " + SQL_GET_BY_ID);
            rs = ps.executeQuery();

            operation = new Operation();
            operation.setId(rs.getLong("id"));
            operation.setDate(rs.getDate("date"));
            operation.setReason(rs.getString("reason"));

            logger.info(operation.toString());
        } finally{
            if (conn != null)
                conn.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();

        }

        return operation;
    }
    @Override
    public void delete(Operation operation) throws SQLException{
        java.sql.Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            logger.debug("Query been executed " + SQL_DELETE);

            logger.info(operation.toString() + " deleted");
            ps.setLong(1, operation.getId());
            ps.executeUpdate();
        } finally {
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }
}
