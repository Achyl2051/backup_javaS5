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
public class V_result {
    int idMateriel;
    int idMeuble;
    int idStyle;
    int idCategorie;
    String categorie;
    String style;
    String volume;
    double quantite;

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

    public int getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(int idStyle) {
        this.idStyle = idStyle;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
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

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
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

    public V_result() {
    }

    public V_result(int idMateriel, int idMeuble, int idStyle, int idCategorie, String categorie, String style, String volume) {
        this.idMateriel = idMateriel;
        this.idMeuble = idMeuble;
        this.idStyle = idStyle;
        this.idCategorie = idCategorie;
        this.categorie = categorie;
        this.style = style;
        this.volume = volume;
    }

    public V_result(int idMateriel, int idMeuble, int idStyle, int idCategorie, String categorie, String style, String volume, double quantite) {
        this.idMateriel = idMateriel;
        this.idMeuble = idMeuble;
        this.idStyle = idStyle;
        this.idCategorie = idCategorie;
        this.categorie = categorie;
        this.style = style;
        this.volume = volume;
        this.quantite = quantite;
    }
    
    public Vector<V_result> getAll(int idmateriel)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select vm.idmateriel,vm.idmeuble,m.idstyle,m.idcategorie,c.nom as categorie,s.nom as style,v.nom as volume,quantite from volumemateriel vm join meuble m on m.idmeuble=vm.idmeuble join style s on m.idstyle=s.idstyle join categorie c on m.idcategorie=c.idcategorie join volume v on vm.idvolume=v.idvolume where idmateriel="+idmateriel;
        ResultSet render = stmt.executeQuery(req);
        Vector<V_result> result = new Vector<V_result>();
        while(render.next()){
            result.add(new V_result(render.getInt(1),render.getInt(2),render.getInt(3),render.getInt(4),render.getString(5),render.getString(6),render.getString(7),render.getDouble(8)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
