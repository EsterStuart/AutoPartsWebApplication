<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

  <link rel="stylesheet" href="css/login.css">
  <link rel="stylesheet" href="css/global.css">
  <link rel="stylesheet" href="css/padfoot.css">

  <meta charset="UTF-8">
  <title>Emp</title>
</head>
<body>
<script id="replace_with_navbar" src="nav.js"></script>



<h1> Employee Login</h1>

<div class="container">
  <form action="load-all-orders-servlet">

  <label for=""><b>Username</b></label>
  <input type="text" placeholder="Enter Username" id="username" required>

  <label for=""><b>Password</b></label>
  <input type="password" placeholder="Enter Password" id="password" required>

  <button type="submit">Login</button>

  </form>
</div>
<script id="add_the_feet" src="Padfeet.js"> </script>
</body>
</html>
