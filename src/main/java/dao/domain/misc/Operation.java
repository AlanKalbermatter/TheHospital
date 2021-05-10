package dao.domain.misc;

import dao.domain.BaseModel;

import java.sql.Date;

public class Operation extends BaseModel {
    private Date date;
    private String reason;

    public Operation(){}

    public Operation(Date date, String reason){
        this.date = date;
        this.reason = reason;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Operation{" +
                ", date=" + date +
                ", reason='" + reason + '\'' +
                '}';
    }
}