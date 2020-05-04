<%@ page import="et.model.EduExp" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 30.01.2020
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<EduExp> eduExpList = (List<EduExp>) request.getAttribute("eduExpList");
    int type = (int) request.getAttribute("type");
%>
<div class="container">
    <div class="arlo_title_holder">
        <h3>İş <span>Təcrübə</span></h3>
    </div>
    <div class="timeline_inner">
        <ul>
            <%
                double msc = 0.2;
                for (EduExp exp : eduExpList) {
                    msc += 0.2;
            %>
            <li class="wow zoomIn" data-wow-duration="<%=msc%>s">
                <div class="inner">
                    <div class="number">
                        <span><%=exp.getDate()%></span>
                    </div>
                    <div class="title">
                        <h3><%=exp.getPlace()%>
                        </h3>
                        <h3 style="color: #ff4b36"><%=exp.getProfession()%>
                        </h3>
                    </div>
                    <div class="read_more">
                        <a class="text-center" href="javascript: getEduExpById('<%=type%>','<%=exp.getId()%>','view')">
                            <button type="button" class="readMoreBtn" data-toggle="modal"
                                    data-target="#exampleModal">
                                Ətraflı
                            </button>
                        </a>
                    </div>
                </div>
            </li>
            <%}%>
        </ul>
    </div>
</div>