<%-- 
    Document   : navbar
    Created on : 20 nov. 2023, 19:27:39
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
                <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }

            header {
                background-color: #333;
                color: #fff;
                padding: 15px;
                text-align: center;
            }

            nav {
                display: flex;
                justify-content: center;
                background-color: #444;
            }

            nav a {
                color: #fff;
                text-decoration: none;
                padding: 15px;
                margin: 5px;
                border-radius: 5px;
            }

            nav a:hover {
                background-color: #555;
            }
        </style>
    </head>
    <body>
        <nav>
            <a href="index.jsp">Acceuil</a>
            <a href="EntreDeStock">Entre de stock</a>
            <a href="EtatDeStock">Etat de stock</a>
            <a href="Validation">Validation</a>
            <a href="SortieDeStock">Sortie de stock</a>
            <a href="ShowHist">Historique</a>
        </nav>
    </body>
</html>
