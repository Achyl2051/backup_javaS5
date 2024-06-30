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
public class Meuble {
    int idMeuble;
    int idStyle;
    int idCategorie;
    int nombreMpiasa;

    public int getIdMeuble() {
        return idMeuble;
    }

    public void setIdMeuble(int idMeuble) {
        this.idMeuble = idMeuble;
    }

    public int getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(int idStyle) {
        this.idStyle = idStyle;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public int getNombreMpiasa() {
        return nombreMpiasa;
    }

    public void setNombreMpiasa(int nombreMpiasa) {
        this.nombreMpiasa = nombreMpiasa;
    }

    public Meuble() {
    }

    public Meuble(int idMeuble, int idStyle, int idCategorie) {
        this.idMeuble = idMeuble;
        this.idStyle = idStyle;
        this.idCategorie = idCategorie;
    }

    public Meuble(int idStyle, int idCategorie) {
        this.idStyle = idStyle;
        this.idCategorie = idCategorie;
    }

    public Meuble(int idMeuble, int idStyle, int idCategorie, int nombreMpiasa) {
        this.idMeuble = idMeuble;
        this.idStyle = idStyle;
        this.idCategorie = idCategorie;
        this.nombreMpiasa = nombreMpiasa;
    }
    
    public void insert()throws Exception
    {
        Connection connecting = new Connect().getConnection();
        String req = "INSERT INTO meuble(idStyle,idCategorie,nombreMpiasa) VALUES (?,?,?)";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
        pstmt.setInt(1, this.getIdStyle());
        pstmt.setInt(2, this.getIdCategorie());
        pstmt.setInt(3, this.getNombreMpiasa());
        pstmt.executeUpdate();
        connecting.close();
    }
    
    public Vector<Meuble> getAll()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from meuble";
        ResultSet render = stmt.executeQuery(req);
        Vector<Meuble> result = new Vector<Meuble>();
        while(render.next()){
            result.add(new Meuble(render.getInt(1),render.getInt(2),render.getInt(3),render.getInt(4)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    
    public Meuble getMeubleByID(int id)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from meuble where idMeuble="+id;
        ResultSet render = stmt.executeQuery(req);
        Meuble result = null;
        while(render.next()){
            result=new Meuble(render.getInt(1),render.getInt(2),render.getInt(3),render.getInt(4));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
