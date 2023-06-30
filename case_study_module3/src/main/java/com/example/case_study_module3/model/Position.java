package com.example.case_study_module3.model;

public class Position {
    private int id;
    private  String name;

    private int valueAllowance;
    public Position (){}

    public Position(int id, String name, int valueAllowance) {
        this.id = id;
        this.name = name;
        this.valueAllowance = valueAllowance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValueAllowance() {
        return valueAllowance;
    }

    public void setValueAllowance(int valueAllowance) {
        this.valueAllowance = valueAllowance;
    }
}
