<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/global.css">
    <title>Title</title>
</head>
<body>

<form action =UpdateCustomerInfo method="get">
=======
<script id="replace_with_navbar" src="nav.js"></script>


    <% String message = (String) request.getAttribute("message");
        if(message != null){
    %>       <p> You must provide a value to at least one of the fields.</p>
        <%}
        else{%>
             <p> Information Updated.</p>
        <%}%>
<button type="submit">Update User Information.</button>


</form>
</body>
</html>
