<%-- 
    Document   : index
    Created on : 6 oct. 2023, 14:00:22
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Service.WebServiceSante" %>
<%@ page import="java.util.Map" %>
<%
    WebServiceSante ty=new WebServiceSante();
    Map<Integer, Map<String, String>> responseData=ty.parsePersonne();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Valiny" method="get">
            <h1>Recherche personne</h1>
            <select name="cin">
                <%
                    for (Map.Entry<Integer, Map<String, String>> entry : responseData.entrySet()) {
                        int cin = entry.getKey();
                        Map<String, String> personneDetails = entry.getValue();
                        %>
                            <option value="<%= cin %>"><%= personneDetails.get("pat_forename") %></option>
                        <%
                    }
                %>
            </select>
            <input type="hidden" name="error" value="0">
            <input type="submit" value="rechercher">
        </form>
        <h1>
            <a href="TestCarte">Voir carte</a>
        </h1>
    </body>
</html>
