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
public class Hist_s {
    int idSortie;
    int idArticle;
    int idEntre;
    int idValidation;

    public int getIdValidation() {
        return idValidation;
    }

    public void setIdValidation(int idValidation) {
        this.idValidation = idValidation;
    }
    
    Date date;
    double quantite;

    public int getIdSortie() {
        return idSortie;
    }

    public void setIdSortie(int idSortie) {
        this.idSortie = idSortie;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public int getIdEntre() {
        return idEntre;
    }

    public void setIdEntre(int idEntre) {
        this.idEntre = idEntre;
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

    public Hist_s() {
    }

    public Hist_s(int idSortie, int idArticle, int idEntre, int idValidation, Date date, double quantite) {
        this.idSortie = idSortie;
        this.idArticle = idArticle;
        this.idEntre = idEntre;
        this.idValidation = idValidation;
        this.date = date;
        this.quantite = quantite;
    }
    
    public void insertSortie(int idArticle,int idEntre,Date daty,double quantite,int idValidation)throws Exception
    {
        Connection connecting = new Connect().getConnection();
        String req = "INSERT INTO hist_s (idArticle, idEntre, date, quantite, idValidation) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
        pstmt.setInt(1, idArticle);
        pstmt.setInt(2, idEntre);
        pstmt.setDate(3, new java.sql.Date(daty.getTime()));
        pstmt.setDouble(4, quantite);
        pstmt.setInt(5, idValidation);
        pstmt.executeUpdate();
        connecting.close();
    }
    
    public Vector<Hist_s> getHist()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from hist_s";
        ResultSet render = stmt.executeQuery(req);
        Vector<Hist_s> result = new Vector<Hist_s>();
        while(render.next()){
            result.add(new Hist_s(render.getInt(1),render.getInt(2),render.getInt(3),render.getInt(4),render.getDate(5),render.getDouble(6)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
