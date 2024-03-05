<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import = "Business.Product"%>
<%@page import = "Business.Order"%>
<%@page import = "Business.Customer"%>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/EmpDash.css">

    <title> Employee Dash</title>
</head>
<body>

<script id="replace_with_navbar" src="nav.js"></script>


<div class="container">
    <h2> ORDERS </h2>
    <div class="order-area">
            <%
                ArrayList<Order> allOrdersArrayList = (ArrayList<Order>) session.getAttribute("allOrdersArrayList");

                for (Order order : allOrdersArrayList){
                    Customer customer = new Customer();
                    customer.selectDB(order.getCustomerID());

                    String customerFName = "N/A";
                    String customerLName = "";

                    if (customer.getCustomerID() != 0){
                        customerFName = customer.getFirstName();
                        customerLName = customer.getLastName();
                    }


                    out.print("<div class='order-card'>");
                    out.print("<h2>" + "Order ID : " + order.getOrderID() + "</h2>");
                    out.print("<h3>" + "Customer : " + customerFName + " " + customerLName + "</h3>");
                    out.print("<h3>" + "Order Date : " + order.getOrderDate()+ "</h3>");
                    out.print("<h3>" + "Total Cost : " + order.getOrderTotalCost() + "</h3>");
                    out.print("<h3>" + "Order Status : " + order.getOrderStatus() + "</h3>");

                    out.print("<form id='loadOrderForm' action='load-order-servlet'>");

                    out.print("<input type='hidden' id='orderID' name='orderID' value='" + order.getOrderID() + "'>");
                    out.print("<input type='submit' value = 'View'>");
                    out.print("</form>");

                    out.print("</div>");

                }
            %>
    </div>
</div>


</body>
</html>
