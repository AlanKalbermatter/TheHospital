package dao.jdbc.impl;

import dao.connections.DBConnection;
import dao.domain.OperationDTO;
import dao.interfaces.IOperationDAO;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OperationDAO extends AbstractJdbcDAO implements IOperationDAO{
    private static final Logger logger = Logger.getLogger(OperationDAO.class);

    private DBConnection conn;

    private final static String SQL_INSERT =    "INSERT INTO patient(name, last_name, reason) VALUES(?, ?, ?)";
    private final static String SQL_UPDATE =    "UPDATE patient SET name=?, last_name=?, reason=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Patients WHERE id = ?";
    private final static String SQL_DELETE =    "DELETE FROM patient WHERE id = ?";

    public OperationDAO() {}

    public OperationDAO(DBConnection conn){
        this.conn = conn;
    }

    @Override
    public void save(OperationDTO operationDTO) throws SQLException {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setDate(1, operationDTO.getDate());
            ps.setString(2, operationDTO.getReason());

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
    public void update(OperationDTO operationDTO) throws SQLException{
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setDate(1, operationDTO.getDate());
            ps.setString(2, operationDTO.getReason());
            ps.setLong(3, operationDTO.getId());

            logger.info("The patient "+ operationDTO.toString() + " has been updated");
            logger.debug("Query been executed " + SQL_UPDATE);
            ps.executeUpdate();
        }finally{
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }

    @Override
    public OperationDTO getById(long id) throws SQLException {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        OperationDTO operationDTO;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_GET_BY_ID);
            logger.debug("Query been executed " + SQL_GET_BY_ID);
            rs = ps.executeQuery();

            operationDTO = new OperationDTO();
            operationDTO.setId(rs.getLong("id"));
            operationDTO.setDate(rs.getDate("date"));
            operationDTO.setReason(rs.getString("reason"));

            logger.info(operationDTO.toString());
        }finally{
            if (conn != null)
                conn.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();

        }

        return operationDTO;
    }
    @Override
    public void delete(OperationDTO operationDTO) throws SQLException{
        java.sql.Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            logger.debug("Query been executed " + SQL_DELETE);

            logger.info(operationDTO.toString() + " deleted");
            ps.setLong(1, operationDTO.getId());
            ps.executeUpdate();
        } finally {
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }
}
