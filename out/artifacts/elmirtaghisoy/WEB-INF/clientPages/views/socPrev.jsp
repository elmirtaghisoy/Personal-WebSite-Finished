<%@ page import="et.model.Post" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 30.01.2020
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Post> postList = (List<Post>) request.getAttribute("postList");
    int postType = (int) request.getAttribute("postType");
%>

<%
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
                <p><span class="first"><a href="#"><%=post.getCategorie().getCategoryName()%></a></span><span
                        class="second"><%=post.getCreatedAt()%></span></p>
            </div>
            <div class="title">
                <form action="pc?action=getPostByIdC" method="post">
                    <input type="hidden" name="postType" value="<%=postType%>">
                    <input type="hidden" name="id" value="<%=post.getId()%>">
                    <h3>
                        <a href="#">
                            <button class="onePostBtn" type="submit">
                                <%=post.getHeading()%>
                            </button>
                        </a>
                    </h3>
                </form>
            </div>
        </div>
    </div>
</li>
<%
    }
%>
