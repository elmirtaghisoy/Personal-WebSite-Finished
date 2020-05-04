<%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 30.01.2020
  Time: 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="arlo_tm_leftpart">
    <div class="inner">
        <div class="logo">
            <a class="dark" href="#"><img src="Resources/Client-Resources/img/logo/logo.png" alt=""/></a>
            <a class="light" href="#"><img src="Resources/Client-Resources/img/logo/light.png" alt=""/></a>
        </div>
        <div class="menu1 scrollable">
            <ul style="padding-bottom: 50%">
                <jsp:include page="WEB-INF/clientPages/static/navbar.jsp"></jsp:include>
            </ul>
        </div>
        <div class="bottom">
            <div class="social">
                <ul>
                    <jsp:include page="WEB-INF/clientPages/static/socialIcons.jsp"></jsp:include>
                </ul>
            </div>
        </div>
        <div class="resize">
            <a href="#"><span></span></a>
        </div>
    </div>
</div>
