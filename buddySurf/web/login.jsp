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
    </head>
    <body>
        <h1>Login</h1>

        <form action="Logon" method="POST">
            Username: <input type='text' name='username'> <br/>
            Password: <input type='text' name='password'> <br/>
            <input type='submit' value='Login'>
        </form>
    </body>
</html>
