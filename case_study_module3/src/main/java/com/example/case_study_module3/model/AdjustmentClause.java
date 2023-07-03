package com.example.case_study_module3.model;

public class AdjustmentClause {
    private String describe;
    private double value;

    public AdjustmentClause() {
    }

    public AdjustmentClause(String describe, double value) {
        this.describe = describe;
        this.value = value;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
