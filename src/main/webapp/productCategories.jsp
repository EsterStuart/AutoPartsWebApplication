<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Part Categories</title>

    <style>
        body {
            font-family: Arial, sans-serif;
        }
        #title {
            text-align: center;
        }

        .navbar {
            background-color: #333;
            position: relative;
            z-index: 999;
        }

        .navbar ul {
            list-style-type: none;
            margin: 0;
            padding: 10px;
            background: black;
        }

        .navbar li {
            display: inline-block;
        }

        .navbar li a {
            color: white;
            display: block;
            padding: 10px 20px;
            text-decoration: none;
        }

        /* Style the dropdown menu */
        .navbar ul ul {
            position: absolute;
            top: 100%;
            display: none;
        }

        .navbar ul ul li {
            display: block;
        }

        .navbar li:hover ul {
            display: block;
        }

        /* Change the background color of dropdown links on hover */
        .navbar ul ul li a:hover {
            background-color: #555;
        }

        /* grid layout */
        .partType {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            grid-gap: 20px;
            margin: 0 0 40px 0;
        }
    </style>
</head>
<body>
<nav class="navbar">
    <ul>
        <li><a href="Home.html">Home</a></li>

        <li>
            <a href="">Vehicle</a>
            <ul>
                <li><a href="#">Sedan</a></li>
                <li><a href="#">SUV</a></li>
                <li><a href="#">Truck</a></li>
                <li><a href="#">Coupe</a></li>
                <li><a href="#">Sport</a></li>
            </ul>
        </li>
        <li><a href="#">Products</a></li>

        <li>
            <a href="#">Login/Account</a>
            <ul>
                <li><a href="Cust%20Login.html">Customer</a> </li>
                <li><a href="Login.html">Employee</a> </li>
            </ul>
        </li>

        <li><a href="#">Cart</a> </li>
        <li><a href="#">Help</a></li>
    </ul>
</nav>
<h1 id="title">Part Categories</h1>

<h2 class="carType">Sedan</h2>
<div class="partType">
    <a href="products.jsp">Spark Plugs</a>
    <a href="products.jsp">Air Filter</a>
    <a href="products.jsp">Battery</a>
    <a href="products.jsp">Brake Pad</a>
    <a href="products.jsp">Tires</a>
    <a href="products.jsp">Oil</a>
    <a href="products.jsp">Coolant</a>
    <a href="products.jsp">Wiper</a>
    <a href="products.jsp">Headlight Bulb</a>
    <a href="products.jsp">Brake Light Bulb</a>
    <a href="products.jsp">Turn Signal Bulb</a>
</div>
<h2 class="carType">SUV</h2>
<div class="partType">
    <a href="products.jsp">Spark Plugs</a>
    <a href="products.jsp">Air Filter</a>
    <a href="products.jsp">Battery</a>
    <a href="products.jsp">Brake Pad</a>
    <a href="products.jsp">Tires</a>
    <a href="products.jsp">Oil</a>
    <a href="products.jsp">Coolant</a>
    <a href="products.jsp">Wiper</a>
    <a href="products.jsp">Headlight Bulb</a>
    <a href="products.jsp">Brake Light Bulb</a>
    <a href="products.jsp">Turn Signal Bulb</a>
</div>
<h2 class="carType">Truck</h2>
<div class="partType">
    <a href="products.jsp">Spark Plugs</a>
    <a href="products.jsp">Air Filter</a>
    <a href="products.jsp">Battery</a>
    <a href="products.jsp">Brake Pad</a>
    <a href="products.jsp">Tires</a>
    <a href="products.jsp">Oil</a>
    <a href="products.jsp">Coolant</a>
    <a href="products.jsp">Wiper</a>
    <a href="products.jsp">Headlight Bulb</a>
    <a href="products.jsp">Brake Light Bulb</a>
    <a href="products.jsp">Turn Signal Bulb</a>
</div>
<h2 class="carType">Coupe</h2>
<div class="partType">
    <a href="products.jsp">Spark Plugs</a>
    <a href="products.jsp">Air Filter</a>
    <a href="products.jsp">Battery</a>
    <a href="products.jsp">Brake Pad</a>
    <a href="products.jsp">Tires</a>
    <a href="products.jsp">Oil</a>
    <a href="products.jsp">Coolant</a>
    <a href="products.jsp">Wiper</a>
    <a href="products.jsp">Headlight Bulb</a>
    <a href="products.jsp">Brake Light Bulb</a>
    <a href="products.jsp">Turn Signal Bulb</a>
</div>
<h2 class="carType">Sport</h2>
<div class="partType">
    <a href="products.jsp">Spark Plugs</a>
    <a href="products.jsp">Air Filter</a>
    <a href="products.jsp">Battery</a>
    <a href="products.jsp">Brake Pad</a>
    <a href="products.jsp">Tires</a>
    <a href="products.jsp">Oil</a>
    <a href="products.jsp">Coolant</a>
    <a href="products.jsp">Wiper</a>
    <a href="products.jsp">Headlight Bulb</a>
    <a href="products.jsp">Brake Light Bulb</a>
    <a href="products.jsp">Turn Signal Bulb</a>
</div>

</body>
</html>
