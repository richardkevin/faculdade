<%-- 
    Document   : index
    Created on : 20/05/2017, 19:13:12
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
            <div class="form-group has-feedback">
                <i class="glyphicon glyphicon-search form-control-feedback"></i>
                <input type="text" class="form-control" placeholder="Procurar...">
            </div>

            <ul class="nav nav-tabs">
                <li role="presentation" class="active"><a href="">Acomodações</a></li>
                <li role="presentation" class=""><a href="">Convocações</a></li>
            </ul>
        </div>
    </body>
</html>
