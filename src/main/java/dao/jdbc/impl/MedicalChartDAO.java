package dao.jdbc.impl;

import dao.connections.DBConnection;
import dao.domain.MedicalChartDTO;
import dao.interfaces.IMedicalChartDAO;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicalChartDAO extends AbstractJdbcDAO implements IMedicalChartDAO {
    private static final Logger logger = Logger.getLogger(MedicalChartDAO.class);

    private DBConnection conn;

    private final static String SQL_INSERT =    "INSERT INTO Medical_charts(history) VALUES(?)";
    private final static String SQL_UPDATE =    "UPDATE Medical_charts SET history=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Medical_charts WHERE id = ?";
    private final static String SQL_DELETE =    "DELETE FROM Medical_charts WHERE id = ?";

    public MedicalChartDAO() {}

    public MedicalChartDAO(DBConnection conn){
        this.conn = conn;
    }

    @Override
    public void save(MedicalChartDTO mc) throws SQLException {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, mc.getHistory());

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
    public void update(MedicalChartDTO mc) throws SQLException{
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, mc.getHistory());
            ps.setLong(2, mc.getId());

            logger.info("The Medical chart " + mc.toString() + " has been updated");
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
    public MedicalChartDTO getById(long id) throws SQLException {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MedicalChartDTO mc;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_GET_BY_ID);
            logger.debug("Query been executed " + SQL_GET_BY_ID);
            rs = ps.executeQuery();

            mc = new MedicalChartDTO();
            mc.setId(rs.getLong("id"));
            mc.setHistory(rs.getString("history"));

            logger.info(mc.toString());
        }finally{
            if (conn != null)
                conn.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();

        }

        return mc;
    }
    @Override
    public void delete(MedicalChartDTO mc) throws SQLException{
        java.sql.Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            logger.debug("Query been executed " + SQL_DELETE);

            logger.info(mc.toString() + " deleted");
            ps.setLong(1, mc.getId());
            ps.executeUpdate();
        } finally {
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }
}
