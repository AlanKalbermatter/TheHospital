package Models.Building;

import Models.Bed;

public class PatientRoom
        extends Room {

    private Bed bed;

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }
}
