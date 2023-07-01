package com.example.case_study_module3.model;

import com.example.case_study_module3.enums.WorkingDateType;

import java.util.Date;

public class CalendarWorkingYear {
    private Date date;
    private int idWorkingDateType;

    public CalendarWorkingYear() {
    }

    public CalendarWorkingYear(Date date, int idWorkingDateType) {
        this.date = date;
        this.idWorkingDateType = idWorkingDateType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdWorkingDateType() {
        return idWorkingDateType;
    }

    public void setIdWorkingDateType(int idWorkingDateType) {
        this.idWorkingDateType = idWorkingDateType;
    }
}
