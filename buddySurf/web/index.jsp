<%--
    Document   : index
    Created on : 20/05/2017, 19:13:12
    Author     : richard
--%>

<%@page import="Model.Accommodation"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="head.jsp" %>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <% List<Accommodation> accommodations = (List<Accommodation>) request.getAttribute("accommodations"); %>
        <% Users user = (Users) request.getAttribute("user"); %>

        <div class="container-fluid">
            <div class="form-group has-feedback">
                <i class="glyphicon glyphicon-search form-control-feedback"></i>
                <input type="text" class="form-control" placeholder="Procurar...">
            </div>

            <ul class="nav nav-tabs">
                <li role="presentation" class="active"><a href="/buddySurf">Acomodações</a></li>
                <li role="presentation" class=""><a href="buddySurf/users">Usuários</a></li>
            </ul>

            <div>
                <% if (request.getAttribute("accommodations") == null || accommodations.isEmpty()) { %>
                    <p>Não há acomodações</p>
                <% } else { %>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>País</th>
                                <th>Cidade</th>
                                <th>Hóspedes</th>
                                <th>Data Inicial</th>
                                <th>Data Final</th>
                                <th>Usuário</th>
                                <th></th>
                            </tr>
                        </thead>
                    <tbody>
                        <% for (Accommodation accom : accommodations) { %>
                            <tr>
                                <td><%= accom.getCountry() %></td>
                                <td><%= accom.getCity() %></td>
                                <td><%= accom.getMaxGuests() %></td>
                                <td><%= accom.getDt_start() %></td>
                                <td><%= accom.getDt_end() %></td>
                                <td><%= accom.getOwner().getUsername() %></td>
                                <% if (accom.getOwner().getId() != user.getId()) { %>
                                    <td><a href="buddySurf/booking/<%= accom.getId() %>">Reservar</a></td>
                                <% } %>
                                </tr>
                        <% } %>
                    </table>
                <% } %>
            </div>
        </div>
    </body>
</html>
