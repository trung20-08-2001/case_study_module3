package com.example.case_study_module3.model;

public class TypeWorkingDate {
    private int IdTypeWorkingDate;
    private String name;

    public TypeWorkingDate() {
    }

    public TypeWorkingDate(int id, String name) {
        this.IdTypeWorkingDate = id;
        this.name = name;
    }


    public int getIdTypeWorkingDate() {
        return IdTypeWorkingDate;
    }

    public void setIdTypeWorkingDate(int idTypeWorkingDate) {
        this.IdTypeWorkingDate = idTypeWorkingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
