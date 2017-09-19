<%-- 
    Document   : add
    Created on : 13/09/2017, 21:39:58
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

        <h1>Cadastre-se</h1>
        <form action='add' method='POST' class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">Nome:</label>
                <div class="col-sm-5">
                    <input class="form-control" type='text' name='name' maxlength="50">
                </div>
                <span>Máximo de caracteres: 50</span>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Username:</label>
                <div class="col-sm-5">
                    <input class="form-control" type='text' name='username' maxlength="20">
                </div>
                <span>Máximo de caracteres: 20</span>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Password:</label>
                <div class="col-sm-5">
                    <input class="form-control" type='password' name='password' maxlength="10">
                </div>
                <span>Máximo de caracteres: 10</span>
            </div>
          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-5">
              <input class="btn btn-default btn-sm navbar-btn" type='submit' value='Enviar'>
            </div>
          </div>
        </form>
    </body>
</html>
