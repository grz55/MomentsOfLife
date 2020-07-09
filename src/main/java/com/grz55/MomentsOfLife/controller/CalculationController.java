package com.grz55.MomentsOfLife.controller;

import com.grz55.MomentsOfLife.model.ChosenDate;
import com.grz55.MomentsOfLife.model.LifeStats;
import com.grz55.MomentsOfLife.service.LifeStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller
public class CalculationController implements WebMvcConfigurer {

    private static final String EMPTY_INPUT_MESSAGE = "Input field can't be empty";
    private static final String FUTURE_DATE_MESSAGE = "Future date can't be chosen";

    private ChosenDate chosenDate;
    private LifeStats lifeStats;
    private LifeStatsService lifeStatsService;

    @Autowired
    public CalculationController(ChosenDate chosenDate, LifeStats lifeStats, LifeStatsService lifeStatsService) {
        this.chosenDate = chosenDate;
        this.lifeStats = lifeStats;
        this.lifeStatsService = lifeStatsService;
    }

    @GetMapping("/")
    public String showForm(ChosenDate chosenDate) {
        return "form";
    }

    @PostMapping("/")
    public String checkDate(@Valid ChosenDate chosenDate, BindingResult bindingResult, Model model) {

        if (chosenDate.getBirthdayString().isEmpty()) {
            bindingResult.addError(new ObjectError("birthday", EMPTY_INPUT_MESSAGE));
        } else if (LocalDate.parse(chosenDate.getBirthdayString()).isAfter(LocalDate.now())) {
            bindingResult.addError(new ObjectError("birthday", FUTURE_DATE_MESSAGE));
        }

        if (bindingResult.hasErrors()) {
            return "form";
        }

        chosenDate.setBirthday(LocalDateTime.of(LocalDate.parse(chosenDate.getBirthdayString()), LocalTime.MIDNIGHT));
        lifeStatsService.calculateLifeStats(chosenDate);
        return "redirect:/stats";
    }

    @GetMapping("/stats")
    public String showStats(Model model) {
        lifeStats = lifeStatsService.getLifeStats();
        model.addAttribute("yearsPassed", lifeStats.getYears());
        model.addAttribute("monthsPassed", lifeStats.getMonths());
        model.addAttribute("weeksPassed", lifeStats.getWeeks());
        model.addAttribute("daysPassed", lifeStats.getDays());
        model.addAttribute("hoursPassed", lifeStats.getHours());
        model.addAttribute("minutesPassed", lifeStats.getMinutes());
        model.addAttribute("secondsPassed", lifeStats.getSeconds());
        model.addAttribute("todayDate", LocalDate.now());
        model.addAttribute("birthdayString", chosenDate.getBirthday());
        return "stats";
    }

    @GetMapping("/all-dates")
    public String showAllDates(Model model) {
        model.addAttribute("datesMap", lifeStatsService.getAllDatesMap());
        return "all-dates";
    }

    @GetMapping("/years")
    public String showOnlyYears(Model model) {
        model.addAttribute("datesMap", lifeStats.getYearsDatesMap());
        return "years";
    }

    @GetMapping("/months")
    public String showOnlyMonths(Model model) {
        model.addAttribute("datesMap", lifeStats.getMonthsDatesMap());
        return "months";
    }

    @GetMapping("/weeks")
    public String showOnlyWeeks(Model model) {
        model.addAttribute("datesMap", lifeStats.getWeeksDatesMap());
        return "weeks";
    }

    @GetMapping("/days")
    public String showOnlyDays(Model model) {
        model.addAttribute("datesMap", lifeStats.getDaysDatesMap());
        return "days";
    }

    @GetMapping("/hours")
    public String showOnlyHours(Model model) {
        model.addAttribute("datesMap", lifeStats.getHoursDatesMap());
        return "hours";
    }

    @GetMapping("/minutes")
    public String showOnlyMinutes(Model model) {
        model.addAttribute("datesMap", lifeStats.getMinutesDatesMap());
        return "minutes";
    }

    @GetMapping("/seconds")
    public String showOnlySeconds(Model model) {
        model.addAttribute("datesMap", lifeStats.getSecondsDatesMap());
        return "seconds";
    }
}
