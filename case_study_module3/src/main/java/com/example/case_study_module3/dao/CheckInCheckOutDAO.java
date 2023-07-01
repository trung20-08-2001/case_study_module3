package com.example.case_study_module3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class CheckInCheckOutDAO {
    final String INSERT_HOUR_IN_OUT=" INSERT INTO WorkingDateDetail(IDEmployee,HoursIn,HoursOut) VALUES (?,?,?)";
    public void saveHourInOut(LocalDate now,int idEmployee){
        try(Connection connection=Connect.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT_HOUR_IN_OUT)){
            preparedStatement.setInt(1,idEmployee);
//            preparedStatement.setDate(2,now);
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
