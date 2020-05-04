<%@ page import="et.model.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="et.model.MFiles" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 23.01.2020
  Time: 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Post info = (Post) request.getAttribute("info");
    List<MFiles> files = (List<MFiles>) request.getAttribute("files");
%>
<!--Content-->
<div class="container about-wrapper">
    <div class="row">
        <div class="col-12">
            <div class="row">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Haqqımda</span>
                    </div>
                    <textarea id="about" style="height: 258px;font-size: 25px" class="form-control"
                              aria-label="With textarea"><%=info.getContext()%></textarea>
                </div>
            </div>
            <div class="row">
                <a href="javascript: updateAbout()">
                    <button type="button" class="btn btn-success mySaveBtn">Yadda Saxla</button>
                </a>
            </div>
            <div class="row">
                <div class="accordion myFileAccordion" id="accordionExample">
                    <div class="card">
                        <div class="card-header" id="headingOne">
                            <h2 class="mb-0">
                                <button class="btn btn-link" type="button" data-toggle="collapse"
                                        data-target="#collapseOne"
                                        aria-expanded="true" aria-controls="collapseOne">
                                    Əsas Fayllar
                                </button>
                            </h2>
                        </div>
                        <div id="collapseOne" class="collapse" aria-labelledby="headingOne"
                             data-parent="#accordionExample">
                            <div class="card-body">
                                <div class="row">
                                    <%for (MFiles file : files) {%>
                                    <div class="col-3">
                                        <div class="row">
                                            <div class="overlayImgBox">
                                                <img height="200" width="200"
                                                     src="<%=file.getFilePath()%>" alt="..."
                                                     class="img-thumbnail myImg overlayImage">
                                                <div class="myOverlay">
                                                    <div class="overlayDiv">
                                                        <h6>Şəkil - 1</h6>
                                                        <a href="javascript: getFileById('<%=file.getId()%>','upd')">
                                                            <button type="button" class="btn btn-warning"
                                                                    data-toggle="modal" data-target="#exampleModal">
                                                                Dəyiş
                                                            </button>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <%}%>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--Content-->

<!--Modal-->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div id="updateFileModalBody"></div>
        </div>
    </div>
</div>
<!--Modal-->