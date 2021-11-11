<%--
  Created by IntelliJ IDEA.
  User: son
  Date: 11/11/2021
  Time: 16:57
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

    <title>Pixie - Product Page</title>
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
<!-- Items Starts Here -->
<div class="featured-page">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-sm-12">
                <div class="section-heading">
                    <div class="line-dec"></div>
                    <h1>Featured Items</h1>
                </div>
            </div>
            <div class="col-md-8 col-sm-12">
                <div id="filters" class="button-group">
                    <button onclick="window.location.href='homeproducts';" class="btn btn-primary">All Products</button>
                    <c:forEach var="c" items="${categorys}">
                    <button onclick="window.location.href='homeproductscate?id=${c.id}';" class="btn btn-primary">${c.name}</button>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="featured container no-gutter">

    <div class="row posts">
        <c:forEach var="p" items="${productscate}">
            <div id="1" class="item new col-md-3">
            <a href="detail?id=${p.id}&cid=${p.categoryid}">
                <div class="featured-item">
                    <img style="width: 220px;height: 251px" src="img/${p.image}" alt="">
                    <h4>${p.name}</h4>
                    <h6>$${p.price}</h6>
                </div>
            </a>
        </div>
        </c:forEach>
    </div>
</div>

<div class="page-navigation">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <ul>
                    <li class="current-page"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#"><i class="fa fa-angle-right"></i></a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- Featred Page Ends Here -->

</body>
</html>
