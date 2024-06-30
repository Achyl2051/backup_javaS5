<%-- 
    Document   : CarteResult
    Created on : 20 oct. 2023, 15:17:12
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Foncier.Bornes" %>
<%@ page import="java.util.ArrayList" %>
<%
    ArrayList<Bornes> bornes= (ArrayList<Bornes>)request.getAttribute("bornes");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" />
        <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>

        <title>JSP Page</title>
    </head>
    <body>
        <div id="map" style="width: 600px; height: 400px;"></div>
        
        <script>
            var map = L.map('map').setView([-18.8792, 47.5079], 14); // Ajustez le niveau de zoom

            L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            }).addTo(map);

            // Créer un tableau pour stocker les marqueurs
            var markers = [];

            // Parcourir la liste des bornes et ajouter des marqueurs pour chaque paire de coordonnées
            <%
                for (Bornes borne : bornes) {
            %>
                markers.push(L.marker([<%= borne.getLatitude() %>, <%= borne.getLongitude() %>]));
            <%
                }
            %>

            // Ajoutez les marqueurs au groupe de marqueurs
            var markersGroup = L.layerGroup(markers);
            markersGroup.addTo(map);

            // Créer un polygone en reliant les marqueurs
            var polygon = L.polygon([
                // Vous pouvez également parcourir la liste des bornes pour créer le polygone
                <%
                    for (Bornes borne : bornes) {
                %>
                    [<%= borne.getLatitude() %>, <%= borne.getLongitude() %>],
                <%
                    }
                %>
            ]).addTo(map);

            // Centrer la carte sur le périmètre
            map.fitBounds(polygon.getBounds());
        </script>
    </body>
</html>
