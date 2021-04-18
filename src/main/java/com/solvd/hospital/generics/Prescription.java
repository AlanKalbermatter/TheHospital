package com.solvd.hospital.generics;

import java.util.Date;

public class Prescription<T>{
    private Date date;
    private T drugName;

    public Prescription(){}
    
    public Prescription(Date date, T drugName){
        this.date = date;
        this.drugName = drugName;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public T getDrugName() {
        return drugName;
    }

    public void setDrugName(T drugName) {
        this.drugName = drugName;
    }
}
