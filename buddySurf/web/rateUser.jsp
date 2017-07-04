<%--
    Document   : rateUser
    Created on : 20/05/2017, 18:50:29
    Author     : richard
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="head.jsp" %>
    </head>
    <body>
        <%@ include file="header.jsp" %>

        <h1>Avaliar Usuário</h1>
        <form action='rate-user' method='POST'>
            Usuário: <select name="user_selected">
                <% for (Users user : (List<Users>) request.getAttribute("userList")) { %>
                <option value=<%= user.getId() %>>
                    <%= user.getName() %>
                </option>
                <% } %>

            </select> <br/>
            Tipo: <select name='type'>
                <option value='0'>Avaliar Amigo</option>
                <option value='1'>Avaliar Hóspede</option>
                <option value='2'>Avaliar Anfitriã(o)</option>
                <option value='3'>Avaliar Convidado</option>
                <option value='4'>Avaliar Organizador</option>
            </select> <br/>
            <div class='rating'>Stars: <span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span></div>

            <div class='stars'>Nota:
                <input type='radio' name='rate' value='1' checked> 1
                <input type='radio' name='rate' value='2'> 2
                <input type='radio' name='rate' value='3'> 3
                <input type='radio' name='rate' value='4'> 4
                <input type='radio' name='rate' value='5'> 5
            </div>
            Descrição: <textarea rows='2' cols='20' name='description'> </textarea><br/>
            <input type='submit' value='Enviar'>
        </form>
    </body>
</html>
