//package com.solvd.hospital.connections;
//
//public class Connection {
//    private int poolSize;
//    private DBConnection dataBase;
//
//    public Connection(){}
//
//    public Connection(int poolSize){
//        this.dataBase = new DataBase();
//        this.number = poolSize;
//    }
//
//    public String excueteDML(String stmt){
//        if(stmt.toLowerCase().contains("insert")){
//            dataBase.insert("something", "insert executed");
//            return "Operation completed";
//        }else{
//            return dataBase.select("something");
//        }
//    }
//
//    public void setPoolSize(int poolSize) {
//        this.poolSize = poolSize;
//    }
//
//    public int getPoolSize(){
//        return poolSize;
//    }
//}
