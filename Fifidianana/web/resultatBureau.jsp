<%-- 
    Document   : bureauDeVote
    Created on : 27 nov. 2023, 14:40:38
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Vector" %>
<%@ page import="models.*" %>
<% Vector<V_resultat> resultat = (Vector<V_resultat>) request.getAttribute("resultat"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <style>

        .container {
            max-width: 800px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input, select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            background-color: #333;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #555;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
            text-align: left;
        }

        th, td {
            padding: 12px;
        }

        th {
            background-color: #333;
            color: #fff;
        }
    </style>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        
        <h1>Resultat General!</h1>
        <h1><center>REPOBLIKAN'I MADAGASIKARA</center></h1>
        <h1><center>fitiavana - Tanindrazana - Fandrosoana</center></h1>
        <h2>RESULTAT DES ÉLECTIONS PRÉSIDENTIELLES</h2>
        <h3>DANS LE BUREAU DE VOTE <%= resultat.getBureauVote() %></h3>
        <h3>Région: <%= resultat.getRegion() %></h3>
        <h3>District: <%= resultat.getDistrict() %></h3>
        <h3>Commune: <%= resultat.getCommune() %></h3>
        <h3>Fokontany: <%= resultat.getFokontany() %></h3>
        <h3>Bureau de Vote: <%= resultat.getCodeBv() %></h3>
        <h3>Inscrits: <%= resultat.getInscrits() %></h3>
        <h3>Votants: <%= resultat.getVotants() %> Taux de participation:...</h3>
        <h3>Blancs: <%= resultat.getBlancs() %> soit: ...% Nuls: <%= resultat.getNuls() %> soit: ...%</h3>
        <h3>Suffrages exprimés: <%= resultat.getTotal() %> soit: ...%</h3>
        
                <table>
                    <tr>
                        <th>Numero</th>
                        <th>Nom</th>
                        <th>Antoko</th>
                        <th>Vote azony</th>
                        <th>Pourcentage</th>
                    </tr>
                    <% for(int i=0;i<2;i++){ %>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    <% } %>
                </table>
    </body>
</html>
