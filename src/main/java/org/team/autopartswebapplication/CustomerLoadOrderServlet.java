package org.team.autopartswebapplication;

import Business.Order;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "CustomerLoadOrderServlet", value = "/customer-load-order-servlet")
public class CustomerLoadOrderServlet extends HttpServlet {

    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        int orderID = Integer.parseInt(request.getParameter("orderID"));

        Order order = new Order();
        order.selectDB(orderID);



        session.setAttribute("customerOrder", order);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customerOrderView.jsp");
        requestDispatcher.forward(request, response);

    }

    public void destroy() {
    }
}