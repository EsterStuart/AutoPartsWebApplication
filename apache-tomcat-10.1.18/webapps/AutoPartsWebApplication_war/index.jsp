<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

  <link rel="stylesheet" href="css/global.css">


  <title>Home</title>

  <style>
    body {
      height: 100vh;
      overflow: hidden;
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

  </style>
</head>
<body>

<script id="replace_with_navbar" src="nav.js"></script>

<h1>Welcome</h1>
<div class="button--container">
  <a href="productCategories.jsp">Search Parts</a>
  <a href="login.jsp">Login</a>
</div>
</body>
</html>
