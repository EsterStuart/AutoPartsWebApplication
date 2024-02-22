package org.team.autopartswebapplication;


import Business.Cart;
import Business.Order;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoadAllOrdersServlet", value = "/load-all-orders-servlet")
public class LoadAllOrdersServlet extends HttpServlet {
    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();

        ArrayList<Order> allOrdersArrayList = Order.getAllOrders();

        session.setAttribute("allOrdersArrayList", allOrdersArrayList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employeeDash.jsp");
        requestDispatcher.forward(request, response);

    }

    public void destroy() {
    }

}
