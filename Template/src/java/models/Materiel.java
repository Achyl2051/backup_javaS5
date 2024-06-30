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
 * @author tahir
 */
public class Materiel {
    int idMateriel;
    String nom;
    int idUnite;
    String unite;
    double pu;

    public int getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws Exception {
            this.nom = nom;
    }

    public int getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(int idUnite) {
        this.idUnite = idUnite;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public double getPu() {
        return pu;
    }

    public void setPu(double pu) {
        this.pu = pu;
    }

    public Materiel() {
    }

    public Materiel(int idMateriel, String nom) throws Exception {
        this.setIdMateriel(idMateriel);
        this.setNom(nom);
    }
    
    public Materiel(int idMateriel, String nom,int idUnite) throws Exception {
        this.setIdMateriel(idMateriel);
        this.setNom(nom);
        this.setIdUnite(idUnite);
    }
    
    public Materiel(int idMateriel, String nom,int idUnite,String unite) throws Exception {
        this.setIdMateriel(idMateriel);
        this.setNom(nom);
        this.setIdUnite(idUnite);
        this.setUnite(unite);
    }
    
    public Materiel(String nom) throws Exception {
        this.setNom(nom);
    }
    
    public Materiel(String nom,int idUnite) throws Exception {
        this.setNom(nom);
        this.setIdUnite(idUnite);
    }

    
    public Materiel(int idMateriel, String nom,int idUnite,String unite,double pu) throws Exception {
        this.setIdMateriel(idMateriel);
        this.setNom(nom);
        this.setIdUnite(idUnite);
        this.setUnite(unite);
        this.setPu(pu);
    }
    
        public Materiel(String nom,int idUnite,double pu) throws Exception {
        this.setNom(nom);
        this.setIdUnite(idUnite);
        this.setPu(pu);
    }
    
    public void insert()throws Exception
    {
        Connection connecting = new Connect().getConnection();
        String req = "INSERT INTO materiel(nom,idUnite,pu) VALUES (?,?,?)";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
        pstmt.setString(1, this.getNom());
        pstmt.setInt(2, this.getIdUnite());
        pstmt.setDouble(3,this.getPu());
        pstmt.executeUpdate();
        connecting.close();
    }
    
    public Vector<Materiel> getAll()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select idmateriel,m.nom,u.idunite,u.nom as unite from materiel m join unite u on u.idunite=m.idunite";
        ResultSet render = stmt.executeQuery(req);
        Vector<Materiel> result = new Vector<Materiel>();
        while(render.next()){
            result.add(new Materiel(render.getInt(1),render.getString(2),render.getInt(3),render.getString(4)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
