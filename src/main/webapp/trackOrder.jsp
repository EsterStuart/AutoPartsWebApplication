<%@ page import="Business.Order" %>
<%@ page import="org.hsqldb.Session" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Business.Product" %>
<%@ page import="Business.PartOrder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Track Order</title>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/trackOrder.css">
</head>
<body>
<script id="replace_with_navbar" src="nav.js"></script>

<div class="main-area">
    <div class="input-area">
        <h1>Track Order </h1>
        <div>
            <form action="track-order-servlet" method="get">

                <label for="orderID" class="track-label">Order Number</label><br>
                <input type="text" id="orderID" name="orderID" class="track-input"  placeholder="#1005" required><br>

                <label for="email" class="track-label">Email</label><br>
                <input type="text" id="email" name="email" class="track-input"  placeholder="JohnSmith@gmail.com" required><br>

                <label for="lastName" class="track-label">Last Name</label><br>
                <input type="text" id="lastName" name="lastName" class="track-input"  placeholder="Smith" required><br>

                <input type="submit" id="submit" value="Submit"><br>

            </form>
        </div>
    </div>

    <div class="order-details-area">
        <h1>Order Details </h1>
        <div>
            <% Order order = (Order) session.getAttribute("trackOrder");
                if(order != null){
                    out.print("<h2> Order Status: <h2>");
                    out.print("<h3 class='text-offset'>" + order.getOrderStatus() + "</h3>");
                    out.print("<div>");
                    out.print("<h2> Products </h2>");
                    ArrayList<PartOrder> partOrderArrayList = order.getOrderedPartsArrayList();
                    for(PartOrder partOrder : partOrderArrayList){
                        Product product = partOrder.getPart();
                        out.print("<div>");
                        out.print("<h3 class='text-offset'>" + partOrder.getQuantity() + "x " + product.getBrand() + " " + product.getName() + " " + product.getProductType() + "</h3>");
                        out.print("</div>");
                    }
                    out.print("</div>");
                } else {
                    out.print("<h2> No Order Found Please Complete Form </h2>");
                }
                session.removeAttribute("trackOrder");
            %>
        </div>
    </div>
</div>
<script id="replace_with_footer" src="Padfeet.js"> </script>
</body>
</html>