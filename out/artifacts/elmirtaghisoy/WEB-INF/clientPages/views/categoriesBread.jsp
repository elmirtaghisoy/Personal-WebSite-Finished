<%@ page import="et.model.Categorie" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 03.02.2020
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<li class="breadcrumb-item">
    <a href="javascript: allPosts()">
        Ümumi
    </a>
</li>
<%
    List<Categorie> categories = (List<Categorie>) request.getAttribute("categories");
    for (Categorie cat : categories) {%>
<li class="breadcrumb-item">
    <a href="javascript: getPostsByCatId('<%=cat.getId()%>','1')">
        <%=cat.getCategoryName()%>
    </a>
</li>
<%}%>
