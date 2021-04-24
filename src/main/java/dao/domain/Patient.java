package dao.domain;

public class Patient {
    private long id;
    private String name;
    private String lastName;
    private String symptom;

    public Patient(){}

    public Patient(String name, String lastName, String symptom){
        this.name = name;
        this.lastName = name;
        this.symptom = symptom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
