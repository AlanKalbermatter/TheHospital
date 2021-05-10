package jaxb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BaseModel {

    @XmlAttribute(name = "id")
    private long id;

    public BaseModel(){}

    public BaseModel(long id){
        this.id = id;
    }

    public long getId() {return id;}

    public void setId(long id){
        this.id = id;
    }
}
