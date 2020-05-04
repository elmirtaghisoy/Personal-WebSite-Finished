<%@ page import="et.model.Categorie" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 02.02.2020
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Categorie> categories = (List<Categorie>) request.getAttribute("categories");%>
<div class="modal-body">
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">Heading</span>
        </div>
        <input type="text" name="heading" id="heading" class="form-control" aria-label="Default"
               aria-describedby="inputGroup-sizing-default">
    </div>
    <div class="input-group mb-3">
        <select name="catName" class="custom-select" aria-label="Example select with button addon">
            <%
                for (Categorie cat : categories) {
            %>
            <option value="<%=cat.getId()%>">
                <%=cat.getCategoryName()%>
            </option>
            <%}%>
        </select>
    </div>
    <div style="margin-bottom: 1rem !important;" class="input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">Context</span>
        </div>
        <textarea name="context" class="form-control" aria-label="With textarea"></textarea>
    </div>
    <div class="input-group mb-3">
        <div class="custom-file">
            <input type="file" name="fileName[]" multiple=" " class="custom-file-input" id="files"
                   aria-describedby="inputGroupFileAddon01">
            <label class="custom-file-label" for="files">Faylı Seçin</label>
        </div>
    </div>
</div>