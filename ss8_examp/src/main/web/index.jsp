<%--
  Created by IntelliJ IDEA.
  User: son
  Date: 11/11/2021
  Time: 14:27
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

    <title>Pixie - Home Page</title>
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
                <li class="nav-item active">
                    <a class="nav-link" href="home">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="homeproducts">Products</a>
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
<!-- Banner Starts Here -->
<div class="banner">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="caption">
                    <h2>Ecommerce HTML Template</h2>
                    <div class="line-dec"></div>
                    <p>Pixie HTML Template can be converted into your desired CMS theme. Total <strong>5 pages</strong> included. You can use this Bootstrap v4.1.3 layout for any CMS.
                        <br><br>Please tell your friends about <a rel="nofollow" href="https://www.facebook.com/tooplate/">Tooplate</a> free template site. Thank you. Photo credit goes to <a rel="nofollow" href="https://www.pexels.com">Pexels website</a>.</p>
                    <div class="main-button">
                        <a href="#">Order Now!</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Banner Ends Here -->

<!-- Featured Starts Here -->
<div class="featured-items">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="section-heading">
                    <div class="line-dec"></div>
                    <h1>Featured Items</h1>
                </div>
            </div>
            <div class="col-md-12">
                <div class="owl-carousel owl-theme">
                <c:forEach var="p" items="${products}">
                    <a href="detail?id=${p.id}&cid=${p.categoryid}">
                        <div class="featured-item">
                            <img style="width: 220px;height: 251px" src="img/${p.image}" alt="">
                            <h4>${p.name}</h4>
                            <h6>$${p.price}</h6>
                        </div>
                    </a>
                </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Featred Ends Here -->

</body>
</html>
