package com.solvd.hospital.connections;

import org.apache.log4j.Logger;

import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private static final Logger logger = Logger.getLogger(ConnectionPool.class);
    private static ConnectionPool connectionPool;
    private static final int MAX_CONNECTION_SIZE = 5;
    private static LinkedBlockingQueue<Connection> connections;
    private static int connectionCount = 0;

    private ConnectionPool(){
        connections = new LinkedBlockingQueue<Connection>(MAX_CONNECTION_SIZE);
    }

    public static ConnectionPool getInstance(){
        if (connectionPool == null){
            connectionPool = new ConnectionPool();
            logger.info("ConnectionPool initialization started");
        }
        logger.info("Returning ConnectionPool");
        return connectionPool;
    }

    private synchronized void newConnection(){
        logger.info("A new connection is being created with a number of: " + connectionCount);
        connections
                .add(new Connection(connectionCount));
        connectionCount++;
    }

    public Connection getConnection() throws InterruptedException {
        if (connectionCount < MAX_CONNECTION_SIZE){
            newConnection();
        }
        return connections.take();
    }


    public void add(Connection conn){
        connections.offer(conn);
    }
    public void freeConnection(Connection connection) throws InterruptedException {
        connections.put(connection);
    }
    public void backConnection(Connection connection){
        connections.offer(connection);
    }
    public static Integer getMaxConnectionsSize(){
        return MAX_CONNECTION_SIZE;
    }

    public void closeConnections(){
        connections.forEach(conn -> {
            try {
                conn.closeConnection();
            } catch (InterruptedException exception) {
                logger.warn("an error happened when the connection was closing", exception);
            }
        });
        connections = new LinkedBlockingQueue<Connection>(MAX_CONNECTION_SIZE);
        connectionCount = 0;
    }


}
