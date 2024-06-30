<%-- 
    Document   : showEtatStock
    Created on : 22 nov. 2023, 10:46:35
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Vector" %>
<%@ page import="models.*" %>
<% String dateInitial = (String) request.getAttribute("dateInitial"); %>
<% String dateFinal = (String) request.getAttribute("dateFinal"); %>
<% Vector<EtatStock> stockInitial = (Vector<EtatStock>) request.getAttribute("stockInitial"); %>
<% Vector<EtatStock> stockFinal = (Vector<EtatStock>) request.getAttribute("stockFinal"); %>
<% Vector<Double> totalStockInitial = (Vector<Double>) request.getAttribute("totalStockInitial"); %>
<% Vector<Double> totalStockFinal = (Vector<Double>) request.getAttribute("totalStockFinal"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>État de stock</title>
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

        <div style="display:flex">
            <div class="container">
                <h2> Stock Initial au <%= dateInitial %></h2>
                <table>
                    <tr>
                        <th>Code Article</th>
                        <th>Nom</th>
                        <th>Quantité</th>
                        <th>Prix Unitaire</th>
                        <th>Prix Total</th>
                        <th>Magasin</th>
                    </tr>
                    <% for(int i=0;i<stockInitial.size();i++){ %>
                        <tr>
                            <td><%= stockInitial.get(i).getCode_article() %></td>
                            <td><%= stockInitial.get(i).getArticle() %></td>
                            <td><%= stockInitial.get(i).getStock_actuel() %></td>
                            <td><%= stockInitial.get(i).getPrixUnitaire() %></td>
                            <td><%= stockInitial.get(i).getPrixTotal() %></td>
                            <td><%= stockInitial.get(i).getMagasin() %></td>
                        </tr>
                    <% } %>
                        <tr>
                            <td style="color: red">Total</td>
                            <td></td>
                            <td style="color: red"><%= totalStockInitial.get(0) %></td>
                            <td style="color: red"><%= totalStockInitial.get(1) %></td>
                            <td style="color: red"><%= totalStockInitial.get(2) %></td>
                            <td></td>
                        </tr>
                </table>
            </div>
            <div class="container">
                <h2> Stock Final au <%= dateFinal %></h2>
                <table>
                    <tr>
                        <th>Code Article</th>
                        <th>Nom</th>
                        <th>Quantité</th>
                        <th>Prix Unitaire</th>
                        <th>Prix Total</th>
                        <th>Magasin</th>
                    </tr>
                    <% for(int i=0;i<stockFinal.size();i++){ %>
                        <tr>
                            <td><%= stockFinal.get(i).getCode_article() %></td>
                            <td><%= stockFinal.get(i).getArticle() %></td>
                            <td><%= stockFinal.get(i).getStock_actuel() %></td>
                            <td><%= stockFinal.get(i).getPrixUnitaire() %></td>
                            <td><%= stockFinal.get(i).getPrixTotal() %></td>
                            <td><%= stockFinal.get(i).getMagasin() %></td>
                        </tr>
                    <% } %>
                        <tr>
                            <td style="color: red">Total</td>
                            <td></td>
                            <td style="color: red"><%= totalStockFinal.get(0) %></td>
                            <td style="color: red"><%= totalStockFinal.get(1) %></td>
                            <td style="color: red"><%= totalStockFinal.get(2) %></td>
                            <td></td>
                        </tr>
                </table>
            </div>
        </div>
    </body>
</html>
