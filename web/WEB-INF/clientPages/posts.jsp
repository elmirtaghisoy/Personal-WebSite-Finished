<%@ page import="et.model.Post" %>
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
                            <a href="#">
                                <img src="Resources/Client-Resources/img/logo/mobile.png" alt=""/>
                            </a>
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
                        <ul style="display: block;padding-top: 10%">
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
                        <ul>
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
                    <div class="arlo_tm_home_news_wrapper_all">
                        <div class="arlo_tm_home_news">
                            <div class="container">
                                <div class="arlo_title_holder">
                                    <%
                                        int postType = (int) request.getAttribute("postType");
                                        if (postType == 1) {
                                    %>
                                    <h3>Blog</h3>
                                    <%} else if (postType == 2) {%>
                                    <h3>Sosial Fəaliyyət</h3>
                                    <%} else if (postType == 3) {%>
                                    <h3>Portfolio</h3>
                                    <%}%>
                                </div>
                                <div style="padding-top: 1.5rem;" class="news_inner">
                                    <% if (postType == 1) {%>
                                    <nav aria-label="breadcrumb">
                                        <ol id="breadCategories" style="padding-top: 0"
                                            class="breadcrumb myBreadCumb"></ol>
                                    </nav>
                                    <%}%>
                                    <ul id="fromCatPosts"></ul>
                                    <ul id="posts">
                                        <% List<Post> postList = (List<Post>) request.getAttribute("postList");
                                            double msc = 0;
                                            for (Post post : postList) {
                                                msc += 0.2;
                                                if (msc == 0.8) break;
                                        %>
                                        <li class="wow zoomIn" data-wow-duration="0.8s" data-wow-delay="<%=msc%>s">
                                            <div class="inner">
                                                <div class="image">
                                                    <img src="<%=post.getFiles().get(0).getFilePath()%>" alt=""/>
                                                    <div class="main" data-img-url="img/news/2.jpg"></div>
                                                    <a class="link" href="news-single-2.html"></a>
                                                </div>
                                                <div class="details">
                                                    <div class="dates">
                                                        <p>
                                                            <span class="first">
                                                                <form style="display: inline-block;margin-right: 1rem"
                                                                      method="post" action="pc?action=getPostsByCatId">
                                                                    <input type="hidden" name="catId"
                                                                           value="<%=post.getCategorie().getId()%>">
                                                                    <input type="hidden" name="postType"
                                                                           value="<%=postType%>">
                                                                    <a href="#">
                                                                        <button class="getCatBtn" type="submit">
                                                                            <%=post.getCategorie().getCategoryName()%>
                                                                        </button>
                                                                    </a>
                                                                </form>
                                                            </span>
                                                            <span class="second">
                                                                <%=post.getCreatedAt()%>
                                                            </span>
                                                        </p>
                                                    </div>
                                                    <div class="title">
                                                        <h3>
                                                            <a href="pc?action=getPostByIdC&postType=<%=postType%>&id=<%=post.getId()%>"><%=post.getHeading()%>
                                                            </a></h3>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <%
                                            }
                                        %>
                                    </ul>
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
