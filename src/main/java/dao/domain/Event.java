package dao.domain;

public class Event {
    private long id;
    private String reason;

    public Event(){}

    public Event(String reason){
        this.reason = reason;
    }

    public long getId() {
        return id;
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
                "id=" + id +
                ", reason='" + reason + '\'' +
                '}';
    }
}
