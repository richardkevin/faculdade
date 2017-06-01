<%-- 
    Document   : login
    Created on : 09/05/2017, 21:13:20
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

        <div class="center">
            <h1>Entrar</h1>

            <form action="Login" method="POST">
                Username: <input type='text' name='username'> <br/>
                Password: <input type='text' name='password'> <br/>
                <input type='submit' value='Login'>
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
