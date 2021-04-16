package models.people;

import enums.Gender;
import enums.WorkShifts;
import interfaces.IHospitalCare;
import org.apache.log4j.Logger;

public class Doctor
        extends Person
        implements IHospitalCare {
    private static final Logger logger = Logger.getLogger(Doctor.class);
    private String specialty;
    private float weeklyHours;
    private Gender gender;

    private WorkShifts workShifts;

    public Doctor( String name, String lastName, int age, long dni, Gender gender, String specialty, WorkShifts workShifts, float weeklyHours ){
        super(name, lastName, age, dni, gender);
        this.specialty = specialty;
        this.workShifts = workShifts;
        this.weeklyHours = weeklyHours;
    }


    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty( String specialty ) {
        this.specialty = specialty;
    }

    public float getWeeklyHours() {
        return weeklyHours;
    }

    public void setWeeklyHours( float weeklyHours ) {
        this.weeklyHours = weeklyHours;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public WorkShifts getWorkShifts() {
        return workShifts;
    }

    public void setWorkShifts(WorkShifts workShifts) {
        this.workShifts = workShifts;
    }

    @Override
    public void treatPatient() {
        logger.info("The patient has been cured");
    }

    @Override
    public void operatePatient() {}

    @Override
    public void assignMedicine() {
        logger.info("The medicine has been assigned");
    }

    @Override
    public void transferPatient() { logger.info("Transferring patient");
    }

    @Override
    public void releasePatient() {
        logger.info("The patient has been released");
    }

    @Override
    public void assignBed() {

    }

    @Override
    public void assignRoom() {

    }


    @Override
    public String toString() {
        return "Doctor{" +
                "specialty='" + specialty + '\'' +
                ", weeklyHours=" + weeklyHours +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", dni=" + dni +
                ", gender='" + gender + '\'' +
                '}';
    }
}