<%-- 
    Document   : etatStock
    Created on : 22 nov. 2023, 09:27:39
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Vector" %>
<%@ page import="models.*" %>
<% Vector<Magasin> magasins = (Vector<Magasin>) request.getAttribute("magasins"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choix de l'état de stock</title>
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
                background-color: #4caf50;
                color: white;
            }
        </style>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        
        <div class="container">
            <h2>Choisir l'État de Stock</h2>
            <form action="ShowEtatDeStock" method="post">
                <label for="article">Article :</label>
                <input type="text" id="article" name="article" placeholder="Début">

                <label for="date_debut">Date de début :</label>
                <input type="date" id="date_debut" name="dateDebut" required>

                <label for="date_fin">Date de fin :</label>
                <input type="date" id="date_fin" name="dateFin" required>

                <label for="magasin">Magasin :</label>
                <select id="magasin" name="magasin">
                    <% for(int i=0;i<magasins.size();i++){ %>
                        <option value="<%= magasins.get(i).getIdMagasin() %>"><%= magasins.get(i).getNom() %></option>
                    <% } %>
                </select>

                <button type="submit">Afficher l'État de Stock</button>
            </form>
        </div>
    </body>
</html>
