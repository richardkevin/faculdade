<%@page import="Model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <a class="navbar-brand" href="/buddySurf">
        <div class="logo">BuddySurf</div>
    </a>

    <div class="nav navbar-nav navbar-right">
        <% if (session.getAttribute("name") == null) { %>
            <a class="btn btn-default btn-sm navbar-btn" href="/buddySurf/add">Cadastre-se</a>
            <a class="btn btn-default btn-sm navbar-btn" href="/buddySurf/login">Entrar</a>
        <% } else { %>
            <a href="/buddySurf/profile">
                <span>
                    <% Users u = (Users) session.getAttribute("user"); %>
                    <%= u.getName() %>
                </span>
            </a>
            <a class="btn btn-default btn-sm navbar-btn" href="/buddySurf/logout">Logout</a>
        <% } %>
    </div>
  </div>
</nav>
