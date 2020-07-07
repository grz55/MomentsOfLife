package com.grz55.MomentsOfLife.model;

import com.grz55.MomentsOfLife.utils.DifferenceDatesCalculator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class ChosenDate {

    Integer yearsPassed;
    Integer monthsPassed;
    Integer weeksPassed;
    Integer daysPassed;
    Integer hoursPassed;
    Integer minutesPassed;
    Long secondsPassed;

    @NotNull
    @NotEmpty
    String birthdayString;

    String todayString;

    public ChosenDate() {
    }

    public ChosenDate(@NotNull String birthdayString) {
        this.birthdayString = birthdayString;
    }

    public void convertToFields(String chosenDate) throws ParseException {
        todayString = getTodayString();
        yearsPassed = DifferenceDatesCalculator.getDifferenceYears(getBirthdayString(), getTodayString());
        monthsPassed = DifferenceDatesCalculator.getDifferenceMonths(getBirthdayString(), getTodayString());
        weeksPassed = DifferenceDatesCalculator.getDifferenceWeeks(getBirthdayString(), getTodayString());
        daysPassed = DifferenceDatesCalculator.getDifferenceDays(getBirthdayString(), getTodayString());
        hoursPassed = DifferenceDatesCalculator.getDifferenceHours(getBirthdayString(), getTodayString());
        minutesPassed = DifferenceDatesCalculator.getDifferenceMinutes(getBirthdayString(), getTodayString());
        secondsPassed = DifferenceDatesCalculator.getDifferenceSeconds(getBirthdayString(), getTodayString());
    }

    public String getTodayString() {
        Date today = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(today);
    }

    public Integer getYearsPassed() {
        return yearsPassed;
    }

    public void setYearsPassed(Integer yearsPassed) {
        this.yearsPassed = yearsPassed;
    }

    public void setTodayString(String todayString) {
        this.todayString = todayString;
    }

    public String getBirthdayString() {
        return birthdayString;
    }

    public void setBirthdayString(String birthdayString) {
        this.birthdayString = birthdayString;
    }

    public Integer getMonthsPassed() {
        return monthsPassed;
    }

    public void setMonthsPassed(Integer monthsPassed) {
        this.monthsPassed = monthsPassed;
    }

    public Integer getDaysPassed() {
        return daysPassed;
    }

    public void setDaysPassed(Integer daysPassed) {
        this.daysPassed = daysPassed;
    }

    public Integer getWeeksPassed() {
        return weeksPassed;
    }

    public void setWeeksPassed(Integer weeksPassed) {
        this.weeksPassed = weeksPassed;
    }

    public Integer getHoursPassed() {
        return hoursPassed;
    }

    public void setHoursPassed(Integer hoursPassed) {
        this.hoursPassed = hoursPassed;
    }

    public Integer getMinutesPassed() {
        return minutesPassed;
    }

    public void setMinutesPassed(Integer minutesPassed) {
        this.minutesPassed = minutesPassed;
    }

    public Long getSecondsPassed() {
        return secondsPassed;
    }

    public void setSecondsPassed(Long secondsPassed) {
        this.secondsPassed = secondsPassed;
    }

    @Override
    public String toString() {
        return "ChosenDate{" +
                "yearsPassed=" + yearsPassed +
                ", monthsPassed=" + monthsPassed +
                ", weeksPassed=" + weeksPassed +
                ", daysPassed=" + daysPassed +
                ", hoursPassed=" + hoursPassed +
                ", minutesPassed=" + minutesPassed +
                ", secondsPassed=" + secondsPassed +
                ", birthdayString='" + birthdayString + '\'' +
                ", todayString='" + todayString + '\'' +
                '}';
    }
}
