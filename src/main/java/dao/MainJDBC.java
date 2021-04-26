package dao;

import dao.connections.DBConnection;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.SQLException;

public class MainJDBC {
    private static final Logger logger = Logger.getLogger(MainJDBC.class);

    public static void main(String[] args) throws SQLException {
        PropertyConfigurator.configure("/home/kalber/workspace/HospitalModelWithMvn/src/main/resources/log4j2.properties");
        DBConnection conn = null;
//        try {
//            conn = DBConnection.getConnection();
//            if (conn.getAutoCommit()) {
//                conn.setAutoCommit(false);
//            }

            logger.info(conn);
    }
}
