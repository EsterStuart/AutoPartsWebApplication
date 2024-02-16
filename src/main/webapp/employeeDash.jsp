<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import = "Business.Product"%>
<%@page import = "Business.Order"%>
<%@page import = "Business.Customer"%>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="EmpDash.css">

    <title>Title</title>
</head>
<body>
<script id="replace_with_navbar" src="nav.js"></script>

<main class="main">

<div>
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


            out.print("<div>");
            out.print("<h3>" + "Order ID : " + order.getOrderID() + " Customer : " + customerFName + " " + customerLName + " Date : " + order.getOrderDate() + " Status : " + order.getOrderStatus() + "</h3>");
            out.print("<form id='loadOrderForm' action='load-order-servlet'>");

            out.print("<input type='hidden' id='orderID' name='orderID' value='" + order.getOrderID() + "'>");
            out.print("<input type='submit' value = 'View'>");
            out.print("</form>");

            out.print("</div>");

        }
    %>

</div>


</main>




</body>
</html>
