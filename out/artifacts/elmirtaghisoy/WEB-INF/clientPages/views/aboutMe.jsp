<%@ page import="et.model.Post" %>
<%@ page import="et.model.MFiles" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 30.01.2020
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Post info = (Post) request.getAttribute("info");
    List<MFiles> files = (List<MFiles>) request.getAttribute("files");
%>
<div class="container">
    <div class="arlo_title_holder">
        <h3>Haqqımda</h3>
    </div>
    <div class="about_inner">
        <div class="leftbox wow zoomIn" data-wow-duration="0.8s">
            <div class="about_image_wrap parallax" data-relative-input="true">
                <div class="image layer" data-depth="0.1">
                    <img src="<%=files.get(0).getFilePath()%>" alt=""/>
                    <div class="inner" data-img-url="<%=files.get(0).getFilePath()%>"></div>
                </div>
                <div class="border layer" data-depth="0.2">
                    <img src="<%=files.get(0).getFilePath()%>" alt=""/>
                    <div class="inner"></div>
                </div>
            </div>
        </div>
        <div class="rightbox wow zoomIn" data-wow-duration="0.8s" data-wow-delay="0.2s">
            <div class="about_title">
                <h3>Elmir Tağısoy - <span class="arlo_tm_animation_text_word"></span>
                </h3>
            </div>
            <div class="text">
                <p><%=info.getContext()%>
                </p>
            </div>
            <div class="buttons">
                <ul>
                    <li>
                        <a href="#">
                            <form method="post" action="dc">
                                <input type="hidden" name="cv"
                                       value="E:\elmirtaghisoy\out\artifacts\elmirtaghisoy_war_exploded\cv\Elmir Taghisoy CV.jpg">
                                <button style="background: none;border: none;" type="submit">
                                    <span style="color: white">CV Yüklə</span>
                                </button>
                            </form>
                        </a>
                    </li>
                    <li><a style="height: 46px" href="#contact" class="menu1"><span>SMS Göndər</span></a></li>
                </ul>
            </div>
        </div>
    </div>
</div>