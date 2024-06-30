/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import connection.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

/**
 *
 * @author Lenovo Legion
 */
public class EntreStock {
    int idMateriel;
    double quantite;
    Date date_entre;

    public int getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }


    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public Date getDate_entre() {
        return date_entre;
    }

    public void setDate_entre(Date date_entre) {
        this.date_entre = date_entre;
    }

    public EntreStock() {
    }

    public EntreStock(int idMateriel,double quantite, Date date_entre) {
        this.idMateriel = idMateriel;
        this.quantite = quantite;
        this.date_entre = date_entre;
    }
    public EntreStock(int idMateriel ,double quantite) {
        this.idMateriel = idMateriel;
        this.quantite = quantite;
    }
    
    public void insert()throws Exception
    {
        Connection connecting = new Connect().getConnection();
        String req = "INSERT INTO stock_entre(idMateriel,quantite) VALUES (?,?)";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
        pstmt.setInt(1, this.getIdMateriel());
        pstmt.setDouble(2, this.getQuantite());
        pstmt.executeUpdate();
        connecting.close();
    }
}
