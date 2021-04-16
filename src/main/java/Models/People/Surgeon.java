package Models.People;

import Interfaces.IHospitalCare;

import java.util.Objects;

public class Surgeon extends Person implements IHospitalCare {
    private String specialty;
    private float weeklyHours;

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public float getWeeklyHours() {
        return weeklyHours;
    }

    public void setWeeklyHours(float weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    @Override
    public void treatPatient() {
        System.out.println("The patient has been cured");
    }

    @Override
    public void operatePatient() {
        System.out.println("The patient has been operated");
    }

    @Override
    public void assignMedicine() {
        System.out.println("The medicine has been prescribed");
    }

    @Override
    public void transferPatient() {
        System.out.println("Transferring patient");
    }

    @Override
    public void releasePatient() {
        System.out.println("The patient has been released");
    }

    @Override
    public void assignBed() {

    }

    @Override
    public void assignRoom() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Surgeon)) return false;
        Surgeon surgeon = (Surgeon) o;
        return Float.compare(surgeon.getWeeklyHours(), getWeeklyHours()) == 0 && Objects.equals(getSpecialty(), surgeon.getSpecialty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSpecialty(), getWeeklyHours());
    }

    @Override
    public String toString() {
        return "Surgeon{" +
                "specialty='" + specialty + '\'' +
                ", weeklyHours=" + weeklyHours +
                '}';
    }
}
