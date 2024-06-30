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
public class Style {
    int idStyle;
    String nom;

    public int getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(int idStyle) {
        this.idStyle = idStyle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws Exception {
            this.nom = nom;
    }

    public Style() {
    }

    public Style(int idStyle, String nom) throws Exception {
        this.setIdStyle(idStyle);
        this.setNom(nom);
    }
    
    public Style(String nom) throws Exception {
        this.setNom(nom);
    }
    
    public void insert()throws Exception
    {
        Connection connecting = new Connect().getConnection();
        String req = "INSERT INTO style(nom) VALUES (?)";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
        pstmt.setString(1, this.getNom());
        pstmt.executeUpdate();
        connecting.close();
    }
    
    public Vector<Style> getAll()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from style";
        ResultSet render = stmt.executeQuery(req);
        Vector<Style> result = new Vector<Style>();
        while(render.next()){
            result.add(new Style(render.getInt(1),render.getString(2)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
