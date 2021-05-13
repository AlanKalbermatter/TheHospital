package jaxb.model;

import dao.domain.misc.Position;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class MedicalStaff extends BaseModel{

    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "specialty")
    private String specialty;
    @XmlElement(name = "position")
    private Position position;

    public MedicalStaff(){}

    public MedicalStaff(String name, String specialty, Position position){
        this.name = name;
        this.specialty = specialty;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "MedicalStaff{" +
                "name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", position=" + position +
                '}';
    }
}
