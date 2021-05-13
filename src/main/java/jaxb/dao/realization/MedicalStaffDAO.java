package jaxb.dao.realization;

import dao.domain.people.MedicalStaff;
import dao.interfaces.IMedicalStaffDAO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import java.io.File;
import java.sql.SQLException;
import java.util.List;

public class MedicalStaffDAO implements IMedicalStaffDAO {
    private static final Logger LOGGER = LogManager.getLogger(MedicalStaffDAO.class);
    private static final File FILE = new File("src/main/resources/xml/medicalStaff.xml");
    @XmlElement(name = "MedicalStaff")
    private List<MedicalStaff> medicalStaff = null;

    @Override
    public void save(MedicalStaff entity) throws SQLException {
        medicalStaff = unmarshall();
        medicalStaff.add(entity);
        marshall(this);
    }

    @Override
    public MedicalStaff getById(long id) throws SQLException {
        medicalStaff = unmarshall();
        return medicalStaff.stream()
                .filter(element -> element.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void update(MedicalStaff entity) throws SQLException {
        medicalStaff = unmarshall();
        medicalStaff.stream()
                .filter(element -> element.getId() == entity.getId())
                .findAny()
                .ifPresent(updateElement -> {
                    updateElement.setName(entity.getName());
                    updateElement.setPosition(entity.getPosition());
                    updateElement.setSpecialty(entity.getSpecialty());
                });
        marshall(this);
    }

    @Override
    public void delete(MedicalStaff entity) throws SQLException {
        medicalStaff = unmarshall();
        medicalStaff.stream()
                .filter(element -> element.getId() == entity.getId())
                .findAny()
                .ifPresent(deleteElement -> medicalStaff.remove(deleteElement));
        marshall(this);
    }
    private static synchronized List<MedicalStaff> unmarshall(){
        MedicalStaffDAO ms = new MedicalStaffDAO();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(MedicalStaffDAO.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ms = (MedicalStaffDAO) jaxbUnmarshaller.unmarshal(FILE);
        } catch (JAXBException ex) {
            LOGGER.error(ex);
        }
        return ms.getMedicalStaff();
    }

    private static synchronized void marshall(MedicalStaffDAO ms){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(MedicalStaffDAO.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(ms, FILE);
        } catch (JAXBException ex) {
            LOGGER.error(ex);
        }
    }
    public List<MedicalStaff> getMedicalStaff() {
        return medicalStaff;
    }

    public void setMedicalStaff(List<MedicalStaff> medicalStaff) {
        this.medicalStaff = medicalStaff;
    }
}
