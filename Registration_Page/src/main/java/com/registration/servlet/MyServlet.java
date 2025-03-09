package com.registration.servlet;

import java.io.IOException;

import com.registration.conn.HibernateUtil;
import com.registration.dao.EmpDao;
import com.registration.entities.Emp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String dept = request.getParameter("dept");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        // Hash password before saving to database

        Emp emp = new Emp(name, dept, email, pass);
        
        EmpDao dao = new EmpDao(HibernateUtil.getFactory());

        boolean f = dao.saveEmp(emp);
        if (f) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("not.jsp");
        }
    }
}
