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
 * @author Lenovo Legion
 */
public class StockVente {
        int idStockVente;
        String nom;
        int idMeuble;
        int idVolume;
        int quantite;

    public int getIdStockVente() {
        return idStockVente;
    }

    public void setIdStockVente(int idStockVente) {
        this.idStockVente = idStockVente;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public StockVente() {
    }

    public StockVente(int idStockVente, String nom, int idMeuble, int idVolume, int quantite) {
        this.idStockVente = idStockVente;
        this.nom = nom;
        this.idMeuble = idMeuble;
        this.idVolume = idVolume;
        this.quantite = quantite;
    }

    public StockVente(String nom, int idMeuble, int idVolume, int quantite) {
        this.nom = nom;
        this.idMeuble = idMeuble;
        this.idVolume = idVolume;
        this.quantite = quantite;
    }
        
    public void insert()throws Exception
    {
        Connection connecting = new Connect().getConnection();
        String req = "INSERT INTO StockVente(nom,idMeuble,idVolume,quantite) VALUES (?,?,?,?)";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
        pstmt.setString(1, this.getNom());
        pstmt.setInt(2, this.getIdMeuble());
        pstmt.setInt(3, this.getIdVolume());
        pstmt.setInt(4, this.getQuantite());
        pstmt.executeUpdate();
        connecting.close();
    }
    
     public Vector<StockVente> getAll()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from V_produit";
        ResultSet render = stmt.executeQuery(req);
        Vector<StockVente> result = new Vector<StockVente>();
        while(render.next()){
            result.add(new StockVente(render.getString("nom"),render.getInt("idMeuble"),render.getInt("idVolume"),render.getInt("stock")));
	}
        stmt.close();
        connecting.close();
        return result;
    }
     
     public boolean testStock(int idMeuble,int idVolume,int quantite)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from V_produit where idMeuble="+idMeuble+" and idVolume="+idVolume;
        ResultSet render = stmt.executeQuery(req);
        StockVente result = new StockVente();
        while(render.next()){
            result=new StockVente(render.getString("nom"),render.getInt("idMeuble"),render.getInt("idVolume"),render.getInt("stock"));
	}
        stmt.close();
        connecting.close();
        
        if(quantite<=result.getQuantite()){
            return true;
        }
        else{
        return false;
        }
    }
     
     public StockVente getMeuble(int idMeuble,int idVolume)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from V_produit where idMeuble="+idMeuble+" and idVolume="+idVolume;
        ResultSet render = stmt.executeQuery(req);
        StockVente result = new StockVente();
        while(render.next()){
            result=new StockVente(render.getString("nom"),render.getInt("idMeuble"),render.getInt("idVolume"),render.getInt("stock"));
	}
        stmt.close();
        connecting.close();
      
        return result;
    }
}
