package Models;

public class Bed {
    private boolean patient;
    private int id;

    public Bed(){}

    public boolean havePatient() {
        return patient;
    }

    public void setPatient( boolean patient ) {
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }
}
