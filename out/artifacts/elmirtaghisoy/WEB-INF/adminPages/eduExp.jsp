<%@ page import="java.util.List" %>
<%@ page import="et.model.EduExp" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 23.01.2020
  Time: 1:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<EduExp> eduExpList = (List<EduExp>) request.getAttribute("eduExpList");
    int type = (int) request.getAttribute("type");
%>
<!--Content-->
<div class="container about-wrapper">
    <div class="row">
        <%
            int i = 1;
            for (EduExp ee : eduExpList) {
                i++;
                if (i == 2) {
        %>
        <div style="margin-bottom: 3rem" class="col-4">
            <div class="card" style="width: 18rem; height: 100%;">
                <div class="card-body text-center">
                    <a href="#" style="transform: translate(0px, 160%);">
                        <button style="transform: translate(0px, 160%);" type="button" class="btn btn1 btn-success"
                                data-toggle="modal"
                                data-target="#addExpModal">
                            Əlavə et
                        </button>
                    </a>
                </div>
            </div>
        </div>
        <div style="margin-bottom: 3rem" class="col-4">
            <div class="card" style="width: 18rem;">
                <div class="card-body text-center">
                    <h5 class="card-title"><%=ee.getDate()%>
                    </h5>
                    <h5 class="card-title"><%=ee.getPlace()%>
                    </h5>
                    <h5 class="card-title"><%=ee.getProfession()%>
                    </h5>
                    <div class="btnBox">
                        <a href="javascript: getEduExpById('<%=type%>','<%=ee.getId()%>','upd')">
                            <button type="button" class="btn btn1 btn-warning" data-toggle="modal"
                                    data-target="#editModal">Dəyiş
                            </button>
                        </a>
                        <a href="javascript: getEduExpById('<%=type%>','<%=ee.getId()%>','del')">
                            <button type="button" class="btn btn1 btn-danger" data-toggle="modal"
                                    data-target="#deleteModal">Sil
                            </button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <%} else {%>
        <div style="margin-bottom: 3rem" class="col-4">
            <div class="card" style="width: 18rem;">
                <div class="card-body text-center">
                    <h5 class="card-title"><%=ee.getDate()%>
                    </h5>
                    <h5 class="card-title"><%=ee.getPlace()%>
                    </h5>
                    <h5 class="card-title"><%=ee.getProfession()%>
                    </h5>
                    <div class="btnBox">
                        <a href="javascript: getEduExpById('<%=type%>','<%=ee.getId()%>','upd')">
                            <button type="button" class="btn btn1 btn-warning" data-toggle="modal"
                                    data-target="#editModal">Dəyiş
                            </button>
                        </a>
                        <a href="javascript: getEduExpById('<%=type%>','<%=ee.getId()%>','del')">
                            <button type="button" class="btn btn1 btn-danger" data-toggle="modal"
                                    data-target="#deleteModal">Sil
                            </button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <%
            }
            if (i % 3 == 0) {
        %>
    </div>
    <div class="row">
        <%
                }
            }
        %>
    </div>
</div>
<%--</div>--%>
<%--</div>--%>
<!--Content-->

<!--Add Modal-->
<div class="modal fade" id="addExpModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div style="margin: 0 !important;" class="input-group mb-3">
                    <div class="input-group mb-3">
                        <input id="years" placeholder="Tarix" type="text" class="form-control"
                               aria-label="Sizing example input"
                               aria-describedby="inputGroup-sizing-default">
                    </div>
                    <div class="input-group mb-3">
                        <input id="place" placeholder="Müəsisə" type="text" class="form-control"
                               aria-label="Sizing example input"
                               aria-describedby="inputGroup-sizing-default">
                    </div>
                    <div class="input-group mb-3">
                        <textarea placeholder="Məlumat" class="form-control" id="aboutEduExpTxt" rows="3"></textarea>
                    </div>
                    <div class="input-group mb-3">
                        <input id="profession" placeholder="İxtisas" type="text" class="form-control"
                               aria-label="Sizing example input"
                               aria-describedby="inputGroup-sizing-default">
                    </div>
                    <div class="input-group mb-3">
                        <input id="queue" placeholder="Sıra" type="text" class="form-control"
                               aria-label="Sizing example input"
                               aria-describedby="inputGroup-sizing-default">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <a href="javascript: addEduExp(<%=type%>)">
                    <button type="button" class="btn btn-primary">Əlavə et</button>
                </a>
            </div>
        </div>
    </div>
</div>
<!--Add Modal-->

<!--Edit Modal-->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div id="updEduExpModalBody"></div>
        </div>
    </div>
</div>
<!--Edit Modal-->

<!--Delete Modal-->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div id="delEduExpModalBody"></div>
        </div>
    </div>
</div>
<!--Delete Modal-->
