<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import = "java.util.ArrayList"%>
<%@page import = "Business.Product"%>
<%@page import = "Business.Cart"%>
<%@page import = "Business.PartOrder"%>

<html>
<head>

    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/cart.css">

  
    <title>Title</title>
</head>
<body>

<script id="replace_with_navbar" src="nav.js"></script>

<div>
    <%
        Cart cart = (Cart) session.getAttribute("UserCart");

        int index = 0;
        double totalCost = 0.0;
        double tax = 0.0;
        double taxRate = .04;

        double totalCostPlusTax = 0.0;
    %>

</div>

<script type="text/javascript">
    function removeFromCart(){
        return true;
    }
</script>


<div class="small-container">

<table>
  <tr>
    <th>Product</th>
    <th>Quantity</th>
    <th>Subtotal</th>
  </tr>

    <%
        if (cart.getPartOrdersInCartArrayList().isEmpty()){
            out.print("<h1> CART IS EMPTY </h1>");

        } else {

            for (PartOrder partOrder : cart.getPartOrdersInCartArrayList()) {
                Product product = partOrder.getPart();

                out.print("<tr>");
                out.print("<td>");
                out.print("<div class='cart-info'>");
                out.print("<div>");
                out.print("<p>" + product.getBrand() + " " + product.getName() + " " + product.getProductType() + "</p>");
                out.print("<small> Price: " + "$" + product.getPrice() + "</small>");

                out.print("<form id='addToCartForm' onSubmit='return removeFromCart()' action='remove-product-from-cart-servlet'>");
                out.print("<input type='hidden' id='IndexValue' name='IndexValue' value='" + index + "'>");
                out.print("<input type='submit' value = 'Remove'>");
                out.print("</form>");

                out.print("</div>");
                out.print("</div>");
                out.print("</td>");
                out.print("<td>" + partOrder.getQuantity() + "</td>");

                out.print("<td>" + "$" + partOrder.getTotalOrderPrice() + "</td>");
                out.print("</tr>");


                totalCost += partOrder.getTotalOrderPrice();
                index += 1;
            }

            tax = totalCost * taxRate;
            totalCostPlusTax = totalCost + tax;
        }
    %>
</table>

  <div class="total-price">

    <table>
      <tr>
        <td>Subtotal</td>
        <td> $<%=String.format("%,.2f", totalCost)%> </td>
      </tr>
      <tr>
        <td>Tax</td>
        <td>$<%=String.format("%,.2f", tax)%></td>
      </tr>
      <tr>
        <td>Total</td>
        <td>$<%=String.format("%,.2f", totalCostPlusTax)%></td>
      </tr>
    </table>
  </div>
</div>

</body>
</html>
