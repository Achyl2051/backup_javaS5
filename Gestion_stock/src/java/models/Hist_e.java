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
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author tahir
 */
public class Hist_e {
    int idEntre;
    int idArticle;
    int idMagasin;
    Date date;
    double quantite;
    double pu;

    public int getIdEntre() {
        return idEntre;
    }

    public void setIdEntre(int idEntre) {
        this.idEntre = idEntre;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public int getIdMagasin() {
        return idMagasin;
    }

    public void setIdMagasin(int idMagasin) {
        this.idMagasin = idMagasin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getPu() {
        return pu;
    }

    public void setPu(double pu) {
        this.pu = pu;
    }

    public Hist_e() {
    }

    public Hist_e(int idEntre, int idArticle, int idMagasin, Date date, double quantite, double pu) {
        this.idEntre = idEntre;
        this.idArticle = idArticle;
        this.idMagasin = idMagasin;
        this.date = date;
        this.quantite = quantite;
        this.pu = pu;
    }
    
    public void insertEntre(int idArticle,int idMagasin,Date daty,double quantite,double pu,int idUnite)throws Exception
    {
        Connection connecting = new Connect().getConnection();
        String req = "INSERT INTO hist_e (idArticle, idMagasin, date, quantite,prixUnitaire) VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
        pstmt.setInt(1, idArticle);
        pstmt.setInt(2, idMagasin);
        pstmt.setDate(3, new java.sql.Date(daty.getTime()));
        pstmt.setDouble(4, quantite);
        pstmt.setDouble(5, pu);
        pstmt.executeUpdate();
        connecting.close();
    }
    
    public Vector<Hist_e> getHist()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from hist_e";
        ResultSet render = stmt.executeQuery(req);
        Vector<Hist_e> result = new Vector<Hist_e>();
        while(render.next()){
            result.add(new Hist_e(render.getInt(1),render.getInt(2),render.getInt(3),render.getDate(4),render.getDouble(5),render.getDouble(6)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
