package com.grz55.MomentsOfLife.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Component
public class ChosenDate {

    @NotNull
    @NotEmpty
    private String birthdayString;

    private LocalDateTime birthday;


    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getBirthdayString() {
        return birthdayString;
    }

    public void setBirthdayString(String birthdayString) {
        this.birthdayString = birthdayString;
    }

    @Override
    public String toString() {
        return "ChosenDate{" +
                "birthdayString='" + birthdayString + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
