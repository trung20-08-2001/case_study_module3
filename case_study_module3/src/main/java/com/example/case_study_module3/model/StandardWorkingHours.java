package com.example.case_study_module3.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class StandardWorkingHours {
    private double hoursIn;
    private double hoursOut;

    public StandardWorkingHours() {
    }

    public StandardWorkingHours(double hoursIn, double hoursOut) {
        this.hoursIn = hoursIn;
        this.hoursOut = hoursOut;
    }

    public double getHoursIn() {
        return hoursIn;
    }

    public void setHoursIn(double hoursIn) {
        this.hoursIn = hoursIn;
    }

    public double getHoursOut() {
        return hoursOut;
    }

    public void setHoursOut(double hoursOut) {
        this.hoursOut = hoursOut;
    }
}
