<%@ page import="et.model.EduExp" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 24.01.2020
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% EduExp eduExp = (EduExp) request.getAttribute("eduExp");%>
<div class="modal-body">
    <h4><%=eduExp.getPlace()%> haqqinda melumat silinsin ?</h4>
</div>
<div class="modal-footer">
    <a href="javascript: deleteEduExp(<%=eduExp.getId()%>)">
        <button type="button" class="btn btn-primary">Yadda Saxla</button>
    </a>
</div>