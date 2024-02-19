package org.team.autopartswebapplication;


import Business.Cart;
import Business.Customer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoadCheckoutServlet", value = "/load-checkout-servlet")
public class LoadCheckoutServlet extends HttpServlet {
    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();

        Cart cart;
        cart = (Cart) session.getAttribute("userCart");


        Customer customer;
        customer = (Customer) session.getAttribute("customer");

        if (customer != null){
            session.setAttribute("customer", customer);
        }


        session.setAttribute("userCart", cart);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/checkout.jsp");
        requestDispatcher.forward(request, response);

    }

    public void destroy() {
    }

}
