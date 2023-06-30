package com.example.case_study_module3.enums;

public enum Role {
    ADMIN(1),MANAGER(2),HR(3),EMPLOYEE(4);
    private int value;

    Role(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
