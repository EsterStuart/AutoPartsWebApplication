package org.team.autopartswebapplication;



import java.io.*;

import Business.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "UpdateCustomerInfo", value = "/update-customer-info-servlet")

public class UpdateCustomerInfo extends HttpServlet {
    private String message;
    private String fname,lname,email,password, street, city, state, zip;
    private HttpServletRequest request;


    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        RequestDispatcher requestDispatcher;

        HttpSession hs = request.getSession();
        Customer c1 = (Customer) hs.getAttribute("customer");

        this.request = request;
        boolean b = validateinput(c1);

        if (b) {
            isempty(request,c1);
            c1.updateDB();
            request.setAttribute("correct", "correct");
            requestDispatcher = request.getRequestDispatcher("customerDash.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("/updateInformation.jsp");
        }
        requestDispatcher.forward(request, response);
    }


    private boolean validateinput(Customer c1){
        Boolean b = true;
        String fname = request.getParameter("Fname");
        String lname = request.getParameter("Lname");
        String email = request.getParameter("email");
        String password = request.getParameter("psw");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");

        if(fname.isEmpty() && lname.isEmpty() && email.isEmpty() && street.isEmpty() && city.isEmpty() && state==null && zip.isEmpty() && password.isEmpty()){
            request.setAttribute("Null","Null");
            b = false;
        }if(fname.matches(c1.getFirstName()) || lname.matches(c1.getLastName())) {
            request.setAttribute("name", "name");
            b = false;
        }
        if(street.matches(c1.completeAddress.getStreet()) ||city.matches(c1.completeAddress.getCity()) ||state ==(c1.completeAddress.getState()) ||zip.matches(c1.completeAddress.getZip())) {
            request.setAttribute("address", "address");
            b = false;
        }
        if(email.matches(c1.getEmail())){
            request.setAttribute("email", "email");
            b = false;
        }
        if(!email.isEmpty() && !email.matches("[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+"A-Z]{2,7}"))
        {
            request.setAttribute("emails","emails");
            b= false;
        }
        if(!password.isEmpty() && !password.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20}")){
            request.setAttribute("pass","pass");
            b= false;
        }
        if(password.matches(c1.getPassword())){
            request.setAttribute("psw","psw");
            b=false;
        }
        return b;
    }
    private void isempty(HttpServletRequest hr, Customer c1) {
        String fname = request.getParameter("Fname");
        String lname = request.getParameter("Lname");
        String email = request.getParameter("email");
        String password = request.getParameter("psw");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        if(!street.isEmpty()){
            c1.completeAddress.setStreet(street);
        }
        if(!city.isEmpty()){
            c1.completeAddress.setCity(city);
        }
        if(!(state ==null)) {
            c1.completeAddress.setState(state);
        }
        if(!zip.isEmpty()) {
            c1.completeAddress.setZip(zip);
        }
        if(!fname.isEmpty()){
            c1.setFirstName(fname);
        }
        if(!lname.isEmpty()){
            c1.setLastName(lname);
        }
        if(!email.isEmpty()){
            c1.setEmail(email);
        }
        if(!password.isEmpty()){
            c1.setPassword(password);
        }
    }
    public void destroy() {
    }
}


