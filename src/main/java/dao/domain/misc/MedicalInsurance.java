package dao.domain.misc;

import dao.domain.BaseModel;

public class MedicalInsurance extends BaseModel {
    private String partnerName;
    private int ssn;

    public MedicalInsurance(){}

    public MedicalInsurance(String partnerName, int ssn){
        this.partnerName = partnerName;
        this.ssn = ssn;
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
                ", partnerName='" + partnerName + '\'' +
                ", ssn=" + ssn +
                '}';
    }
}
