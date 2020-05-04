<%@ page import="et.model.Social" %>
<%@ page import="java.util.List" %>
<%@ page import="et.model.Post" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 23.01.2020
  Time: 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Post> postList = (List<Post>) request.getAttribute("postList");
    int postType = (int) request.getAttribute("postType");
%>
<!--Content-->
<div class="container">
    <div class="row">
        <a style="margin-left: auto;margin-right: auto" href="javascript: getCategoriesForAddPost()">
            <button style="width: 200px; margin-top: 2%" class="btn btn-success"
                    data-toggle="modal" data-target="#addSocialPostModal">Əlavə et
            </button>
        </a>
    </div>
    <div class="row">
        <%
            int i = 0;
            for (Post post : postList) {
                i++;
        %>
        <div style="padding: 2rem" class="col-4">
            <div class="card">
                <%
                    if (post.getFiles().size() != 0) {
                        if (post.getFiles().get(0).getFileType() == 2) {%>
                <h4 style="border-bottom: solid;border-width: thin;border-color: #d9e2eb;text-align: center!important;">
                    VideoPost</h4>
                <%} else {%>
                <img class="card-img-top" src="<%=post.getFiles().get(0).getFilePath()%>"
                     alt="<%=post.getFiles().get(0).getFilePath()%>">
                <%
                        }
                    }
                %>
                <div class="card-body">
                    <h5 class="card-title"><%=post.getHeading()%>
                    </h5>
                    <p class="card-text"><%=post.getContext()%>
                    </p>
                </div>
                <div class="card-footer">
                    <a href="javascript: getPostById('<%=postType%>','<%=post.getId()%>','upd')">
                        <button type="button" class="btn btn-warning" data-toggle="modal"
                                data-target=".bd-example-modal-xl">Dəyiş
                        </button>
                    </a>
                    <a href="javascript: getPostById('<%=postType%>','<%=post.getId()%>','del')">
                        <button data-toggle="modal" data-target="#deleteSocialPostModal" type="button"
                                class="btn btn-danger">Sil
                        </button>
                    </a>
                </div>
            </div>
        </div>
        <%if (i % 4 == 0) {%>
    </div>
    <div class="row">
        <%
                }
            }
        %>
    </div>
</div>
<!--Content-->


<!--Add Modal-->
<div class="modal fade" id="addSocialPostModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="uc" method="post" enctype="multipart/form-data">
                <input type="hidden" name="add">
                <input type="hidden" name="postType" value="<%=postType%>">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div id="addPostBody"></div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Yadda Saxla</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!--Add Modal-->

<!--Delete Modal-->
<div class="modal fade" id="deleteSocialPostModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div id="delPostModalBody"></div>
        </div>
    </div>
</div>
<!--Delete Modal-->

<!--Edit Modal-->
<div class="modal fade bd-example-modal-xl" tabindex="-1" role="dialog" aria-labelledby="myExtraLargeModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-xl" role="document">
        <div class="modal-content">
            <div class="accordion" id="accordionExample">
                <div class="card">
                    <div id="updPostModalBody"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--Edit Modal-->


<!--Delete File Modal-->
<div class="modal fade" id="deleteFileModal" tabindex="-1" role="dialog" aria-labelledby="m1"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div id="deleteFileModalBody"></div>
        </div>
    </div>
</div>
<!--Delete File Modal-->

<!--Edit File Modal-->
<div class="modal fade" id="editFileModal" tabindex="-1" role="dialog" aria-labelledby="m2"
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
<!--Edit File Modal-->
