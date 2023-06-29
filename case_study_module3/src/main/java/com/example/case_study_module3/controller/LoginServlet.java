package com.example.case_study_module3.controller;

import com.example.case_study_module3.dao.EmployeeDAO;
import com.example.case_study_module3.model.Employee;
import com.example.case_study_module3.role.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String password = req.getParameter("password");
        Employee employee = employeeDAO.getEmployee(id, password);
        HttpSession session= req.getSession();
        session.setAttribute("employee",employee);
        if (employee != null) {
            if (employee.getIdPosition() == Role.ROLE_ADMIN) {
                resp.sendRedirect("/view/admin.jsp");
            } else if (employee.getIdPosition() ==  Role.ROLE_MANAGER) {
                resp.sendRedirect("/view/manager.jsp");
            } else if (employee.getIdPosition() ==  Role.ROLE_HR) {
                resp.sendRedirect("/view/hr.jsp");
            } else if(employee.getIdPosition()== Role.ROLE_EMPLOYEE){
                resp.sendRedirect("/view/employee.jsp");
            }else{
                resp.sendRedirect("view/404.jsp");
            }
        }else{
            resp.sendRedirect("view/404.jsp");
        }
    }
}
