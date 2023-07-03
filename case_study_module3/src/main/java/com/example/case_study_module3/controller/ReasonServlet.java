package com.example.case_study_module3.controller;

import com.example.case_study_module3.dao.EmployeeDAO;
import com.example.case_study_module3.dao.MessageDAO;
import com.example.case_study_module3.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/reason")
public class ReasonServlet extends HttpServlet {

    MessageDAO messageDAO=new MessageDAO();
    EmployeeDAO employeeDAO=new EmployeeDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        Employee employee= (Employee) session.getAttribute("employee");
        int idEmployeeSent=employee.getId();
        int idEmployeeReceive=employeeDAO.getIdManager(idEmployeeSent);
        String content=req.getParameter("reason");
        if(idEmployeeReceive!=0) {
            messageDAO.sendRequire(idEmployeeSent, idEmployeeReceive, content);
        }else {
            System.out.println("Không có quản lí");
        }
        String url = req.getHeader("referer");
        resp.sendRedirect(url);
    }
}
