package enums;

public enum PatientAgeGroup {
    CHILD(13),
    TEENAGER(18),
    ADULT(69),
    ELDER(100);

    private int age;

    PatientAgeGroup(int age){
        this.age = age;
    }
}
