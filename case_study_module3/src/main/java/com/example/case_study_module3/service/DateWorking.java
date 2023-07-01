package com.example.case_study_module3.service;

import com.example.case_study_module3.enums.WorkingDateType;
import com.example.case_study_module3.model.CalendarWorkingYear;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateWorking {
    public CalendarWorkingYear createWorkingDate(int day, int month, int year, int idWorkingDateType){
        return new CalendarWorkingYear(new Date(year-1900,month,day),idWorkingDateType);
    }

    public List<CalendarWorkingYear> createCalendar(int year){
        List<CalendarWorkingYear> calendarWorkingYearList=new ArrayList<>();
        Calendar calendar=Calendar.getInstance();
        for(int month=1;month<=12;month++) {
            calendar.set(year, month-1, 1);
            while (calendar.get(Calendar.MONTH)==month-1){
                Date date=calendar.getTime();
                int idWorkingDateType;
                if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY ||
                   calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
                    idWorkingDateType=WorkingDateType.WEEKEND.getValue();
                }else {
                    idWorkingDateType=WorkingDateType.NORMAL.getValue();
                }
                calendarWorkingYearList.add(new CalendarWorkingYear(date,idWorkingDateType));
                calendar.add(Calendar.DATE,1);
            }
        }
        return calendarWorkingYearList;
    }

}
