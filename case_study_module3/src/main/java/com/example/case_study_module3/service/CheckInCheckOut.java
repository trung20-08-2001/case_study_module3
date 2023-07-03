package com.example.case_study_module3.service;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;


public class CheckInCheckOut {

    final int MILLISECOND_OF_HOUR = 3600000;

    final static LocalDateTime STANDARD_OUT_HOUR= LocalDateTime.of(LocalDate.now(), LocalTime.of(17,30));

    public double calculatorHours(Timestamp checkInTime, Timestamp checkOutTime) {
        return ((double) (checkOutTime.getTime() - checkInTime.getTime())) / MILLISECOND_OF_HOUR;
    }


    ////  tạo một timestamp với thời điểm bắt đầu h làm việc buổi sáng 8:0:0
    ////  tham số là một timestamp với thời điểm bất kì trong ngày

    public Timestamp createStandardInHour(Timestamp timestamp){
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        calendar.set(Calendar.HOUR_OF_DAY,8);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        return new Timestamp(calendar.getTimeInMillis());
    }


    ////  tạo một timestamp với thời điểm kết thúc h làm việc buổi chiều 17:30:0
    ////  tham số là một timestamp với thời điểm bất kì trong ngày

    public Timestamp createStandardOutHour(Timestamp timestamp){
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        calendar.set(Calendar.HOUR_OF_DAY,17);
        calendar.set(Calendar.MINUTE,30);
        calendar.set(Calendar.SECOND,0);
        return new Timestamp(calendar.getTimeInMillis());
    }


    public double calculatorOTHours(Timestamp checkOutTime) {
        Timestamp standardOutHour=createStandardOutHour(checkOutTime);
        double overTimeHour=calculatorHours(standardOutHour,checkOutTime);
        if(overTimeHour<=0){
            return 0;
        }else {
            double decimal = overTimeHour - Math.floor(overTimeHour);
            if (decimal <= 0.5) {
                return Math.floor(overTimeHour);
            } else {
                return Math.floor(overTimeHour) + 0.5;
            }
        }
    }

    public double calculatorWorkingHour(Timestamp checkInTime){
       Timestamp standardOutHour=createStandardOutHour(checkInTime);
       double workingHours=calculatorHours(checkInTime,standardOutHour);
       if(workingHours>=9.5){
           workingHours =8;
       } else if (workingHours < 9 && workingHours >= 5) {
           workingHours-=1;
       }
       return workingHours;
    }



}
