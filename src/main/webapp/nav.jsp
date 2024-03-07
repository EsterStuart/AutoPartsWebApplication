<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Business.Customer" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/nav.css">

</head>
<body>

<%
    Customer customer;
    customer =( Customer) session.getAttribute("customer");

%>

<nav class="navbar">
    <ul class="nav-left">
        <li><a href="index.jsp">Home</a></li>
        <li><a href="productCategories.jsp">Products</a></li>
        <li><a href="help.jsp">FAQ</a></li>
        <li><a href="trackOrder.jsp">Track Order</a></li>
        <%
            if (customer == null) {
                out.print("<li>");
                out.print("<a href='login.jsp'>Login/Account</a>");
                out.print("<ul>");
                out.print("<li> <a href='login.jsp'>Customer</a> </li>");
                out.print("<li> <a href='employeeLogin.jsp'> Employee</a> </li>");
                out.print("</ul>");
                out.print("</li>");

            } else {

                out.print("<li>");
                out.print("<a href='customerDash.jsp'> Dash </a>");
                out.print("</li>");

                out.print("<li>");
                out.print("<a href='logout-servlet'> Logout </a>");
                out.print("</li>");
            }
        %>
    </ul>

    <ul class="nav-right">
        <li>
            <form action="searchbar-servlet" method="get">
                <input type="text" name="searchbarText" id="searchbarText" placeholder="Search Products">
                <input type="submit" value="Search">
            </form>
        </li>
        <li><a href="load-cart-servlet">Cart</a></li>
    </ul>
</nav>
</body>
</html>






