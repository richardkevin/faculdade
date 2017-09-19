<%-- 
    Document   : register-project
    Created on : Sep 17, 2017, 3:22:03 PM
    Author     : richard.correa
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Student"%>
<%@page import="Model.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastrar Projeto</h1>
        <form action='project-registration' method='POST'>
            <label>Tema:</label>
            <input name="name">
            <label>Aluno:</label>
            <select name="matricula">
                <% for (Student student : (List<Student>) request.getAttribute("studentsList")) { %>
                <option value=<%= student.getMatricula() %>>
                    <%= student.getMatricula() %>
                </option>
                <% } %>
            </select>
            <label>Orientador:</label>
            <input name="teacher_id" value="1">
            <label>Descrição:</label>
            <textarea name="description"></textarea>
            <input type="submit" >
        </form>
    </body>
</html>
