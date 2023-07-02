package com.example.case_study_module3.dao;

import com.example.case_study_module3.model.Employee;

import java.sql.*;

public class EmployeeDAO {
    Connect connect = new Connect();
    private final String SELECT_EMPLOYEE =
            " select * from Employee " +
                    " join Contract on Employee.IdEmployee=Contract.IdEmployee " +
                    " join Department on Contract.IdDepartment=Department.IdDepartment " +
                    " join Positions on Contract.IdPosition=Positions.IdPosition "+
                    " where Employee.IdEmployee=? and Employee.PasswordEmployee=? ";
    private  final String SELECT_ID=" select *from Employee join Contract on Employee.IdEmployee=Contract.IdEmployee where Employee.IdEmployee=?  and Contract.StatusContract=true ";

    public Employee getEmployee(int id, String password) {
        Employee employee=null;
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE)) {
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,password);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()) {
                int idPosition = resultSet.getInt("IdPosition");
                String name = resultSet.getString("NameEmployee");
                boolean statusContract=resultSet.getBoolean("StatusContract");
                Date birthday=resultSet.getDate("dateOfBirthEmployee");
                String phone=resultSet.getString("phoneEmployee");
                Date joinDate=resultSet.getDate("joinDateEmployee");
                byte numberOfDependents=resultSet.getByte("numberOfDependentsEmployee");
                String namePosition=resultSet.getString("NamePosition");
                String nameDepartment=resultSet.getString("nameDepartment");
                String img=resultSet.getString("ImgEmployee");
                employee= new Employee(id,password,idPosition,namePosition,nameDepartment,statusContract,name,birthday,phone,joinDate,numberOfDependents,img);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return employee;
    }


    public boolean getId(int id) {
        try (Connection connection = connect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
