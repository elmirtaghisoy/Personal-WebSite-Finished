<%@ page import="et.model.EduExp" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 03.02.2020
  Time: 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% EduExp eduExp = (EduExp) request.getAttribute("eduExp");%>
<div class="modal-header">
    <h5 class="modal-title"><%=eduExp.getPlace()%> - İş fəaliyyəti</h5>
    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
</div>
<div class="modal-body">
    <%=eduExp.getAbout()%>
</div>