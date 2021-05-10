package dao.domain.misc;

import dao.domain.BaseModel;

public class Prescription extends BaseModel {

    private String details;

    public Prescription() {}

    public Prescription(String details){
        this.details = details;
    }


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                ", details='" + details + '\'' +
                '}';
    }
}
