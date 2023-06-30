package com.example.case_study_module3.enums;

public enum Role {
    DIRECTOR(1),MANAGER(2), ADMIN(3), USER(4);
    private int value;

    Role(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}

