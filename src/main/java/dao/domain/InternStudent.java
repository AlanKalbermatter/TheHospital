package dao.domain;

public class InternStudent {
    private long id;
    private String name;
    private String lastName;
    private String specialty;

    public InternStudent(){}

    public InternStudent(String name, String lastName, String specialty){
        this.name = name;
        this.lastName = lastName;
        this.specialty = specialty;
    }

    public long getId() {
        return id;
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "InternStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}
