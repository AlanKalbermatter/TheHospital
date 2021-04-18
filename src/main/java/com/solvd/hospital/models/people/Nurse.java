package com.solvd.hospital.models.people;


import com.solvd.hospital.enums.Gender;
import com.solvd.hospital.interfaces.IHospitalCare;

public class Nurse
        extends Person
        implements IHospitalCare{
    private String category;
    private float weeklyHours;


    public Nurse( String name, String lastName, int age, long dni, Gender gender, float weeklyHours, String category ){
        super(name, lastName, age, dni, gender);
        this.weeklyHours = weeklyHours;
        this.category = category;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory( String category ) {
        this.category = category;
    }

    public float getWeeklyHours() {
        return weeklyHours;
    }

    public void setWeeklyHours( float weeklyHours ) {
        this.weeklyHours = weeklyHours;
    }

    @Override
    public void treatPatient() {

    }

    @Override
    public void operatePatient() {

    }

    @Override
    public void assignMedicine() {

    }
}
