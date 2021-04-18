package com.solvd.hospital.interfaces;


import com.solvd.hospital.exceptions.InvalidDoctorSpecialty;

public interface IHospitalCare {
    void treatPatient();
    void operatePatient() throws InvalidDoctorSpecialty;
    void assignMedicine();
}
