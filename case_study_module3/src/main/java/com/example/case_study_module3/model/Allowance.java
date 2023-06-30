package com.example.case_study_module3.model;

public class Allowance {
    private int id;
    private int idTypeAllowance;
    private String name;
    private int value;

    public Allowance() {
    }

    public Allowance(int id, int idTypeAllowance, String name, int value) {
        this.id = id;
        this.idTypeAllowance = idTypeAllowance;
        this.name = name;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTypeAllowance() {
        return idTypeAllowance;
    }

    public void setIdTypeAllowance(int idTypeAllowance) {
        this.idTypeAllowance = idTypeAllowance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
