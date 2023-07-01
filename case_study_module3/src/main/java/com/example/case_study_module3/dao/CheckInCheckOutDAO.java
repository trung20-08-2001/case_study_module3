package com.example.case_study_module3.dao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Date;

public class CheckInCheckOutDAO {
    final byte NOT_COMING=1;  // chưa checkin
    final  byte GOT_INTO=2;  // đã checkin, chưa chekout
    final byte COME_BACK=3;  // đã checkin,checkout
    final String INSERT_HOUR_IN = " INSERT INTO WorkingDateDetail(IDEmployee,HoursIn) VALUES (?,?) ";

    final String INSERT_HOUR_OUT = " UPDATE WorkingDateDetail SET HoursOut=? WHERE IdEmployee=? AND WorkingDate=? ";

    final String SELECT_HOUR_IN_OUT = " SELECT * FROM workingdatedetail WHERE IdEmployee=? AND WorkingDate = ? ";

    public String saveHourInOut(LocalDateTime currentDateTime, int idEmployee) {
        String message = "";
        try (Connection connection = Connect.getConnection();
             PreparedStatement saveHourIn = connection.prepareStatement(INSERT_HOUR_IN);
             PreparedStatement saveHourOut = connection.prepareStatement(INSERT_HOUR_OUT)) {
            if (isClicked(idEmployee)==NOT_COMING) {
                saveHourIn.setInt(1, idEmployee);
                saveHourIn.setTimestamp(2, Timestamp.valueOf(currentDateTime));
                saveHourIn.execute();
                message = "Bạn vào lúc ";
            } else if(isClicked(idEmployee)==GOT_INTO){
                saveHourOut.setTimestamp(1, Timestamp.valueOf(currentDateTime));
                saveHourOut.setInt(2, idEmployee);
                saveHourOut.setDate(3, new java.sql.Date(new Date().getTime()));
                saveHourOut.execute();
                message = "Bạn ra về lúc ";
            }else {
                message="Ngày hôm nay bạn đã nhấn hai lần rồi";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
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
