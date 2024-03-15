<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import = "Business.Product"%>
<%@page import = "Business.Order"%>
<%@page import = "Business.Customer"%>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/EmpDas.css">

    <title> Employee Dash</title>
</head>
<body>

<script id="replace_with_navbar" src="nav.js"></script>


<div class="container">
    <h2 class="title"> ORDERS </h2>
    <div class="order-area">
        <h3> Filter </h3>
        <div class="filter-area">
            <form action="load-filtered-orders-servlet">
                <label class="filter-label" for="OrderID"> OrderID </label>
                <input class="filter-input" type="text" id="OrderID" name="OrderID">

                <span class="divider-span"> OR </span>

                <label class="filter-label" for="FirstName"> First Name </label>
                <input class="filter-input" type="text" id="FirstName" name="FirstName">

                <label class="filter-label" for="LastName"> Last Name </label>
                <input class="filter-input" type="text" id="LastName" name="LastName">

                <input type="submit">

            </form>
            <a href="load-all-orders-servlet"> [x] Clear Filters </a>
        </div>

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

<script id="replace_with_footer" src="Padfeet.js"> </script>
</body>
</html>
