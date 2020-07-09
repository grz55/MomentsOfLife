package com.grz55.MomentsOfLife.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class DifferenceDatesCalculator {

    public long calculateBirthdayToNowDifference(LocalDateTime birthday, ChronoUnit unit) {
        return unit.between(birthday, LocalDateTime.now());
    }
}
