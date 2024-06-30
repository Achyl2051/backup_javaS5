<%-- 
    Document   : sortieStock
    Created on : 20 nov. 2023, 19:30:55
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Vector" %>
<%@ page import="models.*" %>
<% Vector<Article> articles = (Vector<Article>) request.getAttribute("articles"); %>
<% Vector<Magasin> magasins = (Vector<Magasin>) request.getAttribute("magasins"); %>
<% Vector<Unite> unites = (Vector<Unite>) request.getAttribute("unites"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sortie de Stock</title>
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
        </style>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        
        <div class="container">
            <h2>Sortie de Stock</h2>
            <form action="InertSortie" method="post">
                <label for="article">Article :</label>
                <select id="article" name="article">
                    <% for(int i=0;i<articles.size();i++){ %>
                        <option value="<%= articles.get(i).getIdArticle() %>"><%= articles.get(i).getCode() %> <%= articles.get(i).getNom() %></option>
                    <% } %>
                </select>
                
                <label for="magasin">Magasin :</label>
                <select id="magasin" name="magasin">
                    <% for(int i=0;i<magasins.size();i++){ %>
                        <option value="<%= magasins.get(i).getIdMagasin() %>"><%= magasins.get(i).getNom() %></option>
                    <% } %>
                </select>
                
                <label for="unite">Unite :</label>
                <select id="unite" name="unite">
                    <% for(int i=0;i<unites.size();i++){ %>
                        <option value="<%= unites.get(i).getIdUnite() %>"><%= unites.get(i).getNom() %></option>
                    <% } %>
                </select>
                
                <label for="quantite">Quantité :</label>
                <input type="number" id="quantite" name="quantite" step="0.01" required>

                <label for="date">Date :</label>
                <input type="date" id="date" name="date" required>

                <button type="submit">Déduire du Stock</button>
            </form>
        </div>
    </body>
</html>
