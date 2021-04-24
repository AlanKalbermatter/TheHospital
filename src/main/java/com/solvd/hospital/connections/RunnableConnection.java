package com.solvd.hospital.connections;

import org.apache.log4j.Logger;

public class RunnableConnection implements Runnable{
    private static final Logger logger = Logger.getLogger(RunnableConnection.class);
    private final ConnectionPool cp;
    private final int id;

    public RunnableConnection(int id, ConnectionPool cp){
        this.id = id;
        this.cp = cp;
        logger.info(this.toString() + " initialized");
    }

    public void run(){
        Connection conn = null;

        try {
            logger.info(this.toString() + " is taking a connection");
            conn = cp.getConnection();

            conn.doSomething();

            logger.info(this.toString() + " is placing back the connection " + conn.getId());
            cp.backConnection(conn);

        } catch (InterruptedException e) {
            logger.info(this.toString() + " Failed to get a connection: " + e);
        }
    }

    public int getId() {
        return id;
    }

    public ConnectionPool getCp() {
        return cp;
    }

    @Override
    public String toString(){
        return "RunnableConnection " + id;
    }
}
