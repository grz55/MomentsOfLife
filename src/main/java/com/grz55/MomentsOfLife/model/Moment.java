package com.grz55.MomentsOfLife.model;

public class Moment {

    private long count;
    private Periods period;

    public Moment(long count, Periods period) {
        this.count = count;
        this.period = period;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Periods getPeriod() {
        return period;
    }

    public void setPeriod(Periods period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "Moment{" +
                "count=" + count +
                ", period=" + period +
                '}';
    }
}
