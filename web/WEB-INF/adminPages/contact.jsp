<%@ page import="et.model.Social" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 23.01.2020
  Time: 1:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Social> contactsList = (List<Social>) request.getAttribute("contactsList");%>
<!--Content-->
<div class="container-fluid">
    <div style="margin-bottom: 2rem" class="row">
        <button style="margin-left: auto;margin-right: auto;margin-top: 2rem;width: 20%" class="btn btn-success"
                data-toggle="modal" data-target="#addModal">Əlavə et
        </button>
    </div>
    <div class="container">
        <div class="row">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">Sıra</th>
                    <th scope="col">Sosial Şəbəkə</th>
                    <th scope="col">İstifadəçi adı</th>
                    <th scope="col">Link</th>
                    <th scope="col">Icon</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <%for (Social cn : contactsList) {%>
                <tr>
                    <th><%=cn.getPlace()%>
                    </th>
                    <td><%=cn.getSocName()%>
                    </td>
                    <td><%=cn.getAccName()%>
                    </td>
                    <td><%=cn.getLink()%>
                    </td>
                    <td><%=cn.getIcon()%>
                    </td>
                    <td>
                        <a href="javascript: getContactById('<%=cn.getId()%>','upd')">
                            <button type="button" data-toggle="modal" data-target="#editModal"
                                    class="btn btn-warning">Dəyiş
                            </button>
                        </a>
                    </td>
                    <td>
                        <a href="javascript: getContactById('<%=cn.getId()%>','del')">
                            <button type="button" data-toggle="modal" data-target="#deleteModal"
                                    class="btn btn-danger">Sil
                            </button>
                        </a>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!--Content-->

<!--Add Modal-->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="input-group mb-3">
                    <input id="socName" placeholder="Sosial Şəbəkə" type="text" class="form-control"
                           aria-label="Default">
                </div>
                <div class="input-group mb-3">
                    <input id="accName" placeholder="İstifadəçi Adı" type="text" class="form-control"
                           aria-label="Default">
                </div>
                <div class="input-group mb-3">
                    <input id="link" placeholder="Link" type="text" class="form-control" aria-label="Default">
                </div>
                <div class="input-group mb-3">
                    <input id="icon" placeholder="Icon" type="text" class="form-control" aria-label="Default">
                </div>
                <div class="input-group mb-3">
                    <input id="place" placeholder="Sıra" type="text" class="form-control" aria-label="Default">
                </div>
            </div>
            <div class="modal-footer">
                <a href="javascript: addContact()">
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
            <div id="updSocModalBody"></div>
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
            <div id="delSocModalBody"></div>
        </div>
    </div>
</div>
<!--Delete Modal-->
