<%-- 
    Document   : ajoutTerreInputOff
    Created on : 24 oct. 2023, 08:51:51
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Foncier.*" %>
<%
    String cin= (String)request.getAttribute("cin");
    String localisation= (String)request.getAttribute("localisation");
    int nbrBorne= (int)request.getAttribute("nbrBorne");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ajout terre :</h1>
        <form action="AjoutTerreInputOffServlet" method="post">
            <%
                for(int i=0;i<nbrBorne;i++)
                {
                    %>
                    <h3>Borne numero <%= i+1 %></h3>
                    <p>
                        latitude : <input type="number" name="lat<%= i %>" step="0.00001">
                        longitude : <input type="number" name="long<%= i %>" step="0.00001">
                    </p>
                    <%
                }
            %>
            <input type="hidden" name="cin" value="<%= cin %>">
            <input type="hidden" name="localisation" value="<%= localisation %>">
            <input type="hidden" name="nbrBorne" value="<%= nbrBorne %>">
            <input type="submit" value="ok">
        </form>
    </body>
</html>
