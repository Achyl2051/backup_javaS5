<%-- 
    Document   : index
    Created on : 28 janv. 2024, 16:52:40
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
                background-color: #f5f5f5;
                margin: 20px;
            }

            h1 {
                color: #333;
            }

            form {
                margin-top: 20px;
            }

            input[type="text"] {
                padding: 10px;
                width: 200px;
            }

            input[type="submit"] {
                padding: 10px;
                background-color: #4CAF50;
                color: white;
                border: none;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <h1>Inserer U.U</h1>
        <form action="Lister" method="post">
            <input type="text" name="request" >
            <input type="submit" value="rechercher">
        </form>
    </body>
</html>
