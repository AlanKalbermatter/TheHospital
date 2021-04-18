package com.solvd.hospital.models.people;

import com.solvd.hospital.enums.Gender;
import com.solvd.hospital.enums.WorkShifts;
import com.solvd.hospital.exceptions.InvalidDoctorSpecialty;
import com.solvd.hospital.exceptions.NullMedicalHistorySheetException;
import com.solvd.hospital.interfaces.IHospitalCare;
import com.solvd.hospital.interfaces.IMedicalHistorySheet;
import org.apache.log4j.Logger;

public class Doctor
        extends Person
        implements IHospitalCare,
        IMedicalHistorySheet {
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
    public void operatePatient() throws InvalidDoctorSpecialty {
        if(this.getSpecialty().equals("Surgeon"))
            System.out.println("Patient has been operated");
        else
            throw new InvalidDoctorSpecialty("Doctor "+ this.getLastName() +" not surgeon");
    }

    @Override
    public void assignMedicine() {
        logger.info("The medicine has been assigned");
    }

    @Override
    public void showMedicalHistory() throws NullMedicalHistorySheetException {
        throw new NullMedicalHistorySheetException("This patient hasn't got Medical History");
    }

    @Override
    public void updateMedicalHistory() throws NullMedicalHistorySheetException {
        throw new NullMedicalHistorySheetException("There is nothing to change");
    }

    @Override
    public void createMedicalHistory() {
        logger.info("Medical Sheet created successfully");
    }


    @Override
    public String toString() {
        return "Doctor{" +
                "specialty='" + specialty + '\'' +
                ", weeklyHours=" + weeklyHours +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", dni=" + ssn +
                ", gender='" + gender + '\'' +
                '}';
    }
}