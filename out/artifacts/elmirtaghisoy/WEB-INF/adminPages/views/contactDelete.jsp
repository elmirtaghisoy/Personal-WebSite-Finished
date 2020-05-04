<%@ page import="et.model.Social" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 23.01.2020
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Social con = (Social) request.getAttribute("contact");%>
<div class="modal-body">
    <h4><%=con.getSocName()%> silinsin ?</h4>
</div>
<div class="modal-footer">
    <a href="javascript: deleteSocial(<%=con.getId()%>)">
        <button type="button" class="btn btn-primary">Bəli</button>
    </a>
</div>