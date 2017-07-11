<%-- 
    Document   : search
    Created on : 11/07/2017, 00:01:35
    Author     : richard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="form-inline">
    <label>Buscar por país: </label>
    <form class="input-group" method="GET" action="buddySurf/country">
        <input type="text" class="form-control" name="search" placeholder="Buscar país">
        <span class="input-group-btn">
          <button class="btn btn-default" type="submit">Go!</button>
        </span>
    </form>

    <span class="right">
        <label>Buscar por cidade: </label>
        <form class="input-group" method="GET" action="buddySurf/city">
            <input type="text" class="form-control" name="search" placeholder="Buscar cidade">
            <span class="input-group-btn">
              <button class="btn btn-default" type="submit">Go!</button>
            </span>
        </form>
    </span>
</div>

<br/><br/>
