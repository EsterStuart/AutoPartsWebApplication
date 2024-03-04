package org.team.autopartswebapplication;


import Business.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@WebServlet(name = "LoadCheckoutServlet", value = "/checkout-servlet")
public class CheckoutServlet extends HttpServlet {
private  HttpServletRequest request;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        this.request = request;
        Order order = new Order();
        Customer customer = (Customer) session.getAttribute("customer");
        Cart cart = (Cart) session.getAttribute("userCart");

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());


        int customerID = 0;
        String customerFname = request.getParameter("fname");
        String customerLname = request.getParameter("lname");
        String customerEmail = request.getParameter("email");
        String addressStreet = request.getParameter("street");
        String addressCity = request.getParameter("city");
        String addressState = request.getParameter("state");
        String addressZip = request.getParameter("zip");
        String phoneNumber  = request.getParameter("phoneNumber");





        if(customer != null){
            customerID = customer.getCustomerID();
        }

        int index = 0;
        double totalCost = 0.0;
        double tax = 0.0;
        double taxRate = .04;

        double shipping = 9.99;

        double totalCalculatedCost = 0.0;

        if (cart.getPartOrdersInCartArrayList().isEmpty()){

        } else {

            for (PartOrder partOrder : cart.getPartOrdersInCartArrayList()) {
                Product product = partOrder.getPart();

                totalCost += partOrder.getTotalOrderPrice();
                index += 1;
            }

            tax = totalCost * taxRate;
            totalCalculatedCost = totalCost + tax + shipping;


        }



boolean b = validate();
if(b){  order.setCustomerID(customerID);
        order.setOrderTotalCost(totalCalculatedCost);
        order.setOrderDate(timeStamp);
        order.setOrderStatus("Placed");
        order.setOrderedPartsArrayList(cart.getPartOrdersInCartArrayList());
        order.address.setStreet(addressStreet);
        order.address.setCity(addressCity);
        order.address.setState(addressState);
        order.address.setZip(addressZip);
        order.setCustomerFname(customerFname);
        order.setCustomerLname(customerLname);
        order.setPhoneNumber(phoneNumber);
        order.setEmail(customerEmail);

        session.setAttribute("customerOrder", order);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/checkoutPayment.jsp");
        requestDispatcher.forward(request, response);

    }
else{
session.setAttribute("invalid","invalid");
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/checkout.jsp");
    requestDispatcher.forward(request, response);
}
    }
private Boolean validate(){
        boolean b = true;
    String customerFname = request.getParameter("fname");
    String customerLname = request.getParameter("lname");
    String email = request.getParameter("email");
    String addressZip = request.getParameter("zip");
    String phoneNumber  = request.getParameter("phoneNumber");
    if(!customerFname.matches("[a-zA-Z]{2,20}") || !customerLname.matches("[a-zA-Z]{2,20}")){
        request.setAttribute("name","name");
        b=false;
    }
    if(!phoneNumber.matches("\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})")){
        request.setAttribute("phone","phone");
        b = false;
    }
    if(!addressZip.matches("[0-9]{5}")){
        request.setAttribute("zip","zip");
        b = false;
    }
    if(!email.matches("[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+"A-Z]{2,7}")){
        request.setAttribute("email","email");
        b = false;
    }
    return b;
}
    public void destroy() {
    }

}
