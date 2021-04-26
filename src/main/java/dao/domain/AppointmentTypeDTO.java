package dao.domain;

public enum AppointmentTypeDTO {
    ROUTINE_APPOINTMENT("This is a routine appointment"),
    CONTROL_APPOINTMENT("This is a control appointment"),
    REVIEW_APPOINTMENT("This is a review appointment");

    private String description;

    private AppointmentTypeDTO(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
