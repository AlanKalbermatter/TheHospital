package models.building;

import interfaces.IAmbulance;
import models.people.Doctor;
import models.people.Nurse;

import java.util.LinkedHashSet;
import java.util.Objects;

public class Hospital implements IAmbulance {

    private String name;
    private String address;
    private Reception reception;
    private LinkedHashSet<Doctor> doctors;
    private LinkedHashSet<Nurse> nurses;

    public Hospital(String name, String address, Reception reception){
        this.name = name;
        this.address = address;
        this.reception = reception;
    }


    public String getName() { return name; }

    public void setName( String name ) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress( String address ) {
        this.address = address;
    }

    public Reception getReception() {
        return reception;
    }

    public void setReception(Reception reception) {
        this.reception = reception;
    }


    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof Hospital ) ) return false;
        Hospital hospital = (Hospital) o;
        return getName().equals( hospital.getName() ) && getAddress().equals( hospital.getAddress() );
    }

    public LinkedHashSet<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(LinkedHashSet<Doctor> doctors) {
        this.doctors = doctors;
    }

    public LinkedHashSet<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(LinkedHashSet<Nurse> nurses) {
        this.nurses = nurses;
    }

        @Override
        public int hashCode() {
            return Objects.hash( getName(), getAddress() );
        }

        @Override
        public String toString() {
            return "Hospital{" +
                    ", name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }

        @Override
        public void transferPatient() {
            System.out.println( "Patient has been transferred" );
        }
}
