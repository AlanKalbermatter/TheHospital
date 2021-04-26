package dao.domain;

public class PrescriptionDTO extends BaseModel{

    private String details;

    public PrescriptionDTO() {}

    public PrescriptionDTO(String details){
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
