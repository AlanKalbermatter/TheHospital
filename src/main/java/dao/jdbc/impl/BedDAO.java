package dao.jdbc.impl;

import dao.connections.DBConnection;
import dao.domain.misc.BedDTO;
import dao.interfaces.IBedDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BedDAO extends AbstractJdbcDAO implements IBedDAO {
    private static final Logger logger = Logger.getLogger(PatientDAO.class);

    private Connection conn;

    private final static String SQL_INSERT =    "INSERT INTO Beds(room_number) VALUES(?)";
    private final static String SQL_UPDATE =    "UPDATE Beds SET room_number=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Beds WHERE id = ?";
    private final static String SQL_DELETE =    "DELETE FROM Beds WHERE id = ?";

    public BedDAO(){}

    public BedDAO(DBConnection conn) throws SQLException {
        this.conn = conn.getConnection();
    }


    @Override
    public void save(BedDTO bedDTO) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //  if the object of transactionalConnection is different of null, then utilize transactionalConnection,
            //  else get a new connection from the pool
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, bedDTO.getRoomNumber());
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
    public void update(BedDTO bedDTO) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setInt(1, bedDTO.getRoomNumber());
            ps.setLong(2, bedDTO.getId());

            logger.debug("Query been executed " + SQL_UPDATE);
            ps.executeUpdate();
            logger.info("The patient "+ bedDTO.toString() + " has been updated");
        }finally{
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }

    @Override
    public BedDTO getById(long id) throws SQLException {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        BedDTO bedDTO;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_GET_BY_ID);
            logger.debug("Query been executed " + SQL_GET_BY_ID);
            rs = ps.executeQuery();

            bedDTO = new BedDTO();
            bedDTO.setId(rs.getLong("id"));
            bedDTO.setRoomNumber(rs.getInt("room_number"));

            logger.info(bedDTO.toString());
        }finally{
            if(conn != null)
                conn.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();

        }

        return bedDTO;
    }
    @Override
    public void delete(BedDTO bedDTO) throws SQLException{
        java.sql.Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            logger.debug("Query been executed " + SQL_DELETE);

            ps.setLong(1, bedDTO.getId());
            ps.executeUpdate();
            logger.info(bedDTO.toString() + " deleted");
        } finally {
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }
}
