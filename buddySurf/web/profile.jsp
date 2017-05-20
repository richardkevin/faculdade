<%-- 
    Document   : profile
    Created on : 20/05/2017, 17:09:48
    Author     : richard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BuddySurf</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <h1>Olá <%= request.getAttribute("name") %> !</h1>
        
        <h2>Veja suas avaliações</h2>
        
    </body>
</html>
