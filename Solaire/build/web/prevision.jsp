<%-- 
    Document   : prevision
    Created on : 7 déc. 2023, 11:30:08
    Author     : ITU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Vector" %>
<%@ page import="Models.*" %>
<% Vector<Resultat> resultats = (Vector<Resultat>) request.getAttribute("resultats"); %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Tableau de Données</title>
  <style>
    body {
      font-family: Arial, sans-serif;
    }

    table {
      border-collapse: collapse;
      width: 100%;
      margin-top: 20px;
    }

    th, td {
      border: 1px solid #ddd;
      padding: 8px;
      text-align: left;
    }

    th {
      background-color: #f2f2f2;
    }

    tr:hover {
      background-color: #f5f5f5;
    }
  </style>
</head>
<body>
<center><h1> Prevision de coupure de courant: </h1></center>
  <table>
    <thead>
      <tr>
        <th>Date</th>
        <th>Heure</th>
        <th>Consommation</th>
        <th>Élève</th>
        <th>Secteur</th>
        <th>Panneau</th>
        <th>Batterie</th>
        <th>Luminosité</th>
        <th>Coupure</th>
      </tr>
    </thead>
    <tbody>
        <% for(int i=0;i<resultats.size();i++){ %>
            <tr>
                <td><%= resultats.get(i).getDate() %></td>
                <td><%= resultats.get(i).getHeure() %></td>
                <td><%= resultats.get(i).getConsommation() %></td>
                <td><%= resultats.get(i).getEleve() %></td>
                <td><%= resultats.get(i).getSecteur() %></td>
                <td><%= resultats.get(i).getPanneau() %></td>
                <td><%= resultats.get(i).getBatterie() %></td>
                <td><%= resultats.get(i).getLuminosite()*10 %>%</td>
                <td><%= resultats.get(i).getCoupure() %></td>
            </tr>
        <% } %>
    </tbody>
  </table>
</body>
</html>

