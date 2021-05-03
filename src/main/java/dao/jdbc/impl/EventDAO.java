package dao.jdbc.impl;

import dao.connections.DBConnection;
import dao.domain.misc.EventDTO;
import dao.interfaces.IEventDAO;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventDAO extends AbstractJdbcDAO implements IEventDAO {
    private static final Logger logger = Logger.getLogger(EventDAO.class);

    private DBConnection conn;

    private final static String SQL_INSERT =    "INSERT INTO Events(reason) VALUES(?)";
    private final static String SQL_UPDATE =    "UPDATE Events SET reason=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Events WHERE id = ?";
    private final static String SQL_DELETE =    "DELETE FROM Events WHERE id = ?";

    public EventDAO() {}

    public EventDAO(DBConnection conn){
        this.conn = conn;
    }

    @Override
    public void save(EventDTO eventDTO) throws SQLException {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, eventDTO.getReason());

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
    public void update(EventDTO eventDTO) throws SQLException{
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, eventDTO.getReason());
            ps.setLong(2, eventDTO.getId());

            logger.info("The patient "+ eventDTO.toString() + " has been updated");
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
    public EventDTO getById(long id) throws SQLException {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        EventDTO eventDTO;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_GET_BY_ID);
            logger.debug("Query been executed " + SQL_GET_BY_ID);
            rs = ps.executeQuery();

            eventDTO = new EventDTO();
            eventDTO.setId(rs.getLong("id"));
            eventDTO.setReason(rs.getString("reason"));

            logger.info(eventDTO.toString());
        }finally{
            if (conn != null)
                conn.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();

        }

        return eventDTO;
    }
    @Override
    public void delete(EventDTO eventDTO) throws SQLException{
        java.sql.Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            logger.debug("Query been executed " + SQL_DELETE);

            logger.info(eventDTO.toString() + " deleted");
            ps.setLong(1, eventDTO.getId());
            ps.executeUpdate();
        } finally {
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }
}
