package org.team.autopartswebapplication;



import java.io.*;

import Business.Customer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "UpdateCustomerInfo", value = "/update-customer-info-servlet")

public class UpdateCustomerInfo extends HttpServlet {
    private String message;
    private String fname,lname,email,password, street, city, state, zip;
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        RequestDispatcher requestDispatcher;

        HttpSession hs = request.getSession();
        Customer customer = (Customer) hs.getAttribute("customer");

        String fname = request.getParameter("Fname");
        String lname = request.getParameter("Lname");
        String email = request.getParameter("email");
        String password = request.getParameter("psw");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");

        customer.setFirstName(fname);
        customer.setLastName(lname);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.completeAddress.setStreet(street);
        customer.completeAddress.setCity(city);
        customer.completeAddress.setState(state);
        customer.completeAddress.setZip(zip);


        if (customer.updateDB()) {
            requestDispatcher = request.getRequestDispatcher("customerDash.jsp");
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("message", "Missing Value");
            requestDispatcher = request.getRequestDispatcher("/updateInformation.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    public void destroy() {
    }
}

	
