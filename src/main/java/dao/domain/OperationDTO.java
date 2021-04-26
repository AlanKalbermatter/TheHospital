package dao.domain;

import java.sql.Date;

public class OperationDTO {
    private long id;
    private Date date;
    private String reason;

    public OperationDTO(){}

    public OperationDTO(Date date, String reason){
        this.date = date;
        this.reason = reason;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
                "id=" + id +
                ", date=" + date +
                ", reason='" + reason + '\'' +
                '}';
    }
}