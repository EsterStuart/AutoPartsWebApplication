<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/productCategories.css">
    <link rel="stylesheet" href="css/padfoot.css">

    <title>Part Categories</title>
</head>

<body>
<script id="replace_with_navbar" src="nav.js"></script>

<h1 id="title">Part Categories</h1>

<div class="partType">
    <figure class="frame">
        <a href="load-product-servlet?ProductType=Air Filter"><img src="Photos/airFilters.jpg" alt="picture of air filter"></a>
        <figcaption class="pic-text">Air Filters</figcaption>
    </figure>
        <figure class="frame">
            <a href="load-product-servlet?ProductType=Antifreeze and Coolant"><img src="Photos/antifreeze.jpg" alt="picture of antifreeze and coolant"></a>
            <figcaption class="pic-text">Antifreeze and Coolant</figcaption>
        </figure>
            <figure class="frame">
                <a href="load-product-servlet?ProductType=Alternator"><img src="Photos/alternator.png" alt="picture of an alternator"></a>
                <figcaption class="pic-text">Alternator</figcaption>
            </figure>
                <figure class="frame">
                    <a href="load-product-servlet?ProductType=Battery"><img src="Photos/battery.png" alt="picture of a car battery"></a>
                    <figcaption class="pic-text">Batteries</figcaption>
                </figure>
            <figure class="frame">
                    <a href="load-product-servlet?ProductType=Engine Oil"><img src="Photos/engineOil.png" alt="picture of engine oil"></a>
                    <figcaption class="pic-text">Engine Oil</figcaption>
            </figure>
            <figure class="frame">
                    <a href="load-product-servlet?ProductType=Front Brake Pads"><img src="Photos/brakePads.png" alt="picture of brake pads"></a>
                    <figcaption class="pic-text">Front Brake Pads</figcaption>
            </figure>
            <figure class="frame">
                    <a href="load-product-servlet?ProductType=Headlight Bulb"><img src="Photos/headlightBulb.png" alt="picture of headlight bulbs"></a>
                    <figcaption class="pic-text">Headlight Bulb</figcaption>
            </figure>
            <figure class="frame">
                <a href="load-product-servlet?ProductType=Mini Bulb"><img src="Photos/miniBulbs.png" alt="Picture of mini bulbs"></a>
                <figcaption class="pic-text">Mini Bulbs</figcaption>
            </figure>
    <figure class="frame">
        <a href="load-product-servlet?ProductType=Rear Brake Pads"><img src="Photos/rearBrakes.png" alt="Picture of rear brake pads"></a>
        <figcaption class="pic-text">Rear Brake Pads</figcaption>
    </figure>
    <figure class="frame">
        <a href="load-product-servlet?ProductType=Spark Plug"><img src="Photos/sparkPlugs.png" alt="Picture of spark plugs"></a>
        <figcaption class="pic-text">Spark Plugs</figcaption>
    </figure>
    <figure class="frame">
        <a href="load-product-servlet?ProductType=Wiper"><img src="Photos/wiper.png" alt="Picture of wiper blade"></a>
        <figcaption class="pic-text">Windshield Wipers</figcaption>
    </figure>
</div>
<script id="add_the_feet" src="Padfeet.js"> </script>
</body>
</html>
