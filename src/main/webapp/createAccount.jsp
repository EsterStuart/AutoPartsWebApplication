<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
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
        <li><a href="login.jsp">Customer</a> </li>
        <li><a href="employeeLogin.jsp"> Employee</a> </li>
      </ul>
    </li>

    <li><a href="#">Cart</a> </li>
    <li ><a href="#">Help</a></li>
  </ul>
</nav>


<form action="/action_page.php" style="border: 1px solid #ccc">
  <div class="container">
  <h>Create Your Account </h>
  <p>Please fill out this form to complete account creation</p>

  <label for="Fname"><b>First Name</b></label>
  <input type="text" placeholder="Enter First Name" name="Fname" required>

  <label for ="Lname"><b> Last Name</b></label>
  <input type="text" placeholder="Enter Last Name" name="Lname" required>

  <label for="email"><b>Email</b></label>
  <input type="text" placeholder="Enter Email" name="email" required>

  <label for="psw"><b>Password</b></label>
  <input type="password" placeholder="Enter Password" name="psw" required>


<div class="clearfix">
  <button type="button" class="cancelbtn">Cancel</button>
  <button type="submit" class="signupbtn">Sign Up</button>
</div>
</div>
</form>
</body>

</html>
