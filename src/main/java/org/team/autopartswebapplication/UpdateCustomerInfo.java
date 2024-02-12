package org.team.autopartswebapplication;



import java.io.*;

import Business.Customer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "UpdateCustomerInfo", value = "/UpdateCustomerInfo")

public class UpdateCustomerInfo extends HttpServlet {
    private String message;
private String fname;
private String lname;
private String email;
private String Address;
    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        RequestDispatcher rd;
    fname = request.getParameter("fname");
    lname = request.getParameter("lname");
    email = request.getParameter("email");
    Address = request.getParameter("address");

    HttpSession hs = request.getSession();
    Object at = hs.getAttribute("CustomerId");

    Customer c1 = new Customer();
    c1.selectDB((Integer) at);
        if(fname != null){
            c1.setFirstName(fname);
        }
        if(lname != null){
            c1.setLastName(lname);
        }
        if(email != null){
            c1.setEmail(email);
        }
        if(Address != null){
            c1.setAddress(Address);
        }
        else{
            request.setAttribute("message","Missing Value");
            rd = request.getRequestDispatcher("/updateInformation.jsp");
            rd.forward(request,response);
        }
        c1.updateDB();

            rd = request.getRequestDispatcher("updateInformation.jsp");
            rd.forward(request,response);
    }

    public void destroy() {
    }
}

	
