<%-- 
    Document   : newTerreMap
    Created on : 22 oct. 2023, 14:48:58
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String cin= (String)request.getAttribute("cin");
    String localisation= (String)request.getAttribute("localisation");
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

        <form action="AjoutTerreMapOnServlet" method="post">
            <p>
                Superficie : <input type="number" name="superficie" step="0.0001">
            </p>
            <p>
                Perimetre : <input type="number" name="perimetre" step="0.00000000000000000001">
            </p>
            <input type="hidden" name="coordinates" id="coordinates" value="">
            <input type="hidden" name="cin" value="<%= cin %>">
            <input type="hidden" name="localisation" value="<%= localisation %>">
            <input type="submit">
        </form>

        <script>
            var map = L.map('map').setView([-18.971836007765056, 47.543453354481365], 18);
            L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            }).addTo(map);

            var coordinates = []; // Tableau pour stocker les coordonnées
            
            // Créer une couche de marqueurs
            var markerLayer = L.layerGroup().addTo(map);

            map.on('click', function(e) {
                var lat = e.latlng.lat;
                var lng = e.latlng.lng;
                
                // Créer un marqueur à l'emplacement du clic
                var marker = L.marker([lat, lng]).addTo(markerLayer);

                // Ajouter les coordonnées au tableau
                coordinates.push({ lat: lat, lng: lng });

                // Mettre à jour la valeur du champ de formulaire caché
                document.getElementById('coordinates').value = JSON.stringify(coordinates);
            });
        </script>
    </body>
</html>
