<%@ page import="et.model.MFiles" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 28.01.2020
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% MFiles file = (MFiles) request.getAttribute("file");%>
<form action="uc" method="post" enctype="multipart/form-data">
    <input type="hidden" name="updateFileById">
    <input type="hidden" name="fileId" value="<%=file.getId()%>">
    <div class="modal-body">
        <div class="input-group mb-3">
            <div class="custom-file">
                <input type="file" name="fileName" class="custom-file-input" id="inputGroupFile01"
                       aria-describedby="inputGroupFileAddon01">
                <label class="custom-file-label" for="inputGroupFile01">Faylı Seçin</label>
            </div>
        </div>
        <img height="200" width="200" src="<%=file.getFilePath()%>" class="rounded mx-auto d-block" alt="...">
    </div>
    <div class="modal-footer">
        <button type="submit" class="btn btn-primary">Yadda Saxla</button>
    </div>
</form>
