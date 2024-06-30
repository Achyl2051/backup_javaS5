<%-- 
    Document   : information
    Created on : 17 janv. 2024, 09:16:55
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.*, java.util.*" %>
<%
    Vector<Symptome> symptomes = (Vector<Symptome>) request.getAttribute("symptomes");
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
        }
        
        h1 {
            color: #333;
        }
        
        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        
        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
        }
        
        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        
        button {
            background-color: #4caf50;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <form method="post" action="Result">
        <h1>Entrer les informations:</h1>
        
        <div>
            <label for="inputText">Age</label>
            <div>
                <input type="number" name="age" value="1" required>
            </div>
        </div>
        
        <% for (int i = 0; i < symptomes.size(); i++) { %>

            <div>
                <label for="inputText"><%= symptomes.get(i).getDesignation() %></label>
                <div>
                    <input type="number" name="<%= symptomes.get(i).getIdSymptome() %>" step="0.01" value="0" required>
                </div>
            </div>

        <% } %>
              
        <div>
            <button type="submit">Consulter</button>
        </div>
    </form>
</body>
</html>

