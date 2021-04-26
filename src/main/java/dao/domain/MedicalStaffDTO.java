package dao.domain;

public class MedicalStaffDTO extends BaseModel{
    private String name;
    private String specialty;
    private PositionDTO positionDTO;

    public MedicalStaffDTO(){}

    public MedicalStaffDTO(String name, String specialty, PositionDTO positionDTO){
        this.name = name;
        this.specialty = specialty;
        this.positionDTO = positionDTO;
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

    public PositionDTO getPosition() {
        return positionDTO;
    }

    public void setPosition(PositionDTO positionDTO) {
        this.positionDTO = positionDTO;
    }

    @Override
    public String toString() {
        return "MedicalStaff{" +
                "name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", position=" + positionDTO +
                '}';
    }
}
