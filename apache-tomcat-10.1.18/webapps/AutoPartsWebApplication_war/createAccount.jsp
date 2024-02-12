<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/global.css">
  <link rel="stylesheet" href="css/Signup.css">
    <title>SignUp</title>
<body>

<script id="replace_with_navbar" src="nav.js"></script>

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
