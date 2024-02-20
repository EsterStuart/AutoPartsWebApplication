
<%@ page import="Business.Customer" %>
<link rel="stylesheet" href="css/navbar.css">

<%
    Customer customer;
    customer =( Customer) session.getAttribute("customer");

%>

<nav class="navbar">
    <ul>
        <li><a href="index.jsp">Home</a></li>
        <li><a href="productCategories.jsp">Products</a></li>
        <li><a href="help.jsp">FAQ</a></li>

        <li>
            <form action="searchbar-servlet">
                <input type="text" id="searchbarText" placeholder="Product">
                <input type="submit" value="Search">
            </form>
        </li>

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
                    out.print("<a href='logout-servlet'> Logout </a>");
                out.print("</li>");

                out.print("<li>");
                    out.print("<a href='customerDash.jsp'> Dash </a>");
                out.print("</li>");
            }

        %>



        <li><a href="load-cart-servlet">Cart</a> </li>
    </ul>
</nav>