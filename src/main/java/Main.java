import models.building.Hospital;
import models.building.Reception;
import models.people.Doctor;
import models.people.Nurse;
import models.people.Patient;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import static enums.Gender.FEMALE;
import static enums.Gender.MALE;
import static enums.PatientAgeGroup.*;
import static enums.SeverityOfIlleness.*;
import static enums.WorkShifts.*;

public class Main {

//    Faker faker = new Faker();
    private static LinkedHashSet<Doctor> fillDoctorsList() {
        LinkedHashSet<Doctor> doctorList = new LinkedHashSet<>();

        Doctor doctor = new Doctor("Robert", "Deniro", 42, 10000003, MALE , "Doctor", MORNING, 40);
        Doctor doctor1 = new Doctor("Bob", "Stuart", 58, 10000004, MALE, "Surgeon", AFTERNOON, 35);
        Doctor doctor2 = new Doctor("Natalea", "Zambone", 39, 10000007, FEMALE  , "Doctor", EVENING, 40);
        doctorList.add(doctor);
        doctorList.add(doctor1);
        doctorList.add(doctor2);
        return doctorList;
    }

    private static LinkedHashSet<Nurse> fillNursesList() {
        LinkedHashSet<Nurse> nurseList = new LinkedHashSet<>();
        Nurse nurse = new Nurse("Alice", "Ericson", 29, 10000004, FEMALE, 40, "Intensive cares");
        Nurse nurse1 = new Nurse("Susan", "Gonzales", 33, 10000005, FEMALE, 40, "Elders cares");
        Nurse nurse2 = new Nurse("William", "Fergunson", 27, 10000006, MALE, 40, "Doctor Assistant");
        nurseList.add(nurse);
        nurseList.add(nurse1);
        nurseList.add(nurse2);
        return nurseList;
    }

    private static ArrayList<Patient> fillPatientsList() {
        ArrayList<Patient> patientsList = new ArrayList<>();
        Patient patient1 = new Patient("Lucas", "Johnson", 34, 10000000, MALE, ADULT, HIGH);
        Patient patient2 = new Patient("John", "Robinson", 76, 10000001, MALE, ELDER, INTERMEDIATE);
        Patient patient3 = new Patient("Maria", "Williams", 14, 10000002, FEMALE, TEENAGER, LOW);
        patientsList.add(patient1);
        patientsList.add(patient2);
        patientsList.add(patient3);
        return patientsList;
    }

    private static final Logger logger = Logger.getLogger(Main.class);

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

        logger.info("Number of actual patients in the hospital is: " + hospital.getReception().getPatients().size());
        System.out.println("Number of actual patients in the hospital is: " + hospital.getReception().getPatients().size());
        //Assign medicine
        //To go through the linked list, I have simulated a medicine container class
        // where each node is a tablet of pills or something similar,
        // and the route informs you for each tablet how many pills are left
//        MedicineContainer test = new MedicineContainer();
//        test.insert(1, 10);
//        test.insert(2, 20);
//        test.insert(3, 30);
//        test.insert(4, 40);
//        test.run();
//        test.reverseRun();

        logger.debug("Thanks for using the HOSPITAL Terminal");
    }
}



