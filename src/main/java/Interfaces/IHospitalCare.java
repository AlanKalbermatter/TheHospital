package Interfaces;

import Exceptions.SpecialityException;

public interface IHospitalCare {
    void treatPatient();
    void operatePatient() throws SpecialityException;
    void assignMedicine();
    void transferPatient();
    void releasePatient();
    void assignBed();
    void assignRoom();
}
