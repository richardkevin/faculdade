<%-- 
    Document   : teacher
    Created on : Sep 17, 2017, 3:03:55 PM
    Author     : richard.correa
--%>

<%@page import="Model.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Person u = (Person) session.getAttribute("user"); %>

        <h1>Olá <%= u.getName() %></h1>
        <a href="/devAppCorp/project-registration">Cadastrar Projeto</a>
    </body>
</html>
