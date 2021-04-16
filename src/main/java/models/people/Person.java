package models.people;

import enums.Gender;

public abstract class Person {
    protected String name;
    protected String lastName;
    protected int age;
    protected long dni;
    protected Gender gender;

    public Person(String name, String lastName, int age, long dni, Gender gender) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.dni = dni;
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

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
