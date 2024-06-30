<%-- 
    Document   : hist
    Created on : 23 nov. 2023, 14:34:58
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Vector" %>
<%@ page import="models.*" %>
<% Vector<Hist_s> sortie = (Vector<Hist_s>) request.getAttribute("hist_s"); %>
<% Vector<Hist_e> entre = (Vector<Hist_e>) request.getAttribute("hist_e"); %>
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
        
        <h1>Entre!</h1>
        <% for(int i=0;i<entre.size();i++){ %>
            <h2>entre:<%= i %></h2>
            <p>idEntre: <%= entre.get(i).getIdEntre() %></p>
            <p>idArticle: <%= entre.get(i).getIdArticle() %></p>
            <p>idMagasin: <%= entre.get(i).getIdMagasin() %></p>
            <p>date: <%= entre.get(i).getDate() %></p>
            <p>qtt: <%= entre.get(i).getQuantite() %></p>
            <p>pu: <%= entre.get(i).getPu() %></p>
        <% } %>
        
        <h1>Sortie!</h1>
        <% for(int i=0;i<sortie.size();i++){ %>
            <h2>sortie:<%= i %></h2>
            <p>idSortie <%= sortie.get(i).getIdSortie() %></p>
            <p>idArticle <%= sortie.get(i).getIdArticle() %></p>
            <p>idEntre: <%= sortie.get(i).getIdEntre() %></p>
            <p>idValidation: <%= sortie.get(i).getIdValidation() %></p>
            <p>Date: <%= sortie.get(i).getDate() %></p>
            <p>Quantite: <%= sortie.get(i).getQuantite() %></p>
        <% } %>
    </body>
</html>
