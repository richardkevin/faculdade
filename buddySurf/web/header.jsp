<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <a class="navbar-brand" href="/buddySurf">
        <div class="logo">BuddySurf</div>
    </a>
    <div class="nav navbar-nav navbar-right">
        
        <% if (session.getAttribute("name") == null) { %>
            <a class="btn btn-default navbar-btn" href="add">Cadastre-se</a>
            <a class="btn btn-default navbar-btn" href="login">Entrar</a>
        <% } else { %>
        <a href="profile">
            <p class="navbar-text navbar-right">
                <%= request.getAttribute("name") %>
            </p>
        </a>
            <a class="btn btn-default navbar-btn" href="logout">Logout</a>
        <% } %>
    </div>
  </div>
</nav>