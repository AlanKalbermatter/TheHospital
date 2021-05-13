package jaxb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Event extends BaseModel{
    @XmlElement(name = "reason")
    private String reason;

    public Event(){}

    public Event(String reason){
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Event{" +
                ", reason='" + reason + '\'' +
                '}';
    }
}
