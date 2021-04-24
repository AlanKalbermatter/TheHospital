package dao.domain;

import java.sql.Date;

public class Appointment {
    private long id;
    private Date date;

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointments{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
