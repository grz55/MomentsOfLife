package com.grz55.MomentsOfLife.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

@Component
public class LifeStats {

    private int years;
    private int months;
    private int weeks;
    private int days;
    private int hours;
    private int minutes;
    private long seconds;

    private Map<LocalDate, Moment> yearsDatesMap = new TreeMap<>();
    private Map<LocalDate, Moment> monthsDatesMap = new TreeMap<>();
    private Map<LocalDate, Moment> daysDatesMap = new TreeMap<>();
    private Map<LocalDate, Moment> weeksDatesMap = new TreeMap<>();
    private Map<LocalDate, Moment> hoursDatesMap = new TreeMap<>();
    private Map<LocalDate, Moment> minutesDatesMap = new TreeMap<>();
    private Map<LocalDate, Moment> secondsDatesMap = new TreeMap<>();

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public long getSeconds() {
        return seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    public Map<LocalDate, Moment> getYearsDatesMap() {
        return yearsDatesMap;
    }

    public void setYearsDatesMap(Map<LocalDate, Moment> yearsDatesMap) {
        this.yearsDatesMap = yearsDatesMap;
    }

    public Map<LocalDate, Moment> getMonthsDatesMap() {
        return monthsDatesMap;
    }

    public void setMonthsDatesMap(Map<LocalDate, Moment> monthsDatesMap) {
        this.monthsDatesMap = monthsDatesMap;
    }

    public Map<LocalDate, Moment> getDaysDatesMap() {
        return daysDatesMap;
    }

    public void setDaysDatesMap(Map<LocalDate, Moment> daysDatesMap) {
        this.daysDatesMap = daysDatesMap;
    }

    public Map<LocalDate, Moment> getWeeksDatesMap() {
        return weeksDatesMap;
    }

    public void setWeeksDatesMap(Map<LocalDate, Moment> weeksDatesMap) {
        this.weeksDatesMap = weeksDatesMap;
    }

    public Map<LocalDate, Moment> getHoursDatesMap() {
        return hoursDatesMap;
    }

    public void setHoursDatesMap(Map<LocalDate, Moment> hoursDatesMap) {
        this.hoursDatesMap = hoursDatesMap;
    }

    public Map<LocalDate, Moment> getMinutesDatesMap() {
        return minutesDatesMap;
    }

    public void setMinutesDatesMap(Map<LocalDate, Moment> minutesDatesMap) {
        this.minutesDatesMap = minutesDatesMap;
    }

    public Map<LocalDate, Moment> getSecondsDatesMap() {
        return secondsDatesMap;
    }

    public void setSecondsDatesMap(Map<LocalDate, Moment> secondsDatesMap) {
        this.secondsDatesMap = secondsDatesMap;
    }
}
