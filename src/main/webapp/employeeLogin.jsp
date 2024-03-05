<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

  <link rel="stylesheet" href="css/login.css">
  <link rel="stylesheet" href="css/global.css">

  <meta charset="UTF-8">
  <title>Employee Login</title>
</head>
<body>
<script id="replace_with_navbar" src="nav.js"></script>



<h1 class="Split"> Employee Login</h1>
<h1 id="title"> Employee Login</h1>


<div class="login-area">
  <form action="load-all-orders-servlet">

  <label for=""><b>Username</b></label>
  <input type="text" placeholder="Enter Username" id="username" required>

  <label for=""><b>Password</b></label>
  <input type="password" placeholder="Enter Password" id="password" required>

  <button type="submit">Login</button>

  </form>
</div>


</body>
</html>
