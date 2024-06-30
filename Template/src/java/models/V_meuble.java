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
public class V_meuble {
    int idMeuble;
    int idStyle;
    int idCategorie;
    int nombreMpiasa;
    String categorie;
    String style;

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

    public void setStyle(String style) {
        this.style = style;
    }

    public int getNombreMpiasa() {
        return nombreMpiasa;
    }

    public void setNombreMpiasa(int nombreMpiasa) {
        this.nombreMpiasa = nombreMpiasa;
    }

    public V_meuble() {
    }

    public V_meuble(int idMeuble, int idStyle, int idCategorie, String categorie, String style) {
        this.idMeuble = idMeuble;
        this.idStyle = idStyle;
        this.idCategorie = idCategorie;
        this.categorie = categorie;
        this.style = style;
    }

    public V_meuble(int idMeuble, int idStyle, int idCategorie, int nombreMpiasa, String categorie, String style) {
        this.idMeuble = idMeuble;
        this.idStyle = idStyle;
        this.idCategorie = idCategorie;
        this.nombreMpiasa = nombreMpiasa;
        this.categorie = categorie;
        this.style = style;
    }
    
    public Vector<V_meuble> getAll()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select*from v_meuble_complet";
        ResultSet render = stmt.executeQuery(req);
        Vector<V_meuble> result = new Vector<V_meuble>();
        while(render.next()){
            result.add(new V_meuble(render.getInt(1),render.getInt(2),render.getInt(3),render.getInt(4),render.getString(5),render.getString(6)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
