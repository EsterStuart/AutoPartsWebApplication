package org.team.autopartswebapplication;
import java.io.*;

import Business.Customer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet(name = "CustomerLoginServlet", value = "/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
    private int id;
    private String pass;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        RequestDispatcher rd;
        HttpSession hs = request.getSession();

        String email = request.getParameter("email");
        pass = request.getParameter("psw");
        PrintWriter out = response.getWriter();

        Customer c1 = new Customer();
        c1.selectDB(email);
/**
   Leads to Customer Dashboard and saves Customer Information if password is correct or displays error message if incorrect
 */
        if (pass.equals(c1.getPassword())){

            hs.setAttribute("customer", c1);
            rd = request.getRequestDispatcher("/customerDash.jsp");
            rd.forward(request,response);
    }
        else{
            request.setAttribute("message","Incorrect");
            rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request,response);

}


    }

    public void destroy() {
    }
}
