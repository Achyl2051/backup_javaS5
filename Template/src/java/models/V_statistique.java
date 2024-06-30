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
public class V_statistique {
    int idMeuble;
    String nom;
    int homme,femme;

    public int getIdMeuble() {
        return idMeuble;
    }

    public void setIdMeuble(int idMeuble) {
        this.idMeuble = idMeuble;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getHomme() {
        return homme;
    }

    public void setHomme(int homme) {
        this.homme = homme;
    }

    public int getFemme() {
        return femme;
    }

    public void setFemme(int femme) {
        this.femme = femme;
    }

    public V_statistique() {
    }

    public V_statistique(int idMeuble, String nom, int homme, int femme) {
        this.idMeuble = idMeuble;
        this.nom = nom;
        this.homme = homme;
        this.femme = femme;
    }

    public Vector<V_statistique> getAll()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select*from v_statistique";
        ResultSet render = stmt.executeQuery(req);
        Vector<V_statistique> result = new Vector<V_statistique>();
        while(render.next()){
            result.add(new V_statistique(render.getInt(1),render.getString(2),render.getInt(3),render.getInt(4)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    
    public Vector<V_statistique> getByMeuble(String idmeuble)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select*from v_statistique where idmeuble="+idmeuble;
        ResultSet render = stmt.executeQuery(req);
        Vector<V_statistique> result = new Vector<V_statistique>();
        while(render.next()){
            result.add(new V_statistique(render.getInt(1),render.getString(2),render.getInt(3),render.getInt(4)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
