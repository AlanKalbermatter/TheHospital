package dao.domain;

public class Prescription {
    private long id;
    private String details;

    public Prescription() {}

    public Prescription(String details){
        this.details = details;
    }

    public long getId() {
        return id;
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
                "id=" + id +
                ", details='" + details + '\'' +
                '}';
    }
}
