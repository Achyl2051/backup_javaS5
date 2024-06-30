/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import connection.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author tahir
 */
public class Categorie {
    int idCategorie;
    String nom;

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws Exception {
            this.nom = nom;
    }

    public Categorie() {
    }

    public Categorie(int idCategorie, String nom) throws Exception {
        this.setIdCategorie(idCategorie);
        this.setNom(nom);
    }
    
    public Categorie(String nom) throws Exception {
        this.setNom(nom);
    }
    
    public void insert()throws Exception
    {
        Connection connecting = new Connect().getConnection();
        String req = "INSERT INTO categorie(nom) VALUES (?)";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
        pstmt.setString(1, this.getNom());
        pstmt.executeUpdate();
        connecting.close();
    }
    
    public Vector<Categorie> getAll()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from categorie";
        ResultSet render = stmt.executeQuery(req);
        Vector<Categorie> result = new Vector<Categorie>();
        while(render.next()){
            result.add(new Categorie(render.getInt(1),render.getString(2)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
