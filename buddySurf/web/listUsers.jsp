<%--
    Document   : listUsers
    Created on : 03/07/2017, 22:42:39
    Author     : richard
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="head.jsp" %>
    </head>
    <body>
        <%@ include file="header.jsp" %>

        <div class="container-fluid">
            <%@ include file="search.jsp" %>

            <ul class="nav nav-tabs">
                <li role="presentation"><a href="/buddySurf">Acomodações</a></li>
                <li role="presentation" class="active"><a href="users">Usuários</a></li>
            </ul>

            <% List<Users> listUsers = (List<Users>) request.getAttribute("listUsers"); %>
                <% if (listUsers.isEmpty()) { %>
                    <p>Não há usuários</p>
                <% } else { %>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Usuário</th>
                            <th>Nome</th>
                            <th></th>
                        </tr>
                    </thead>
                <tbody>
                    <% for (Users user : listUsers) { %>
                        <tr>
                            <td><a href="profile/<%= user.getId() %>"><%= user.getUsername() %></a></td>
                            <td><a href="profile/<%= user.getId() %>"><%= user.getName() %></a></td>
                            <% if (user.getId() != user.getId()) { %>
                                <td><a href="rate-user/<%= user.getId() %>">Avaliar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </table>
            <% } %>
        </div>
    </body>
</html>
