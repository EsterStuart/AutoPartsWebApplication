<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import = "java.util.ArrayList"%>
<%@page import = "Business.Product"%>



<html>
<head>

    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/products.css">



    <title>Products</title>

    <style>
        body {font-family: Arial, Helvetica, sans-serif;}
    </style>


</head>

<body>

<script id="replace_with_navbar" src="nav.js"></script>

<h1 class="title">Products</h1>

<div class="main-area">
    <div class="car-type-selection-area">
        <div>
            <h2>Add Your Vehicle to See Exact Fit Parts</h2>
        </div>
        <div class="car-select">
            <form action="load-product-servlet">
                <label for="type" class="car-select-label"> Type </label>
                <select class="filter-drop-down" id="type" name="type" required>
                    <option disabled selected hidden="">Type</option>
                    <option value="suv">SUV</option>
                    <option value="sedan">Sedan</option>
                    <option value="truck">Truck</option>
                    <option value="coupe">Coupe</option>
                    <option value="sport">Sport</option>

                </select>



                <label for="year" class="car-select-label"> Year </label>
                <input class="filter-input" type="number" id="year" name="year" min="1960" max="2025" step="1" required/>

                <label for="make" class="car-select-label"> Make </label>
                <select class="filter-drop-down" id="make" name="make" required>
                    <option disabled selected hidden="">Make</option>
                    <option value="ford"> Ford </option>
                    <option value="bmw"> BMW </option>
                    <option value="jeep"> Jeep </option>
                    <option value="toyota"> Toyota </option>
                    <option value="chevrolet"> Chevrolet </option>
                    <option value="honda"> Honda </option>
                    <option value="volkswagon"> Volkswagon </option>
                    <option value="audi"> Audi </option>
                </select>

                <input class="filter-submit" type="submit" value="Apply">

            </form>
        </div>

    </div>
    <div class="filter-area">
        <div class="filter-row">
            <h3>Car Type</h3>
            <br>
            <a href="" class="filter-option"> SUV </a>
            <br>
            <a href="" class="filter-option"> SEDAN </a>
            <br>
            <a href="" class="filter-option"> TRUCK </a>
            <br>
            <a href="" class="filter-option"> SUV </a>
            <br>
            <a href="" class="filter-option"> SPORT </a>
        </div>
    </div>

    <div class="grid-container">
        <%
            ArrayList<Product> ProductsFilteredList = new ArrayList<Product>();
            ArrayList<Product> carTypeFilteredList = (ArrayList<Product>) session.getAttribute("filteredByCartTypeProducts");


            if (carTypeFilteredList != null){
                ProductsFilteredList = carTypeFilteredList;
            } else {
                ProductsFilteredList = (ArrayList) session.getAttribute("ArrayOfFilteredProducts");
            }


            if (ProductsFilteredList.isEmpty() != true){
                for (Product product : ProductsFilteredList){
                    out.print("<div class='grid-item'>");
                        out.print("<h2>" + product.getBrand() + " " + product.getName() + " " + product.getProductType() + "</h2>");
                        out.print("<img src='Photos/spark-plug-ex.jpg' alt='place holder icon' class='productImage'>");


                         out.print("<h4>" + product.getDescription() + "</h4>");
                         out.print("<h4>$" + product.getPrice() + "</h4>");
                         out.print("<h4 class='product-number-text' >Product # " + product.getProductID() + "</h4>");


                        out.print("<form id='addToCartForm' onSubmit='return addItemToCart()' action='add-product-to-cart-servlet'>");
                            out.print("<input type='hidden' id='ProductID' name='ProductID' value='" + product.getProductID() + "'>");
                            out.print("<hr>");
                            out.print("<label for='orderQuantity' id='orderQuantity'>Quantity</label>");
                            out.print("<input type='number' class='quantity-input' id='OrderQuantity' name='OrderQuantity' value='1' min='1' max='100' />");
                            out.print("<input class='add-to-cart-btn' type='submit' value ='Add' />");
                        out.print("</form>");
                    out.print("</div>");
                }
            } else {
                out.print("<h1> NO PRODUCTS FOUND </h1>");
            }
            session.removeAttribute("filteredByCartTypeProducts ");
        %>
    </div>
</div>




<button id="showBtn" style="display: none">Open Modal</button>

<div id="myModal" class="modal">
    <div class="modal-content">
        <h1>Item Added to Cart!</h1>
        <span class="close">&times;</span>
        <a href="load-cart-servlet"> Got To Checkout </a>
    </div>

</div>



<script>
    var modal = document.getElementById("myModal");
    var showModalBtn = document.getElementById("showBtn");
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
</body>
</html>
