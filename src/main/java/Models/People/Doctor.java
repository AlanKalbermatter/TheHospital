package Models.People;

import Exceptions.SpecialityException;
import Interfaces.IHospitalCare;
import org.apache.log4j.Logger;

import java.util.List;

public class Doctor
        extends Person
        implements IHospitalCare {
    private static final Logger logger = Logger.getLogger(Doctor.class);
    private String specialty;
    private float weeklyHours;
    private List<Patient> patients;

    public Doctor(){}

    public Doctor( String name, String lastName, int age, long dni, String gender, String specialty ){
        this.setName(name);
        this.setLastName(lastName);
        this.setAge(age);
        this.setDni(dni);
        this.setGender(gender);
        this.setSpecialty(specialty);
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

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Patient patient) {
        this.patients.add(patient);
    }
    @Override
    public void treatPatient() {
        logger.info("The patient has been cured");
    }

    @Override
    public void operatePatient()throws SpecialityException {
        if( !this.specialty.equals("Surgeon") )
            throw new SpecialityException( "Doctors aren't able to surgery on patients" );
    }

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
                ", patients=" + patients +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", dni=" + dni +
                ", gender='" + gender + '\'' +
                '}';
    }
}