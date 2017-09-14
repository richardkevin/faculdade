<%-- 
    Document   : login
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

        <div class="container-fluid">
            <h1 class="col-sm-offset-5">Entrar</h1>

            <form class="form-horizontal col-sm-offset-2" action="Login" method="POST">
              <div class="form-group">
                <label class="col-sm-2 control-label">Username:</label>
                <div class="col-sm-5">
                    <input class="form-control" type="text" name="username">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">Password</label>
                <div class="col-sm-5">
                  <input type="password" class="form-control" name="password">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5">
                  <button type="submit" class="btn btn-default">Entrar</button>
                </div>
              </div>
            </form>

            <div class="errors">
                <%
                    String error = (String) request.getAttribute("error");
                    if (error != null) {
                        out.println(error);
                } %>
            </div11>
        </div>
    </body>
</html>
