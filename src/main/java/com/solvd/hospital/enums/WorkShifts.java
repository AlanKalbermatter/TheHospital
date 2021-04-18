package com.solvd.hospital.enums;

public enum WorkShifts {
    MORNING(8),
    AFTERNOON(8),
    EVENING(8);

    private int shift;
    WorkShifts(int shift){
        this.shift = shift;
    }

    int doubleShifts(){
        return shift * 2;
    }
}
