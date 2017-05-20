<%--
    Document   : add
    Created on : 20/05/2017, 18:54:12
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

        <h1>Cadastre-se</h1>
        <form action='add' method='POST'>
        Nome: <input type='text' name='name' > <br/>
        Username: <input type='text' name='username' > <br/>
        Password: <input type='text' name='password' > <br/>
        Idade: <input type='text' name='age' > <br/>
        Endereço: <input type='text' name='address' > <br/>
        Max Guests: <select id='max_guests' name='max_guests'>
            <option value='0'>Não permitir</option>
            <option value='1'>1 Hóspede</option>
            <option value='2'>2 Hóspedes</option>
            <option value='3'>3 Hóspedes</option>
            <option value='4'>4 Hóspedes</option>
            <option value='5'>5 Hóspedes</option>
            <option value='6'>6 Hóspedes</option>
            <option value='7'>7 Hóspedes</option>
            <option value='8'>8 Hóspedes</option>
            <option value='9'>9 Hóspedes</option>
            <option value='10'>10 Hóspedes</option>
        </select> <br/>

        <div>

        </div>
        <input type='submit' value='Enviar'>
        </form>
    </body>
</html>
