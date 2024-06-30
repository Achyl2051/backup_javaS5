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
public class MeubleMpiasa {
    int idMeubleMpiasa;
    int idMeuble;
    int idVolume;
    int idMpiasa;
    int nombre;

    public int getIdMeubleMpiasa() {
        return idMeubleMpiasa;
    }

    public void setIdMeubleMpiasa(int idMeubleMpiasa) {
        this.idMeubleMpiasa = idMeubleMpiasa;
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

    public int getIdMpiasa() {
        return idMpiasa;
    }

    public void setIdMpiasa(int idMpiasa) {
        this.idMpiasa = idMpiasa;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public MeubleMpiasa() {
    }

    public MeubleMpiasa(int idMeuble, int idVolume, int idMpiasa, int nombre) {
        this.idMeuble = idMeuble;
        this.idVolume = idVolume;
        this.idMpiasa = idMpiasa;
        this.nombre = nombre;
    }
    
    public void insert()throws Exception
    {
        Connection connecting = new Connect().getConnection();
        String req = "INSERT INTO MeubleMpiasa(idMeuble,idVolume,idMpiasa,nombre) VALUES (?,?,?,?)";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
        pstmt.setInt(1, this.getIdMeuble());
        pstmt.setInt(2, this.getIdVolume());
        pstmt.setInt(3, this.getIdMpiasa());
        pstmt.setInt(4, this.getNombre());
        pstmt.executeUpdate();
        connecting.close();
    }
}
