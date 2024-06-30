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

/**
 *
 * @author tahir
 */
public class Entre {
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

    public Entre() {
    }

    public Entre(int idEntre, int idArticle, int idMagasin, Date date, double quantite, double pu) {
        this.setIdEntre(idEntre);
        this.setIdArticle(idArticle);
        this.setIdMagasin(idMagasin);
        this.setDate(date);
        this.setQuantite(quantite);
        this.setPu(pu);
    }
    
    public Entre(int idArticle, int idMagasin, Date date, double quantite, double pu) {
        this.setIdArticle(idArticle);
        this.setIdMagasin(idMagasin);
        this.setDate(date);
        this.setQuantite(quantite);
        this.setPu(pu);
    }
    
    public void insertEntre(int idArticle,int idMagasin,Date daty,double quantite,double pu,int idUnite)throws Exception
    {
        Connection connecting = new Connect().getConnection();
        if(new Validation().lastSortie(idArticle, idMagasin).compareTo(daty)>0){
            throw new Exception("Jereo fa misy olana ilay date");
        }
        Equivalence equival=new Equivalence().getEquivalenceById(idUnite, idArticle);
        String req = "INSERT INTO entre (idArticle, idMagasin, date, quantite,prixUnitaire) VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
        pstmt.setInt(1, idArticle);
        pstmt.setInt(2, idMagasin);
        pstmt.setDate(3, new java.sql.Date(daty.getTime()));
        pstmt.setDouble(4, quantite*equival.getPoids());
        pstmt.setDouble(5, pu/equival.getPoids());
        pstmt.executeUpdate();
        connecting.close();
    }
    
}
