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
 * @author tahir
 */
public class Volume {
    int idVolume;
    String nom;

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

    public Volume() {
    }

    public Volume(int idVolume, String nom) {
        this.setIdVolume(idVolume);
        this.setNom(nom);
    }
    
    public Vector<Volume> getAll()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from volume";
        ResultSet render = stmt.executeQuery(req);
        Vector<Volume> result = new Vector<Volume>();
        while(render.next()){
            result.add(new Volume(render.getInt(1),render.getString(2)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
