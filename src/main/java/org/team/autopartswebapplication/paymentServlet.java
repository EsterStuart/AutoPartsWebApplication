package org.team.autopartswebapplication;


import Business.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

@WebServlet(name = "PaymentServlet", value = "/payment-servlet")
public class paymentServlet extends HttpServlet {
    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();


        Order order = (Order) session.getAttribute("customerOrder");
        ArrayList<PartOrder> partOrderArrayList = order.getOrderedPartsArrayList();
        for (PartOrder partOrder : partOrderArrayList){
            Product.decreaseProductStock(partOrder.getPart().getProductID(), partOrder.getQuantity());
        }


        order.insertDB();
        session.removeAttribute("userCart");
        session.setAttribute("customerOrder", order);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/orderReview.jsp");
        requestDispatcher.forward(request, response);

    }

    public void destroy() {
    }

}
