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

@WebServlet(name = "trackOrderServlet", value = "/track-order-servlet")
public class trackOrderServlet extends HttpServlet {

    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        session.removeAttribute("trackOrder");
        try{
            String inputOrderID = request.getParameter("orderID");
            inputOrderID = inputOrderID.replace("#", "");
            int orderID = Integer.parseInt(inputOrderID);
            Order order = new Order();
            order.selectDB(orderID);
            session.setAttribute("trackOrder", order);

        } catch (Exception ex) {
            ex.printStackTrace();
        }



        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/trackOrder.jsp");

        requestDispatcher.forward(request, response);

    }

    public void destroy() {
    }
}