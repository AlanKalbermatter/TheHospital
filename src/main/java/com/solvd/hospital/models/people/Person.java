package com.solvd.hospital.models.people;

import com.solvd.hospital.enums.Gender;

public abstract class Person {
    protected String name;
    protected String lastName;
    protected int age;
    protected long ssn;
    protected Gender gender;

    public Person(String name, String lastName, int age, long dni, Gender gender) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.ssn = dni;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
