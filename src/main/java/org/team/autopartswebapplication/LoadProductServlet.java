package org.team.autopartswebapplication;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.SessionCookieConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.*;


import Business.Product;

import javax.sound.midi.SysexMessage;

@WebServlet(name = "LoadProductServlet", value = "/load-product-servlet")
public class LoadProductServlet extends HttpServlet {
    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();

        String partType = request.getParameter("ProductType");

        String carType = request.getParameter("CarType");

        ArrayList<Product> productsArrayList = new ArrayList<Product>();

        Product product = new Product();
        if (partType != null){
            if (carType != null) {
                productsArrayList = product.getAllProductsFilterBy(partType, Product.getCarType(carType));
            } else {
                productsArrayList = Product.getAllProductsFilterBy(partType);
            }
        } else if (carType != null) {
            productsArrayList = product.getAllProductsFilterBy(Product.getCarType(carType));
        }

        session.setAttribute("ArrayOfFilteredProducts", productsArrayList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/products.jsp");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }

}
