<%-- 
    Document   : reservation
    Created on : 08/07/2017, 19:00:39
    Author     : richard
--%>

<%@page import="Model.Accommodation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="head.jsp" %>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <% Accommodation accommodation = (Accommodation) request.getAttribute("accommodation"); %>

        <h1>Fazer Reserva</h1>

        <p>Diária por pessoa: R$ <%= accommodation.getGuestPrice() %>,00</p>

        <form action='/buddySurf/booking/<%= accommodation.getId() %>' method="POST">
            Hóspedes: <input type="number" name="maxGuests"> <br/>
            Data Inicial: <input type="date" name="dt_start"> <span>Hoje</span> <br/>
            Data Final: <input type="date" name="dt_end"> <br/>
            <input type="submit">
        </form>
    </body>
</html>
