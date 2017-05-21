<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="menuBar">
    <a href="/buddySurf">
        <div class="logo">BuddySurf</div>
    </a>
    <div class="actionBar">
        
        <% if (session.getAttribute("name") == null) { %>
            <a href="add">Cadastre-se</a>
            <a href="login">Entrar</a>
        <% } else { %>
            Olá <a href="profile"><%= request.getAttribute("name") %></a>
            <a href="logout">Logout</a>
        <% } %>
    </div>
</div>