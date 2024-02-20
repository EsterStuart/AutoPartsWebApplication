package org.team.autopartswebapplication;



import java.io.*;

import Business.Customer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "UpdateCustomerInfo", value = "/UpdateCustomerInfo")

public class UpdateCustomerInfo extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        RequestDispatcher rd;
        HttpSession hs = request.getSession();
        String fname = request.getParameter("Fname");
        String lname = request.getParameter("Lname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String psw = request.getParameter("psw");
    Customer c1 = (Customer) hs.getAttribute("c1");

    int id = c1.getCustomerID();
    c1.selectDB(id);
    boolean b=true;

        if(fname.isEmpty() && lname.isEmpty() && email.isEmpty() && address.isEmpty() && psw.isEmpty()){
            request.setAttribute("Null","Null");
            b = false;
        }if(fname.matches(c1.getFirstName()) || lname.matches(c1.getLastName())) {
            request.setAttribute("name", "name");
            b = false;
        }
        else{
            c1.setFirstName(fname);
            c1.setLastName(lname);
        }

        if(address.matches(c1.getAddress())) {
            request.setAttribute("address", "address");
            b = false;
        }
        else{
            c1.setAddress(address);
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

        if (psw.matches(c1.getPassword())){
            request.setAttribute("psw","psw");
            b = false;
        }
        if(!psw.isEmpty() && psw.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]){6,20}")){
        request.setAttribute("pass","pass");
        b= false;
        }

        if(!email.isEmpty()){
            c1.setEmail(email);
        }
        if(!psw.isEmpty()){
            c1.setPassword(psw);
        }
        if(!b){
            rd = request.getRequestDispatcher("/updateInformation.jsp");
        }
        else{
            c1.updateDB();
            request.setAttribute("correct","correct");
            rd = request.getRequestDispatcher("customerDash.jsp");
            }
        rd.forward(request,response);
    }

    public void destroy() {
    }
}

	
