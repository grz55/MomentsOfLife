package com.grz55.MomentsOfLife.controller;

import com.grz55.MomentsOfLife.model.ChosenDate;
import com.grz55.MomentsOfLife.model.Moment;
import com.grz55.MomentsOfLife.model.Periods;
import com.grz55.MomentsOfLife.service.MomentsOfLifeAnalyzer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Map;

@Controller
public class CalculationController implements WebMvcConfigurer {

    ChosenDate chosenDate;

    @GetMapping("/")
    public String showForm(ChosenDate chosenDate) {
        return "form";
    }

    @PostMapping("/")
    public String checkDate(Model model, @Valid ChosenDate chosenDate, BindingResult bindingResult) throws ParseException {

        if(chosenDate.getBirthdayString().equals(""))
            bindingResult.addError(new ObjectError("birthdayString","Input field can't be null"));
        else {
            if(LocalDate.parse(chosenDate.getBirthdayString()).toEpochDay()>LocalDate.now().toEpochDay())
                bindingResult.addError(new ObjectError("birthdayString", "Future date can't be chosen"));
        }

        if (bindingResult.hasErrors()) {
            return "form";
        }
        chosenDate.convertToFields(chosenDate.getBirthdayString());
        this.chosenDate = chosenDate;

        MomentsOfLifeAnalyzer analyzer = new MomentsOfLifeAnalyzer(chosenDate);

        model.addAttribute("yearsPassed", chosenDate.getYearsPassed());
        model.addAttribute("monthsPassed", chosenDate.getMonthsPassed());
        model.addAttribute("weeksPassed", chosenDate.getWeeksPassed());
        model.addAttribute("daysPassed", chosenDate.getDaysPassed());
        model.addAttribute("hoursPassed", NumberFormat.getNumberInstance(Locale.US).format(chosenDate.getHoursPassed()));
        model.addAttribute("minutesPassed", NumberFormat.getNumberInstance(Locale.US).format(chosenDate.getMinutesPassed()));
        model.addAttribute("secondsPassed", NumberFormat.getNumberInstance(Locale.US).format(chosenDate.getSecondsPassed()));
        model.addAttribute("todayString", chosenDate.getTodayString());
        model.addAttribute("birthdayString", chosenDate.getBirthdayString());
        model.addAttribute("allDates",analyzer.getAllDatesMap());
        return "results";
    }

    @GetMapping("/stats")
    public String showStats(Model model) throws ParseException {

        chosenDate.convertToFields(chosenDate.getBirthdayString());
        model.addAttribute("yearsPassed", chosenDate.getYearsPassed());
        model.addAttribute("monthsPassed", chosenDate.getMonthsPassed());
        model.addAttribute("weeksPassed", chosenDate.getWeeksPassed());
        model.addAttribute("daysPassed", chosenDate.getDaysPassed());
        model.addAttribute("hoursPassed", NumberFormat.getNumberInstance(Locale.US).format(chosenDate.getHoursPassed()));
        model.addAttribute("minutesPassed", NumberFormat.getNumberInstance(Locale.US).format(chosenDate.getMinutesPassed()));
        model.addAttribute("secondsPassed", NumberFormat.getNumberInstance(Locale.US).format(chosenDate.getSecondsPassed()));
        model.addAttribute("todayString", chosenDate.getTodayString());
        model.addAttribute("birthdayString", chosenDate.getBirthdayString());

        return "stats";
    }

    @GetMapping("/allDates")
    public String showAllDates(Model model) {
        MomentsOfLifeAnalyzer analyzer = new MomentsOfLifeAnalyzer(chosenDate);
        model.addAttribute("datesMap", analyzer.getAllDatesMap());

        return "allDates";
    }

    @GetMapping("/years")
    public String showOnlyYears(Model model) {
        MomentsOfLifeAnalyzer analyzer = new MomentsOfLifeAnalyzer(chosenDate);
        Map<LocalDate, Moment> yearsMap =  analyzer.calculateMomentsPeriod(chosenDate.getBirthdayString(),chosenDate.getYearsPassed(), Periods.YEAR);
        model.addAttribute("datesMap", yearsMap);

        return "years";
    }

    @GetMapping("/months")
    public String showOnlyMonths(Model model) {
        MomentsOfLifeAnalyzer analyzer = new MomentsOfLifeAnalyzer(chosenDate);
        Map<LocalDate, Moment> monthsMap =  analyzer.calculateMomentsPeriod(chosenDate.getBirthdayString(),chosenDate.getMonthsPassed(), Periods.MONTH);
        model.addAttribute("datesMap", monthsMap);

        return "months";
    }

    @GetMapping("/weeks")
    public String showOnlyWeeks(Model model) {
        MomentsOfLifeAnalyzer analyzer = new MomentsOfLifeAnalyzer(chosenDate);
        Map<LocalDate, Moment> weeksMap =  analyzer.calculateMomentsPeriod(chosenDate.getBirthdayString(),chosenDate.getWeeksPassed(), Periods.WEEK);
        model.addAttribute("datesMap", weeksMap);

        return "weeks";
    }

    @GetMapping("/days")
    public String showOnlyDays(Model model) {
        MomentsOfLifeAnalyzer analyzer = new MomentsOfLifeAnalyzer(chosenDate);
        Map<LocalDate, Moment> daysMap =  analyzer.calculateMomentsPeriod(chosenDate.getBirthdayString(),chosenDate.getDaysPassed(), Periods.DAY);
        model.addAttribute("datesMap", daysMap);

        return "days";
    }

    @GetMapping("/hours")
    public String showOnlyHours(Model model) {
        MomentsOfLifeAnalyzer analyzer = new MomentsOfLifeAnalyzer(chosenDate);
        Map<LocalDate, Moment> hoursMap =  analyzer.calculateMomentsPeriod(chosenDate.getBirthdayString(),chosenDate.getHoursPassed(), Periods.HOUR);
        model.addAttribute("datesMap", hoursMap);

        return "hours";
    }

    @GetMapping("/minutes")
    public String showOnlyMinutes(Model model) {
        MomentsOfLifeAnalyzer analyzer = new MomentsOfLifeAnalyzer(chosenDate);
        Map<LocalDate, Moment> minutesMap =  analyzer.calculateMomentsPeriod(chosenDate.getBirthdayString(),chosenDate.getMinutesPassed(), Periods.MINUTE);
        model.addAttribute("datesMap", minutesMap);

        return "minutes";
    }

    @GetMapping("/seconds")
    public String showOnlySeconds(Model model) {
        MomentsOfLifeAnalyzer analyzer = new MomentsOfLifeAnalyzer(chosenDate);
        Map<LocalDate, Moment> secondsMap =  analyzer.calculateMomentsPeriod(chosenDate.getBirthdayString(),chosenDate.getSecondsPassed(), Periods.SECOND);
        model.addAttribute("datesMap", secondsMap);

        return "seconds";
    }
}
