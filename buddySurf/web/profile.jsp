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

        <div class="container-fluid">
            <div class="col-md-2 sidebar">
                <div class="sidebar-content">
                    <img src="https://pbs.twimg.com/profile_images/656239066220855296/UYTxg0GV_400x400.png" alt="" class="img-circle">

                    <% Users user = (Users) request.getAttribute("user"); %>
                    <h1>Olá <%= user.getName() %> !</h1>
                    <ul>
                        <li>
                            <a href="rateUser">Avaliar</a>
                        </li>
                        <li>Sobre</li>
                        <li>Viagens</li>
                        <li>Acomodações</li>
                    </ul>
                </div>
            </div>

            <div class="col-md-8">
                <h2>Veja suas avaliações</h2>
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
                        <% for (Rating rate : (List<Rating>) request.getAttribute("listRates")) { %>
                        <tr>
                            <td><%= rate.getSender().getName() %></td>
                            <!--<td><%= rate.getType() %></td>-->
                            <td><%= rate.getDescription() %></td>
                            <td><%= rate.getStars() %></td>
                        <% } %>
                        </tr>
                </table>
            </div>
        </div>
    </body>
</html>
