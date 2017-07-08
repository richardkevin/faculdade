<%-- 
    Document   : profile
    Created on : 20/05/2017, 17:09:48
    Author     : richard
--%>

<%@page import="Model.Rating"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="head.jsp" %>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <% Users user = (Users) request.getAttribute("user"); %>

        <div class="container-fluid">
            <% if (request.getAttribute("hideSidebar") == null) { %>
                <div class="col-md-2 sidebar">
                    <div class="sidebar-content">
                        <img src="https://pbs.twimg.com/profile_images/656239066220855296/UYTxg0GV_400x400.png" alt="" class="img-circle">

                        <h1>Olá <%= user.getName() %> !</h1>
                        <ul>
                            <li><a>Amigos</a></li>
                            <li><a>Sobre</a></li>
                            <% if (user.isAllowGuest()) { %><li><a href="my-accommodations">Hospedagens</a></li><% } %>
                        </ul>
                    </div>
                </div>
            <% } %>

            <div class="col-md-8">
                <h2>Avaliações</h2>
                
                <% List<Rating> listRates = (List<Rating>) request.getAttribute("listRates"); %>
                    <% if (listRates.isEmpty()) { %>
                        <p>Não há avaliações</p>
                    <% } else { %>
                    <table>
                        <thead>
                            <tr>
                                <th>Usuário</th>
                                <!--<th>Tipo</th>-->
                                <th>Descrição</th>
                                <th>Avaliação</th>
                            </tr>
                        </thead>
                    <tbody>
                        <% for (Rating rate : listRates) { %>
                            <tr>
                                <td><%= rate.getSender().getName() %></td>
                                <!--<td><%= rate.getType() %></td>-->
                                <td><%= rate.getDescription() %></td>
                                <td><%= rate.getStars() %></td>
                                </tr>
                        <% } %>
                    </table>
                    <% } %>
            </div>

            <% if (user.isAllowGuest()) { %>
            <div class="col-md-8">
                <h2>Acomodações</h2>
                <span>ver todas</span>
            </div>
            <% } %>
        </div>
    </body>
</html>
