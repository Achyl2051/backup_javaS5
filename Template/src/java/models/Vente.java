/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import connection.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Lenovo Legion
 */
public class Vente {
    int idVente;
    String nom;
    int idMeuble;
    int idVolume;
    double prixVente;
    Date dateVente;
    int genre;
    int quantite;

    public int getIdVente() {
        return idVente;
    }

    public void setIdVente(int idVente) {
        this.idVente = idVente;
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

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    

    
    public Vente(int idVente, String nom, int idMeuble, int idVolume, double prixVente, Date dateVente, int genre,int quantite) {
        this.idVente = idVente;
        this.nom = nom;
        this.idMeuble = idMeuble;
        this.idVolume = idVolume;
        this.prixVente = prixVente;
        this.dateVente = dateVente;
        this.genre = genre;
        this.quantite=quantite;
    }

    public Vente(String nom, int idMeuble, int idVolume, double prixVente, Date dateVente, int genre,int quantite) {
        this.nom = nom;
        this.idMeuble = idMeuble;
        this.idVolume = idVolume;
        this.prixVente = prixVente;
        this.dateVente = dateVente;
        this.genre = genre;
        this.quantite=quantite;
    }

    public Vente() {
    }
    
    public void insert()throws Exception
    {
        Connection connecting = new Connect().getConnection();
        String req = "INSERT INTO Vente(nom,idMeuble,idVolume,prixVente,dateVente,genre,quantite) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
        pstmt.setString(1, this.getNom());
        pstmt.setInt(2, this.getIdMeuble());
        pstmt.setInt(3, this.getIdVolume());
        pstmt.setDouble(4, this.getPrixVente());
        pstmt.setDate(5, this.getDateVente());
        pstmt.setInt(6, this.getGenre());
        pstmt.setInt(7, this.getQuantite());
        pstmt.executeUpdate();
        connecting.close();
    }
    
}
