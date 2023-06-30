package com.example.case_study_module3.model;

import java.util.Date;

public class Employee {
    private  int id;
    private String password;
    private int idPosition;
    private boolean statusContract;
    private int idCalendarWorkingYear;
    private String name;
    private Date birthday;
    private String phone;
    private Date joinDate;
    private byte numberOfDependents;
    private  String img;

    public Employee() {
    }

    public Employee(int id, String password, int idPosition, boolean statusContract, int idCalendarWorkingYear, String name, Date birthday, String phone, Date joinDate, byte numberOfDependents, String img) {
        this.id = id;
        this.password = password;
        this.idPosition = idPosition;
        this.statusContract = statusContract;
        this.idCalendarWorkingYear = idCalendarWorkingYear;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.joinDate = joinDate;
        this.numberOfDependents = numberOfDependents;
        this.img = img;
    }

    public Employee(int id, String password, int idPosition, String name,boolean statusContract) {
        this.id = id;
        this.password = password;
        this.idPosition = idPosition;
        this.name=name;
        this.statusContract=statusContract;
    }

    public boolean isStatusContract() {
        return statusContract;
    }

    public void setStatusContract(boolean statusContract) {
        this.statusContract = statusContract;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdCalendarWorkingYear() {
        return idCalendarWorkingYear;
    }

    public void setIdCalendarWorkingYear(int idCalendarWorkingYear) {
        this.idCalendarWorkingYear = idCalendarWorkingYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public byte getNumberOfDependents() {
        return numberOfDependents;
    }

    public void setNumberOfDependents(byte numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
