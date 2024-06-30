<%-- 
    Document   : result
    Created on : 29 janv. 2024, 18:49:56
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.*, java.util.*" %>
<%
    Vector<V_Produit> liste = (Vector<V_Produit>) request.getAttribute("liste");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 20px;
        }

        h1 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
    </head>
    <body>
        <h1>Resultat!</h1>
        <table>
            <tr>
                <th>idProduit</th>
                <th>idCategorie</th>
                <th>nom</th>
                <th>categorie</th>
                <th>prix</th>
                <th>qualite</th>
                <th>qualite/prix</th>
            </tr>
                <% for (int i = 0; i < liste.size(); i++) { %>
            <tr>

                    <td> <%= liste.get(i).getIdProduit() %></td>
                    <td> <%= liste.get(i).getIdCategorie()%></td>
                    <td> <%= liste.get(i).getNom()%></td>
                    <td> <%= liste.get(i).getCategorie()%></td>
                    <td> <%= liste.get(i).getPrix()%></td>
                    <td> <%= liste.get(i).getQualite()%></td>
                    <td> <%= liste.get(i).getQualitePrix()%></td>
            </tr>
                <% } %>
        </table>
    </body>
</html>
