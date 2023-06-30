package com.example.case_study_module3.model;

import java.util.Date;

public class CalendarWorkingYear {

    private int id;
    private Date date;
    private int IdTypeWorkingDate;

    public CalendarWorkingYear() {
    }

    public CalendarWorkingYear(int id, Date date, int idTypeWorkingDate) {
        this.id = id;
        this.date = date;
        IdTypeWorkingDate = idTypeWorkingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
