<%-- 
    Document   : general
    Created on : 27 nov. 2023, 14:41:43
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        
        <div class="container">
            <h2>Choisir le bureau de vote</h2>
            <form action="ParBureau" method="post">
                <label for="codeBV">Code du bureau de vote :</label>
                <input type="text" id="codeBV" name="codeBV" required>

                <button type="submit">Voir le resultat</button>
            </form>
        </div>
    </body>
</html>
