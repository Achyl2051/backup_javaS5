/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Foncier;

import jakarta.ejb.Stateless;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author tahir
 */
@Stateless
public class Bornes implements EjbBornes{
    int id;
    int idTerre;
    double latitude;
    double longitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTerre() {
        return idTerre;
    }

    public void setIdTerre(int idTerre) {
        this.idTerre = idTerre;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Bornes() {
    }

    public Bornes(int id, int idTerre, double latitude, double longitude) {
        this.id = id;
        this.idTerre = idTerre;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    @Override
    public ArrayList<Bornes> getBornes(String id){
        Connection connecting=null;
	ConFoncier connection=new ConFoncier();
	connecting=connection.getConnection();
        ArrayList<Bornes> result = new ArrayList<Bornes>();
        try{
            Statement stmt = connecting.createStatement();
            String req = "select*from bornes where idterre=" + id;
            ResultSet render = stmt.executeQuery(req);
            while(render.next()){
                Bornes temp=new Bornes(render.getInt(1),render.getInt(2),render.getDouble(3),render.getDouble(4));
                result.add(temp);
            }
            stmt.close();
            connecting.close();
        }
        catch(Exception e)
        {}
        return result;
    }
    
    @Override
    public void insertBornes(int idTerre,double latitude, double longitude) {
        Connection connection = null;
        ConFoncier conFoncier = new ConFoncier();
        connection = conFoncier.getConnection();

        try {
            // Utiliser PreparedStatement pour éviter les problèmes de sécurité liés aux requêtes SQL dynamiques
            String insertQuery = "INSERT INTO bornes (idterre,latitude, longitude) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(insertQuery);

            pstmt.setInt(1, idTerre);
            pstmt.setDouble(2, latitude);
            pstmt.setDouble(3, longitude);

            // Exécuter l'insertion et récupérer l'ID généré (ignorer le résultat)
            pstmt.executeQuery();
            pstmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();  // Gérer les erreurs d'accès à la base de données
        }
    }

    @Override
    public double calculerAire(ArrayList<Double> latitudes,ArrayList<Double> longitudes) {
        int numPoints = latitudes.size();
        double aireTotale = 0;

        if (numPoints > 2) {
            for (int i = 0; i < numPoints; i++) {
                double lat1=latitudes.get(i);
                double long1=longitudes.get(i);
                
                double lat2=latitudes.get((i+1)%numPoints); // Enroulement circulaire
                double long2=longitudes.get((i+1)%numPoints); // Enroulement circulaire

                aireTotale += radians(long2 - long1) * (2 + Math.sin(radians(lat1)) + Math.sin(radians(lat2)));
            }

            aireTotale = aireTotale * 6371000 * 6371000 / 2; // Rayon de la Terre en mètres
        }

        return Math.abs(aireTotale);
    }

    private static double radians(double degres) {
        return degres * Math.PI / 180.0;
    }
    
    @Override
    public double getPerimetre(ArrayList<Double> latitudes, ArrayList<Double> longitudes) {
        double perimeter = 0.0;
        for (int i = 0; i < latitudes.size() - 1; i++) {
            double lat1 = latitudes.get(i);
            double lon1 = longitudes.get(i);
            double lat2 = latitudes.get(i + 1);
            double lon2 = longitudes.get(i + 1);
            double distance = haversine(lat1, lon1, lat2, lon2);
            perimeter += distance * 1000; // Conversion en m tres
        }
        double lat1 = latitudes.get(latitudes.size() - 1);
        double lon1 = longitudes.get(latitudes.size() - 1);
        double lat2 = latitudes.get(0);
        double lon2 = longitudes.get(0);
        double distance = haversine(lat1, lon1, lat2, lon2);
        perimeter += distance * 1000; // Conversion en m tres

        return perimeter;
    }

    public double haversine(double lat1, double lon1, double lat2, double lon2) {
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);
        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;
        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = 6371 * c; // Distance en kilom tres
        return distance;
    }
    
}
