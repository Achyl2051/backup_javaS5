<%-- 
    Document   : validation
    Created on : 20 nov. 2023, 19:46:09
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Vector" %>
<%@ page import="models.*" %>
<% Vector<Validation> validation = (Vector<Validation>) request.getAttribute("validation"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validation</title>
    <style>

        .container {
            max-width: 840px;
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
            width: 65%;
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
            <h1>Validation</h1>
                <table>
                    <tr>
                        <th>Article</th>
                        <th>Magasin</th>
                        <th>Quantité</th>
                        <th>Date</th>
                        <th>État</th>
                        <th></th>
                    </tr>
                    <% for(int i=0;i<validation.size();i++){ %>
                        <tr>
                            <td><%= new Article().getArticleById(validation.get(i).getIdArticle()).getNom() %></td>
                            <td><%= new Magasin().getMagasinById(validation.get(i).getIdMagasin()).getNom() %></td>
                            <td><%= validation.get(i).getQuantite() %></td>
                            <td><%= validation.get(i).getDate() %></td>
                            <td><%= validation.get(i).transfEtat() %></td>
                            <td>
                                <form action="InsertValidation" method="post">
                                    <input type="date" name="date" required>
                                    <input type="hidden" name="id" value="<%= validation.get(i).getIdValidation() %>" >                  
                                    <input type="hidden" name="unite" value="<%= validation.get(i).getIdUnite() %>" >
                                    <button>Valider</button>
                                </form>
                            </td>
                        </tr>
                    <% } %>
                </table>
        </div>
    </body>
</html>
