package dao.domain;

public class MedicalInsurance {
    private long id;
    private String partnerName;
    private int ssn;

    public MedicalInsurance(){}

    public MedicalInsurance(String partnerName, int ssn){
        this.partnerName = partnerName;
        this.ssn = ssn;
    }

    public long getId() {
        return id;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "MedicalInsurance{" +
                "id=" + id +
                ", partnerName='" + partnerName + '\'' +
                ", ssn=" + ssn +
                '}';
    }
}
