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
 * @author Lenovo Legion
 */
public class MeubleMontant {
    String categorie;
    String style;
    String volume;
    double montant;

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

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public MeubleMontant(String categorie, String style, String volume, double montant) {
        this.setCategorie(categorie);
        this.setStyle(style);
        this.setVolume(volume);
        this.setMontant(montant);
    }

    public MeubleMontant() {
    }
    public Vector<MeubleMontant> getAll()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select*from v_meuble_montant";
        ResultSet render = stmt.executeQuery(req);
        Vector<MeubleMontant> result = new Vector<MeubleMontant>();
        while(render.next()){
            result.add(new MeubleMontant(render.getString(1),render.getString(2),render.getString(3),render.getDouble(4)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    public Vector<MeubleMontant> test(double m1,double m2,Vector<MeubleMontant> tab){
        Vector<MeubleMontant> result = new Vector<MeubleMontant>();
        for(int i=0; i<tab.size();i++){
            if(tab.get(i).getMontant() >= m1 && tab.get(i).getMontant() <= m2 ){
                result.add(tab.get(i));
            }
        }
        return result;
    }
}
