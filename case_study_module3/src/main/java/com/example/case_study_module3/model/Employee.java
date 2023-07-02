package com.example.case_study_module3.model;

import java.util.Date;

public class Employee {
    private  int id;
    private String password;
    private int idPosition;
    private String namePosition;
    private String nameDepartment;
    private boolean statusContract;
    private String name;
    private Date birthday;
    private String phone;
    private Date joinDate;
    private byte numberOfDependents;
    private  String img;

    public Employee() {
    }

    public Employee(int id, String password, int idPosition, String namePosition, String nameDepartment, boolean statusContract, String name, Date birthday, String phone, Date joinDate, byte numberOfDependents, String img) {
        this.id = id;
        this.password = password;
        this.idPosition = idPosition;
        this.namePosition = namePosition;
        this.nameDepartment = nameDepartment;
        this.statusContract = statusContract;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.joinDate = joinDate;
        this.numberOfDependents = numberOfDependents;
        this.img = img;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
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

    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }

}
