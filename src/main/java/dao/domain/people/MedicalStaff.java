package dao.domain.people;

import dao.domain.BaseModel;
import dao.domain.misc.Position;

import java.util.Objects;

public class MedicalStaff extends BaseModel {
    private String name;
    private String specialty;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicalStaff)) return false;
        MedicalStaff that = (MedicalStaff) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getSpecialty(), that.getSpecialty()) && position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSpecialty(), position);
    }
}
