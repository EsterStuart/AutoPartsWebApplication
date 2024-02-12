<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action =UpdateCustomerInfo method="get">

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
