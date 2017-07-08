<%--
    Document   : add
    Created on : 20/05/2017, 18:54:12
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
        <form action='add' method='POST'>
            Nome: <input type='text' name='name' maxlength="50"> <span>Máximo de caracteres: 50</span> <br/>
        Username: <input type='text' name='username' maxlength="20"> <span>Máximo de caracteres: 20</span><br/>
        Password: <input type='text' name='password' maxlength="10"> <span>Máximo de caracteres: 10</span><br/>
        Idade: <input type='text' name='age' > <br/>
        Endereço: <input type='text' name='address' maxlength="10"> <span>Máximo de caracteres: 10</span><br/>
        Max Guests: <input type="checkbox" name='allowGuest'> <br/>

        <input type='submit' value='Enviar'>
        </form>
    </body>
</html>
