<%--
  Created by IntelliJ IDEA.
  User: son
  Date: 11/11/2021
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<html>
<head>
    <title><decorator:title/></title>
    <jsp:include page="homehead.jsp" />
    <decorator:head />
</head>
<body>
<decorator:body />
<jsp:include page="homefooter.jsp" />
<jsp:include page="homejs.jsp" />
</body>
</html>
