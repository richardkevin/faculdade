<%--
    Document   : profile
    Created on : 20/05/2017, 17:09:48
    Author     : richard
--%>

<%@page import="Model.Accommodation"%>
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
                <div class="sidebar col-md-2">
                    <h1>Olá <%= user.getName() %>!</h1>
                </div>
            <% } %>

            <div class="col-md-offset-1 col-md-7">
                <span class="title">Minhas Avaliações</span>

                <% List<Rating> rates = (List<Rating>) request.getAttribute("rates"); %>
                    <% if (rates.isEmpty()) { %>
                        <p>Não há avaliações</p>
                    <% } else { %>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Usuário</th>
                                <!--<th>Tipo</th>-->
                                <th>Descrição</th>
                                <th>Avaliação</th>
                            </tr>
                        </thead>
                    <tbody>
                        <% for (Rating rate : rates) { %>
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
            <div class="col-md-offset-1 col-md-7">
                <span class="title">Minhas Acomodações</span>
                <a href="my-accommodations/add"><span class="btn btn-default navbar-btn">Adicionar</span></a>
                <% List<Accommodation> accommodations = (List<Accommodation>) request.getAttribute("accommodations"); %>
                    <% if (accommodations.isEmpty()) { %>
                        <p>Não há acomodações</p>
                    <% } else { %>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>País</th>
                                <th>Cidade</th>
                                <th>Vagas</th>
                                <th>Diária/Pessoa</th>
                                <th>Solicitações</th>
                            </tr>
                        </thead>
                    <tbody>
                        <% for (Accommodation accommodation : accommodations) { %>
                            <tr>
                                <td><%= accommodation.getCountry() %></td>
                                <td><%= accommodation.getCity() %></td>
                                <td>0/<%= accommodation.getMaxGuests() %></td>
                                <td><%= accommodation.getGuestPrice() %></td>
                                <td></td>
                            </tr>
                        <% } %>
                    </table>
                <% } %>

                <span class="right"><a href="my-accommodations">ver todas</a></span>
            </div>
            <% } %>
        </div>
    </body>
</html>
