package com.example.case_study_module3.enums;

public enum WorkingDateType {
    NORMAL(1),HOLIDAY(2),WEEKEND(3),COMPENSATORY_LEAVE(4);
    private int value;
    WorkingDateType(int value){
        this.value=value;
    }

    public int getValue(){
        return value;
    }
}
