package com.example.case_study_module3.dao;

import com.example.case_study_module3.model.StandardWorkingHours;
import com.example.case_study_module3.model.TimeRecord;
import com.example.case_study_module3.service.CheckInCheckOut;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeRecordDAO {
    CheckInCheckOut checkInCheckOut=new CheckInCheckOut();
    final String SELECT_TIME_RECORD =
            " select * from TypeWorkingDate " +
                    " join CalendarWorkingYear on TypeWorkingDate.IdTypeWorkingDate=CalendarWorkingYear.IdTypeWorkingDate " +
                    " join WorkingDateDetail on CalendarWorkingYear.DateWorking =WorkingDateDetail.WorkingDate " +
                    " where WorkingDateDetail.IDEmployee=? ";

    public List<TimeRecord> getTimeRecord(int idEmployee) {
        List<TimeRecord> timeRecordList = new ArrayList<>();
        try (Connection connection = Connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TIME_RECORD)) {
            preparedStatement.setInt(1, idEmployee);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Date workingDate = resultSet.getDate("DateWorking");
                int idWorkingDateType = resultSet.getInt("IdTypeWorkingDate");
                String nameWorkingDateType = resultSet.getString("NameTypeWorkingDate");
                Timestamp checkInTime = resultSet.getTimestamp("HoursIn");
                Timestamp checkOutTime = resultSet.getTimestamp("HoursOut");
                double workingHour=checkInCheckOut.calculatorWorkingHour(checkInTime);
                double overTimeHour=checkInCheckOut.calculatorOTHours(checkOutTime);
                boolean status = workingHour==8;
                timeRecordList.add(new TimeRecord(workingDate, idWorkingDateType, nameWorkingDateType, checkInTime, checkOutTime,workingHour,overTimeHour,status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return timeRecordList;
    }

}
