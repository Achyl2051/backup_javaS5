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
public class Equivalence {
    int idEquivalence;
    int idArticle;
    int idUnite;
    double poids;
    String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public int getIdEquivalence() {
        return idEquivalence;
    }

    public void setIdEquivalence(int idEquivalence) {
        this.idEquivalence = idEquivalence;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public int getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(int idUnite) {
        this.idUnite = idUnite;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public Equivalence() {
    }

    public Equivalence(int idEquivalence, int idArticle, int idUnite, double poids,String nom) {
        this.setIdEquivalence(idEquivalence);
        this.setIdArticle(idArticle);
        this.setIdUnite(idUnite);
        this.setPoids(poids);
        this.setNom(nom);
    }
    
    public Vector<Equivalence> getEquivalence()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select u.*,unite.nom from unite_equivalence as u join unite on unite.idUnite=u.idUnite";
        ResultSet render = stmt.executeQuery(req);
        Vector<Equivalence> result = new Vector<Equivalence>();
        while(render.next()){
            result.add(new Equivalence(render.getInt(1),render.getInt(2),render.getInt(3),render.getDouble(4),render.getString(5)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    
    public Equivalence getEquivalenceById(int idUnite,int idArticle)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select u.*,unite.nom from unite_equivalence as u join unite on unite.idUnite=u.idUnite where u.idUnite="+idUnite+" and u.idArticle="+idArticle;
        ResultSet render = stmt.executeQuery(req);
        Equivalence result = null;
        while(render.next()){
            result=new Equivalence(render.getInt(1),render.getInt(2),render.getInt(3),render.getDouble(4),render.getString(5));
	}
        if(result==null)
        {
            throw new Exception("Tsy anazy ilay Unite");
        }
        stmt.close();
        connecting.close();
        return result;
    }
    
    public Unite getUniteById(int id)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select u.idunite,unite.nom from unite_equivalence as u join unite on unite.idUnite=u.idUnite where u.idEquivalence=" +id;
        ResultSet render = stmt.executeQuery(req);
        Unite result = new Unite();
        while(render.next()){
            result=new Unite(render.getInt(1),render.getString(2));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
