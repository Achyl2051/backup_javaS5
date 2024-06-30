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
public class Unite {
    int idUnite;
    String nom;

    public int getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(int idUnite) {
        this.idUnite = idUnite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Unite() {
    }

    public Unite(int idUnite, String nom) {
        this.setIdUnite(idUnite);
        this.setNom(nom);
    }
    
    public Unite getUniteById(int id)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from unite where idunite="+id;
        ResultSet render = stmt.executeQuery(req);
        Unite result = new Unite();
        while(render.next()){
            result=new Unite(render.getInt(1),render.getString(2));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    
    public Vector<Unite> getUnite()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from unite";
        ResultSet render = stmt.executeQuery(req);
        Vector<Unite> result = new Vector<Unite>();
        while(render.next()){
            result.add(new Unite(render.getInt(1),render.getString(2)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
