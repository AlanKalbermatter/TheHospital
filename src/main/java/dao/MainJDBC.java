package dao;

import dao.connections.PoolConnection;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.Connection;
import java.sql.SQLException;

public class MainJDBC {
    private static final Logger logger = Logger.getLogger(MainJDBC.class);

    public static void main(String[] args) throws SQLException {

        PropertyConfigurator.configure("/home/kalber/workspace/HospitalModelWithMvn/src/main/resources/log4j2.properties");
        Connection conn = null;
        try {
            conn = PoolConnection.getConnection();
            logger.info(conn);
        }
        catch(SQLException ex){
            logger.error(ex.getMessage());
        }
    }
}
