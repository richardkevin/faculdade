<%--
    Document   : header
    Created on : 13/09/2017, 21:39:58
    Author     : richard
--%>

<%@page import="Model.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <a class="navbar-brand" href="/devAppCorp">
        <div class="logo">devAppCorp</div>
    </a>
    <a href="/devAppCorp/students">
        <div>Alunos</div>
    </a>
    <a href="/devAppCorp/teacher">
        <div>Professores</div>
    </a>

    <div class="nav navbar-nav navbar-right">
        <% if (session.getAttribute("name") == null) { %>
            <a class="btn btn-default btn-sm navbar-btn" href="/devAppCorp/add">Cadastre-se</a>
            <a class="btn btn-default btn-sm navbar-btn" href="/devAppCorp/login">Entrar</a>
        <% } else { %>
            <a href="/devAppCorp/profile">
                <span>
                    <% Person u = (Person) session.getAttribute("user"); %>
                    <%= u.getName() %>
                </span>
            </a>
            <a class="btn btn-default btn-sm navbar-btn" href="/devAppCorp/logout">Logout</a>
        <% } %>
    </div>
  </div>
</nav>
