<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="css/global.css">

    <title>Part Categories</title>
    <style>

        #title {
            text-align: center;
        }
        /* grid layout */
        .partType {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            grid-gap: 20px;
            margin: 0 0 40px 0;
        }
    </style>
</head>

<body>
<script id="replace_with_navbar" src="nav.js"></script>

<h1 id="title">Part Categories</h1>

<div class="partType">
    <a href="load-product-servlet?ProductType=Air Filter"> Air Filter </a>
    <a href="load-product-servlet?ProductType=Antifreeze and Coolant"> Antifreeze and Coolant </a>
    <a href="load-product-servlet?ProductType=Alternator"> Alternator </a>
    <a href="load-product-servlet?ProductType=Battery"> Battery </a>
    <a href="load-product-servlet?ProductType=Engine Oil"> Engine Oil </a>
    <a href="load-product-servlet?ProductType=Front Brake Pads"> Front Brake Pads </a>
    <a href="load-product-servlet?ProductType=Headlight Bulb"> Headlight Bulb </a>
    <a href="load-product-servlet?ProductType=Mini Bulb"> Mini Bulb </a>
    <a href="load-product-servlet?ProductType=Rear Brake Pads"> Rear Brake Pads </a>
    <a href="load-product-servlet?ProductType=Spark Plug"> Spark Plug </a>
    <a href="load-product-servlet?ProductType=Wiper"> Wiper </a>
    <a href="load-product-servlet?ProductType=Headlight Bulb"> Headlight Bulb </a>
    <a href="load-product-servlet?ProductType=Headlight Bulb"> Headlight Bulb </a>

</div>

</body>
</html>
