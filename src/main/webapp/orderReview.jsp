<%@ page import="Business.Order" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Business.PartOrder" %>
<%@ page import="Business.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/orderReview2.css">
    <title>Review Order Details</title>
</head>
<body>
<script id="replace_with_navbar" src="nav.js"></script>

<div id="main-container">
        <%
            Order order = (Order) session.getAttribute("customerOrder");

            String customerFname = order.getCustomerFname();
            String customerLname = order.getCustomerLname();
            String email = order.getEmail();
            String phoneNumber = order.getPhoneNumber();
            String street = order.address.getStreet();
            String city = order.address.getCity();
            String state = order.address.getState();
            String zip = order.address.getZip();

            ArrayList<PartOrder> partOrderArrayList = order.getOrderedPartsArrayList();

            int orderNumber = order.getOrderID(); //FIX does not retrieve OrderID

            double orderTotal = order.getOrderTotalCost();

        %>

        <div class="container">
            <h1>Order Confirmation</h1>
            <div class="order-summary">
                <h2>Order Number: <%= orderNumber%></h2>
                <p>Thank you for your purchase! Your order details:</p>
                <h3>Summary:</h3>
                <ul class="purchases">

                    <%
                        for (PartOrder partOrder : partOrderArrayList){
                            Product product = partOrder.getPart();
                            out.print("<li>" + product.getBrand() + " " + product.getName() + " " + product.getProductType() + "</li>");
                        }
                    %>
                </ul>
                <p>Total: <%=String.format("%,.2f", orderTotal)%></p>
                <a href="index.jsp">Continue Shopping</a>
            </div>
            <div class="customer-info">
                <!--Data example-->
                <h3>Customer Information:</h3>
                <p>Name: <%=customerFname%> <%=customerLname%></p>
                <p>Email: <%=email%></p>
                <p>Phone: <%=phoneNumber%></p>
                <p>Shipping Address: <%=street%>, <%=city%>, <%=state%>, <%=zip%></p>
                <p>Billing Address: Same as Shipping Address</p>
            </div>
            <div class="thank-you-message">
                <p>Thank you for shopping with us!</p>
            </div>
            <!--related products, if not needed or wanted, it can be deleted-->
            <div class="related-products">
                <h3>Related Products</h3>
                <!-- Add related products here -->
            </div>
        </div>
</div>
<% session.removeAttribute("customerOrder");%>
<script id="replace_with_footer" src="Padfeet.js"> </script>
</body>
</html>
