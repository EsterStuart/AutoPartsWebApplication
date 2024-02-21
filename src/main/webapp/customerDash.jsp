<%@ page import="Business.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/Dash.css">
    <title>Title</title>
</head>
<body>
<script id="replace_with_navbar" src="nav.js"></script>

<% Customer c1 = (Customer) session.getAttribute("customer");
%>
<main class="main">
    <div class="card">
        <h>Customer Information <a href="updateInformation.jsp"> Edit</a> </h>
        <ul><% String message = (String) request.getAttribute("correct");
            if(message != null && message == "correct"){
        %>       <p> Information Updated!</p>
            <%}%>
            <li><%=c1.getFirstName()%>  <%=c1.getLastName()%></li>
            <li><%=c1.getEmail()%></li>
            <li><%=c1.completeAddress.getStreet()%> <%=c1.completeAddress.getCity()%> <%=c1.completeAddress.getState()%> <%=c1.getCompleteAddress().getZip()%></li>
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
