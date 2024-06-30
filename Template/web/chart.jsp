<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Double Graphique JSP sans Chart.js</title>
</head>
<body>

    <h1>Double Graphique JSP sans Chart.js</h1>

    <!-- Ajoutez les éléments pour afficher les deux graphiques -->
    <div id="graphiqueContainer1" style="width: 400px; height: 300px; float: left;"></div>
    <div id="graphiqueContainer2" style="width: 400px; height: 300px; float: left;"></div>

    <!-- Ajoutez le script JavaScript pour générer les deux graphiques -->
    <script>
        // Données communes des étiquettes
        var labels = ['Janvier', 'Février', 'Mars', 'Avril', 'Mai'];

        // Données du premier graphique (exemple)
        var data1 = [10, 20, 15, 25, 30];

        // Créer le premier graphique
        var canvas1 = document.createElement('canvas');
        canvas1.width = 400;
        canvas1.height = 300;
        document.getElementById('graphiqueContainer1').appendChild(canvas1);

        var ctx1 = canvas1.getContext('2d');
        ctx1.fillStyle = 'lightblue';
        ctx1.strokeStyle = 'blue';

        // Dessiner les barres du premier graphique
        for (var i = 0; i < data1.length; i++) {
            var barHeight1 = data1[i] * 5; // Ajustez la hauteur des barres selon vos besoins
            var x1 = i * 80; // Espace entre les barres
            var y1 = canvas1.height - barHeight1;

            ctx1.fillRect(x1, y1, 60, barHeight1);
            ctx1.strokeRect(x1, y1, 60, barHeight1);
        }

        // Ajouter les étiquettes
        ctx1.fillStyle = 'black';
        ctx1.font = '14px Arial';
        for (var i = 0; i < labels.length; i++) {
            var x1 = i * 80 + 30; // Position des étiquettes
            var y1 = canvas1.height - 10;

            ctx1.fillText(labels[i], x1, y1);
        }

        // Données du deuxième graphique (exemple)
        var data2 = [15, 25, 20, 30, 35];

        // Créer le deuxième graphique
        var canvas2 = document.createElement('canvas');
        canvas2.width = 400;
        canvas2.height = 300;
        document.getElementById('graphiqueContainer2').appendChild(canvas2);

        var ctx2 = canvas2.getContext('2d');
        ctx2.fillStyle = 'lightgreen';
        ctx2.strokeStyle = 'green';

        // Dessiner les barres du deuxième graphique
        for (var i = 0; i < data2.length; i++) {
            var barHeight2 = data2[i] * 5; // Ajustez la hauteur des barres selon vos besoins
            var x2 = i * 80 + 40; // Décalage pour être à côté des barres du premier graphique
            var y2 = canvas2.height - barHeight2;

            ctx2.fillRect(x2, y2, 60, barHeight2);
            ctx2.strokeRect(x2, y2, 60, barHeight2);
        }

        // Ajouter les étiquettes (utilise les mêmes étiquettes que le premier graphique)
        ctx2.fillStyle = 'black';
        ctx2.font = '14px Arial';
        for (var i = 0; i < labels.length; i++) {
            var x2 = i * 80 + 30; // Position des étiquettes
            var y2 = canvas2.height - 10;

            ctx2.fillText(labels[i], x2, y2);
        }
    </script>

</body>
</html>
