package com.alex.calendarred.model;

public class Orders {

    private String nameOrder;
    private String time;

    public Orders(String nameOrder, String time) {
        this.nameOrder = nameOrder;
        this.time = time;
    }

    public String getNameOrder() {
        return nameOrder;
    }

    public void setNameOrder(String nameOrder) {
        this.nameOrder = nameOrder;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
