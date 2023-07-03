package com.example.case_study_module3.dao;

import com.example.case_study_module3.service.CheckInCheckOut;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class CheckInCheckOutDAO {
    final byte NOT_COMING = 1;  // chưa checkin
    final byte GOT_INTO = 2;  // đã checkin, chưa chekout
    final byte COME_BACK = 3;  // đã checkin,checkout
    final String INSERT_HOUR_IN = " INSERT INTO WorkingDateDetail(IDEmployee ,HoursIn) VALUES (?,?) ";
    final String INSERT_HOUR_OUT = " update workingdatedetail set hoursOut=? , where IdEmployee=? and workingDate=? ";
    final String SELECT_HOUR_IN_OUT = " SELECT * FROM workingdatedetail WHERE IdEmployee=? AND WorkingDate = ? ";

    CheckInCheckOut checkInCheckOut = new CheckInCheckOut();

    public String saveHourInOut(LocalDateTime currentDateTime, int idEmployee) {
        String message = "";
        String time = currentDateTime.getHour() + ":" + currentDateTime.getMinute() + ":" + currentDateTime.getSecond();
        if (isClicked(idEmployee) == NOT_COMING) {
            saveHourIn(currentDateTime, idEmployee);
            message = "Bạn vào lúc " + time;
        } else if (isClicked(idEmployee) == GOT_INTO) {
            saveHourOut(currentDateTime, idEmployee);
            message = "Bạn ra về lúc " + time;
        } else {
            message = "Ngày hôm nay bạn đã nhấn hai lần rồi";
        }
        return message;
    }

    public void saveHourIn(LocalDateTime currentDateTime, int idEmployee) {
        try (Connection connection = Connect.getConnection();
             PreparedStatement saveHourIn = connection.prepareStatement(INSERT_HOUR_IN)) {
            saveHourIn.setInt(1, idEmployee);
            saveHourIn.setTimestamp(2, Timestamp.valueOf(currentDateTime));
            saveHourIn.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void saveHourOut(LocalDateTime currentDateTime, int idEmployee) {
        try (Connection connection = Connect.getConnection();
             PreparedStatement saveHourOut = connection.prepareStatement(INSERT_HOUR_OUT)) {
            saveHourOut.setTimestamp(1, Timestamp.valueOf(currentDateTime));
            saveHourOut.setInt(2, idEmployee);
            saveHourOut.setDate(3, new java.sql.Date(new Date().getTime()));
            saveHourOut.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public byte isClicked(int idEmployee) {
        try (Connection connection = Connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOUR_IN_OUT)) {
            preparedStatement.setInt(1, idEmployee);
            preparedStatement.setDate(2, new java.sql.Date(new Date().getTime()));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getString("HoursOut") == null) {
                    return GOT_INTO;
                }
            } else {
                return NOT_COMING;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return COME_BACK;
    }
}
