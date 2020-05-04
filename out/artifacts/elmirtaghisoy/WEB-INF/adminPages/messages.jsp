<%@ page import="et.model.Message" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 01.02.2020
  Time: 0:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Message> messageList = (List<Message>) request.getAttribute("messageList");
%>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Ad / Soyad</th>
            <th scope="col">Email</th>
            <th scope="col">Telefon</th>
            <th scope="col">Tarix</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Message message : messageList) {
        %>
        <tr>
            <th scope="row">1</th>
            <td>
                <%=message.getUserName()%>
            </td>
            <td>
                <%=message.getEmail()%>
            </td>
            <td>
                <%=message.getPhone()%>
            </td>
            <td>
                <%=message.getDate()%>
            </td>
            <td>
                <a href="">
                    <button class="btn btn-warning">
                        Cavabla
                    </button>
                </a>
            </td>
            <td>
                <a href="">
                    <button class="btn btn-danger">
                        Sil
                    </button>
                </a>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
