<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

  <link rel="stylesheet" href="css/global.css">
  <link rel="stylesheet" href="css/index2.css">

  <title>Home</title>
</head>
<body>

  <div class="deal-banner">
    <div class="banner-info">
      <span class="info"><strong>Save for Easter with 30% off on orders $75+ with code ChattParts</strong></span>
      <span class="fine-print"><em>*Restrictions apply. Ends 3/31</em></span>
    </div>
  </div>

  <div class="content-container">
  <script id="replace_with_navbar" src="nav.js"></script>



  <div class="introduction">
  <h1>Welcome</h1>
    <p>Welcome to AutoPlace, your premier destination for all your automotive part needs. Whether you're a do-it-yourself enthusiast or a professional mechanic, we offer a wide range of high-quality auto parts to keep your vehicle running smoothly.

      Our extensive inventory covers everything from engine components and brakes to lighting and suspension. We source our products from trusted manufacturers, ensuring that you receive reliable, long-lasting parts at competitive prices.

      At AutoPlace, customer satisfaction is our top priority. Our knowledgeable staff is here to assist you in finding the right parts for your vehicle and provide expert advice on installation and maintenance.

      Browse our online catalog or visit our store today to find the perfect parts for your automotive needs. Thank you for choosing AutoPlace – your trusted partner in auto parts.</p>
  </div>

  <div class="topCat-container">
    <h2>Top Categories</h2>
    <div class="top--cat">
      <figure class="frame">
        <a href="categoryBrakes.jsp"><img src="product-images/BrakePad/brake_pad.jpg" alt="picture of air filter"></a>
        <figcaption class="pic-text">Brakes</figcaption>
      </figure>
      <figure class="frame">
        <a href="categoryHeatingCoolingAC.jsp"><img src="product-images/Radiator/radiator.jpg" alt="picture of antifreeze and coolant"></a>
        <figcaption class="pic-text">Heating, Cooling, & AC</figcaption>
      </figure>
      <figure class="frame">
        <a href="categoryDrivetrain.jsp"><img src="product-images/CVAxle/cv_axle.jpg" alt="picture of an alternator"></a>
        <figcaption class="pic-text">Drivetrain</figcaption>
      </figure>
    </div>
  </div>


  <div class="deal-container">
    <h2>Deals</h2>
    <div class="deal-links">
      <figure class="deal-info">
        <a href="load-product-servlet?ProductType=Wiper"><img src="dealPhotos/deals-wiperblades.jpeg" alt="picture of wiper blades"></a>
      </figure>
      <figure class="deal-info">
        <a href="load-product-servlet?ProductType=Wiper"><img src="dealPhotos/deals-motorOil.jpg" alt="picture of motor oil"></a>
      </figure>
      <figure class="deal-info">
        <a href="load-product-servlet?ProductType=Wiper"><img src="dealPhotos/deals-daycoBelt.jpeg" alt="picture of a serpentine belt"></a>
      </figure>
      <figure class="deal-info">
        <a href="load-product-servlet?ProductType=Wiper"><img src="dealPhotos/deals-airFilters.jpeg" alt="picture of an air filter"></a>
      </figure>
      <figure class="deal-info">
        <a href="load-product-servlet?ProductType=Wiper"><img src="dealPhotos/deals-antifreeze.jpeg" alt="picture of an antifreeze"></a>
      </figure>
      <figure class="deal-info">
        <a href="load-product-servlet?ProductType=Wiper"><img src="dealPhotos/deals-headlightbulb.jpeg" alt="picture of headlight bulbs"></a>
      </figure>
    </div>
  </div>

  <div class="carousel-container">
    <h2>Best Selling Brands</h2>
  <div class="carousel">
    <button id="prev-btn" class="prev-btn"></button>
        <div id="item-list" class="item-list">
          <img class="item" src="brandLogos/logo-valvoline.jpg" alt="picture of valvoline logo"/>
          <img class="item" src="brandLogos/logo-prestone.jpg" alt="picture of prestone logo"/>
          <img class="item" src="brandLogos/logo-moog.jpg" alt="picture of moog logo"/>
          <img class="item" src="brandLogos/logo-KandN.jpg" alt="picture of K&N logo"/>
          <img class="item" src="brandLogos/logo-fram.jpg" alt="picture of fram logo"/>
          <img class="item" src="brandLogos/logo-dorman.jpg" alt="picture of dorman logo"/>
          <img class="item" src="brandLogos/logo-dayco.jpg" alt="picture of dayco logo"/>
          <img class="item" src="brandLogos/logo-carquest.jpg" alt="picture of carquest logo"/>
        </div>


        <button id="next-btn" class="next-btn"></button>
      </div>
    </div>

  <!-- scroll button -->
  <a href="#" class="scrollTop" title="scroll"></a>

<div class="signup-container">
  <div class="signup">
    <p>Want more great deals?<br>Sign up today to receive special deals exclusively for members.</p>
    <a href="createAccount.jsp">Sign Up</a>
  </div>
</div>
  </div>

  <script id="replace_with_footer" src="Padfeet.js"> </script>
  <script src="indexScript.js"></script>


</body>

</html>
