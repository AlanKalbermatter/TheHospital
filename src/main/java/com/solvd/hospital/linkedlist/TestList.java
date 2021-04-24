package com.solvd.hospital.linkedlist;

import com.solvd.hospital.generics.Prescription;
import com.solvd.hospital.models.Medicine;
import com.solvd.hospital.models.people.Patient;
import org.apache.log4j.PropertyConfigurator;

import java.util.Calendar;

import static com.solvd.hospital.enums.Gender.*;
import static com.solvd.hospital.enums.PatientAgeGroup.*;
import static com.solvd.hospital.enums.SeverityOfIlleness.*;

public class TestList {
    private static Calendar calendar = Calendar.getInstance();
    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/kalber/workspace/HospitalModelWithMvn/src/main/resources/log4j2.properties");

        Medicine ibuprofen = new Medicine("Ibuprofen");
        Medicine antibiotic = new Medicine("Antibiotic");
        Medicine aspirin = new Medicine("Aspirin");
        Medicine tylenol = new Medicine("Tylenol");
        MedicineDoublyList testDoubly = new MedicineDoublyList();
        testDoubly.insert(1, ibuprofen);
        testDoubly.insert(2, aspirin);
        testDoubly.insert(3, antibiotic);
        testDoubly.insert(4, tylenol);
        testDoubly.run();
        testDoubly.reverseRun();
        testDoubly.quantity();

        calendar.set(2022,12,12);
        Patient alan =      new Patient(1,"Headache","Alan", "Kalber", 23, 778899444, MALE, ADULT, INTERMEDIATE, new Prescription(calendar.getTime(),"Ibuprofen") );
        Patient martin =    new Patient(1,"Fever","Martin", "Salomon", 18, 666555444, NEUTER, ADULT, HIGH, new Prescription(calendar.getTime(),"Antibiotic") );
        Patient jose =      new Patient(1,"Fever","Jose", "Johnson", 34, 777888999, MALE, ADULT, LOW, new Prescription(calendar.getTime(),"Aspirin") );
        Patient lilia =     new Patient(1,"Stomachache","Lilia", "Felber", 80, 444555666, FEMALE, ELDER, HIGH, new Prescription(calendar.getTime(),"Tylenol") );
        Patient sabrina =   new Patient(1,"Knee pain","Sabrina", "Washington", 4, 111222333, FEMALE, CHILD, HIGH, new Prescription(calendar.getTime(),"Aspirin") );


        PatientQueue testSingleton = new PatientQueue();
        testSingleton.insert(alan);
        testSingleton.insert(martin);
        testSingleton.insert(lilia);
        testSingleton.insert(sabrina);
        testSingleton.insert(jose);
        testSingleton.run();
        testSingleton.counter();




    }
}
