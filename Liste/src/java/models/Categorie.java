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
public class Categorie {
    int idCategorie;
    String nom;

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie() {
    }

    public Categorie(int idCategorie, String nom) {
        this.idCategorie = idCategorie;
        this.nom = nom;
    }
    
    public Vector<Categorie> getAll()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from categorie";
        ResultSet render = stmt.executeQuery(req);
        Vector<Categorie> result = new Vector<Categorie>();
        while(render.next()){
            result.add(new Categorie(render.getInt(1),render.getString(2)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    
    public String categorie(String[] liste)throws Exception
    {
        Vector<Categorie> categories=this.getAll();
        for(int i=0;i<liste.length;i++)
        {
            for(int j=0;j<categories.size();j++)
            {
                if(liste[i].equalsIgnoreCase(categories.get(j).getNom()))
                {
                    return String.valueOf(categories.get(j).getIdCategorie());
                }
            }
        }
        return "";
    }
}
