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
public class Article {
    int idArticle;
    String code;
    String nom;
    String type;

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public Article() {
    }

    public Article(int idArticle, String code, String nom, String type) {
        this.setIdArticle(idArticle);
        this.setCode(code);
        this.setNom(nom);
        this.setType(type);
    }
    
    public Vector<Article> getArticle()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from article";
        ResultSet render = stmt.executeQuery(req);
        Vector<Article> result = new Vector<Article>();
        while(render.next()){
            result.add(new Article(render.getInt(1),render.getString(2),render.getString(3),render.getString(4)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    
    public Article getArticleById(int idArticle)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from article where idArticle="+idArticle;
        ResultSet render = stmt.executeQuery(req);
        Article result = new Article();
        while(render.next()){
            result=new Article(render.getInt(1),render.getString(2),render.getString(3),render.getString(4));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
