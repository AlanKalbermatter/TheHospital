package com.solvd.hospital.connections;

import org.apache.log4j.Logger;

public class Connection {
    private static final Logger logger = Logger.getLogger(Connection.class);
    private int id;

    public Connection(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void doSomething() throws InterruptedException {
        logger.info("Connection " + id + " is executing");
        wait(2000);
    }

    public void closeConnection() throws InterruptedException {
        logger.info("Releasing connection");
        ConnectionPool
                .getInstance()
                .freeConnection(this);
    }
}
