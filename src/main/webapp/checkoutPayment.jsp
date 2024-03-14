<%@ page import="Business.Product" %>
<%@ page import="Business.PartOrder" %>
<%@ page import="Business.Cart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment</title>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/paymentCheckout2.css">
</head>
<body>
<%
    Cart cart;
    cart = (Cart) session.getAttribute("userCart");

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
%>
<script id="replace_with_navbar" src="nav.js"></script>

<h1>Payment Information</h1>
<div class="container">
    <form action="payment-servlet" method="get">
        <h2>Card Information</h2>
        <fieldset>
            <label for="cardNumber">Card Number:</label><br>
            <input type="text" id="cardNumber" name="cardNumber" class="text--input" value=""  placeholder="Enter your debit/credit card number" required><br>
            <label for="Expiration">Expiration:</label><br>
            <input type="text" id="Expiration" name="expiration" class="text--input" value="" placeholder="enter expiration date" required><br>
            <label for="cvv">CVV</label><br>
            <input type="text" id="cvv" name="cvv" class="text--input" value=""  placeholder="Enter cvv number" required><br>
            <label for="zip">Zip Code:</label><br>
            <input type="text" id="zip" name="zip" class="text--input" value="" placeholder="Enter your zip code" required><br>

            <input type="submit" id="submit" value="Submit"><br>
        </fieldset>
    </form>
    <div class="total-section">
        <div class="total-item">
            <span class="total-label">Subtotal: </span>
            <span class="subtotal-price"> $<%=String.format("%,.2f", totalCost) %> </span>
        </div>
        <div class="total-item">
            <span class="total-label">Taxes:</span>
            <span class="taxes"> $<%= String.format("%,.2f", tax) %> </span>
        </div>
        <div class="total-item">
            <span class="total-label">Shipping:</span>
            <span class="shipping"> $<%= String.format("%,.2f", shipping) %> </span>
        </div>
        <div class="total-item">
            <span class="total-label">Total:</span>
            <span class="total-price"> $<%= String.format("%,.2f", totalCalculatedCost) %> </span>
        </div>
    </div>
</div>

<script id="replace_with_footer" src="Padfeet.js"> </script>

</body>
</html>
