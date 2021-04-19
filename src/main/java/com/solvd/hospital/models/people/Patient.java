package com.solvd.hospital.models.people;


import com.solvd.hospital.enums.Gender;
import com.solvd.hospital.enums.PatientAgeGroup;
import com.solvd.hospital.enums.SeverityOfIlleness;
import com.solvd.hospital.generics.Prescription;

public class Patient
        extends Person {
    private int patientId;
    private String symptom;
    private PatientAgeGroup patientAgeGroup;
    private SeverityOfIlleness severityOfIlleness;
    private Prescription prescription;

    public Patient(int patientId, String symptom,String name, String lastName, int age, long ssn, Gender gender, PatientAgeGroup patientAgeGroup, SeverityOfIlleness severityOfIlleness, Prescription prescription){
        super(name, lastName, age, ssn, gender);
        this.patientId = patientId;
        this.symptom = symptom;
        this.patientAgeGroup = patientAgeGroup;
        this.severityOfIlleness = severityOfIlleness;
        this.prescription = prescription;
    }

    public int getPatientId() { return patientId; }

    public void setPatientId( int patientId ) { this.patientId = patientId; }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom( String symptom ) {
        this.symptom = symptom;
    }

    public PatientAgeGroup getPatientAgeGroup() {
        return patientAgeGroup;
    }

    public void setPatientAgeGroup(PatientAgeGroup patientAgeGroup) {
        this.patientAgeGroup = patientAgeGroup;
    }

    public SeverityOfIlleness getSeverityOfIlleness() {
        return severityOfIlleness;
    }

    public void setSeverityOfIlleness(SeverityOfIlleness severityOfIlleness) {
        this.severityOfIlleness = severityOfIlleness;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", symptom='" + symptom + '\'' +
                ", patientAgeGroup=" + patientAgeGroup +
                ", severityOfIlleness=" + severityOfIlleness +
                ", prescription=" + prescription +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", ssn=" + ssn +
                ", gender=" + gender +
                '}';
    }
}
