<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Home</title>
  <style>
    body {
      height: 100vh;
      overflow: hidden;
      font-family: Arial, sans-serif;
    }

    h1 {
      text-align: center;
    }

    /* style for login and search button */
    .button--container {
      display: flex;
      align-items: center;
      justify-content: center;
      gap: 20px;
      position: relative;
      top: 25%;
    }

    .button--container a {
      text-decoration: none;
      padding: 10px 20px;
      background-color: #000;
      border-radius: 10px;
      color: #ffffff;
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
        <li><a href="Login.html"> Employee</a> </li>
      </ul>
    </li>

    <li><a href="#">Cart</a> </li>
    <li><a href="#">Help</a></li>
  </ul>
</nav>
<h1>Welcome</h1>
<div class="button--container">
  <a href="productCategories.jsp">Search Parts</a>
  <a href="login.jsp">Login</a>
</div>
</body>
</html>