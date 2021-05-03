package dao.domain.misc;

public enum PositionDTO {
    NURSE("Nurse"),
    DOCTOR("Doctor"),
    PEDIATRICIAN("Pediatrician"),
    SURGEON("Surgeon");

    private String positionName;

    PositionDTO(){}

    PositionDTO(String positionName){
        this.positionName = positionName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
