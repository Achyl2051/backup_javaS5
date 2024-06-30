<%-- 
    Document   : testCarte
    Created on : 22 oct. 2023, 13:32:18
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

    <form action="TestTab" method="post" id="coordinateForm">
        <input type="hidden" name="coordinates" id="coordinates" value="">
        <input type="submit">
    </form>

    <script>
        var map = L.map('map').setView([-18.8792, 47.5079], 14);
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