<%--
  Created by IntelliJ IDEA.
  User: son
  Date: 12/11/2021
  Time: 00:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">

    <title>Pixie - Product Detail</title>
    <jsp:include page="decorators/homehead.jsp"/>
</head>
<body>
<jsp:include page="decorators/homeprehead.jsp"/>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
    <div class="container">
        <a class="navbar-brand" href="#"><img src="assets/images/header-logo.png" alt=""></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="home">Home</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="homeproducts">Products
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="about">About Us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact">Contact Us</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->
<!-- Single Starts Here -->
<div class="single-product">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="section-heading">
                    <div class="line-dec"></div>
                    <h1>Single Product</h1>
                </div>
            </div>
            <div class="col-md-6">
                <div class="product-slider">
                    <div id="slider" class="flexslider">
                        <ul class="slides">
                            <li>
                                <img src="img/${detail.image}" alt="">
                            </li>
                            <li>
                                <img src="assets/images/big-02.jpg" />
                            </li>
                            <li>
                                <img src="assets/images/big-03.jpg" />
                            </li>
                            <li>
                                <img src="assets/images/big-04.jpg" />
                            </li>
                            <!-- items mirrored twice, total of 12 -->
                        </ul>
                    </div>
                    <div id="carousel" class="flexslider">
                        <ul class="slides">
                            <li>
                                <img src="assets/images/thumb-01.jpg" />
                            </li>
                            <li>
                                <img src="assets/images/thumb-02.jpg" />
                            </li>
                            <li>
                                <img src="assets/images/thumb-03.jpg" />
                            </li>
                            <li>
                                <img src="assets/images/thumb-04.jpg" />
                            </li>
                            <!-- items mirrored twice, total of 12 -->
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="right-content">
                    <h4>${detail.name}</h4>
                    <h6>$${detail.price}</h6>
                    <p>${detail.description}</p>
                    <span>${detail.quantity} left on stock</span>
                    <form action="" method="get">
                        <label for="quantity">Quantity:</label>
                        <input name="quantity" type="quantity" class="quantity-text" id="quantity"
                               onfocus="if(this.value == '1') { this.value = ''; }"
                               onBlur="if(this.value == '') { this.value = '1';}"
                               value="1">
                        <input type="submit" class="button" value="Order Now!">
                    </form>
                    <div class="down-content">
                        <div class="categories">
                            <h6>Category: <span><a href="homeproductscate?id=${detail.category.id}">${detail.category.name}</a></span></h6>
                        </div>
                        <div class="share">
                            <h6>Share: <span><a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i class="fa fa-linkedin"></i></a><a href="#"><i class="fa fa-twitter"></i></a></span></h6>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Single Page Ends Here -->


<!-- Similar Starts Here -->
<div class="featured-items">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="section-heading">
                    <div class="line-dec"></div>
                    <h1>You May Also Like</h1>
                </div>
            </div>
            <div class="col-md-12">
                <div class="owl-carousel owl-theme">
                    <c:forEach var="s" items="${simdetail}">
                        <a href="detail?id=${s.id}&cid=${s.categoryid}">
                            <div class="featured-item">
                                <img style="width: 220px;height: 251px" src="img/${s.image}" alt="">
                                <h4>${s.name}</h4>
                                <h6>$${s.price}</h6>
                            </div>
                        </a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Similar Ends Here -->

</body>
</html>
