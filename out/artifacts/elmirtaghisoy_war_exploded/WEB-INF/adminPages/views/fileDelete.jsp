<%@ page import="et.model.MFiles" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 28.01.2020
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% MFiles file = (MFiles) request.getAttribute("file");%>
<div class="modal-body">
    <img width="200" height="200" src="<%=file.getFilePath()%>">
    <h4>Faylı silinsin ?</h4>
</div>
<div class="modal-footer">
    <a href="javascript: deleteFile(<%=file.getId()%>)">
        <button type="button" class="btn btn-primary">Bəli</button>
    </a>
</div>