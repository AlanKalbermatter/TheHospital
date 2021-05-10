package dao.domain.misc;

public enum Position {
    NURSE("Nurse"),
    DOCTOR("Doctor"),
    PEDIATRICIAN("Pediatrician"),
    SURGEON("Surgeon");

    private String positionName;

    Position(){}

    Position(String positionName){
        this.positionName = positionName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
