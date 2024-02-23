<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment</title>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/checkoutPayment.css">
</head>
<body>
<script id="replace_with_navbar" src="nav.js"></script>

<h1>Payment Information</h1>
<div class="container">
    <form action="checkout-servlet" method="get">
        <h2>Card Information</h2>
        <fieldset>
            <label for="cardNumber">Card Number:</label><br>
            <input type="text" id="cardNumber" name="cardNumber" class="text--input" value=""  placeholder="Enter your debit/credit card number"><br>
            <label for="Expiration">Expiration:</label><br>
            <input type="text" id="Expiration" name="expiration" class="text--input" value="" placeholder="enter expiration date"><br>
            <label for="cvv">CVV</label><br>
            <input type="text" id="cvv" name="cvv" class="text--input" value=""  placeholder="Enter cvv number"><br>
            <label for="zip">Zip Code:</label><br>
            <input type="text" id="zip" name="zip" class="text--input" value="" placeholder="Enter your zip code"><br>

            <input type="submit" id="submit" value="Submit"><br>
        </fieldset>
    </form>
    <div class="total-section">
        <div class="total-item">
            <span class="total-label">Subtotal: </span>
            <span class="subtotal-price"> $ </span>
        </div>
        <div class="total-item">
            <span class="total-label">Taxes:</span>
            <span class="taxes"> $ </span>
        </div>
        <div class="total-item">
            <span class="total-label">Shipping:</span>
            <span class="shipping"> $ </span>
        </div>
        <div class="total-item">
            <span class="total-label">Total:</span>
            <span class="total-price"> $</span>
        </div>
    </div>
</div>
</body>
</html>
