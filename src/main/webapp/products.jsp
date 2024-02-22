<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import = "java.util.ArrayList"%>
<%@page import = "Business.Product"%>
<%@ page import="org.hsqldb.Session" %>
<%@ page import="com.sun.source.tree.WhileLoopTree" %>


<html>
<head>

    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/products.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <title>Products</title>

</head>

<body>

<script id="replace_with_navbar" src="nav.js"></script>

<h1 class="title">Products</h1>

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
            <a class="ft-modal-close" href="productCategories.jsp">Keep Shopping</a>
            <a href="load-cart-servlet">Go to Cart</a>
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
            out.print("<form id='addToCartForm' onSubmit='return addItemToCart()' action='add-product-to-cart-servlet'>");

            out.print("<input type='hidden' id='ProductID' name='ProductID' value='" + product.getProductID() + "'>");
            out.print("<hr>");
            out.print("<label for='orderQuantity' id='orderQuantity'>Quantity</label>");
            out.print("<input type='number' id='OrderQuantity' name='OrderQuantity' min='1' max='100' />");

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
