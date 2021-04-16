package Models.People;


import java.util.Date;

public class Patient
        extends Person {
    private int patientId;
    private long numberSocialWelfare;
    private String symptom;
    private String medicalDiagnostic;
    private Date dateOfAppointment;

    public Patient(){}

    public Patient( String name, String lastName, int age, long dni, String gender ){
        this.setName(name);
        this.setLastName(lastName);
        this.setAge(age);
        this.setDni(dni);
        this.setGender(gender);
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
