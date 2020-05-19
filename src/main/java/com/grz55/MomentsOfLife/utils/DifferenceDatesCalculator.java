package com.grz55.MomentsOfLife.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DifferenceDatesCalculator {

    public static int getDifferenceYears(String date1, String date2){
        int diff = (int)ChronoUnit.YEARS.between(LocalDate.parse(date1), LocalDate.parse(date2));
        return diff;
    }

    public static int getDifferenceMonths(String date1, String date2) {
        int diff = (int)ChronoUnit.MONTHS.between(LocalDate.parse(date1), LocalDate.parse(date2));
        return diff;
    }

    public static int getDifferenceWeeks(String date1, String date2) {
        int diff = (int)ChronoUnit.WEEKS.between(LocalDate.parse(date1),LocalDate.parse(date2));
        return diff;
    }

    public static int getDifferenceDays(String date1, String date2) {
        int diff = (int)ChronoUnit.DAYS.between(LocalDate.parse(date1),LocalDate.parse(date2));
        return diff;
    }

    public static int getDifferenceHours(String date1, String date2) {
        int diff = (int)ChronoUnit.DAYS.between(LocalDate.parse(date1),LocalDate.parse(date2))*24;
        return diff;
    }

    public static int getDifferenceMinutes(String date1, String date2) {
        int diff = (int)ChronoUnit.DAYS.between(LocalDate.parse(date1),LocalDate.parse(date2))*24*60;
        return diff;
    }

    public static long getDifferenceSeconds(String date1, String date2) {
        long diff = ChronoUnit.DAYS.between(LocalDate.parse(date1),LocalDate.parse(date2))*24*60*60;
        return diff;
    }
}
