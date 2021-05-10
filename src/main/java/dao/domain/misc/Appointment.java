package dao.domain.misc;

import dao.domain.BaseModel;
import dao.domain.people.MedicalStaff;
import dao.domain.people.Patient;

import java.sql.Date;

public class Appointment extends BaseModel {
    private Date date;
    private MedicalStaff medicalStaff;
    private Patient patient;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MedicalStaff getMedicalStaff() {
        return medicalStaff;
    }

    public void setMedicalStaff(MedicalStaff medicalStaff) {
        this.medicalStaff = medicalStaff;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "date=" + date +
                ", MedicalStaff=" + medicalStaff.toString() +
                ", patient=" + patient +
                '}';
    }
}
