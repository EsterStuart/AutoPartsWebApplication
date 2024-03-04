<%@ page import="Business.Cart" %>
<%@ page import="Business.Customer" %>
<%@ page import="Business.Product" %>
<%@ page import="Business.PartOrder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/checkout.css">
    <title>Title</title>
</head>
<body>
<script id="replace_with_navbar" src="nav.js"></script>


<%
String phone = (String) request.getAttribute("phone"); String email = (String) request.getAttribute("email"); String zip = (String) request.getAttribute("zip");
    Cart cart;
    cart = (Cart) session.getAttribute("userCart");

    Customer customer = new Customer();
    customer = (Customer) session.getAttribute("customer");


    String customerFName = "";
    String customerLName = "";
    String customerEmail = "";
    String customerStreet = "";
    String customerCity = "";
    String customerState = null;
    String customerZip = "";


    if (customer != null){
        customerFName = customer.getFirstName();
        customerLName = customer.getLastName();
        customerEmail = customer.getEmail();
        customerStreet = customer.completeAddress.getStreet();
        customerCity = customer.completeAddress.getCity();
        customerState = customer.completeAddress.getState();
        customerZip = customer.completeAddress.getZip();
    }

    int index = 0;
    double totalCost = 0.0;
    double tax = 0.0;
    double taxRate = .04;

    double shipping = 9.99;

    double totalCalculatedCost = 0.0;




    if (cart.getPartOrdersInCartArrayList().isEmpty()){

    } else {

        for (PartOrder partOrder : cart.getPartOrdersInCartArrayList()) {
            Product product = partOrder.getPart();

            totalCost += partOrder.getTotalOrderPrice();
            index += 1;
        }

        tax = totalCost * taxRate;
        totalCalculatedCost = totalCost + tax + shipping;


    }



%>


<h1>Checkout</h1>
<div class="container">
    <form action="checkout-servlet" method="get">
        <h2>Contact Information</h2>
        <fieldset>
            <label for="fname">First name:</label><br>
            <input type="text" id="fname" name="fname" class="text--input" value="<%= customerFName %>"  placeholder="Enter First Name" required><br>
            <label for="lname">Last name:</label><br>
            <input type="text" id="lname" name="lname" class="text--input" value="<%= customerLName%>" placeholder="Enter Last Name" required><br>
            <label for="phoneNumber">Phone Number:</label><br>
            <input type="text" id="phoneNumber" name="phoneNumber" class="text--input" value="<%= customerFName %>"  placeholder="Enter a phone number" required><br>
            <% if(phone !=null && phone.equals("phone")){
            %>      <p> Phone Number is Invalid.</p><%}%>
            <label for="email">Email:</label><br>
            <input type="text" id="email" name="email" class="text--input" value="<%= customerEmail%>" placeholder="Enter your email address" required><br>
            <% if(email !=null && email.equals("email")){
            %>      <p> Email is Invalid.</p><%}%>
            <label for="Street">Street:</label><br>
            <input type="text" id="Street" name="street" class="text--input" value ="<%= customerStreet%>" placeholder="Enter Street Address" required/><br>
            <label for="city">City:</label><br>
            <input type="text" id="city" name="city" class="text--input" value="<%= customerCity%>"  placeholder="Enter City" required><br>

            <label for="state">State:</label><br>
            <select name="state" id="state" required>
                <option disabled="" selected="">Select a State</option>
                <option value="Alabama">Alabama</option>
                <option value="Alaska">Alaska</option>
                <option value="Arizona">Arizona</option>
                <option value="Arkansas">Arkansas</option>
                <option value="California">California</option>
                <option value="Colorado">Colorado</option>
                <option value="Connecticut">Connecticut</option>
                <option value="Delaware">Delaware</option>
                <option value="Florida">Florida</option>
                <option value="Georgia">Georgia</option>
                <option value="Hawaii">Hawaii</option>
                <option value="Idaho">Idaho</option>
                <option value="Illinois">Illinois</option>
                <option value="Indiana">Indiana</option>
                <option value="Iowa">Iowa</option>
                <option value="Kansas">Kansas</option>
                <option value="Kentucky">Kentucky</option>
                <option value="Louisiana">Louisiana</option>
                <option value="Maine">Maine</option>
                <option value="Maryland">Maryland</option>
                <option value="Massachusetts">Massachusetts</option>
                <option value="Michigan">Michigan</option>
                <option value="Minnesota">Minnesota</option>
                <option value="Mississippi">Mississippi</option>
                <option value="Missouri">Missouri</option>
                <option value="Montana">Montana</option>
                <option value="Nebraska">Nebraska</option>
                <option value="Nevada">Nevada</option>
                <option value="New Hampshire">New Hampshire</option>
                <option value="New Jersey">New Jersey</option>
                <option value="New Mexico">New Mexico</option>
                <option value="New York">New York</option>
                <option value="North Carolina">North Carolina</option>
                <option value="North Dakota">North Dakota</option>
                <option value="Ohio">Ohio</option>
                <option value="Oklahoma">Oklahoma</option>
                <option value="Oregon">Oregon</option>
                <option value="Pennsylvania">Pennsylvania</option>
                <option value="Rhode Island">Rhode Island</option>
                <option value="South Carolina">South Carolina</option>
                <option value="South Dakota">South Dakota</option>
                <option value="Tennessee">Tennessee</option>
                <option value="Texas">Texas</option>
                <option value="Utah">Utah</option>
                <option value="Vermont">Vermont</option>
                <option value="Virginia">Virginia</option>
                <option value="Washington">Washington</option>
                <option value="West Virginia">West Virginia</option>
                <option value="Wisconsin">Wisconsin</option>
                <option value="Wyoming">Wyoming</option>
            </select><br><br>

            <label for="zip">Zip:</label><br>
            <input type="text" id="zip" name="zip" class="text--input" value="<%= customerZip%>" placeholder="Enter Zip Code" required><br>
            <% if(zip !=null && zip.equals("zip")){
            %>      <p> Zip Code is Invalid.</p><%}%>
            <input type="submit" id="submit" value="Submit">
        </fieldset>
    </form>

    <div class="total-section">
        <div class="total-item">
            <span class="total-label">Subtotal: </span>
            <span class="subtotal-price"> $<%=String.format("%,.2f", totalCost) %> </span>
        </div>
        <div class="total-item">
            <span class="total-label">Taxes:</span>
            <span class="taxes"> $<%= String.format("%,.2f", tax) %> </span>
        </div>
        <div class="total-item">
            <span class="total-label">Shipping:</span>
            <span class="shipping"> $<%= String.format("%,.2f", shipping) %> </span>
        </div>
        <div class="total-item">
            <span class="total-label">Total:</span>
            <span class="total-price"> $<%= String.format("%,.2f", totalCalculatedCost) %> </span>
        </div>
    </div>
</div>
</body>
</html>
