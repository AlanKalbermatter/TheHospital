package dao.domain;

public class BedDTO extends BaseModel{
    private int roomNumber;
    private PatientDTO patientDTO;

    public BedDTO(){}

    public BedDTO(int roomNumber, PatientDTO patientDTO){
        this.roomNumber = roomNumber;
        this.patientDTO = patientDTO;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public PatientDTO getPatient() {
        return patientDTO;
    }

    public void setPatient(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }

    @Override
    public String toString() {
        return "Bed{" +
                "roomNumber=" + roomNumber +
                ", patient=" + patientDTO +
                '}';
    }
}
