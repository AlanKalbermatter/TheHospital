//package com.solvd.hospital.connections;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.PriorityBlockingQueue;
//
//public class ConnectionPool {
//    private List<Connection> connectionPool;
//    private List<Connection> usedConnections = new ArrayList<>();
//    private int connectionsCounter;
//    private static ConnectionPool singleton = null;
//    private BlockingQueue<Connection> connections;
//    private static int poolSize;
//
//
//    public ConnectionPool(int poolSize){
//        this.poolSize = poolSize;
//        connectionsCounter = 0;
//        connections = new PriorityBlockingQueue<>();
//    }
//
//    public static ConnectionPool ConnectionPool(int poolSizeo){
//        if(singleton == null){
//            singleton = new ConnectionPool(poolSize);
//        }
//        return singleton;
//    }
//
////    public void returnConnection(Connection conn){
////        connections.add(conn);
////    }
//
////    public Connection getConnection() throws InterruptedException{
////        synchronized(this){
////            if (connections.size() == 0 && conn)
////        }
////        return connections.take();}
////
////}
