package dao.domain.misc;

import dao.domain.BaseModel;

public class Event extends BaseModel {
    private String reason;

    public Event(){}

    public Event(String reason){
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