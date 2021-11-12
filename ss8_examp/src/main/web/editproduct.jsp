<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/8/2021
  Time: 5:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>EditProduct</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body id="page-top">
<div id="wrapper">
    <!-- Content Wrapper -->
    <jsp:include page="decorators/sidebar.jsp" />
    <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->

        <div id="content" style="width: 100%">
            <jsp:include page="decorators/topbar.jsp" />
            <!-- Begin Page Content -->
            <div class="container-fluid">

                <div class="container">
                    <div class="row">
                        <div class="col-6">
                            <form method="post" action="adminupdateproduct" enctype="multipart/form-data">
                                <div class="mb-3">
                                    <label for="name" class="form-label">Name</label>
                                    <input type="text" class="form-control" name="name" id="name" value="<c:out value='${productes.name}' />">
                                </div>
                                <div class="mb-3">
                                    <label for="price" class="form-label">Price</label>
                                    <input type="text" class="form-control" name="price" id="price" value="<c:out value='${productes.price}' />">
                                </div>
                                <div class="mb-3">
                                    <label for="quantity" class="form-label">Quantity</label>
                                    <input type="text" class="form-control" name="quantity" id="quantity" value="<c:out value='${productes.quantity}' />">
                                </div>
                                <div class="mb-3">
                                    <label for="image" class="form-label">Image</label>
                                    <input type="file" class="form-control" name="image" id="image">
                                </div>
                                <div class="col-md-12">
                                    <img src="img/${productes.image}" style="width: 100px; height: 70px">
                                </div>
                                <div class="mb-3">
                                    <label>Category</label>
                                    <select name="category" class="form-control">
                                        <c:forEach var="p" items="${categories}">
                                            <option
                                                    value="${p.id}"${p.id==productes.categoryid ?'selected':''}> ${p.name}
                                               <%-- value="{{$item -> id}}"{{$hang_sx_selected->id==$item->id?'selected':''}}>{{$item->ten_hangsx}}--%>
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <input type="submit" class="btn btn-primary" value="Save">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

