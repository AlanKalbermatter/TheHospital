package jaxb.dao.realization;

import jaxb.dao.interfaces.IPatientDAO;
import jaxb.model.Patient;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import java.io.File;
import java.util.List;

public class PatientDAO implements IPatientDAO {
    private static final Logger LOGGER = LogManager.getLogger(PatientDAO.class);
    private static final File FILE = new File("src/main/resources/xml/patients.xml");
    @XmlElement(name = "Patient")
    private List<Patient> patients = null;

    @Override
    public void save(Patient entity) {
        patients = unmarshall();
        patients.add(entity);
        marshall(this);
    }

    @Override
    public Patient getById(long id) {
        patients = unmarshall();
        return patients.stream()
                .filter(element -> element.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void update(Patient entity) {
        patients = unmarshall();
        patients.stream()
                .filter(element -> element.getId() == entity.getId())
                .findAny()
                .ifPresent(updateElement -> {
                    updateElement.setName(entity.getName());
                    updateElement.setLastName(entity.getLastName());
                    updateElement.setSymptom(entity.getSymptom());
                });
        marshall(this);
    }

    @Override
    public void delete(Patient entity) {
        patients = unmarshall();
        patients.stream()
                .filter(element -> element.getId() == entity.getId())
                .findAny()
                .ifPresent(deleteElement -> patients.remove(deleteElement));
        marshall(this);
    }
    private static synchronized List<Patient> unmarshall(){
        PatientDAO patient = new PatientDAO();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PatientDAO.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            patient = (PatientDAO) jaxbUnmarshaller.unmarshal(FILE);
        } catch (JAXBException ex) {
            LOGGER.error(ex);
        }
        return patient.getPatients();
    }

    private static synchronized void marshall(PatientDAO patient){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(PatientDAO.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(patient, FILE);
        } catch (JAXBException ex) {
            LOGGER.error(ex);
        }
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
