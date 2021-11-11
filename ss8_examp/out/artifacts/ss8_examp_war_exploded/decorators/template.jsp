<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/10/2021
  Time: 6:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<html>
<head>
    <title><decorator:title/></title>
    <jsp:include page="head.jsp" />
    <decorator:head />
</head>
<body>
<decorator:body />
<jsp:include page="footer.jsp" />
<jsp:include page="jsdefault.jsp" />
</body>
</html>
