package com.solvd.hospital.generics;

import java.util.Date;

public class EventsCalendar<I, A>{

    private I information;
    private A activity;
    private Date date;

    public EventsCalendar(){}

    public EventsCalendar(I information, A activity, Date date){
        this.information = information;
        this.activity = activity;
        this.date = date;
    }

    public I getInformation() {
        return information;
    }

    public void setInformation(I information) {
        this.information = information;
    }

    public A getActivity() {
        return activity;
    }

    public void setActivity(A activity) {
        this.activity = activity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
