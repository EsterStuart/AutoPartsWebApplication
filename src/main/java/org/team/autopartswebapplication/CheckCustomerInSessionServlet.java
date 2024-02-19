
package org.team.autopartswebapplication;
import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;



@WebServlet(name = "CheckCustomerInSessionServlet", value = "/CheckCustomerInSessionServlet")

public class CheckCustomerInSessionServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        HttpSession hs = request.getSession(false);
        RequestDispatcher rd;

        if(hs.getAttribute("CustomerID") != null){
            rd = request.getRequestDispatcher("/customerDash.jsp");
        }
        else if(hs.getAttribute("EmployeeID")!= null){
            rd =request.getRequestDispatcher("/employeeDash.jsp");
        }
        else {
            rd = request.getRequestDispatcher("/login.jsp");
        }
        rd.forward(request,response);
    }

    public void destroy() {
    }
}
