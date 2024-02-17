package org.team.autopartswebapplication;

import Business.Order;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hsqldb.Session;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoadOrderServlet", value = "/load-order-servlet")
public class LoadOrderServlet extends HttpServlet {

    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        int orderID = Integer.parseInt(request.getParameter("orderID"));

        Order order = new Order();
        order.selectDB(orderID);



        session.setAttribute("customerOrder", order);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/orderView.jsp");
        requestDispatcher.forward(request, response);

    }

    public void destroy() {
    }
}