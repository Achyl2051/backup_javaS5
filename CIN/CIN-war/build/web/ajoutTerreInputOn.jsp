<%-- 
    Document   : ajoutTerreinputOn
    Created on : 21 oct. 2023, 18:00:51
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
        <form action="AjoutTerreInputOnServlet" method="post">
            <p>
                Superficie : <input type="number" name="superficie" step="0.00000000000000000001">
            </p>
            <p>
                Perimetre : <input type="number" name="perimetre" step="0.00000000000000000001">
            </p>
            <%
                for(int i=0;i<nbrBorne;i++)
                {
                    %>
                    <h3>Borne numero <%= i+1 %></h3>
                    <p>
                        latitude : <input type="number" name="lat<%= i %>" step="0.00000000000000000001">
                        longitude : <input type="number" name="long<%= i %>" step="0.00000000000000000001">
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
