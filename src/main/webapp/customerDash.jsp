<%@ page import="Business.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/Dash.css">
    <title>Title</title>
</head>
<% Customer c1 = (Customer) session.getAttribute("c1");
%>
<body>
<script id="replace_with_navbar" src="nav.js"></script>


<main class="main">
    <div class="card">
        <h>Customer Information <a href="updateInformation.jsp"> Edit</a> </h>
        <% String message = (String) request.getAttribute("correct");
            if(message != null && message.equals("correct")){
        %>       <p> Information has been Updated!</p>
        <%}%>
        <ul>
            <li><%=c1.getFirstName()%> <%=c1.getLastName() %></li>

            <li><%=c1.getEmail() %></li>
            <li><%=c1.getAddress()%></li>
        </ul>
    </div>
    <div class="card">
        <h>Customers orders</h>
        <ul>
            <li>Order #1</li>
            <li>Order #2</li>
            <li>Order #3</li>
        </ul>
    </div>

</main>

</body>
</html>
