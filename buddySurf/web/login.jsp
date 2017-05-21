<%-- 
    Document   : login
    Created on : 09/05/2017, 21:13:20
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
