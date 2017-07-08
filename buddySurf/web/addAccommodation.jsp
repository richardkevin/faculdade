<%-- 
    Document   : addAccommodation
    Created on : Jul 7, 2017, 11:57:16 AM
    Author     : richard.correa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="head.jsp" %>
    </head>
    <body>
        <%@ include file="header.jsp" %>

        <h1>Criar Hospedagem</h1>
        <form action='myAccommodations' method="POST">
            País: <input type="text" name="country"> <br/>
            Cidade: <input type="text" name="city"> <br/>
            Hóspedes: <input type="number" name="maxGuests"> <br/>
            Data Inicial: <input type="date" name="dt_start"> <span>Hoje</span> <br/>
            Data Final: <input type="date" name="dt_end"> <br/>

            <input type="submit">
        </form>
    </body>
</html>