<%@ page import="et.model.Post" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 24.01.2020
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Post post = (Post) request.getAttribute("post");
%>
<div class="modal-body">
    <h4><%=post.getHeading()%> silinsin ?</h4>
</div>
<div class="modal-footer">
    <a href="javascript: deletePost(<%=post.getId()%>)">
        <button type="button" class="btn btn-primary">Bəli</button>
    </a>
</div>