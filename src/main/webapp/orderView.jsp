<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/orderView.css">
    <title>Title</title>
</head>
<body>
<script id="replace_with_navbar" src="nav.js"></script>
<div class="container">
    <h1>Order Details</h1>
    <div class="order-details">

        <h2>Order Number:</h2>
        <p>Customer:</p>
        <p>Order Date:</p>
        <p>Total Amount:</p>
        <p class="order-status">Order Status:</p>
    </div>
    <form action="" method="post">
        <input type="hidden" name="orderId" value="123456">
        <label for="status">Change Order Status to:</label>
        <select name="status" id="status">
            <option value="Shipped">Shipped</option>
            <option value="Canceled">Canceled</option>
        </select>
        <br>
        <input type="submit" value="Update Status">
    </form>
    <div class="return-link">
        <a href="employeeDash.jsp">Back</a>
    </div>
</div>
</body>
</html>
