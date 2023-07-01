package com.example.case_study_module3.service;

import java.time.LocalDate;
import java.util.Calendar;

public class test {
    public static void main(String[] args) {
        int year = 2023;
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        for (int month = 0; month < 12; month++) {
            calendar.set(Calendar.MONTH, month);
            int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            System.out.printf("Tháng %d%n", month + 1);
            System.out.println("CN T2 T3 T4 T5 T6 T7");
            for (int day = 1; day <= maxDay; day++) {
                calendar.set(Calendar.DAY_OF_MONTH, day);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                if (day == 1) {
                    for (int i = 1; i < dayOfWeek; i++) {
                        System.out.print("   ");
                    }
                }

                System.out.printf("%2d ", day);
                if (dayOfWeek == Calendar.SATURDAY) {
                    System.out.println();
                }
            }
            System.out.println();
        }


        Calendar calendar2 = Calendar.getInstance();
        int dayOfWeek = calendar2.get(Calendar.DAY_OF_WEEK);
        String dayName = "";
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                dayName = "Chủ nhật";
                break;
            case Calendar.MONDAY:
                dayName = "Thứ hai";
                break;
            case Calendar.TUESDAY:
                dayName = "Thứ ba";
                break;
            case Calendar.WEDNESDAY:
                dayName = "Thứ tư";
                break;
            case Calendar.THURSDAY:
                dayName = "Thứ năm";
                break;
            case Calendar.FRIDAY:
                dayName = "Thứ sáu";
                break;
            case Calendar.SATURDAY:
                dayName = "Thứ bảy";
                break;
        }
    }
}