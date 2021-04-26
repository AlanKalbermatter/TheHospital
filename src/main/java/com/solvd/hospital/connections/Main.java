package com.solvd.hospital.connections;

import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main{
    private static final Logger logger = Logger.getLogger(Main.class);
    int POOL_SIZE = 5;
    private final static Integer EXEC = 6;
    private static int count = 1;
    private final static ConnectionPool cp = ConnectionPool.getInstance();


    public static void main(String[] args) {
        ExecutorService connectionsExecutor = Executors.newFixedThreadPool(EXEC);

        IntStream
                .range(0,EXEC)
                .forEach(e -> {
                                        logger.info("A thread is executing a new RunnableConnection");
                                        connectionsExecutor.execute(new RunnableConnection(count, cp));
                                        count++;
                });
        count = 1;
    }
}