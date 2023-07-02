package com.example.case_study_module3.controller.calendar;

import com.example.case_study_module3.dao.CalendarWorkingYearDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.TreeMap;

@WebServlet("/viewCalendar")
public class ViewCalendarServlet extends HttpServlet {
    CalendarWorkingYearDAO calendarWorkingYearDAO = new CalendarWorkingYearDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestUrl = req.getRequestURL().toString();
        int year = Integer.parseInt("year");
        TreeMap<Date, Integer> treeMap = calendarWorkingYearDAO.getCalendarWorkingYear(year);
        req.setAttribute("calendar", treeMap);
        RequestDispatcher dispatcher = req.getRequestDispatcher(requestUrl);
        dispatcher.forward(req, resp);
    }
}
