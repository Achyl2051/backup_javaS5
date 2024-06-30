/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import connection.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author tahir
 */
public class Sortie {
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

    public Sortie() {
    }

    public Sortie(int idSortie, int idArticle, int idEntre, Date date, double quantite) {
        this.setIdSortie(idSortie);
        this.setIdArticle(idArticle);
        this.setIdEntre(idEntre);
        this.setDate(date);
        this.setQuantite(quantite);
    }

    public Sortie(int idArticle, int idEntre, Date date, double quantite) {
        this.setIdArticle(idArticle);
        this.setIdEntre(idEntre);
        this.setDate(date);
        this.setQuantite(quantite);
    }   
    
    public Sortie(int idArticle, int idEntre, Date date, double quantite,int idValidation) {
        this.setIdArticle(idArticle);
        this.setIdEntre(idEntre);
        this.setDate(date);
        this.setQuantite(quantite);
        this.setIdValidation(idValidation);
    }   
    
    public void insertSortie(int idArticle,int idEntre,Date daty,double quantite,int idValidation)throws Exception
    {
        Connection connecting = new Connect().getConnection();
        String req = "INSERT INTO sortie (idArticle, idEntre, date, quantite, idValidation) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
        pstmt.setInt(1, idArticle);
        pstmt.setInt(2, idEntre);
        pstmt.setDate(3, new java.sql.Date(daty.getTime()));
        pstmt.setDouble(4, quantite);
        pstmt.setInt(5, idValidation);
        pstmt.executeUpdate();
        connecting.close();
    }
    
    public double totalStock(Vector<EtatStock> tab)
    {
        double result=0;
        for(int i=0;i<tab.size();i++)
        {
            result+=tab.get(i).getStock_actuel();
        }
        return result;
    }
    
    public void sortiStock(int idArticle,int idMagasin,Date daty,double quantite,int idValidation,int idUnite) throws Exception 
    {
        Article article = new Article().getArticleById(idArticle);
        Vector<EtatStock> etatStock=new EtatStock().getEtatStockByProduit(idArticle, daty, idMagasin);
        if(article.getType().equalsIgnoreCase("LIFO")){
            Collections.reverse(etatStock);
        }
        double quantiterest = quantite;
        int count=0;
        for(int i=0;i<etatStock.size();i++){
            if(this.totalStock(etatStock)<quantite){
                throw new Exception("Tsy ampy ny stock");
            }
            if(new Validation().lastSortie(idArticle, idMagasin).compareTo(daty)>0){
                throw new Exception("Jereo fa misy olana ilay date");
            }
            else{
                double qte = 0;
                if(quantiterest>=etatStock.get(i).getStock_actuel()){
                    qte = etatStock.get(i).getStock_actuel();
                }else{
                    qte = quantiterest;
                }
                if(quantiterest!=0){
                    this.insertSortie(idArticle,etatStock.get(i).getIdEntre(),daty,qte,idValidation);
                    if(count==0)
                    {
                        new Hist_s().insertSortie(idArticle,etatStock.get(i).getIdEntre(),daty,qte,idValidation);
                        count+=1;
                    }
                    quantiterest -= qte; 
                }else{
                    return;
                }
            }
        }
    }
}
