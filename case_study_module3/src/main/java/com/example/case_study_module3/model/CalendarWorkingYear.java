package com.example.case_study_module3.model;

import java.util.Date;

public class CalendarWorkingYear {

    private int IdCalendarWorkingYear;
    private Date date;
    private int IdTypeWorkingDate;

    public CalendarWorkingYear() {
    }

    public CalendarWorkingYear(int idCalendarWorkingYear, Date date, int idTypeWorkingDate) {
        IdCalendarWorkingYear = idCalendarWorkingYear;
        this.date = date;
        IdTypeWorkingDate = idTypeWorkingDate;
    }

    public int getIdCalendarWorkingYear() {
        return IdCalendarWorkingYear;
    }

    public void setIdCalendarWorkingYear(int idCalendarWorkingYear) {
        IdCalendarWorkingYear = idCalendarWorkingYear;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdTypeWorkingDate() {
        return IdTypeWorkingDate;
    }

    public void setIdTypeWorkingDate(int idTypeWorkingDate) {
        IdTypeWorkingDate = idTypeWorkingDate;
    }
}
