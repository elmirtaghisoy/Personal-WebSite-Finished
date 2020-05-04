<%@ page import="et.model.Post" %>
<%@ page import="et.model.MFiles" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 24.01.2020
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Post post = (Post) request.getAttribute("post");%>
<div style="padding: 5%" class="col-12">
    <form action="uc" method="post" enctype="multipart/form-data">
        <input type="hidden" name="update">
        <input type="hidden" name="postId" value="<%=post.getId()%>">
        <div class="row">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Heading</span>
                </div>
                <input name="heading" type="text" class="form-control" aria-label="Default"
                       aria-describedby="inputGroup-sizing-default" value="<%=post.getHeading()%>">
            </div>
        </div>
        <div class="row">
            <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text">Context</span>
                </div>
                <textarea name="context" style="height: 258px;font-size: 25px" class="form-control"
                          aria-label="With textarea"><%=post.getContext()%></textarea>
            </div>
        </div>
        <div style="margin-top: 2%" class="row">
            <div class="input-group mb-3">
                <select class="custom-select" id="inputGroupSelect03"
                        aria-label="Example select with button addon">
                    <option value="<%=post.getCategorie().getId()%>" selected><%=post.getCategorie().getCategoryName()%>
                        >
                    </option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>
            </div>
        </div>
        <div class="row">
            <button type="submit" class="btn btn-success mySaveBtn">Yadda Saxla</button>
        </div>
    </form>


    <div style="margin-top: 7%" class="card-header" id="headingOne">
        <h2 class="mb-0">
            <button class="btn btn-link" type="button" data-toggle="collapse"
                    data-target="#collapseOne"
                    aria-expanded="true" aria-controls="collapseOne">
                Fayllar
            </button>
        </h2>
    </div>
    <div class="row">
        <div id="collapseOne" class="collapse" aria-labelledby="headingOne"
             data-parent="#accordionExample">
            <div class="card-body">
                <div class="row">
                    <%
                        int i = 1;
                        for (MFiles files : post.getFiles()) {
                            i++;
                            if (files.getFileType() == 1) {
                    %>
                    <div class="col-3">
                        <div class="row">
                            <div class="overlayImgBox">
                                <img height="200" width="200" src="<%=files.getFilePath()%>" alt="..."
                                     class="img-thumbnail myImg overlayImage">
                                <div class="myOverlay">
                                    <div class="overlayDiv">
                                        <h6>Şəkil - 1</h6>
                                        <a href="javascript: getFileById('<%=files.getId()%>','upd')">
                                            <button type="button" class="btn btn-warning"
                                                    data-toggle="modal" data-id="1" data-target="#editFileModal">
                                                Dəyiş
                                            </button>
                                        </a>
                                        <a href="javascript: getFileById('<%=files.getId()%>','del')">
                                            <button type="button" class="btn btn-danger"
                                                    data-toggle="modal" data-target="#deleteFileModal">
                                                Sil
                                            </button>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <% } else { %>
                    <div class="col-3">
                        <div class="overlayImgBox">
                            <div class="embed-responsive embed-responsive-16by9">
                                <video controls="true" class="embed-responsive-item">
                                    <source src="<%=files.getFilePath()%>" type="video/mp4"/>
                                </video>
                            </div>
                            <div class="myOverlay1">
                                <div class="overlayDiv">
                                    <h6>Şəkil - 1</h6>
                                    <a href="javascript: getFileById('<%=files.getId()%>','upd')">
                                        <button type="button" class="btn btn-warning"
                                                data-toggle="modal" data-id="1" data-target="#editFileModal">
                                            Dəyiş
                                        </button>
                                    </a>
                                    <a href="javascript: getFileById('<%=files.getId()%>','del')">
                                        <button type="button" class="btn btn-danger"
                                                data-toggle="modal" data-target="#deleteFileModal">
                                            Sil
                                        </button>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <% }
                        if (i % 5 == 0) {%>
                </div>
                <div class="row">
                    <%
                            }
                        }
                    %>
                </div>
                <div style="margin-top: 1rem" class="row">
                    <form style="margin-left: auto; margin-right: auto;" action="uc" method="post"
                          enctype="multipart/form-data">
                        <input type="hidden" name="addFile">
                        <input type="hidden" name="postId" value="<%=post.getId()%>">
                        <div class="input-group mb-3">
                            <div class="custom-file">
                                <input type="file" name="fileName[]" multiple=" " class="custom-file-input"
                                       id="files"
                                       aria-describedby="inputGroupFileAddon01">
                                <label class="custom-file-label" for="files">Faylı Seçin</label>
                            </div>
                        </div>
                        <button style="text-align: center" type="submit" class="btn btn-success">Yadda Saxla</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
