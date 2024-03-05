<%@ page import="Business.Customer" %>
<%@ page import="Business.Order" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/Dash.css">
    <title>Title</title>
</head>
<body>
<script id="replace_with_navbar" src="nav.js"></script>

<% Customer c1 = (Customer) session.getAttribute("customer");
%>
<main class="main">
    <h1> Welcome <%= c1.getFirstName()%> <%=c1.getLastName()%> </h1>
    <h>Customer Information <a href="updateInformation.jsp"> Edit</a> </h>
    <ul><% String message = (String) request.getAttribute("correct");
        if(message != null && message == "correct"){
    %>       <p> Information Updated!</p>
        <%}%>
        <li><%=c1.getFirstName()%>  <%=c1.getLastName()%></li>
        <li><%=c1.getEmail()%></li>
        <li><%=c1.completeAddress.getStreet()%> <%=c1.completeAddress.getCity()%> <%=c1.completeAddress.getState()%> <%=c1.getCompleteAddress().getZip()%></li>
    </ul>
    <h>Customers orders</h>
    <%
        ArrayList<Order> allOrdersArrayList = Order.getAllOrders(c1.getCustomerID());

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
</main>

</body>
</html>
