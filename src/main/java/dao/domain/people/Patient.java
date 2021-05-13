package dao.domain.people;

public class Patient {
    private String name;
    private String lastName;
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
