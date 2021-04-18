package com.solvd.hospital.models.building;

import com.solvd.hospital.interfaces.IPrescription;

public class Pharmacy extends Room implements IPrescription {

    @Override
    public void prescribeMedicine() {
        System.out.println("The medicine has been prescribed");
    }

    @Override
    public void endTreatment() {
        System.out.println("The treatment has ended");
    }
}
