<%@ page import="et.model.Post" %>
<%@ page import="et.model.MFiles" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 31.01.2020
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Elmir Tağısoy | Proqramçı</title>
    <jsp:include page="/WEB-INF/clientPages/static/headerLinks.jsp"></jsp:include>
</head>
<body>
<% Post post = (Post) request.getAttribute("post");%>
<% List<Post> lastesPosts = (List<Post>) request.getAttribute("lastesPosts");%>
<!-- Preloader -->
<div class="arlo_tm_preloader">
    <div class="spinner_wrap">
        <div class="spinner"></div>
    </div>
</div>
<!-- Preloader -->

<!-- Main Wrapper -->
<div id="mainWrap" class="arlo_tm_all_wrap">
    <div class="wrapper_inner">

        <!-- Topbar -->
        <div class="arlo_tm_topbar">
            <div class="topbar_inner">
                <div class="container">
                    <div class="topbar_in">
                        <div class="logo">
                            <a href="#"><img src="Resources/Client-Resources/img/logo/mobile.png" alt=""/></a>
                        </div>
                        <div class="trigger">
                            <a href="#">
                                <span class="menu">Menu</span>
                                <span class="close">Close</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="dropdown">
                <div class="container">
                    <div class="dropdown_inner">
                        <ul>
                            <jsp:include page="/WEB-INF/clientPages/static/navbar2.jsp"></jsp:include>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- Topbar -->

        <!-- Left -->
        <div class="arlo_tm_leftpart">
            <div class="inner">
                <div class="logo">
                    <a class="dark" href="#"><img src="Resources/Client-Resources/img/logo/logo.png" alt=""/></a>
                    <a class="light" href="#"><img src="Resources/Client-Resources/img/logo/light.png" alt=""/></a>
                </div>
                <div class="menu scrollable">
                    <ul style="display: block;padding-top: 10%">
                        <jsp:include page="/WEB-INF/clientPages/static/navbar2.jsp"></jsp:include>
                    </ul>
                </div>
                <div class="bottom">
                    <div class="social">
                        <ul style="display: block;padding-top: 10%">
                            <jsp:include page="/WEB-INF/clientPages/static/socialIcons.jsp"></jsp:include>
                        </ul>
                    </div>
                </div>
                <div class="resize">
                    <a href="#"><span></span></a>
                </div>
            </div>
        </div>
        <!-- Left -->

        <!-- Right -->
        <div class="arlo_tm_rightpart">
            <div class="rightpart_inner">

                <!--Post-->
                <div class="arlo_tm_section">
                    <div class="arlo_tm_news_single">
                        <div class="container">
                            <div class="arlo_tm_twinbox">
                                <div class="twinbox_left">
                                    <div class="single_inner">
                                        <div class="top_image">
                                            <img src="<%=post.getFiles().get(0).getFilePath()%>" alt=""/>
                                            <div class="main" data-img-url="img/news/3.jpg"></div>
                                        </div>
                                        <div class="short_detail">
                                            <div class="dates">
                                                <p>
                                                    <span class="second">
                                                        <%=post.getCreatedAt()%>
                                                    </span>
                                                    <span class="category">
                                                        <a href="#"><%=post.getCategorie().getCategoryName()%></a>
                                                    </span>
                                                </p>
                                            </div>
                                            <div class="title">
                                                <h3><%=post.getHeading()%>
                                                </h3>
                                            </div>
                                        </div>
                                        <div class="descriptions">
                                            <p><%=post.getContext()%>
                                            </p>
                                            <div class="description_images">
                                                <ul>
                                                    <%
                                                        for (MFiles file : post.getFiles()) {
                                                    %>
                                                    <li>
                                                        <div class="inner">
                                                            <div class="image">
                                                                <img src="<%=file.getFilePath()%>" alt=""/>
                                                                <div class="main" data-img-url="img/news/2.jpg"></div>
                                                            </div>
                                                        </div>
                                                    </li>
                                                    <%}%>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="twinbox_right">
                                    <div class="arlo_tm_sidebar_wrap">
                                        <div class="sidebar_list_wrap">
                                            <ul class="ul">
                                                <li>
                                                    <div class="title_holder">
                                                        <h3>Son Paylaşımlar</h3>
                                                    </div>
                                                    <div class="posts_list">
                                                        <ul>
                                                            <%
                                                                int a = 0;
                                                                for (Post lp : lastesPosts) {
                                                                    a++;
                                                            %>
                                                            <li>
                                                                <div class="inner">
                                                                    <div class="post_wrap">
                                                                        <div class="post_image">
                                                                            <img src="<%=lp.getFiles().get(0).getFilePath()%>"
                                                                                 alt=""/>
                                                                            <div class="image"
                                                                                 data-img-url="img/news/1.jpg"></div>
                                                                            <div class="overlay_post"></div>
                                                                        </div>
                                                                        <div class="title_date">
                                                                            <h3><a href="#"><%=lp.getHeading()%>
                                                                            </a></h3>
                                                                            <span><%=lp.getCreatedAt()%></span>
                                                                        </div>
                                                                    </div>
                                                                    <a class="arlo_tm_post_full_link" href="#"></a>
                                                                </div>
                                                            </li>
                                                            <%
                                                                    if (a == 4) break;
                                                                }
                                                            %>
                                                        </ul>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--Post-->

                <!-- Footer -->
                <div class="arlo_tm_section">
                    <div class="arlo_tm_footer">
                        <div class="container">
                            <div class="footer_inner">
                                <div class="copyright wow zoomIn" data-wow-duration="0.8s">
                                    <p>Copyright &copy; 2019</p>
                                </div>
                                <div class="top wow zoomIn" data-wow-duration="0.8s" data-wow-delay="0.2s">
                                    <span></span>
                                    <a href="#"></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Footer -->

            </div>
        </div>
        <!-- Right -->

    </div>
</div>
<!-- Main Wrapper -->

<jsp:include page="/WEB-INF/clientPages/static/footerLinks.jsp"></jsp:include>
</body>
</html>
