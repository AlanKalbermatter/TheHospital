package dao.jdbc.impl;

import dao.connections.PoolConnection;
import dao.domain.misc.Bed;
import dao.interfaces.IBedDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BedDAO extends AbstractJdbcDAO implements IBedDAO {
    private static final Logger logger = Logger.getLogger(PatientDAO.class);


    private final static String SQL_INSERT =    "INSERT INTO Beds(room_number) VALUES(?)";
    private final static String SQL_UPDATE =    "UPDATE Beds SET room_number=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Beds WHERE id = ?";
    private final static String SQL_DELETE =    "DELETE FROM Beds WHERE id = ?";

    public BedDAO(){}

    @Override
    public void save(Bed bed) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, bed.getRoomNumber());
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
    public void update(Bed bed) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setInt(1, bed.getRoomNumber());
            ps.setLong(2, bed.getId());

            logger.debug("Query been executed " + SQL_UPDATE);
            ps.executeUpdate();
            logger.info("The patient "+ bed.toString() + " has been updated");
        } finally{
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }

    @Override
    public Bed getById(long id) throws SQLException {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Bed bed = null;

        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_GET_BY_ID);
            logger.debug("Query been executed " + SQL_GET_BY_ID);
            rs = ps.executeQuery();

            bed = new Bed();
            bed.setId(rs.getLong("id"));
            bed.setRoomNumber(rs.getInt("room_number"));

            logger.info(bed.toString());
        } finally{
            if(conn != null)
                conn.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();

        }

        return bed;
    }
    @Override
    public void delete(Bed bed) throws SQLException{
        java.sql.Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = PoolConnection.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            logger.debug("Query been executed " + SQL_DELETE);

            ps.setLong(1, bed.getId());
            ps.executeUpdate();
            logger.info(bed.toString() + " deleted");
        } finally {
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }
}