package dao.domain;

import java.sql.Date;

public class AppointmentDTO extends BaseModel{
    private Date date;
    private MedicalStaffDTO medicalStaffDTO;
    private PatientDTO patientDTO;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MedicalStaffDTO getMedicalStaff() {
        return medicalStaffDTO;
    }

    public void setMedicalStaff(MedicalStaffDTO medicalStaffDTO) {
        this.medicalStaffDTO = medicalStaffDTO;
    }

    public PatientDTO getPatient() {
        return patientDTO;
    }

    public void setPatient(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "date=" + date +
                ", MedicalStaff=" + medicalStaffDTO.toString() +
                ", patient=" + patientDTO +
                '}';
    }
}
