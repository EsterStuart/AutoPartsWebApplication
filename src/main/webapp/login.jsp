<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


 <link rel="stylesheet" href="css/global.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/padfoot.css">


  <meta charset="UTF-8">
  <title>Title</title>



</head>
<body>
<script id="replace_with_navbar" src="nav.js"></script>


<h1 id="title"> Customer Login </h1>
<div class="container">
  <Form action="CustomerLoginServlet" method="get">
  <label for=""><b>Email</b></label>
  <input type="text" placeholder="Enter Email" name="email" required>

  <label for=""><b>Password</b></label>
  <input type="password" placeholder="Enter Password" name="psw" required>
  <button type="submit">Login</button>
  </Form>
<% String message = (String) request.getAttribute("message");
if(message != null){
%><p>Incorrect Username or Password. Please Try Again.</p>
<%}%>


  <p class="divider"><span class="divider-span">Don't Have an Account?</span></p>
  <a href="createAccount.jsp" class="create-account-btn"> Create an account </a>



</div>

<<<<<<< HEAD
  <script id="add_the_feet" src="Padfeet.js"> </script>
</Form>
=======


>>>>>>> 1664355036b5735a7678710ea769245023c29f5c

</body>



</html>
