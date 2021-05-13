package dao.jdbc.impl;

import dao.connections.PoolConnection;
import dao.domain.misc.Event;
import dao.interfaces.IEventDAO;
import jaxb.model.MedicalStaff;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventDAO extends AbstractJdbcDAO implements IEventDAO {
    private static final Logger logger = Logger.getLogger(EventDAO.class);


    private final static String SQL_INSERT =    "INSERT INTO Events(reason) VALUES(?)";
    private final static String SQL_UPDATE =    "UPDATE Events SET reason=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Events WHERE id = ?";
    private final static String SQL_DELETE =    "DELETE FROM Events WHERE id = ?";

    public EventDAO() {}

    @Override
    public void save(Event event) throws SQLException {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, event.getReason());

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
    public void update(Event event) throws SQLException{
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, event.getReason());
            ps.setLong(2, event.getId());

            logger.info("The patient "+ event.toString() + " has been updated");
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
        Event event = null;

        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_GET_BY_ID);
            logger.debug("Query been executed " + SQL_GET_BY_ID);
            rs = ps.executeQuery();

            event = new Event();
            event.setId(rs.getLong("id"));
            event.setReason(rs.getString("reason"));

            logger.info(event.toString());
        } finally{
            if (conn != null)
                conn.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();

        }

        return event;
    }
    @Override
    public void delete(Event event) throws SQLException{
        java.sql.Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            logger.debug("Query been executed " + SQL_DELETE);

            logger.info(event.toString() + " deleted");
            ps.setLong(1, event.getId());
            ps.executeUpdate();
        } finally {
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }
}
