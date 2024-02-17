package org.team.autopartswebapplication;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.*;

@WebServlet(name = "EmployeeLoginServlet", value = "/employee-login-servlet")
public class EmployeeLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();


        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (correctLogin(username, password)) {
            resp.sendRedirect("loadAllOrdersServlet");

        } else {
            session.setAttribute("message","Incorrect");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/employeeLogin.jsp");
            requestDispatcher.forward(req,resp);
        }
    }

    public boolean correctLogin(String username, String password) {
        if (username.equals("admin") && password.equals("123")) {
            return true;
        } else return false;
    }
}