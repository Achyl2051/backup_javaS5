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
public class ParametreFabrication {
    int idParametre;
    int idMeuble;
    int idVolume;
    double prixVente;
    double dureeFabrication;

    public ParametreFabrication() {
    }

    public ParametreFabrication(int idParametre, int idMeuble, int idVolume, double prixVente, double dureeFabrication) {
        this.idParametre = idParametre;
        this.idMeuble = idMeuble;
        this.idVolume = idVolume;
        this.prixVente = prixVente;
        this.dureeFabrication = dureeFabrication;
    }

    public ParametreFabrication(int idMeuble, int idVolume, double prixVente, double dureeFabrication) {
        this.idMeuble = idMeuble;
        this.idVolume = idVolume;
        this.prixVente = prixVente;
        this.dureeFabrication = dureeFabrication;
    }
    
    

    public int getIdParametre() {
        return idParametre;
    }

    public void setIdParametre(int idParametre) {
        this.idParametre = idParametre;
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

    public double getDureeFabrication() {
        return dureeFabrication;
    }

    public void setDureeFabrication(double dureeFabrication) {
        this.dureeFabrication = dureeFabrication;
    }
  
    public void insert()throws Exception
    {
        Connection connecting = new Connect().getConnection();
        String req = "INSERT INTO paramatreFabrication(idMeuble,idVolume,prixVente,dureeFabrication) VALUES (?,?,?,?)";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
        pstmt.setInt(1, this.getIdMeuble());
        pstmt.setInt(2, this.getIdVolume());
        pstmt.setDouble(3, this.getPrixVente());
        pstmt.setDouble(4, this.getDureeFabrication());
        
        pstmt.executeUpdate();
        connecting.close();
    }
    public Vector<ParametreFabrication> getById(int idMeuble,int idVolume)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from ParamatreFabrication";
        ResultSet render = stmt.executeQuery(req);
        Vector<ParametreFabrication> result = new Vector<ParametreFabrication>();
        while(render.next()){
            result.add(new ParametreFabrication(render.getInt(1),render.getInt(2),render.getInt(3),render.getDouble(4),render.getDouble(5)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
