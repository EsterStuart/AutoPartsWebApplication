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

<Form action="CustomerLoginServlet" method="get">


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


</Form>
<script id="add_the_feet" src="Padfeet.js"> </script>
</body>



</html>
