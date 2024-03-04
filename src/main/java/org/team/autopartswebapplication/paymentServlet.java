package org.team.autopartswebapplication;


import Business.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

@WebServlet(name = "PaymentServlet", value = "/payment-servlet")
public class paymentServlet extends HttpServlet {
    private HttpServletRequest request;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        this.request = request;
        HttpSession session = request.getSession();

    boolean b = validate();
    if(b) {
        Order order = (Order) session.getAttribute("customerOrder");
        ArrayList<PartOrder> partOrderArrayList = order.getOrderedPartsArrayList();
    for (PartOrder partOrder : partOrderArrayList) {
        Product.decreaseProductStock(partOrder.getPart().getProductID(), partOrder.getQuantity());
    }
        order.insertDB();
        session.removeAttribute("userCart");
        session.setAttribute("customerOrder", order);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/orderReview.jsp");
        requestDispatcher.forward(request, response);
}
    else{
        RequestDispatcher rd = request.getRequestDispatcher("/checkoutPayment.jsp");
        rd.forward(request,response);
}
    }
private Boolean validate(){
    boolean b = true;

    String cardNumber= request.getParameter("cardNumber");
    String expiration = request.getParameter("expiration");
    String cvv = request.getParameter("cvv");
    String zip = request.getParameter("zip");


    if(!cardNumber.matches(".{8,19}")){
        request.setAttribute("card","card");
        b = false;
    }
    if(!expiration.matches("((0[1-9])|(1[0-2]))(/)?((\\d{2})|(\\d{4}))")){
        request.setAttribute("exp","exp");
        b = false;
    }
    if(!(cvv.matches("[0-9]{3}"))){
        request.setAttribute("cvv","cvv");
        b = false;
    }
    if(!(zip.matches("[0-9]{5}"))){
        request.setAttribute("zip","zip");
        b = false;
    }
    return b;
}
    public void destroy() {
    }

}
