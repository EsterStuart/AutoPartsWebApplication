<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import = "java.util.ArrayList"%>
<%@page import = "Business.Product"%>



<html>
<head>

    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/products.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <title>Products</title>

    <style>
        body {font-family: Arial, Helvetica, sans-serif;}

        /* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            padding-top: 100px; /* Location of the box */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }

        /* Modal Content */
        .modal-content {
            background-color: #fefefe;
            margin: auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
        }

        /* The Close Button */
        .close {
            color: #aaaaaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: #000;
            text-decoration: none;
            cursor: pointer;
        }
    </style>


</head>

<body>

<script id="replace_with_navbar" src="nav.js"></script>

<h1 class="title">Products</h1>








<div class="grid-container">
    <%
        ArrayList<Product> ProductsFilteredList = (ArrayList) session.getAttribute("ArrayOfFilteredProducts");

        for (Product product : ProductsFilteredList){
            out.print("<div class='grid-item'>");
            out.print("<h3>" + product.getBrand() + " " + product.getName() + " " + product.getProductType() + "</h3>");
            out.print("<h4>" + product.getDescription() + "</h4>");
            out.print("<h4>$" + product.getPrice() + "</h4>");


            out.print("<form id='addToCartForm' onSubmit='return addItemToCart()' action='add-product-to-cart-servlet'>");

            out.print("<input type='hidden' id='ProductID' name='ProductID' value='" + product.getProductID() + "'>");

            out.print("<hr>");
            out.print("<label for='orderQuantity' id='orderQuantity'>Quantity</label>");

            out.print("<input type='number' id='OrderQuantity' name='OrderQuantity' value='1' min='1' max='100' />");


            out.print("<input type='submit' value ='Add' />");

            out.print("</form>");

            out.print("</div>");
        }
    %>

</div>




<button id="myBtn" style="display: none">Open Modal</button>


<div id="myModal" class="modal">
    <div class="modal-content">
        <h1>Item Added to Cart!</h1>
        <span class="close">&times;</span>
        <a href="load-cart-servlet"> Got To Checkout </a>
    </div>

</div>



<script>


    var modal = document.getElementById("myModal");
    var showModalBtn = document.getElementById("myBtn");
    var span = document.getElementsByClassName("close")[0];


    function addItemToCart(){
        showModalBtn.click();
        return true;
    }

    showModalBtn.onclick = function() {
        modal.style.display = "block";
    }
    span.onclick = function() {
        modal.style.display = "none";
    }
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>


<% session.removeAttribute("ArrayOfFilteredProducts");%>
</body>
</html>
