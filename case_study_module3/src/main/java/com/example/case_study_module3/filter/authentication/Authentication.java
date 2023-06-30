package com.example.case_study_module3.filter.authentication;

import com.example.case_study_module3.model.Employee;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/view/director.jsp","/view/user.jsp","/view/admin.jsp","/view/manager.jsp"})
public class Authentication extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session= req.getSession();
        Employee employee=(Employee) session.getAttribute("employee");
        if(employee!=null){
            chain.doFilter(req,res);
        }else{
            res.sendRedirect("/view/login.jsp");
        }
    }
}
