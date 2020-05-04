<%@ page import="et.model.Post" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 03.02.2020
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Post> postList = (List<Post>) request.getAttribute("postList");
    int postType = (int) request.getAttribute("postType");
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
                        <form style="display: inline-block;margin-right: 1rem" method="post" action="pc?action=getPostsByCatId">
                            <input type="hidden" name="catId" value="<%=post.getCategorie().getId()%>">
                            <input type="hidden" name="postType" value="<%=postType%>">
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