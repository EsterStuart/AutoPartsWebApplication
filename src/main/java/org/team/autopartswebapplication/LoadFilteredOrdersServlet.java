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
import java.util.ArrayList;

@WebServlet(name = "LoadFilteredOrdersServlet", value = "/load-filtered-orders-servlet")
public class LoadFilteredOrdersServlet extends HttpServlet {
    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        System.out.println("RUNNING THE LOAD FILTER");



        HttpSession session = request.getSession();
        ArrayList<Order> allOrdersArrayList = new ArrayList<Order>();

        String firstName = request.getParameter("FirstName");
        String lastName = request.getParameter("LastName");
        String orderID = request.getParameter("OrderID");

        System.out.println(firstName + " fNAme");
        System.out.println(lastName + " lName");
        System.out.println(orderID + " orderID");


        if (firstName != "" && lastName != ""){
            System.out.println("RUNNING THE NAME FILTER");
            allOrdersArrayList = Order.getAllOrders(firstName, lastName);
        }

        if (orderID != ""){
            System.out.println("RUNNING THE ID FILTER");
            allOrdersArrayList.clear();


            int intOrderID = Integer.parseInt(orderID);

            Order order = new Order();
            order.selectDB(intOrderID);

            allOrdersArrayList.add(order);
        }


        session.setAttribute("allOrdersArrayList", allOrdersArrayList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employeeDash.jsp");
        requestDispatcher.forward(request, response);

    }

    public void destroy() {
    }

}
