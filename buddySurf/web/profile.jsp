<%-- 
    Document   : profile
    Created on : 20/05/2017, 17:09:48
    Author     : richard
--%>

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

                    <h1>Olá <%= request.getAttribute("name") %> !</h1>
                    <ul>
                        <li>Sobre</li>
                        <li>Viagens</li>
                        <li>Acomodações</li>
                    </ul>
                </div>
            </div>

            <div class="col-md-8">
                <h2>Veja suas avaliações</h2>
            </div>
        </div>
    </body>
</html>
