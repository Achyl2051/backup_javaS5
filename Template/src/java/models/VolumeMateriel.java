/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import connection.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author tahir
 */
public class VolumeMateriel {
    int idVolumeMateriel;
    int idVolume;
    int idMateriel;
    int idMeuble;
    double quantite;

    public int getIdVolumeMateriel() {
        return idVolumeMateriel;
    }

    public void setIdVolumeMateriel(int idVolumeMateriel) {
        this.idVolumeMateriel = idVolumeMateriel;
    }

    public int getIdVolume() {
        return idVolume;
    }

    public void setIdVolume(int idVolume) {
        this.idVolume = idVolume;
    }

    public int getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public int getIdMeuble() {
        return idMeuble;
    }

    public void setIdMeuble(int idMeuble) {
        this.idMeuble = idMeuble;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public VolumeMateriel() {
    }

    public VolumeMateriel(int idVolume, int idMateriel, int idMeuble, double quantite) {
        this.idVolume = idVolume;
        this.idMateriel = idMateriel;
        this.idMeuble = idMeuble;
        this.quantite = quantite;
    }
    
    public void insert()throws Exception
    {
        Connection connecting = new Connect().getConnection();
        String req = "INSERT INTO volumeMateriel(idVolume,idMateriel,idMeuble,quantite) VALUES (?,?,?,?)";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
        pstmt.setInt(1, this.getIdVolume());
        pstmt.setInt(2, this.getIdMateriel());
        pstmt.setInt(3, this.getIdMeuble());
        pstmt.setDouble(4, this.getQuantite());
        pstmt.executeUpdate();
        connecting.close();
    }
}
