package Models.Building;

import Models.People.Doctor;
import Models.People.Nurse;

import java.util.HashSet;
import java.util.Set;

public class Reception
        extends Room {
    private Set<Doctor> doctors;
    private Set<Nurse> nurses;

    public Reception(){
        Set<Doctor> doctors = new HashSet();
    }
    public Set<Doctor> getDoctor() {
        return doctors;
    }

    public void setDoctors(Doctor doctor) {
        this.doctors.add(doctor);
    }

    public Set<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(Nurse nurse) {
        this.nurses.add(nurse);
    }
}
