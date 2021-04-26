package dao.jdbc.impl;

import com.solvd.hospital.connections.ConnectionPool;

public class AbstractJdbcDAO {

    private static ConnectionPool cp = ConnectionPool.getInstance();

    public AbstractJdbcDAO() {
        cp = ConnectionPool.getInstance();
    }

    public ConnectionPool getConnectionPool() {
        return cp;
    }
}
