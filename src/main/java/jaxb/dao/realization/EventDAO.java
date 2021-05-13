package jaxb.dao.realization;

import jaxb.dao.interfaces.IEventDAO;
import jaxb.model.Event;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import java.io.File;
import java.util.List;

public class EventDAO implements IEventDAO {
    private static final Logger LOGGER = LogManager.getLogger(EventDAO.class);
    private static final File FILE = new File("src/main/resources/xml/events.xml");
    @XmlElement(name = "event")
    private List<Event> events = null;


    @Override
    public void save(Event entity) {
        events = unmarshall();
        events.add(entity);
        marshall(this);
    }

    @Override
    public Event getById(long id) {
        events = unmarshall();
        return events.stream()
                .filter(element -> element.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void update(Event entity) {
        events = unmarshall();
        events.stream()
                .filter(element -> element.getId() == entity.getId())
                .findAny()
                .ifPresent(updateElement -> updateElement.setReason(entity.getReason()));
        marshall(this);
    }

    @Override
    public void delete(Event entity) {
        events = unmarshall();
        events.stream()
                .filter(element -> element.getId() == entity.getId())
                .findAny()
                .ifPresent(deleteElement -> events.remove(deleteElement));
        marshall(this);
    }

    private static synchronized List<Event> unmarshall(){
        EventDAO event = new EventDAO();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(EventDAO.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            event = (EventDAO) jaxbUnmarshaller.unmarshal(FILE);
        } catch (JAXBException ex) {
            LOGGER.error(ex);
        }
        return event.getEvents();
    }

    private static synchronized void marshall(EventDAO event){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(EventDAO.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(event, FILE);
        } catch (JAXBException ex) {
            LOGGER.error(ex);
        }
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
