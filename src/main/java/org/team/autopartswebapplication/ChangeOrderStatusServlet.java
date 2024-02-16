package org.team.autopartswebapplication;

import Business.Cart;
import Business.Order;
import Business.Product;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ChangeOrderStatusServlet", value = "/change-order-status-servlet")
public class ChangeOrderStatusServlet extends HttpServlet {
    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();

        Order order = (Order) session.getAttribute("customerOrder");

        order.setOrderStatus(request.getParameter("orderStatus"));

        order.updateDB();

        session.setAttribute("customerOrder", order);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/orderView.jsp");
        requestDispatcher.forward(request, response);

    }

    public void destroy() {
    }

}
