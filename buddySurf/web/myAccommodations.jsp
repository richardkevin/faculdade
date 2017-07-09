<%-- 
    Document   : myAccommodations
    Created on : Jul 4, 2017, 1:38:43 PM
    Author     : richard.correa
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Accommodation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="head.jsp" %>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <% List<Accommodation> accommodations = (List<Accommodation>) request.getAttribute("accommodations"); %>

        <h2>Minhas Hospedagens</h2>
        <a class="btn btn-default navbar-btn" href="my-accommodations/add">Adicionar</a>
        
        <div>
            <% if (accommodations.isEmpty()) { %>
                <p>Não há acomodações</p>
            <% } else { %>
                <table>
                    <thead>
                        <tr>
                            <th>País</th>
                            <th>Cidade</th>
                            <th>Hóspedes</th>
                            <th>Data Inicial</th>
                            <th>Data Final</th>
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
                            </tr>
                    <% } %>
                </table>
            <% } %>
        </div>
    </body>
</html>
