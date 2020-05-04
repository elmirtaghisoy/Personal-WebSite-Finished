<%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 29.01.2020
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Elmir Tağısoy | Proqramçı</title>
    <jsp:include page="WEB-INF/clientPages/static/headerLinks.jsp"></jsp:include>
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
                            <jsp:include page="WEB-INF/clientPages/static/navbar.jsp"></jsp:include>
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
                <div class="menu1">
                    <ul style="padding-bottom: 70%">
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
        <!-- Left -->

        <!-- Right -->
        <div class="arlo_tm_rightpart">
            <div class="rightpart_inner">

                <!-- Ana Sehife -->
                <div class="arlo_tm_section" id="home">
                    <div class="arlo_tm_hero_header particle jarallax" data-speed="0.2">
                        <div id="particles-js"></div>
                        <div class="overlay"></div>
                        <div class="hero_content">
                            <div class="image_wrap">
                                <img src="Resources/Client-Resources/img/about/500x500.jpg" alt=""/>
                                <div class="main" data-img-url="Resources/Client-Resources/img/about/3.jpg"></div>
                            </div>
                            <div class="name_holder">
                                <h3>Elmİr <span>Tağısoy</span></h3>
                            </div>
                            <div class="text_typing">
                                <p><span class="arlo_tm_animation_text_word"></span> <i
                                        style="position:relative; top:1.2px;" class="fas fa-chevron-right"></i></p>
                            </div>
                        </div>
                        <div class="arlo_tm_arrow_wrap bounce anchor">
                            <a href="#about"><i class="xcon-angle-double-down"></i></a>
                        </div>
                    </div>
                </div>
                <!-- Ana Sehife -->

                <!-- Haqqimda -->
                <div class="arlo_tm_section" id="about">
                    <div class="arlo_tm_about_wrap_all">
                        <div class="arlo_tm_about">
                            <div id="about-wrapper"></div>
                        </div>
                    </div>
                </div>
                <!-- Haqqimda -->

                <!-- Tecrube -->
                <div id="exp" class="arlo_tm_section">
                    <div style="box-shadow: inset 0px 20px 20px white;" class="arlo_tm_timeline">
                        <div id="experience"></div>
                    </div>
                </div>
                <!-- Tecrube -->

                <!-- Tehsil -->
                <div id="edu" class="arlo_tm_section">
                    <div style="padding-top: 0px;box-shadow: 0px -20px 20px #f1f1f1;" class="arlo_tm_timeline">
                        <div id="education"></div>
                    </div>
                </div>
                <!-- Tehsil -->

                <!-- Sosial -->
                <div class="arlo_tm_section" id="news">
                    <div class="arlo_tm_home_news_wrapper_all">
                        <div class="arlo_tm_home_news">
                            <div class="container">
                                <div class="arlo_title_holder">
                                    <h3>Sosial<span> Fəaliyyətlər</span></h3>
                                </div>
                                <div class="news_inner">
                                    <ul id="newsPrev">
                                    </ul>
                                    <div style="text-align: center" class="arlo_tm_button" data-color="pink">
                                        <form action="pc?action=getPostsListC" method="post">
                                            <input type="hidden" name="postType" value="2">
                                            <a style="padding: 0;height: 50px;width: 150px" href="">
                                                <span>
                                                    <button style="color:white;" class="onePostBtn onePostsBtn"
                                                            type="submit">
                                                        Daha Çox
                                                    </button>
                                                </span>
                                            </a>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Sosial -->

                <!-- Blog -->
                <div class="arlo_tm_section" id="blog">
                    <div class="arlo_tm_home_news_wrapper_all">
                        <div class="arlo_tm_home_news">
                            <div class="container">
                                <div class="arlo_title_holder">
                                    <h3>Blog</h3>
                                </div>
                                <div class="news_inner">
                                    <ul id="blogsPrev">
                                    </ul>
                                    <div style="text-align: center" class="arlo_tm_button" data-color="pink">
                                        <form action="pc?action=getPostsListC" method="post">
                                            <input type="hidden" name="postType" value="1">
                                            <a style="padding: 0;height: 50px;width: 150px" href="">
                                                <span>
                                                    <button style="color:white;" class="onePostBtn onePostsBtn"
                                                            type="submit">
                                                        Daha Çox
                                                    </button>
                                                </span>
                                            </a>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Blog -->

                <!--Portfolio -->
                <div class="arlo_tm_section" id="portfolio">
                    <div class="arlo_tm_home_news_wrapper_all">
                        <div class="arlo_tm_home_news">
                            <div class="container">
                                <div class="arlo_title_holder">
                                    <h3>Portfolio</h3>
                                </div>
                                <div class="news_inner">
                                    <ul id="portfolioPrev">
                                    </ul>
                                    <div style="text-align: center" class="arlo_tm_button" data-color="pink">
                                        <form action="pc?action=getPostsListC" method="post">
                                            <input type="hidden" name="postType" value="3">
                                            <a style="padding: 0;height: 50px;width: 150px" href="">
                                                <span>
                                                    <button style="color:white;" class="onePostBtn onePostsBtn"
                                                            type="submit">
                                                        Daha Çox
                                                    </button>
                                                </span>
                                            </a>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--Portfolio-->

                <!--Elaqe-->
                <div class="arlo_tm_section" id="contact">
                    <div class="arlo_tm_contact_wrapper_all">
                        <div class="arlo_tm_contact">
                            <div class="container">
                                <div class="arlo_title_holder">
                                    <h3><span>Əlaqə</span></h3>
                                </div>
                                <div class="contact_inner">
                                    <div class="left wow zoomIn" data-wow-duration="0.8s">
                                        <div class="about_short_contact_wrap">
                                            <ul>
                                                <li>
                                                    <img class="svg"
                                                         src="Resources/Client-Resources/img/svg/phone-call.svg"
                                                         alt=""/>
                                                    <span><label>Telefon:</label> <a href="tel:+994559552897">+994559552897</a></span>
                                                </li>
                                                <li>
                                                    <img class="svg"
                                                         src="Resources/Client-Resources/img/svg/whatsapp.svg" alt=""/>
                                                    <span><label>WhatsApp:</label> <a
                                                            href="https://wa.me/+994559552897" target="_blank">+994559552897</a></span>
                                                </li>
                                                <li>
                                                    <img class="svg"
                                                         src="Resources/Client-Resources/img/svg/facebook.svg" alt=""/>
                                                    <span><label>Facebook:</label> <a
                                                            href="https://www.facebook.com/elmir.taghyev"
                                                            target="_blank">Elmir Taghisoy</a></span>
                                                </li>
                                                <li>
                                                    <img class="svg"
                                                         src="Resources/Client-Resources/img/svg/instagram.svg" alt=""/>
                                                    <span><label>Instagram:</label> <a
                                                            href="https://www.instagram.com/elmirtaghisoy/"
                                                            target="_blank">elmirtaghisoy</a></span>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="right wow zoomIn" data-wow-duration="0.8s" data-wow-delay="0.2s">
                                        <form action="http://integrothemes.com/" method="post" class="contact_form"
                                              id="contact_form">
                                            <div class="returnmessage"
                                                 data-success="Your message has been received, We will contact you soon."></div>
                                            <div class="empty_notice"><span>Please Fill Required Fields</span></div>
                                            <div class="input_wrap">
                                                <ul>
                                                    <li><input required id="mUsername" type="text"
                                                               placeholder="Ad / Soyad"/>
                                                    </li>
                                                    <li><input required id="mEmail" type="email" placeholder="Email"/>
                                                    </li>
                                                    <li><input required id="mPhone" type="text"
                                                               placeholder="Əlaqə Nömrəsi"/>
                                                    </li>
                                                    <li><textarea required id="mContext" placeholder="Mətn"></textarea>
                                                    </li>
                                                </ul>
                                                <div class="arlo_tm_button" data-color="pink">
                                                    <a id=""
                                                       href="javascript: addMessage() "><span>Göndər</span> </a>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--Elaqe-->

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

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div id="aboutEduExpModal"></div>
            <div class="modal-footer">
                <button style="color: #ffffff;background-color: #ff4b36;" type="button" class="btn btn-warning" data-dismiss="modal">Bağla</button>
            </div>
        </div>
    </div>
</div>


<jsp:include page="WEB-INF/clientPages/static/footerLinks.jsp"></jsp:include>
</body>
</html>
