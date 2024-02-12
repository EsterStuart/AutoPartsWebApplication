package org.team.autopartswebapplication;


import Business.Cart;
import Business.PartOrder;
import Business.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoadCartServlet", value = "/load-cart-servlet")
public class LoadCartServlet extends HttpServlet {
    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();

        Cart cart;
        if(null != session.getAttribute("UserCart")){
            cart = (Cart) session.getAttribute("UserCart");
            System.out.println("CART ALREADY IN SESSION");
        } else {
            cart = new Cart();
            System.out.println("CART NOT IN SESSION ==========");
        }

        session.setAttribute("UserCart", cart);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cart.jsp");
        requestDispatcher.forward(request, response);

    }

    public void destroy() {
    }

}
