package org.team.autopartswebapplication;

import Business.Customer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CreateCustomerServlet", value = "/create-customer-servlet")
public class CreateCustomerServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        RequestDispatcher requestDispatcher;
        HttpSession session = request.getSession();

        Customer customer = new Customer();

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

        customer.insertDB();

        session.setAttribute("customer", customer);
        requestDispatcher = request.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }
}
