package com.solvd.hospital.models.building;

import com.solvd.hospital.models.people.Patient;

import java.util.ArrayList;

public class Reception
        extends Room {

    private ArrayList<Patient> patients;


    public Reception(ArrayList<Patient> patients){
        this.patients = patients;
    }
    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }
}
