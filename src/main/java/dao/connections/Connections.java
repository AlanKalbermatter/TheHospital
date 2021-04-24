package dao.connections;

import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import java.sql.*;

public class Connections {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "root";
    private static BasicDataSource dataSource;
    public static DataSource getDataSource(){
        if (dataSource == null) {
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASS);
            //define the size of the poolConnection
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
        }
    }

    public static void close(PreparedStatement ps){
        try {
            ps.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
