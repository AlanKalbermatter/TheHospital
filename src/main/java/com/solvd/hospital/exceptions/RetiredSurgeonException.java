package com.solvd.hospital.exceptions;

public class RetiredSurgeonException extends InvalidDoctorSpecialty{
    public RetiredSurgeonException(String message){
        super(message);
    }
}
