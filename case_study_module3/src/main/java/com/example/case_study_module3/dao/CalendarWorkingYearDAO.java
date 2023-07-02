package com.example.case_study_module3.dao;
import com.example.case_study_module3.model.CalendarWorkingYear;
import com.example.case_study_module3.service.DateWorking;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.TreeMap;


public class CalendarWorkingYearDAO {
    final String INSERT_WORKING_TYPE = " insert into CalendarWorkingYear values (?,?)";
    final String EDIT_WORKING_TYPE = " update CalendarWorkingYear set IdTypeWorkingDate=? where DateWorking=? ";
    final String GET_CALENDAR = " SELECT * FROM CalendarWorkingYear where year(DateWorking)=? order by DateWorking";
    final String DELETE_ALL_DATA=" DELETE FROM calendarworkingyear ";

    public void editCalendar(CalendarWorkingYear calendarWorkingYear) {
        try (Connection connection = Connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EDIT_WORKING_TYPE)) {
            preparedStatement.setInt(1, calendarWorkingYear.getIdWorkingDateType());
            preparedStatement.setDate(2, new java.sql.Date(calendarWorkingYear.getDate().getTime()));
            preparedStatement.execute();
        } catch (SQLException error) {
            error.printStackTrace();

        }
    }

    public void saveCalendar(int year){
        DateWorking dateWorking=new DateWorking();
        List<CalendarWorkingYear> calendarWorkingYearList=dateWorking.createCalendar(year);
        try(Connection connection=Connect.getConnection();
        PreparedStatement preparedStatement1=connection.prepareStatement(INSERT_WORKING_TYPE);
        PreparedStatement preparedStatement2=connection.prepareStatement(DELETE_ALL_DATA)){
//            preparedStatement2.execute();
            for(int i=0;i<calendarWorkingYearList.size();i++){
                preparedStatement1.setDate(1,new java.sql.Date(calendarWorkingYearList.get(i).getDate().getTime()));
                preparedStatement1.setInt(2,calendarWorkingYearList.get(i).getIdWorkingDateType());
                preparedStatement1.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        new CalendarWorkingYearDAO().saveCalendar(2023);
//    }
    public TreeMap<Date, Integer> getCalendarWorkingYear(int year) {
        TreeMap<Date,Integer> treeMap=new TreeMap<>();
        try (Connection connection = Connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CALENDAR)) {
            preparedStatement.setInt(1,year);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Date date = resultSet.getDate("DateWorking");
                int idWorkingDateType = resultSet.getInt("IdTypeWorkingDate");;
                treeMap.put(date,idWorkingDateType);
            }
            return treeMap;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
