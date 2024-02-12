<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import = "java.util.ArrayList"%>
<%@page import = "Business.Product"%>
<%@page import = "Business.Cart"%>
<%@page import = "Business.PartOrder"%>

<html>
<head>

    <link rel="stylesheet" href="css/global.css">
    <title>Title</title>
</head>
<body>

<script id="replace_with_navbar" src="nav.js"></script>

<div>
    <%
        Cart cart = (Cart) session.getAttribute("UserCart");

        int index = 0;
        for (PartOrder partOrder : cart.getPartOrdersInCartArrayList()){
            Product product = partOrder.getPart();

            out.print("<div>");
            out.print("<h3>" + product.getBrand() + " " + product.getName() + " " + product.getProductType() + "</h3>");
            out.print("<form id='addToCartForm' onSubmit='return removeFromCart()' action='remove-product-from-cart-servlet'>");

            out.print("<input type='hidden' id='IndexValue' name='IndexValue' value='" + index + "'>");
            out.print("<input type='submit' value = 'Remove'>");
            out.print("</form>");

            out.print("</div>");
            index += 1;
        }
    %>

</div>

<script type="text/javascript">
    function removeFromCart(){
        return true;
    }
</script>



</body>
</html>
