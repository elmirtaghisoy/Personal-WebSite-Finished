<%--
  Created by IntelliJ IDEA.
  User: Elmir
  Date: 23.01.2020
  Time: 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--Nav-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Elmir Tağısoy</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav myNav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="menu2" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Informasiya
                </a>
                <div class="dropdown-menu" aria-labelledby="menu2">
                    <a class="dropdown-item" href="javascript: getAboutMe()">Haqqımda</a>
                    <a class="dropdown-item" href="javascript: getAllEduExp(1)">Təhsil</a>
                    <a class="dropdown-item" href="javascript: getAllEduExp(2)">Təcrübə</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Postlar
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="javascript: getAllPosts(1)">Blog</a>
                    <a class="dropdown-item" href="javascript: getAllPosts(2)">Sosial Fəaliyyət</a>
                    <a class="dropdown-item" href="javascript: getAllPosts(3)">Portfolio</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="javascript: getAllCategories()">Kateqoriya</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="javascript: getMessages()">Bildiriş</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="javascript: getAllContacts()">Əlaqə</a>
            </li>
        </ul>
    </div>
</nav>
<!--Nav-->