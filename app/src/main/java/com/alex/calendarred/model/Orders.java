package com.alex.calendarred.model;

public class Orders {

    private String procedure;
    private String time;
    private String nameclient;

    public Orders(String procedure, String time, String nameclient) {
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
