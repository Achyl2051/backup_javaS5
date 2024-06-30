<%-- 
    Document   : newTerre
    Created on : 21 oct. 2023, 11:16:23
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Foncier.*" %>
<%
    String cin= (String)request.getAttribute("cin");
    int superficie= (int)request.getAttribute("superficie");
    String localisation= (String)request.getAttribute("localisation");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nombre de borne : </h1>
        <form action="InputBorne" method="post">
            <input type="number" name="nbrBorne" min="3">
            <input type="hidden" name="cin" value="<%= cin %>">
            <input type="hidden" name="superficie" value="<%= superficie %>">
            <input type="hidden" name="localisation" value="<%= localisation %>">
            <input type="submit" value="ok">
        </form>
    </body>
</html>
