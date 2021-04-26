package dao.domain;

public class EventDTO extends BaseModel{
    private String reason;

    public EventDTO(){}

    public EventDTO(String reason){
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