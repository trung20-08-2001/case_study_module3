package com.example.case_study_module3.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class TimeRecord {
    private Date workingDate;
    private int idWorkingDateType;
    private String nameWorkingDateType;
    private Timestamp checkInTime;
    private Timestamp checkOutTime;
    private double workingHours;
    private double overTimeHours;
    private boolean status;
    public TimeRecord() {
    }

    public TimeRecord(Date workingDate, int idWorkingDateType, String nameWorkingDateType, Timestamp checkInTime, Timestamp checkOutTime, double workingHours, double overTimeHours, boolean status) {
        this.workingDate = workingDate;
        this.idWorkingDateType = idWorkingDateType;
        this.nameWorkingDateType = nameWorkingDateType;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.workingHours = workingHours;
        this.overTimeHours = overTimeHours;
        this.status = status;
    }

    public Date getWorkingDate() {
        return workingDate;
    }

    public void setWorkingDate(Date workingDate) {
        this.workingDate = workingDate;
    }

    public int getIdWorkingDateType() {
        return idWorkingDateType;
    }

    public void setIdWorkingDateType(int idWorkingDateType) {
        this.idWorkingDateType = idWorkingDateType;
    }

    public String getNameWorkingDateType() {
        return nameWorkingDateType;
    }

    public void setNameWorkingDateType(String nameWorkingDateType) {
        this.nameWorkingDateType = nameWorkingDateType;
    }

    public String getCheckInTime() {
        LocalDateTime localDateTime=this.checkInTime.toLocalDateTime();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();
        return hour+":"+minute+":"+second;
    }

    public Timestamp checkInHour(){
        return checkInTime;
    }

    public void setCheckInTime(Timestamp checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        LocalDateTime localDateTime=this.checkOutTime.toLocalDateTime();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();
        return hour+":"+minute+":"+second;
    }

    public Timestamp checkOutHour(){
        return this.checkOutTime;
    }

    public void setCheckOutTime(Timestamp checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    public double getOverTimeHours() {
        return overTimeHours;
    }

    public void setOverTimeHours(double overTimeHours) {
        this.overTimeHours = overTimeHours;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}

