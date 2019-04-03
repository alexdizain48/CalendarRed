package com.alex.calendarred.model;
import com.github.sundeepk.compactcalendarview.domain.Event;

public class OrdersFromCalendar {

    private String procedure;
    private String time;
    private String nameclient;

    public OrdersFromCalendar(String procedure, String time, String nameclient) {
        this.procedure = procedure;
        this.time = time;
        this.nameclient = nameclient;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNameclient() {
        return nameclient;
    }

    public void setNameclient(String nameclient) {
        this.nameclient = nameclient;
    }
}
