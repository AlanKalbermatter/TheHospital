package dao.connections;

import dao.MainJDBC;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;

public class DBConnection {

    private static final Logger logger = Logger.getLogger(MainJDBC.class);

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "root";
    private static BasicDataSource dataSource;

    public static DataSource getDataSource(){
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASS);
            dataSource.setInitialSize(5);
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
            logger.error(exception);
        }
    }

    public static void close(PreparedStatement ps){
        try {
            ps.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
            logger.error(exception);
        }
    }

    public static void close(java.sql.Connection conn){
        try {
            conn.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
            logger.error(exception);
        }
    }
}