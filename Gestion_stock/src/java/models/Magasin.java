/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import connection.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author tahir
 */
public class Magasin {
    int idMagasin;
    String nom;
    String localisation;
    Date ouverture;

    public int getIdMagasin() {
        return idMagasin;
    }

    public void setIdMagasin(int idMagasin) {
        this.idMagasin = idMagasin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Date getOuverture() {
        return ouverture;
    }

    public void setOuverture(Date ouverture) {
        this.ouverture = ouverture;
    }

    public Magasin() {
    }

    public Magasin(int idMagasin, String nom, String localisation, Date ouverture) {
        this.setIdMagasin(idMagasin);
        this.setNom(nom);
        this.setLocalisation(localisation);
        this.setOuverture(ouverture);
    }
    
    public Vector<Magasin> getMagasin()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from magasin";
        ResultSet render = stmt.executeQuery(req);
        Vector<Magasin> result = new Vector<Magasin>();
        while(render.next()){
            result.add(new Magasin(render.getInt(1),render.getString(2),render.getString(3),render.getDate(4)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    
    public Magasin getMagasinById(int id)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from magasin where idmagasin="+id;
        ResultSet render = stmt.executeQuery(req);
        Magasin result = new Magasin();
        while(render.next()){
            result=new Magasin(render.getInt(1),render.getString(2),render.getString(3),render.getDate(4));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
