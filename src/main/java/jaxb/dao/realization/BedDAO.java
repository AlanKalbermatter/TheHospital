package jaxb.dao.realization;

import jaxb.dao.interfaces.IBedDAO;
import jaxb.model.Bed;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

@XmlRootElement(name = "beds")
@XmlAccessorType(XmlAccessType.FIELD)
public class BedDAO implements IBedDAO{

    private static final Logger LOGGER = LogManager.getLogger(BedDAO.class);
    private static final File FILE = new File("src/main/resources/xml/beds.xml");
    @XmlElement(name = "bed")
    private List<Bed> beds = null;

    @Override
    public void save(Bed entity){
        beds = unmarshall();
        beds.add(entity);
        marshall(this);
    }

    @Override
    public Bed getById(long id){
        beds = unmarshall();
        return beds.stream()
                .filter(element -> element.getId() == id)
                .findAny()
                .orElse(null);
    }           

    @Override
    public void update(Bed entity){
        beds = unmarshall();
        beds.stream()
                .filter(element -> element.getId() == entity.getId())
                .findAny()
                .ifPresent(updateElement -> updateElement.setRoomNumber(entity.getRoomNumber()));
        marshall(this);
    }

    @Override
    public void delete(Bed entity){
        beds = unmarshall();
        beds.stream()
                .filter(element -> element.getId() == entity.getId())
                .findAny()
                .ifPresent(deleteElement -> beds.remove(deleteElement));
        marshall(this);
    }

    private static synchronized List<Bed> unmarshall(){
        BedDAO bed = new BedDAO();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BedDAO.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            bed = (BedDAO) jaxbUnmarshaller.unmarshal(FILE);
        } catch (JAXBException ex) {
            LOGGER.error(ex);
        }
        return bed.getBeds();
    }

    private static synchronized void marshall(BedDAO bed){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(BedDAO.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(bed, FILE);
        } catch (JAXBException ex) {
            LOGGER.error(ex);
        }
    }

    public List<Bed> getBeds() {
        return beds;
    }

    public void setBeds(List<Bed> beds) {
        this.beds = beds;
    }
}
