package com.solvd.hospital.connections;

import org.apache.log4j.Logger;

public class ThreadConnection {
    private int threadId;
    private ConnectionPool cp;
    private Logger logger = Logger.getLogger(ThreadConnection.class);

    public ThreadConnection() {}

    public ThreadConnection(int threadId, ConnectionPool pool) {
        this.threadId = threadId;
        this.cp = pool;
    }

    public void run() {
        Connection connection = null;
        try {
            connection = cp.getConnection();
        } catch (InterruptedException exception) {
            logger.error("Thread number " + threadId + "cant get one connection",exception);
        }

        logger.info("Thread number"+ threadId + "take a connection " + connection);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException exception) {
            logger.warn("Time out");
        }

        cp.add(connection);
        logger.info("The connection " + connection + " has been added");
    }
}
