<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/Updat.css">
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
    <form action="/action_page.php" style="border: 1px solid #ccc">
        <div class="container">
            <h>Update Your information </h>
            <p>Please fill out this form to update your information</p>

            <label for="Fname"><b>First Name</b></label>
            <input type="text" placeholder="Enter First Name" name="Fname" required>

            <label for ="Lname"><b> Last Name</b></label>
            <input type="text" placeholder="Enter Last Name" name="Lname" required>

            <label for="email"><b>Email</b></label>
            <input type="text" placeholder="Enter Email" name="email" required>

            <label for="psw"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" required>


            <div class="clearfix">

                <button type="submit">Update User Information.</button>
            </div>
        </div>
    </form>


</form>
</body>
</html>
