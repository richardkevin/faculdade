<%-- 
    Document   : index
    Created on : 20/05/2017, 19:13:12
    Author     : richard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <%@ include file="header.jsp" %>
        
        <div class="main">
            <div class="search">
                <input type="text" placeholder="Procurar...">
                <span class="fa fa-search"></span>
            </div>

            <div class="navBar">
                <a href="">
                    <div class="navBarItem">Acomodações</div>
                </a>
                <a href="">
                    <div class="navBarItem">Convocações</div>
                </a>
                <a href="rateUser">
                    <div class="navBarItem">Avaliações</div>
                </a>
            </div>
        </div>

        <!-- mock -->
            <table class="results">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Endereço</th>
                        <th>Custo Total</th>
                  </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>03/05/17</td>
                        <td>Rua sem saida</td>
                        <td>R$ 2 pilas</td>
                    </tr>
                    <tr>
                        <td>15/05/17</td>
                        <td>Rua A</td>
                        <td>R$ 10 real</td>
                    </tr>
                </tbody>
            </table>
        
    </body>
</html>
