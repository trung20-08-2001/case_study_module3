package com.example.case_study_module3.controller;

import com.example.case_study_module3.dao.TimeRecordDAO;
import com.example.case_study_module3.model.TimeRecord;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewTimeRecord")
public class ViewTimeRecordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher=req.getRequestDispatcher("/view/admin.jsp");
        TimeRecordDAO timeRecordDAO=new TimeRecordDAO();
        int idEmployee= Integer.parseInt(req.getParameter("id"));
        List<TimeRecord> timeRecordList=timeRecordDAO.getTimeRecord(idEmployee);
        req.setAttribute("timeRecordList",timeRecordList);
        dispatcher.forward(req,resp);

    }
}
