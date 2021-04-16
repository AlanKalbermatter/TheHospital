import Models.*;
import Exceptions.WrongInputException;
import Models.Building.Hospital;
import Models.People.Doctor;
import Models.People.Nurse;
import Models.People.Patient;
import Repository.MedicineContainer;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {
    static final String FEMALE = "Female";
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main( String[] args ) throws WrongInputException{
        // configurator for logger
        PropertyConfigurator.configure( "/home/kalber/workspace/HospitalModelWithMvn/src/main/resources/log4j2.properties" );


        Hospital hospital = new Hospital.Builder()
                .withName( "New Amsterdam" )
                .withAddress( "1090 Amsterdam Ave, New York, NY 10025, United States" )
                .build();

        Reception reception = new Reception();

        Doctor doctor = new Doctor("Robert","Deniro",42,10000003,"Male","Doctor");
        Doctor doctor1 = new Doctor("Bob","Stuart",58,10000004,"Male","Surgeon");
        Doctor doctor2 = new Doctor("Natalea","Zambone",39,10000007,FEMALE,"Doctor");
        reception.setDoctors(doctor);reception.setDoctors(doctor1);reception.setDoctors(doctor2);
        // initialize hospital crowd
        Patient patient1 = new Patient("Lucas","Johnson",34,10000000,"Male");
        Patient patient2 = new Patient("John","Robinson",66,10000001,"Male");
        Patient patient3 = new Patient("Maria","Williams",14,10000002,FEMALE);
        doctor.setPatients(patient1);doctor.setPatients(patient2);doctor.setPatients(patient3);

        Nurse nurse = new Nurse("Alice","Ericson",29,10000004,FEMALE);
        Nurse nurse1 = new Nurse("Susan","Gonzales",33,10000005,FEMALE);
        Nurse nurse2 = new Nurse("William","Fergunson",27,10000006,"Male");
        reception.setNurses(nurse);reception.setNurses(nurse2);reception.setNurses(nurse2);

            //add a new patient
            Patient newPatient = new Patient();
            doctor1.setPatients(newPatient);
            logger.info("List of patients " + doctor.getPatients());
            logger.info("Amount of patients of Doctor " + doctor.getName() + " " + doctor.getPatients().size());


            //Assign medicine
            //To go through the linked list, I have simulated a medicine container class
            // where each node is a tablet of pills or something similar,
            // and the route informs you for each tablet how many pills are left
            MedicineContainer test = new MedicineContainer();
            test.insert(1,10);
            test.insert(2,20);
            test.insert(3,30);
            test.insert(4,40);
            test.run();
            test.reverseRun();

            logger.info(doctor.getPatients());

        logger.debug( "Thanks for using the HOSPITAL Terminal" );
    }
}



