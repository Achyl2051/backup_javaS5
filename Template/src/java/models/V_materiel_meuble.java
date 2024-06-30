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
public class V_materiel_meuble {
    int idVolume;
    int idMateriel;
    int idMeuble;
    String categorie;
    String style;
    String volume;
    double quantite;
    String materiel;

    public int getIdVolume() {
        return idVolume;
    }

    public void setIdVolume(int idVolume) {
        this.idVolume = idVolume;
    }

    public int getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public int getIdMeuble() {
        return idMeuble;
    }

    public void setIdMeuble(int idMeuble) {
        this.idMeuble = idMeuble;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public String getMateriel() {
        return materiel;
    }

    public void setMateriel(String materiel) {
        this.materiel = materiel;
    }

    public V_materiel_meuble() {
    }

    public V_materiel_meuble(int idVolume, int idMateriel, int idMeuble, String categorie, String style, String volume, double quantite, String materiel) {
        this.idVolume = idVolume;
        this.idMateriel = idMateriel;
        this.idMeuble = idMeuble;
        this.categorie = categorie;
        this.style = style;
        this.volume = volume;
        this.quantite = quantite;
        this.materiel = materiel;
    }
    
    public Vector<V_materiel_meuble> getMaterielMeuble(int idMeuble,int idVolume,double quantite) throws Exception
    {
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
        String req = "select*from v_stock_meuble where idmeuble="+idMeuble+" and idvolume="+idVolume;
        ResultSet render = stmt.executeQuery(req);
        Vector<V_materiel_meuble> result = new Vector<V_materiel_meuble>();
        while(render.next()){
            result.add(new V_materiel_meuble(render.getInt(1),render.getInt(2),render.getInt(3),render.getString(4),render.getString(5),render.getString(6),render.getDouble(7)*quantite,render.getString(8)));
        }
        stmt.close();
        connecting.close();
        return result;
    }
    
    public String fabrication(int idMeuble,int idVolume,double quantite) throws Exception
    {
        Vector<V_materiel_meuble> materielMeuble=this.getMaterielMeuble(idMeuble, idVolume, quantite);
        Vector<MeubleVolume> meuble=new MeubleVolume().getById(idMeuble, idVolume);
        for(int i=0;i<materielMeuble.size();i++)
        {
            Vector<EtatDeStock> etatStockTemp=new EtatDeStock().getAll(String.valueOf(materielMeuble.get(i).getIdMateriel()));
            if(etatStockTemp.get(0).getStock_actuel()<materielMeuble.get(i).getQuantite())
            {
                return "tsy ampy ilay stock";
            }
        }
        System.out.println("first boucle");
        for(int j=0;j<materielMeuble.size();j++)
        {
            new SortieStock(materielMeuble.get(j).getIdMateriel(),materielMeuble.get(j).getQuantite()).insert();
            new StockVente(meuble.get(0).getMeuble()+" "+meuble.get(0).getVolume(),idMeuble,idVolume,(int)quantite).insert();
        }
        return "";
    }
}
