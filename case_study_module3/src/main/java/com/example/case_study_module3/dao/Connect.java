package com.example.case_study_module3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return  DriverManager.getConnection("jdbc:mysql://localhost:3306/caseStudyModul3", "root", "123456789");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
