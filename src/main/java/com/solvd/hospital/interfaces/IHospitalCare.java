package com.solvd.hospital.interfaces;


import com.solvd.hospital.exceptions.InvalidDoctorSpecialty;
import com.solvd.hospital.exceptions.InvalidMedicineException;
import com.solvd.hospital.exceptions.NurseOperateException;

public interface IHospitalCare {
    void treatPatient();
    void operatePatient() throws InvalidDoctorSpecialty, NurseOperateException;
    void assignMedicine() throws InvalidMedicineException;
}
