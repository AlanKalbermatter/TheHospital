package dao.domain.misc;

import dao.domain.BaseModel;
import dao.domain.people.Patient;

public class Bed extends BaseModel {
    private int roomNumber;
    private Patient patient;

    public Bed(){}

    public Bed(int roomNumber, Patient patient){
        this.roomNumber = roomNumber;
        this.patient = patient;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Bed{" +
                "roomNumber=" + roomNumber +
                ", patient=" + patient +
                '}';
    }
}
