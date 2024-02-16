<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import = "java.util.ArrayList"%>
<%@page import = "Business.Product"%>
<%@ page import="org.hsqldb.Session" %>
<%@ page import="com.sun.source.tree.WhileLoopTree" %>


<html>
<head>

    <link rel="stylesheet" href="css/global.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <title>Products</title>
    <style>
        .grid-container {
            display: grid;
            grid-template-columns: auto auto auto;
            background-color: #2196F3;
            padding: 10px;
        }
        .grid-item {
            background-color: rgba(255, 255, 255, 0.8);
            border: 1px solid rgba(0, 0, 0, 0.8);
            padding: 20px;
            font-size: 30px;
            text-align: center;
        }

        .item-added-popup-container {
            display: none;
        }
        .item-added-popup {

        }

        .ft-modal {
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            opacity: 0;
            z-index: 9999;
            overflow: auto;
            position: fixed;
            visibility: hidden;
            margin-top: -250px;
            background: rgba(0,0,0,.8);

            transition: all .3s ease-in-out;
            -moz-transition: all .3s ease-in-out;
            -webkit-transition: all .3s ease-in-out;
        }

        .ft-modal:target {
            opacity: 1;
            margin-top: 0px;
            visibility: visible;
        }

        .ft-modal-content {
            width: 70%;
            padding: 25px;
            background: #FFF;
            max-width: 600px;
            margin: 70px auto;
            position: relative;
            border-radius: 8px;
            box-shadow: 0 0 6px rgba(0, 0, 0, 0.2);
        }

        /*
        .ft-modal-close {
            top: 9px;
            right: 12px;
            float: right;
            position: absolute;
        }
        */


    </style>

</head>

<body>



<script id="replace_with_navbar" src="nav.js"></script>

<!-- Start Modal -->
<div class="ft-modal" id="ft-demo-modal">
    <a href="#ft-demo-modal" id="openPopup" style="visibility: hidden"></a>
    <div class="ft-modal-content">
        <div class="ft-modal-header">
            <div class="header">
                <h3>Item Added To Cart</h3>
            </div>
        </div>
        <div class="ft-modal-body">
            <h3>Thank you! Your item has been added to cart</h3>
        </div>
        <div class="ft-modal-footer">
            <a class="ft-modal-close" href="#">[&#10006;] Keep Shopping</a>
            <a href="load-cart-servlet"> Go to Cart</a>
        </div>
    </div>
</div>
<!-- End Modal -->

<!-- Link in page to show modal on click-->




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
            out.print("<input type='number' id='OrderQuantity' name='OrderQuantity' value='1' min='1' max='100' />");

            out.print("<input type='submit'/>");
            out.print("</form>");

            out.print("</div>");
        }
    %>

</div>

<script type="text/javascript">
function addItemToCart(){
    var popup = document.getElementById("openPopup");
    popup.click();
    return true;
}

</script>


</body>
</html>
