package Models.Building;

public abstract class Room {
    private String name;
    private String[] medicalStaff;
    private String patients;

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

    public String getPatients() {
        return patients;
    }

    public void setPatients(String patients) {
        this.patients = patients;
    }
}
