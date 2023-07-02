package com.example.case_study_module3.controller.calendar;

import com.example.case_study_module3.dao.CalendarWorkingYearDAO;
import com.example.case_study_module3.model.CalendarWorkingYear;
import com.example.case_study_module3.service.DateWorking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editCalendar")
public class EditCalendarServlet extends HttpServlet {
    DateWorking dateWorking=new DateWorking();
    CalendarWorkingYearDAO calendarWorkingYearDAO=new CalendarWorkingYearDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int year=Integer.parseInt(req.getParameter("year"));
        int month=Integer.parseInt(req.getParameter("month"));
        int day=Integer.parseInt(req.getParameter("day"));
        int  idWorkingDateType= Integer.parseInt(req.getParameter("type"));
        CalendarWorkingYear calendarWorkingYear=dateWorking.createWorkingDate(day,month,year,idWorkingDateType);
        calendarWorkingYearDAO.editCalendar(calendarWorkingYear);
        resp.sendRedirect("/view/admin.jsp");
    }
}
