<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import = "java.util.ArrayList"%>
<%@page import = "Business.Product"%>
<%@ page import="org.hsqldb.Session" %>
<%@ page import="com.sun.source.tree.WhileLoopTree" %>


<html>
<head>

    <link rel="stylesheet" href="css/global.css">

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
    </style>

</head>

<body>
<script id="replace_with_navbar" src="nav.js"></script>

<div class="grid-container">
    <%
        ArrayList<Product> ProductsFilteredList = (ArrayList) session.getAttribute("ArrayOfFilteredProducts");
        for (Product product : ProductsFilteredList){
            out.print("<div class='grid-item'>");
            out.print("<h3>" + product.getBrand() + " " + product.getName() + " " + product.getProductType() + "</h3>");
            out.print("<h4>" + product.getDescription() + "</h4>");
            out.print("</div>");
        }
    %>

</div>
</body>
</html>
