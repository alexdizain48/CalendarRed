package com.alex.calendarred.model;

import com.github.sundeepk.compactcalendarview.domain.Event;

import java.util.List;

public class DateEvent {

    private List<Orders2> orders;

    public DateEvent(List<Orders2> orders) {
        this.orders = orders;
    }

    public List<Orders2> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders2> orders) {
        this.orders = orders;
    }
}
