<%@ page import="et.model.Social" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 23.01.2020
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Social con = (Social) request.getAttribute("contact");%>
<div class="modal-body">
    <div class="input-group mb-3">
        <input id="updSocName" placeholder="Sosial Şəbəkə" type="text" class="form-control" aria-label="Default"
               value="<%=con.getSocName()%>">
    </div>
    <div class="input-group mb-3">
        <input id="updAccName" placeholder="Profil adı" type="text" class="form-control" aria-label="Default"
               value="<%=con.getAccName()%>">
    </div>
    <div class="input-group mb-3">
        <input id="updLink" placeholder="Link" type="text" class="form-control" aria-label="Default"
               value="<%=con.getLink()%>">
    </div>
    <div class="input-group mb-3">
        <input id="updIcon" placeholder="Icon" type="text" class="form-control" aria-label="Default"
               value="<%=con.getIcon()%>">
    </div>
    <div class="input-group mb-3">
        <input id="updPlace" placeholder="Sıra" type="text" class="form-control" aria-label="Default"
               value="<%=con.getPlace()%>">
    </div>
</div>
<div class="modal-footer">
    <a href="javascript: updateSocial(<%=con.getId()%>)">
        <button type="button" class="btn btn-primary">Yadda Saxla</button>
    </a>
</div>