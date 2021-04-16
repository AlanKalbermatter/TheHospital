package models.people;


import enums.Gender;
import enums.PatientAgeGroup;
import enums.SeverityOfIlleness;

import java.util.Date;

public class Patient
        extends Person {
    private int patientId;
    private long numberSocialWelfare;
    private String symptom;
    private String medicalDiagnostic;
    private Date dateOfAppointment;
    private PatientAgeGroup patientAgeGroup;
    private SeverityOfIlleness severityOfIlleness;

    public Patient(String name, String lastName, int age, long dni, Gender gender, PatientAgeGroup patientAgeGroup, SeverityOfIlleness severityOfIlleness){
        super(name, lastName, age,dni,gender);
        this.patientAgeGroup = patientAgeGroup;
        this.severityOfIlleness = severityOfIlleness;
    }

    public int getPatientId() { return patientId; }

    public void setPatientId( int patientId ) { this.patientId = patientId; }

    public long getNumberSocialWelfare() {
        return numberSocialWelfare;
    }

    public void setNumberSocialWelfare( long numberSocialWelfare ) {
        this.numberSocialWelfare = numberSocialWelfare;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom( String symptom ) {
        this.symptom = symptom;
    }

    public String getMedicalDiagnostic() {
        return medicalDiagnostic;
    }

    public void setMedicalDiagnostic(String medicalDiagnostic) {
        this.medicalDiagnostic = medicalDiagnostic;
    }

    public Date getDateOfAppointment(){
        return dateOfAppointment;
    }

    public void setDateOfAppointment(Date dateOfAppointment){
        this.dateOfAppointment = dateOfAppointment;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", numberSocialWelfare=" + numberSocialWelfare +
                ", symptom='" + symptom + '\'' +
                ", medicalDiagnostic='" + medicalDiagnostic + '\'' +
                ", dateOfAppointment=" + dateOfAppointment +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", dni=" + dni +
                ", gender='" + gender + '\'' +
                '}';
    }
}
