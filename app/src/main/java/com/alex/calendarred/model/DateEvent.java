package com.alex.calendarred.model;

import com.github.sundeepk.compactcalendarview.domain.Event;

import java.util.List;

public class DateEvent {

    private long timeInMillis;
    private List<Orders> orders;

    public DateEvent(long timeInMillis, List<Orders> orders) {
        this.timeInMillis = timeInMillis;
        this.orders = orders;
    }

    public long getTimeInMillis() {
        return timeInMillis;
    }

    public void setTimeInMillis(long timeInMillis) {
        this.timeInMillis = timeInMillis;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
