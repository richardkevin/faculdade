<%-- 
    Document   : myAccommodations
    Created on : Jul 4, 2017, 1:38:43 PM
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
        
        <h2>Minhas Hospedagens</h2>
        <a class="btn btn-default navbar-btn" href="my-accommodations/add">Adicionar</a>
        
        <%= request.getAttribute("accommodations") %>
    </body>
</html>
