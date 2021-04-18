package com.solvd.hospital.enums;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    NEUTER("Neuter");


    private String gender;

    Gender(String gender){
        this.gender = gender;
    }
}
