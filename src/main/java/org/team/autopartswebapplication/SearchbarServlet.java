package org.team.autopartswebapplication;


import Business.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SearchbarServlet", value = "/searchbar-servlet")
public class SearchbarServlet extends HttpServlet {
    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();

        String searchQuery = request.getParameter("searchbarText");

        ArrayList<Product> productsArrayList = new ArrayList<Product>();

        productsArrayList = Product.getProductsBySearch(searchQuery);


        session.setAttribute("ArrayOfFilteredProducts", productsArrayList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/products.jsp");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }

}
