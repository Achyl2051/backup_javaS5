/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import connection.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Lenovo Legion
 */
public class V_produit {
    int idMeuble;
    int idVolume;
    String nom;
    int stock;

    public int getIdMeuble() {
        return idMeuble;
    }

    public void setIdMeuble(int idMeuble) {
        this.idMeuble = idMeuble;
    }

    public int getIdVolume() {
        return idVolume;
    }

    public void setIdVolume(int idVolume) {
        this.idVolume = idVolume;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public V_produit() {
    }

    public V_produit(int idMeuble, int idVolume, String nom, int stock) {
        this.idMeuble = idMeuble;
        this.idVolume = idVolume;
        this.nom = nom;
        this.stock = stock;
    }
    
    public Vector<V_produit> getAll()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from V_produit";
        ResultSet render = stmt.executeQuery(req);
        Vector<V_produit> result = new Vector<V_produit>();
        while(render.next()){
            result.add(new V_produit(render.getInt(1),render.getInt(2),render.getString(3),render.getInt(4)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    public Vector<V_produit> getById(int idMeuble,int idVolume)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from V_produit where idMeuble="+idMeuble+" and idVolume="+idVolume;
        ResultSet render = stmt.executeQuery(req);
        Vector<V_produit> result = new Vector<V_produit>();
        while(render.next()){
            result.add(new V_produit(render.getInt(1),render.getInt(2),render.getString(3),render.getInt(4)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
