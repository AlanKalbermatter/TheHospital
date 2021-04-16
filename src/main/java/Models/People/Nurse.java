package Models.People;


import Interfaces.IHospitalCare;
import Interfaces.IPeopleManager;

import java.util.ArrayList;
import java.util.List;

public class Nurse
        extends Person
        implements IHospitalCare, IPeopleManager {
    private String category;
    private float weeklyHours;
    public static List< Nurse > nurseList = new ArrayList<>();

    public Nurse(){}

    public Nurse( String name, String lastName, int age, long dni, String gender ){
        this.setName(name);
        this.setLastName(lastName);
        this.setAge(age);
        this.setDni(dni);
        this.setGender(gender);
    }
    public Nurse( int amount ){
        for( int i = 0; i < amount; i++ ){
            nurseList.add( new Nurse() );
        }
    }

    public List getNurseList() { return nurseList; }

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
