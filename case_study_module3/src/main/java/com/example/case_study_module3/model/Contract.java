package com.example.case_study_module3.model;

import java.util.Date;

public class Contract {
    private int id;
    private int idEmployee;
    private int idAllowance;
    private int idPosition;
    private int idDepartment;
    private int basicSalary;
    private Date startDay;
    private Date endDay;
    private boolean status;

    public Contract() {
    }

    public Contract(int id, int idEmployee, int idAllowance, int idPosition, int idDepartment, int basicSalary, Date startDay, Date endDay, boolean status) {
        this.id = id;
        this.idEmployee = idEmployee;
        this.idAllowance = idAllowance;
        this.idPosition = idPosition;
        this.idDepartment = idDepartment;
        this.basicSalary = basicSalary;
        this.startDay = startDay;
        this.endDay = endDay;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdAllowance() {
        return idAllowance;
    }

    public void setIdAllowance(int idAllowance) {
        this.idAllowance = idAllowance;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
