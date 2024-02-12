<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="Login.css">
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<Form action="CustomerLoginServlet" method="get"><body>
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

<div class ="Split"><h1> Customer Login</h1>
  <h2><a href="createAccount.jsp"> Sign Up</a></h2>
</div>

<div class="container">
  <label for=""><b>Username</b></label>
  <input type="text" placeholder="Enter Username" name="uname" required>

  <label for=""><b>Password</b></label>
  <input type="password" placeholder="Enter Password" name="psw" required>
<% String message = (String) request.getAttribute("message");
if(message != null){
%><p>Incorrect Username or Password. Please Try Again.</p>
<%}%>

  <button type="submit">Login</button>
</div>

</body></Form>
</html>
