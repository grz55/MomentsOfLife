package com.grz55.MomentsOfLife.service;

import com.grz55.MomentsOfLife.model.ChosenDate;
import com.grz55.MomentsOfLife.model.Moment;
import com.grz55.MomentsOfLife.model.Periods;

import java.time.*;
import java.time.temporal.TemporalAmount;
import java.util.*;


public class MomentsOfLifeAnalyzer {

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
    private Map<LocalDate, Moment> allDatesMap = new TreeMap<>();

    public MomentsOfLifeAnalyzer(ChosenDate chosenDate) {
        years = chosenDate.getYearsPassed();
        months = chosenDate.getMonthsPassed();
        weeks = chosenDate.getWeeksPassed();
        days = chosenDate.getDaysPassed();
        hours = chosenDate.getHoursPassed();
        minutes = chosenDate.getMinutesPassed();
        seconds = chosenDate.getSecondsPassed();
        calculateMoments(chosenDate.getBirthdayString());
    }

    private void calculateMoments(String birthdayString){
        yearsDatesMap = calculateMomentsPeriod(birthdayString, years, Periods.YEAR);
        monthsDatesMap = calculateMomentsPeriod(birthdayString, months, Periods.MONTH);
        weeksDatesMap = calculateMomentsPeriod(birthdayString, weeks, Periods.WEEK);
        daysDatesMap = calculateMomentsPeriod(birthdayString, days, Periods.DAY);
        hoursDatesMap = calculateMomentsPeriod(birthdayString, hours, Periods.HOUR);
        minutesDatesMap = calculateMomentsPeriod(birthdayString, minutes, Periods.MINUTE);
        secondsDatesMap = calculateMomentsPeriod(birthdayString, seconds, Periods.SECOND);
        putAllMapsTogether();
    }

    public Map<LocalDate,Moment> calculateMomentsPeriod(String birthdayString, long passedCount, Periods period){
        LocalDateTime birthday = LocalDateTime.of(LocalDate.parse(birthdayString),LocalTime.MIDNIGHT);
        LocalDateTime firstMoment;
        long loopFullCountStarter;
        long limit;
        int step;
        Map<LocalDate,Moment> momentsMap = new TreeMap<>();
        TemporalAmount durationToAdd;

        switch(period){
            case YEAR:{
                loopFullCountStarter = ((passedCount + 10) / 10) * 10;
                firstMoment = birthday.plusYears(loopFullCountStarter);
                limit = 100;
                step = 10;
                durationToAdd = Period.ofYears(step);
                break;
            }
            case MONTH:{
                loopFullCountStarter = ((passedCount + 100) / 100) * 100;
                firstMoment = birthday.plusMonths(loopFullCountStarter);
                limit = 1200;
                step = 100;
                durationToAdd = Period.ofMonths(step);
                break;
            }
            case WEEK:{
                loopFullCountStarter = ((passedCount + 100) / 100) * 100;
                firstMoment = birthday.plusWeeks(loopFullCountStarter);
                limit = 5300;
                step = 100;
                durationToAdd = Period.ofWeeks(step);
                break;
            }
            case DAY:{
                loopFullCountStarter = ((passedCount + 1000) / 1000) * 1000;
                firstMoment = birthday.plusDays(loopFullCountStarter);
                limit = 36000;
                step = 1000;
                durationToAdd = Period.ofDays(step);
                break;
            }
            case HOUR:{
                loopFullCountStarter = ((passedCount + 100000) / 100000) * 100000;
                firstMoment = birthday.plusHours(loopFullCountStarter);
                limit = 900000;
                step = 100000;
                durationToAdd = Duration.ofHours(step);
                break;
            }
            case MINUTE:{
                loopFullCountStarter = ((passedCount + 1000000) / 1000000) * 1000000;
                firstMoment = birthday.plusMinutes(loopFullCountStarter);
                limit = 52000000;
                step = 1000000;
                durationToAdd = Duration.ofMinutes(step);
                break;
            }
            case SECOND:{
                loopFullCountStarter = ((passedCount + 1000000000) / 1000000000) * 1000000000;
                firstMoment = birthday.plusSeconds(loopFullCountStarter);
                limit = 3000000000L;
                step = 1000000000;
                durationToAdd = Duration.ofSeconds(step);
                break;
            }
            default:{
                return momentsMap;
            }
        }

        for(long i = loopFullCountStarter; i <= limit; i+= step){
            Moment moment = new Moment(i, period);
            momentsMap.put(firstMoment.toLocalDate(),moment);
            firstMoment = firstMoment.plus(durationToAdd);
        }

        return momentsMap;
    }

    public void putAllMapsTogether(){
        allDatesMap.putAll(secondsDatesMap);
        allDatesMap.putAll(minutesDatesMap);
        allDatesMap.putAll(hoursDatesMap);
        allDatesMap.putAll(daysDatesMap);
        allDatesMap.putAll(weeksDatesMap);
        allDatesMap.putAll(monthsDatesMap);
        allDatesMap.putAll(yearsDatesMap);
    }

    public void printAllMaps(){
        System.out.println(yearsDatesMap);
        System.out.println(monthsDatesMap);
        System.out.println(weeksDatesMap);
        System.out.println(daysDatesMap);
        System.out.println(hoursDatesMap);
        System.out.println(minutesDatesMap);
        System.out.println(secondsDatesMap);
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
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

    public Map<LocalDate, Moment> getAllDatesMap() {
        return allDatesMap;
    }
}
