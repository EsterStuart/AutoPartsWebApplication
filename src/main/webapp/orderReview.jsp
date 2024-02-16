<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/orderReview.css">
    <title>Title</title>
</head>
<body>
<script id="replace_with_navbar" src="nav.js"></script>
<div class="container">
    <h1>Order Confirmation</h1>
    <div class="order-summary">
        <h2>Order Number: </h2>
        <p>Thank you for your purchase! Your order details:</p>
        <h3>Summary:</h3>
        <ul class="purchases">
            <li>Product Name 1  </li>
            <li>Product Name 2  </li>
            <li>Product Name 3  </li>
        </ul>
        <p>Total: </p>
        <a href="index.jsp">Continue Shopping</a>
    </div>
    <div class="customer-info">
        <!--Data example-->
        <h3>Customer Information:</h3>
        <p>Name: John Doe</p>
        <p>Email: johndoe@example.com</p>
        <p>Phone: +1 (123) 456-7890</p>
        <p>Shipping Address: 123 Main St, Cityville, State, 12345</p>
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
</body>
</html>
