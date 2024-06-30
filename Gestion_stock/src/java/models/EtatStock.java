/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import connection.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author tahir
 */
public class EtatStock {
    int idEntre;

    public int getIdEntre() {
        return idEntre;
    }

    public void setIdEntre(int idEntre) {
        this.idEntre = idEntre;
    }
    String code_article;
    String article;
    double stock_actuel;
    double prixUnitaire;
    double prixTotal;
    String magasin;

    public String getCode_article() {
        return code_article;
    }

    public void setCode_article(String code_article) {
        this.code_article = code_article;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public double getStock_actuel() {
        return stock_actuel;
    }

    public void setStock_actuel(double stock_actuel)throws Exception {
        if(stock_actuel<0)
        {
            throw new Exception("Nisy diso tany anaty insert ana entrer");
        }
        this.stock_actuel = stock_actuel;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) throws Exception{
        if(prixUnitaire<0)
        {
            throw new Exception("Nisy diso tany anaty insert ana entrer");
        }
        this.prixUnitaire = prixUnitaire;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }
    
    public void setPrixTotal() {
        this.prixTotal = this.getStock_actuel()*this.getPrixUnitaire();
    }


    public String getMagasin() {
        return magasin;
    }

    public void setMagasin(String magasin) {
        this.magasin = magasin;
    }

    public EtatStock() {
    }

    public EtatStock(String code_article, String article, double stock_actuel, double prixUnitaire, String magasin)throws Exception {
        this.setCode_article(code_article);
        this.setArticle(article);
        this.setStock_actuel(stock_actuel);
        this.setPrixUnitaire(prixUnitaire);
        this.setPrixTotal();
        this.setMagasin(magasin);
    }
    
    public EtatStock(int idEntre, String code_article, String article, double stock_actuel, double prixUnitaire, String magasin)throws Exception {
        this.setIdEntre(idEntre);
        this.setCode_article(code_article);
        this.setArticle(article);
        this.setStock_actuel(stock_actuel);
        this.setPrixUnitaire(prixUnitaire);
        this.setPrixTotal();
        this.setMagasin(magasin);
    }
    
    public Vector<EtatStock> getEtatStock(String code,String date,int magasin)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req ="SELECT " +
"                a.code AS code_article," +
"                a.nom AS article," +
"                COALESCE(quantite - qtt, quantite, 0) AS stock_actuel," +
"                e.prixUnitaire," +
"                m.nom AS magasin" +
"            FROM " +
"                entre e " +
"            LEFT JOIN " +
"                (SELECT sortie.idEntre,sum(sortie.quantite) AS qtt FROM sortie JOIN validation_sortie as v on sortie.idValidation = v.idValidation WHERE v.date_validation<='"+date+"' GROUP BY sortie.idEntre) AS s ON e.idEntre = s.idEntre" +
"            JOIN " +
"                article AS a ON e.idArticle = a.idArticle" +
"            JOIN " +
"                magasin AS m ON e.idMagasin = m.idMagasin" +
"            WHERE" +
"                e.date<='"+date+"'" +
"                AND a.code LIKE '%"+code+"%'" +
"                AND e.idMagasin="+magasin+" ORDER BY e.date";
        ResultSet render = stmt.executeQuery(req);
        Vector<EtatStock> result = new Vector<EtatStock>();
        while(render.next()){
            result.add(new EtatStock(render.getString(1),render.getString(2),render.getDouble(3),render.getDouble(4),render.getString(5)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    
    public Vector<Double> getTotalEtatStock(String code,String date,int magasin)throws Exception{
        Vector<EtatStock> etatStock=this.getEtatStock(code,date,magasin);
        double quantite=0;
        double montantTotal=0;
        for(int i=0;i<etatStock.size();i++)
        {
            quantite+=etatStock.get(i).getStock_actuel();
            montantTotal+=etatStock.get(i).getPrixTotal();
        }
        double prixUnitaire=montantTotal/quantite;
        Vector<Double> result=new Vector<Double>();
        result.add(quantite);
        result.add(prixUnitaire);
        result.add(montantTotal);
        return result;
    }
    
    public Vector<EtatStock> getEtatStockByProduit(int idArticle,Date date,int magasin)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req ="SELECT " +
"                e.idEntre," +
"                a.code AS code_article," +
"                a.nom AS article," +
"                COALESCE(quantite - qtt, quantite, 0) AS stock_actuel," +
"                e.prixUnitaire," +
"                m.nom AS magasin" +
"            FROM " +
"                entre e " +
"            LEFT JOIN " +
"                (SELECT sortie.idEntre,sum(sortie.quantite) AS qtt FROM sortie JOIN validation_sortie as v on sortie.idValidation = v.idValidation WHERE v.date_validation<='"+date+"' GROUP BY sortie.idEntre) AS s ON e.idEntre = s.idEntre" +
"            JOIN " +
"                article AS a ON e.idArticle = a.idArticle" +
"            JOIN " +
"                magasin AS m ON e.idMagasin = m.idMagasin" +
"            WHERE" +
"                e.date<='"+date+"'" +
"                AND a.idArticle="+idArticle +
"                AND e.idMagasin="+magasin+" ORDER BY e.date";
        ResultSet render = stmt.executeQuery(req);
        Vector<EtatStock> result = new Vector<EtatStock>();
        while(render.next()){
            result.add(new EtatStock(render.getInt(1),render.getString(2),render.getString(3),render.getDouble(4),render.getDouble(5),render.getString(6)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
