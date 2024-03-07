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
import java.util.Objects;
import java.util.stream.Stream;

@WebServlet(name = "CreateCustomerServlet", value = "/create-customer-servlet")
public class CreateCustomerServlet extends HttpServlet {
private HttpServletRequest hs;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        RequestDispatcher requestDispatcher;
        HttpSession session = request.getSession();
        this.hs =request;
        Customer customer = new Customer();
        String fname = hs.getParameter("Fname");
        String lname = hs.getParameter("Lname");
        String email = hs.getParameter("email");
        String password = hs.getParameter("psw");
        String street = hs.getParameter("street");
        String city = hs.getParameter("city");
        String state = hs.getParameter("state");
        String zip = hs.getParameter("zip");

        System.out.println(zip);
        System.out.println(zip.matches("[0-9]+{5}"));


        boolean b = validate(customer);
         if(b) {
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
         else {session.setAttribute("invalid","invalid");
            requestDispatcher = request.getRequestDispatcher("/createAccount.jsp");
            requestDispatcher.forward(request,response);
        }}


    private boolean validate(Customer c1){
        boolean b = true;
        String fname = hs.getParameter("Fname");
        String lname = hs.getParameter("Lname");
        String email = hs.getParameter("email");
        String password = hs.getParameter("psw");
        String zip = hs.getParameter("zip");
    if(!fname.matches("[a-zA-Z]{2,20}") || !lname.matches("[a-zA-Z]{2,20}")){
        hs.setAttribute("name","name");
        b=false;

    }
    if(!password.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20}")){
        hs.setAttribute("pass","pass");
        b= false;
    }
    if(!email.matches("[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+"A-Z]{2,7}")){
        hs.setAttribute("email","email");
        b=false;
    }
    if(!zip.matches("[0-9]+{5}")){
        hs.setAttribute("zip","zip");
        b=false;
    }
    return b;
    }

    public void destroy() {
    }
}
