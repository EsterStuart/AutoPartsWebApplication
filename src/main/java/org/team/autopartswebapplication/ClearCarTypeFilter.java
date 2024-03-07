package org.team.autopartswebapplication;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ClearCarTypeFilterServlet", value = "/clear-car-type-filter-servlet")
public class ClearCarTypeFilter extends HttpServlet {
    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();

        session.removeAttribute("carType");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("load-product-servlet");
        requestDispatcher.forward(request, response);

    }

    public void destroy() {
    }

}
