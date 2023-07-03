package com.example.case_study_module3.controller;

import com.example.case_study_module3.dao.MessageDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/reason")
public class ReasonServlet extends HttpServlet {

    MessageDAO messageDAO=new MessageDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idEmployeeSent=Integer.parseInt(req.getParameter("idEmployeeSent"));
        int idEmployeeReceive=Integer.parseInt(req.getParameter("idEmployeeReceive"));
        String content=req.getParameter("content");
        messageDAO.sendRequire(idEmployeeSent,idEmployeeReceive,content);
        String url = req.getHeader("referer");
        resp.sendRedirect(url);
    }
}
