package com.solvd.hospital.linkedlist;

public class TestList {

    public static void main(String[] args) {
        MedicineDoublyList test = new MedicineDoublyList();
        test.insert(1, 10);
        test.insert(2, 20);
        test.insert(3, 30);
        test.insert(4, 40);
        test.run();
        test.reverseRun();
    }
}
