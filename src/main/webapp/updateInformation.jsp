<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/Updat.css">
    <title>Title</title>
</head>
<body>



<script id="replace_with_navbar" src="nav.js"></script>



    <form action =UpdateCustomerInfo method="get" style="border: 1px solid #ccc">
        <div class="container">
            <h>Update Your information </h>
            <p>Please fill out this form to update your information</p>

            <label for="Fname"><b>First Name</b></label>
            <input type="text" placeholder="Enter First Name" name="Fname" id="Fname" >

            <label for ="Lname"><b> Last Name</b></label>
            <input type="text" placeholder="Enter Last Name" name="Lname" id="Lname"  >

            <% String name = (String) request.getAttribute("name");
                if(name != null && name.equals("name")){ %><p> You are already using this name.</p><%}%>

            <label for="email"><b>Email</b></label>
            <input type="text" placeholder="Enter Email" name="email" id="email" >
            <% String emails = (String) request.getAttribute("emails");
                if(emails != null && emails.equals("emails")){ %><p> You must enter a valid email</p><%}%>

            <% String email = (String) request.getAttribute("email");
                if(email != null && email.equals("email")){ %><p> You are already using this email.</p><%}%>

            <label for="address"><b>Address</b></label>
            <input type="text" placeholder="Enter Address" name="address" id="address" >

            <% String address = (String) request.getAttribute("address");
                if(address != null && address.equals("address")){%><p> You are already using this address.</p><%}%>

            <label for="psw"><b>Password (Must Include at least 6 characters,1 Uppercase,1 Lowercase character, and 1 Number) </b></label>
            <input type="password" placeholder="Enter Password" name="psw" id="psw" >

            <% String pass = (String) request.getAttribute("psw");
                if(pass != null && pass.equals("psw")){%><p> You are already using this password.</p><%}%>
            <% String psw = (String) request.getAttribute("pass");
                 if(psw != null && psw.equals("pass")){%><p> Invalid Password.</p><%}%>

            <div class="clearfix">

                <% String test = (String) request.getAttribute("Null");
                    if(test != null && test.equals("Null")){%><p> You must enter a value to at least one of the fields.</p><%}%>

                <button type="submit">Update User Information.</button>
            </div>
        </div>
    </form>



</body>
</html>
