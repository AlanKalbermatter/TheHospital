package jaxb.model;

import dao.domain.people.Patient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Bed extends BaseModel{
    @XmlElement(name = "name")
    private int roomNumber;

    private Patient patient;

    public Bed(){}

    public Bed(int roomNumber, dao.domain.people.Patient patient){
        this.roomNumber = roomNumber;
        this.patient = patient;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public dao.domain.people.Patient getPatient() {
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
