package com.grz55.MomentsOfLife.service;

import com.grz55.MomentsOfLife.model.ChosenDate;
import com.grz55.MomentsOfLife.model.LifeStats;
import com.grz55.MomentsOfLife.model.Moment;
import com.grz55.MomentsOfLife.utils.DifferenceDatesCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.Map;
import java.util.TreeMap;

@Service
public class LifeStatsService {

    private LifeStats lifeStats;
    private DifferenceDatesCalculator differenceDatesCalculator;

    @Autowired
    public LifeStatsService(LifeStats lifeStats, DifferenceDatesCalculator differenceDatesCalculator) {
        this.lifeStats = lifeStats;
        this.differenceDatesCalculator = differenceDatesCalculator;
    }

    public void calculateLifeStats(ChosenDate chosenDate) {
        lifeStats.setYears((int) differenceDatesCalculator.calculateBirthdayToNowDifference(chosenDate.getBirthday(), ChronoUnit.YEARS));
        lifeStats.setMonths((int) differenceDatesCalculator.calculateBirthdayToNowDifference(chosenDate.getBirthday(), ChronoUnit.MONTHS));
        lifeStats.setWeeks((int) differenceDatesCalculator.calculateBirthdayToNowDifference(chosenDate.getBirthday(), ChronoUnit.WEEKS));
        lifeStats.setDays((int) differenceDatesCalculator.calculateBirthdayToNowDifference(chosenDate.getBirthday(), ChronoUnit.DAYS));
        lifeStats.setHours((int) differenceDatesCalculator.calculateBirthdayToNowDifference(chosenDate.getBirthday(), ChronoUnit.HOURS));
        lifeStats.setMinutes((int) differenceDatesCalculator.calculateBirthdayToNowDifference(chosenDate.getBirthday(), ChronoUnit.MINUTES));
        lifeStats.setSeconds(differenceDatesCalculator.calculateBirthdayToNowDifference(chosenDate.getBirthday(), ChronoUnit.SECONDS));

        lifeStats.setYearsDatesMap(calculateMapOfMomentsByUnit(chosenDate.getBirthday(), lifeStats.getYears(), ChronoUnit.YEARS));
        lifeStats.setMonthsDatesMap(calculateMapOfMomentsByUnit(chosenDate.getBirthday(), lifeStats.getMonths(), ChronoUnit.MONTHS));
        lifeStats.setWeeksDatesMap(calculateMapOfMomentsByUnit(chosenDate.getBirthday(), lifeStats.getWeeks(), ChronoUnit.WEEKS));
        lifeStats.setDaysDatesMap(calculateMapOfMomentsByUnit(chosenDate.getBirthday(), lifeStats.getDays(), ChronoUnit.DAYS));
        lifeStats.setHoursDatesMap(calculateMapOfMomentsByUnit(chosenDate.getBirthday(), lifeStats.getHours(), ChronoUnit.HOURS));
        lifeStats.setMinutesDatesMap(calculateMapOfMomentsByUnit(chosenDate.getBirthday(), lifeStats.getMinutes(), ChronoUnit.MINUTES));
        lifeStats.setSecondsDatesMap(calculateMapOfMomentsByUnit(chosenDate.getBirthday(), lifeStats.getSeconds(), ChronoUnit.SECONDS));
    }

    public LifeStats getLifeStats() {
        return lifeStats;
    }

    private Map<LocalDate, Moment> calculateMapOfMomentsByUnit(LocalDateTime birthday, long passedCount, ChronoUnit unit) {
        LocalDateTime firstMoment;
        long loopFullCountStarter;
        long limit;
        int step;
        Map<LocalDate, Moment> momentsMap = new TreeMap<>();
        TemporalAmount durationToAdd;

        switch (unit) {
            case YEARS: {
                loopFullCountStarter = ((passedCount + 10) / 10) * 10;
                firstMoment = birthday.plusYears(loopFullCountStarter);
                limit = 100;
                step = 10;
                durationToAdd = Period.ofYears(step);
                break;
            }
            case MONTHS: {
                loopFullCountStarter = ((passedCount + 100) / 100) * 100;
                firstMoment = birthday.plusMonths(loopFullCountStarter);
                limit = 1200;
                step = 100;
                durationToAdd = Period.ofMonths(step);
                break;
            }
            case WEEKS: {
                loopFullCountStarter = ((passedCount + 100) / 100) * 100;
                firstMoment = birthday.plusWeeks(loopFullCountStarter);
                limit = 5300;
                step = 100;
                durationToAdd = Period.ofWeeks(step);
                break;
            }
            case DAYS: {
                loopFullCountStarter = ((passedCount + 1000) / 1000) * 1000;
                firstMoment = birthday.plusDays(loopFullCountStarter);
                limit = 36000;
                step = 1000;
                durationToAdd = Period.ofDays(step);
                break;
            }
            case HOURS: {
                loopFullCountStarter = ((passedCount + 100000) / 100000) * 100000;
                firstMoment = birthday.plusHours(loopFullCountStarter);
                limit = 900000;
                step = 100000;
                durationToAdd = Duration.ofHours(step);
                break;
            }
            case MINUTES: {
                loopFullCountStarter = ((passedCount + 1000000) / 1000000) * 1000000;
                firstMoment = birthday.plusMinutes(loopFullCountStarter);
                limit = 52000000;
                step = 1000000;
                durationToAdd = Duration.ofMinutes(step);
                break;
            }
            case SECONDS: {
                loopFullCountStarter = ((passedCount + 1000000000) / 1000000000) * 1000000000;
                firstMoment = birthday.plusSeconds(loopFullCountStarter);
                limit = 3000000000L;
                step = 1000000000;
                durationToAdd = Duration.ofSeconds(step);
                break;
            }
            default: {
                return momentsMap;
            }
        }

        for (long i = loopFullCountStarter; i <= limit; i += step) {
            Moment moment = new Moment(i, unit);
            momentsMap.put(firstMoment.toLocalDate(), moment);
            firstMoment = firstMoment.plus(durationToAdd);
        }

        return momentsMap;
    }

    public Map<LocalDate, Moment> getAllDatesMap() {
        Map<LocalDate, Moment> allDatesMap = new TreeMap<>();
        allDatesMap.putAll(lifeStats.getYearsDatesMap());
        allDatesMap.putAll(lifeStats.getMonthsDatesMap());
        allDatesMap.putAll(lifeStats.getWeeksDatesMap());
        allDatesMap.putAll(lifeStats.getDaysDatesMap());
        allDatesMap.putAll(lifeStats.getHoursDatesMap());
        allDatesMap.putAll(lifeStats.getMinutesDatesMap());
        allDatesMap.putAll(lifeStats.getSecondsDatesMap());
        return allDatesMap;
    }
}
