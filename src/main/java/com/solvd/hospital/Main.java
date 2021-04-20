package com.solvd.hospital;

import com.solvd.hospital.exceptions.InvalidDoctorSpecialty;
import com.solvd.hospital.exceptions.NullMedicalHistorySheetException;
import com.solvd.hospital.exceptions.NurseOperateException;
import com.solvd.hospital.generics.Appointment;
import com.solvd.hospital.generics.Prescription;
import com.solvd.hospital.models.building.Hospital;
import com.solvd.hospital.models.building.Reception;
import com.solvd.hospital.models.people.Doctor;
import com.solvd.hospital.models.people.Nurse;
import com.solvd.hospital.models.people.Patient;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashSet;

import static com.solvd.hospital.enums.Gender.*;
import static com.solvd.hospital.enums.PatientAgeGroup.*;
import static com.solvd.hospital.enums.SeverityOfIlleness.*;
import static com.solvd.hospital.enums.WorkShifts.*;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);
    private static Calendar calendar = Calendar.getInstance();
    private static LinkedHashSet<Doctor> fillDoctorsList() {

        LinkedHashSet<Doctor> doctorList = new LinkedHashSet<>();

        Doctor doctor = new Doctor("Robert", "Deniro", 42, 10000003, MALE , "Doctor", MORNING, 40);
        try {
            doctor.operatePatient();
        }catch(InvalidDoctorSpecialty exception){
            logger.error(exception.getMessage());
        }
        Doctor doctor1 = new Doctor("Bob", "Stuart", 58, 10000004, MALE, "Surgeon", AFTERNOON, 35);
        try{
            doctor1.showMedicalHistory();
        }catch (NullMedicalHistorySheetException exception){
            logger.error(exception.getMessage());
        }
        Doctor doctor2 = new Doctor("Natalea", "Zambone", 39, 10000007, FEMALE  , "Doctor", EVENING, 40);
        doctorList.add(doctor);
        doctorList.add(doctor1);
        doctorList.add(doctor2);
        return doctorList;
    }

    private static LinkedHashSet<Nurse> fillNursesList() {

        LinkedHashSet<Nurse> nurseList = new LinkedHashSet<>();
        Nurse nurse = new Nurse("Alice", "Ericson", 29, 10000004, FEMALE, 40, "Intensive cares");
        try {
            nurse.operatePatient();
        }catch(NurseOperateException exception){
            logger.error(exception.getMessage());
        }
        Nurse nurse1 = new Nurse("Susan", "Gonzales", 33, 10000005, FEMALE, 40, "Elders cares");
        Nurse nurse2 = new Nurse("William", "Fergunson", 27, 10000006, MALE, 40, "Doctor Assistant");
        nurseList.add(nurse);
        nurseList.add(nurse1);
        nurseList.add(nurse2);
        return nurseList;
    }

    private static ArrayList<Patient> fillPatientsList() {

        ArrayList<Patient> patientsList = new ArrayList<>();

        calendar.set(2021,04,18);
        Patient patient1 = new Patient(1,"Fever","Lucas", "Johnson", 34, 555444666, NEUTER, ADULT, HIGH, new Prescription(calendar.getTime(),"Ibuprofen") );
        Patient patient2 = new Patient(2,"Headache","John", "Robinson", 76, 123456789, MALE, ELDER, INTERMEDIATE, new Prescription(calendar.getTime(),"Ibuprofen") );
        Patient patient3 = new Patient(3,"Stomachache","Maria", "Williams", 14, 555444666, FEMALE, TEENAGER, LOW, new Prescription(calendar.getTime(),"Antibiotic") );
        patientsList.add(patient1);
        patientsList.add(patient2);
        patientsList.add(patient3);
        return patientsList;
    }

    public static void main(String[] args) {
        // configurator for logger
        PropertyConfigurator.configure("/home/kalber/workspace/HospitalModelWithMvn/src/main/resources/log4j2.properties");


        Reception reception = new Reception(fillPatientsList());
        Hospital hospital = new Hospital(
                "New Amsterdam",
                "1090 Amsterdam Ave, New York, NY 10025, United States",
                reception
        );

        // initialize hospital crowd
        hospital.setDoctors(fillDoctorsList());
        hospital.setNurses(fillNursesList());

        //generics implementations
        calendar.set(2021,05,1);
        logger.info(new Appointment("Zambone","Johnson",calendar.getTime()).toString());



        logger.info("Number of actual patients in the hospital is: " + hospital.getReception().getPatients().size());
        System.out.println("Number of actual patients in the hospital is: " + hospital.getReception().getPatients().size());


        //To go through the linked list, I have simulated a medicine container class
        // where each node is a tablet of pills or something similar,
        // and the route informs you for each tablet how many pills are left


        logger.debug("Thanks for using the HOSPITAL Terminal");
    }
}



