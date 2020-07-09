package com.grz55.MomentsOfLife.model;

import java.time.temporal.ChronoUnit;

public class Moment {

    private long count;
    private ChronoUnit unit;

    public Moment(long count, ChronoUnit unit) {
        this.count = count;
        this.unit = unit;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public ChronoUnit getUnit() {
        return unit;
    }

    public void setUnit(ChronoUnit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Moment{" +
                "count=" + count +
                ", unit=" + unit +
                '}';
    }
}
