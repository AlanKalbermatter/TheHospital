package models.people;


import enums.Gender;
import interfaces.IHospitalCare;
import interfaces.IPeopleManager;

public class Nurse
        extends Person
        implements IHospitalCare, IPeopleManager {
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

    @Override
    public void transferPatient() {

    }

    @Override
    public void releasePatient() {

    }

    @Override
    public void assignBed() {

    }

    @Override
    public void assignRoom() {

    }

    @Override
    public void add() {

    }

    @Override
    public boolean delete() {
        return false;
    }
}
