package com.solvd.hospital.models;

public class Medicine {

    private String name;

    public Medicine(){}

    public Medicine(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
