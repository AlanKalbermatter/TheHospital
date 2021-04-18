package com.solvd.hospital.models.building;

import com.solvd.hospital.models.Bed;

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
