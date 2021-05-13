package jaxb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Patient extends BaseModel{
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "lastName")
    private String lastName;
    @XmlElement(name = "symptom")
    private String symptom;

    public Patient(){}

    public Patient(String name, String lastName, String symptom){
        this.name = name;
        this.lastName = name;
        this.symptom = symptom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
}
