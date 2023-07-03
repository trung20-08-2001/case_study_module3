package com.example.case_study_module3.dao;

import com.example.case_study_module3.model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {

    final String SEND_REQUIRE = " INSERT INTO Message(IdEmployeeSent,IdEmployeeReceive,Content,StatusMessage) VALUES (?,?,?,?) ";

    final String APPROVE_REQUEST = " UPDATE Message set StatusMessage=? WHERE IdMessage=? ";

    final String GET_REQUEST=" SELECT * FROM Message WHERE IdEmployeeReceive=? AND StatusMessage=? ";
    public void sendRequire(int idEmployeeSent, int idEmployeeReceive, String content) {
        try (Connection connection = Connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEND_REQUIRE)) {
            preparedStatement.setInt(1, idEmployeeSent);
            preparedStatement.setInt(2, idEmployeeReceive);
            preparedStatement.setString(3, content);
            preparedStatement.setBoolean(4, false);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void approveRequest(int idMessage) {
        try (Connection connection = Connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(APPROVE_REQUEST)) {
            preparedStatement.setBoolean(1, true);
            preparedStatement.setInt(2, idMessage);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Message> getListRequest(int idEmployee){
        List<Message> messageList=new ArrayList<>();
        try(Connection connection=Connect.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(GET_REQUEST)){
            preparedStatement.setInt(1,idEmployee);
            preparedStatement.setBoolean(2,false);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int idMessage=resultSet.getInt("IdMessage");
                int idEmployeeSent=resultSet.getInt("IdEmployeeSent");
                int idEmployeeReceive=resultSet.getInt("IdEmployeeReceive");
                String content=resultSet.getString("Content");
                boolean status=resultSet.getBoolean("StatusMessage");
                messageList.add(new Message(idMessage,idEmployeeSent,idEmployeeReceive,content,status));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return messageList;
    }
}
