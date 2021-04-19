package com.solvd.hospital.generics;

import java.util.Date;

public class Appointment<D,P> {
    private D doctor;
    private P patient;
    private Date date;

    public Appointment(D doctor, P patient, Date date){
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    public D getDoctor() {
        return doctor;
    }

    public void setDoctor(D doctor) {
        this.doctor = doctor;
    }

    public P getPatient() {
        return patient;
    }

    public void setPatient(P patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "doctor=" + doctor +
                ", patient=" + patient +
                ", date=" + date +
                '}';
    }
}
