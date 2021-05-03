package dao.domain.people;

import dao.domain.BaseModel;
import dao.domain.misc.PositionDTO;

import java.util.Objects;

public class MedicalStaffDTO extends BaseModel {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicalStaffDTO)) return false;
        MedicalStaffDTO that = (MedicalStaffDTO) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getSpecialty(), that.getSpecialty()) && positionDTO == that.positionDTO;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSpecialty(), positionDTO);
    }
}
