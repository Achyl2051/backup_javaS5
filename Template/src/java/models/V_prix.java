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
public class V_prix {
    int idMeuble;
    int idVolume;
    String meuble;
    String volume;
    double prixVente;
    double prixRevient;
    double benefice;

    public int getIdMeuble() {
        return idMeuble;
    }

    public void setIdMeuble(int idMeuble) {
        this.idMeuble = idMeuble;
    }

    public int getIdVolume() {
        return idVolume;
    }

    public void setIdVolume(int idVolume) {
        this.idVolume = idVolume;
    }

    public String getMeuble() {
        return meuble;
    }

    public void setMeuble(String meuble) {
        this.meuble = meuble;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public double getPrixRevient() {
        return prixRevient;
    }

    public void setPrixRevient(double prixRevient) {
        this.prixRevient = prixRevient;
    }

    public double getBenefice() {
        return benefice;
    }

    public void setBenefice(double benefice) {
        this.benefice = benefice;
    }

    public V_prix() {
    }

    public V_prix(int idMeuble, int idVolume, String meuble, String volume, double prixVente, double prixRevient, double benefice) {
        this.idMeuble = idMeuble;
        this.idVolume = idVolume;
        this.meuble = meuble;
        this.volume = volume;
        this.prixVente = prixVente;
        this.prixRevient = prixRevient;
        this.benefice = benefice;
    }
    
    public Vector<V_prix> getAll()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select*from v_prix";
        ResultSet render = stmt.executeQuery(req);
        Vector<V_prix> result = new Vector<V_prix>();
        while(render.next()){
            result.add(new V_prix(render.getInt(1),render.getInt(2),render.getString(3),render.getString(4),render.getDouble(5),render.getDouble(6),render.getDouble(7)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    
    public Vector<V_prix> test(double min,double max,Vector<V_prix> tab){
        Vector<V_prix> result = new Vector<V_prix>();
        for(int i=0; i<tab.size();i++){
            if(tab.get(i).getBenefice()>= min && tab.get(i).getBenefice() <= max ){
                result.add(tab.get(i));
            }
        }
        return result;
    }
}
