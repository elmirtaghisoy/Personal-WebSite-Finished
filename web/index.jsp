<%@ page import="et.model.LoginUser" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 21.01.2020
  Time: 5:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Elmir Taghisoy | Admin</title>
    <jsp:include page="WEB-INF/adminPages/static/headerLinks.jsp"></jsp:include>
</head>
<body>
<%
    LoginUser loginUser = (LoginUser) request.getSession(false).getAttribute("login");
    if (loginUser == null) {
        response.sendRedirect("login.jsp");
    }
%>
<jsp:include page="WEB-INF/adminPages/static/header.jsp"></jsp:include>
<div id="main-wrapper"></div>
<jsp:include page="WEB-INF/adminPages/static/footerLinks.jsp"></jsp:include>
</body>
</html>
