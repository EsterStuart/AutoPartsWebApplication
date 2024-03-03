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
import org.hsqldb.Session;

import javax.sound.midi.SysexMessage;

@WebServlet(name = "LoadProductServlet", value = "/load-product-servlet")
public class LoadProductServlet extends HttpServlet {
    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();

        String partType = request.getParameter("ProductType");
        String carType = request.getParameter("type");
        String maxPrice = request.getParameter("maxPrice");
        String minPrice = request.getParameter("minPrice");


        if (carType != null){
            session.setAttribute("carType", carType);
        } else {
            carType = (String) session.getAttribute("carType");
        }

        if (maxPrice != null){
            session.setAttribute("maxPrice", maxPrice);
        } else {
            maxPrice = (String) session.getAttribute("maxPrice");
        }

        if (minPrice != null){
            session.setAttribute("minPrice", minPrice);
        } else {
            minPrice = (String) session.getAttribute("minPrice");
        }





        session.removeAttribute("filteredByCartTypeProducts");

        ArrayList<Product> productsArrayList = new ArrayList<Product>();

        ArrayList<Product> carTypeFilteredList = new ArrayList<>();


        productsArrayList =(ArrayList<Product>) session.getAttribute("ArrayOfFilteredProducts");

        if (partType != null){
            productsArrayList = Product.getAllProductsFilterBy(partType);

        }




        double minPriceNum = 0.0;
        double maxPriceNum = 0.0;

        if (minPrice != null && maxPrice!= null){
            minPriceNum = Double.parseDouble(minPrice);
            maxPriceNum = Double.parseDouble(maxPrice);
        }

        if (partType != null){
            session.removeAttribute("minPrice");
            session.removeAttribute("maxPrice");
            session.removeAttribute("carType");

            carType = null;
            minPriceNum = 0.0;
            maxPriceNum = 0.0;
        }


        boolean filterSearchUsed = false;

        ArrayList<Product> filteredList = new ArrayList<Product>();
        filteredList = productsArrayList;

        if (carType != null) {
            filteredList = Product.filterArrayListByCarType(productsArrayList, carType);
            filterSearchUsed = true;
        }
        if (maxPriceNum != 0){
            ArrayList<Product> temporaryList = Product.filterListByPrice(filteredList, minPriceNum, maxPriceNum);
            filteredList = temporaryList;

            filterSearchUsed = true;


        }


        session.setAttribute("filterSearchUsed", filterSearchUsed);
        session.setAttribute("ArrayOfFilteredProducts", productsArrayList);
        session.setAttribute("FilteredProductList", filteredList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/products.jsp");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }

}
