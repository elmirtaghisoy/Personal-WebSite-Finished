<%@ page import="et.model.Categorie" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 29.01.2020
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Categorie> categories = (List<Categorie>) request.getAttribute("categories");
%>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Kateqoriya</th>
            <th style="padding-top: 1.5%" scope="col"><input id="newCat" type="text"></th>
            <th scope="col">
                <a href="javascript: addCategorie()">
                    <button class="btn btn-warning">
                        Add
                    </button>
                </a>
            </th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Categorie cat : categories) {
        %>
        <tr>
            <th scope="row">1</th>
            <td>
                <input type="text" name="catName" id="cn-<%=cat.getId()%>" value="<%=cat.getCategoryName()%>">
            </td>
            <td>
                <a href="javascript: updateCategorie(<%=cat.getId()%>)">
                    <button class="btn btn-warning">
                        Save
                    </button>
                </a>
            </td>
            <td>
                <a href="javascript: deleteCategorie(<%=cat.getId()%>)">
                    <button class="btn btn-danger">
                        Del
                    </button>
                </a>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
