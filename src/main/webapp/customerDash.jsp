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

    <h1 id="title"> Welcome <%= c1.getFirstName()%> <%=c1.getLastName()%> </h1>

    <div class="row">
        <div class="column">
            <div class="column-interior">

                <h2 class="inner-title">Customer Information  </h2>

                <% String message = (String) request.getAttribute("correct");
                    if(message != null && message == "correct") {
                        out.print("<h2> Information Updated! </h2>");
                    }
                %>

                <h2 class="sub-text"><%=c1.getFirstName()%>  <%=c1.getLastName()%></h2>
                <h2 class="sub-text"><%=c1.getEmail()%></h2>
                <h2 class="sub-text"><%=c1.completeAddress.getStreet()%> <%=c1.completeAddress.getCity()%> <%=c1.completeAddress.getState()%> <%=c1.getCompleteAddress().getZip()%></h2>

                <a href="updateInformation.jsp">
                    <button class="button">Update Information</button>
                </a>
            </div>
        </div>



        <div class="column">
            <div class="column-interior">
                <h2 class="inner-title">Previous Orders</h2>

                <%
                    ArrayList<Order> allOrdersArrayList = Order.getAllOrders(c1.getCustomerID());

                    if (allOrdersArrayList.isEmpty()){
                        out.print("<h2> There are currently no orders associated with this account </h2>");
                    }

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
                        out.print("<h2 class='sub-text'>" + "Order ID : " + order.getOrderID() + "</h2>");
                        out.print("<h3 class='sub-text'>" + "Customer : " + customerFName + " " + customerLName + "</h3>");
                        out.print("<h3 class='sub-text'> " + "Order Date : " + order.getOrderDate()+ "</h3>");
                        out.print("<h3 class='sub-text'>" + "Total Cost : " + order.getOrderTotalCost() + "</h3>");
                        out.print("<h3 class='sub-text'>" + "Order Status : " + order.getOrderStatus() + "</h3>");

                        out.print("<form id='loadOrderForm' action='customer-load-order-servlet'>");

                        out.print("<input type='hidden' id='orderID' name='orderID' value='" + order.getOrderID() + "'>");
                        out.print("<input class='button' type='submit' value = 'View'>");
                        out.print("</form>");

                        out.print("</div>");

                    }
                %>
            </div>
        </div>
    </div>






</main>

</body>
</html>
