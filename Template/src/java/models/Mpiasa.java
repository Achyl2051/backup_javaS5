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
public class Mpiasa {
    int idMpiasa;
    String nom;
    double tarif;

    public int getIdMpiasa() {
        return idMpiasa;
    }

    public void setIdMpiasa(int idMpiasa) {
        this.idMpiasa = idMpiasa;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }
    

    public Mpiasa(int idMpiasa, String nom, double tarif) {
        this.idMpiasa = idMpiasa;
        this.nom = nom;
        this.tarif = tarif;
    }

    public Mpiasa(String nom, double tarif) {
        this.nom = nom;
        this.tarif = tarif;
    }
    
    

    public Mpiasa() {
    }
    
    public void insert()throws Exception
    {
        Connection connecting = new Connect().getConnection();
        String req = "INSERT INTO mpiasa(nom,tarif) VALUES (?,?)";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
        pstmt.setString(1, this.getNom());
        pstmt.setDouble(2, this.getTarif());
        pstmt.executeUpdate();
        connecting.close();
    }
    
    public Vector<Mpiasa> getAll()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from mpiasa";
        ResultSet render = stmt.executeQuery(req);
        Vector<Mpiasa> result = new Vector<Mpiasa>();
        while(render.next()){
            result.add(new Mpiasa(render.getInt(1),render.getString(2),render.getDouble(3)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    
    
}
