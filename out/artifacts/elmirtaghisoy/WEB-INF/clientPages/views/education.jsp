<%@ page import="et.model.EduExp" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 30.01.2020
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<EduExp> eduExpList = (List<EduExp>) request.getAttribute("eduExpList");
    int type = (int) request.getAttribute("type");
%>
<div class="container">
    <div class="arlo_title_holder">
        <h3><span>Təhsil</span></h3>
    </div>
    <div class="timeline_inner">
        <ul>
            <%
                double msc = 0.2;
                for (EduExp edu : eduExpList) {
                    msc += 0.2;
            %>
            <li class="wow zoomIn" data-wow-duration="<%=msc%>s">
                <div class="inner">
                    <div class="number">
                        <span><%=edu.getDate()%></span>
                    </div>
                    <div class="title">
                        <h3><%=edu.getPlace()%>
                        </h3>
                        <h3 style="color: #ff4b36"><%=edu.getProfession()%>
                        </h3>
                    </div>
                    <div class="read_more">
                        <a class="text-center" href="javascript: getEduExpById('<%=type%>','<%=edu.getId()%>','view')">
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