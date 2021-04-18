package com.solvd.hospital.models.building;

public abstract class Room {
    private String name;
    private String[] medicalStaff;
    private String patient;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getMedicalStaff() {
        return medicalStaff;
    }

    public void setMedicalStaff(String[] medicalStaff) {
        this.medicalStaff = medicalStaff;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }
}
