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
public class Terre implements EjbFoncier{
    int id;
    int cin;
    String terre_localisation;
    double superficie;
    double perimetre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getTerre_localisation() {
        return terre_localisation;
    }

    public void setTerre_localisation(String terre_localisation) {
        this.terre_localisation = terre_localisation;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }

    public double getPerimetre() {
        return perimetre;
    }

    public void setPerimetre(double perimetre) {
        this.perimetre = perimetre;
    }

    public Terre() {
    }

    public Terre(int id, int cin, String terre_localisation, double superficie, double perimetre) {
        this.id = id;
        this.cin = cin;
        this.terre_localisation = terre_localisation;
        this.superficie = superficie;
        this.perimetre = perimetre;
    }

    
    @Override
    public ArrayList<Terre> getTerre(String cin){
        Connection connecting=null;
	ConFoncier connection=new ConFoncier();
	connecting=connection.getConnection();
        ArrayList<Terre> result = new ArrayList<Terre>();
        try{
            Statement stmt = connecting.createStatement();
            String req = "select * from terre where cin=" + cin;
            ResultSet render = stmt.executeQuery(req);
            while(render.next()){
                Terre temp=new Terre(render.getInt(1),render.getInt(2),render.getString(3),render.getDouble(4),render.getDouble(5));
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
    public int insertTerre(int cin, String terre_localisation, double superficie, double perimetre) {
        Connection connection = null;
        ConFoncier conFoncier = new ConFoncier();
        connection = conFoncier.getConnection();

        int generatedId = -1;  // Initialiser l'ID généré à -1 (une valeur invalide) par défaut

        try {
            // Utiliser PreparedStatement pour éviter les problèmes de sécurité liés aux requêtes SQL dynamiques
            String insertQuery = "INSERT INTO terre (cin, terre_localisation, superficie,perimetre) VALUES (?, ?, ?,?) RETURNING id";
            PreparedStatement pstmt = connection.prepareStatement(insertQuery);

            pstmt.setInt(1, cin);
            pstmt.setString(2, terre_localisation);
            pstmt.setDouble(3, superficie);
            pstmt.setDouble(4, perimetre);

            // Exécuter l'insertion et récupérer l'ID généré
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                generatedId = resultSet.getInt(1);
            }

            pstmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return generatedId;  //
    }
}
