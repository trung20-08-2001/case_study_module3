package com.example.case_study_module3.controller;

import com.example.case_study_module3.dao.EmployeeDAO;
import com.example.case_study_module3.enums.Role;
import com.example.case_study_module3.model.Employee;

import javax.servlet.RequestDispatcher;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher dispatcher=req.getRequestDispatcher("/view/login.jsp");
        int id = Integer.parseInt(req.getParameter("id"));
        String password = req.getParameter("password");
        Employee employee = employeeDAO.getEmployee(id, password);
        boolean isEmployee=employeeDAO.getId(id);

        HttpSession session= req.getSession();
        session.setAttribute("employee",employee);

        if (employee != null) {
            if(employee.isStatusContract()) {
                if (employee.getIdPosition() == Role.DIRECTOR.getValue()) {
                    resp.sendRedirect("/view/director.jsp");
                } else if (employee.getIdPosition() == Role.MANAGER.getValue()) {
                    resp.sendRedirect("/view/manager.jsp");
                } else if (employee.getIdPosition() == Role.ADMIN.getValue()) {
                    resp.sendRedirect("/view/admin.jsp");
                } else if (employee.getIdPosition() == Role.USER.getValue()) {
                    resp.sendRedirect("/view/user.jsp");
                }
            }else {
                req.setAttribute("message3","Tài khoản của bạn đã bị khóa.");
                dispatcher.forward(req,resp);
            }
        }else{
            if(isEmployee) {
                req.setAttribute("id",id);
                req.setAttribute("message1","Sai mật khẩu.");
            }else{
                req.setAttribute("message2","ID không tồn tại");
            }
            dispatcher.forward(req,resp);
        }
    }
}
