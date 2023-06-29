package com.example.case_study_module3.model;

import java.util.Date;

public class WorkingDateDetail {

    private Date workingDate;
    private  int idEmployee;
    private Date hoursIn;
    private Date hoursOut;

    public WorkingDateDetail() {
    }

    public WorkingDateDetail(Date workingDate, int idEmployee, Date hoursIn, Date hoursOut) {
        this.workingDate = workingDate;
        this.idEmployee = idEmployee;
        this.hoursIn = hoursIn;
        this.hoursOut = hoursOut;
    }

    public Date getWorkingDate() {
        return workingDate;
    }

    public void setWorkingDate(Date workingDate) {
        this.workingDate = workingDate;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Date getHoursIn() {
        return hoursIn;
    }

    public void setHoursIn(Date hoursIn) {
        this.hoursIn = hoursIn;
    }

    public Date getHoursOut() {
        return hoursOut;
    }

    public void setHoursOut(Date hoursOut) {
        this.hoursOut = hoursOut;
    }
}
