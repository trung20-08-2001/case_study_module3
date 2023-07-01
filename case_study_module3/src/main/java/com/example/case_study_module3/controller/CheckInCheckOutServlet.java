package com.example.case_study_module3.controller;

import com.example.case_study_module3.dao.CheckInCheckOutDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/checkHour")
public class CheckInCheckOutServlet extends HttpServlet {
    CheckInCheckOutDAO checkInCheckOutDAO=new CheckInCheckOutDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher=req.getRequestDispatcher("/view/admin.jsp");
        LocalDateTime currentDateTime=LocalDateTime.now();
        int id=Integer.parseInt(req.getParameter("id"));
        String message=checkInCheckOutDAO.saveHourInOut(currentDateTime,id);
        req.setAttribute("message",message);
        dispatcher.forward(req,resp);
    }

}
