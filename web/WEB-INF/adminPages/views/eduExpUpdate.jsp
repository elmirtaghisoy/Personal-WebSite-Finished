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
    <div style="margin: 0 !important;" class="input-group mb-3">
        <div class="input-group mb-3">
            <input id="updYears" placeholder="Tarix" type="text" class="form-control"
                   aria-label="Sizing example input"
                   aria-describedby="inputGroup-sizing-default" value="<%=eduExp.getDate()%>">
        </div>
        <div class="input-group mb-3">
            <input id="updPlace" placeholder="Müəsisə" type="text" class="form-control"
                   aria-label="Sizing example input"
                   aria-describedby="inputGroup-sizing-default" value="<%=eduExp.getPlace()%>">
        </div>
        <div class="input-group mb-3">
            <input id="updProfession" placeholder="İxtisas" type="text" class="form-control"
                   aria-label="Sizing example input"
                   aria-describedby="inputGroup-sizing-default" value="<%=eduExp.getProfession()%>">
        </div>
        <div class="input-group mb-3">
            <textarea placeholder="Məlumat" class="form-control" id="updAboutEduExpTxt"
                      rows="3"><%=eduExp.getAbout()%></textarea>
        </div>
        <div class="input-group mb-3">
            <input id="updQueue" placeholder="Sıra" type="text" class="form-control"
                   aria-label="Sizing example input"
                   aria-describedby="inputGroup-sizing-default" value="<%=eduExp.getQueue()%>">
        </div>
    </div>
</div>
<div class="modal-footer">
    <a href="javascript: updateEduExp(<%=eduExp.getId()%>)">
        <button type="button" class="btn btn-primary">Yadda Saxla</button>
    </a>
</div>