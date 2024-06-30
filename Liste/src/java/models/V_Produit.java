/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import connection.Connect;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author tahir
 */
public class V_Produit {
    int idProduit;
    int idCategorie;
    String nom;
    String categorie;
    double prix;
    double qualite;
    double qualitePrix;

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getQualite() {
        return qualite;
    }

    public void setQualite(double qualite) {
        this.qualite = qualite;
    }

    public double getQualitePrix() {
        return qualitePrix;
    }

    public void setQualitePrix(double qualitePrix) {
        this.qualitePrix = qualitePrix;
    }

    public V_Produit() {
    }

    public V_Produit(int idProduit, int idCategorie, String nom, String categorie, double prix, double qualite, double qualitePrix) {
        this.idProduit = idProduit;
        this.idCategorie = idCategorie;
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.qualite = qualite;
        this.qualitePrix = qualitePrix;
    }
    
    public Vector<V_Produit> getAll(String sql)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
        ResultSet render = stmt.executeQuery(sql);
        Vector<V_Produit> result = new Vector<V_Produit>();
        while(render.next()){
            result.add(new V_Produit(render.getInt(1),render.getInt(2),render.getString(3),render.getString(4),render.getDouble(5),render.getDouble(6),render.getDouble(7)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    
    public String attribut(String[] liste){
        for(int i=0;i<liste.length;i++)
        {
            if(this.estAttribut(liste[i]))
            {
                return liste[i];
            }
        }
        return "";
    }
    
    public boolean estAttribut(String mot) {
        Field[] champs = this.getClass().getDeclaredFields();
        for (Field champ : champs) {
            if (champ.getName().equalsIgnoreCase(mot)) {
                return true;
            }
        }
        return false;
    }
}
