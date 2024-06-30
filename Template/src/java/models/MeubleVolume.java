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
public class MeubleVolume {
    int idMeuble;
    int idVolume;
    String meuble;
    String volume;

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

    public MeubleVolume() {
    }
    

    public MeubleVolume(int idVolume, int idMeuble, String volume,String meuble) {
        this.idMeuble = idMeuble;
        this.idVolume = idVolume;
        this.meuble = meuble;
        this.volume = volume;
    }
    
    public Vector<MeubleVolume> getAll()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
        String req = "select * from v_meuble";
        ResultSet render = stmt.executeQuery(req);
        Vector<MeubleVolume> result = new Vector<MeubleVolume>();
        while(render.next()){
            result.add(new MeubleVolume(render.getInt(1),render.getInt(2),render.getString(3),render.getString(4)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    public Vector<MeubleVolume> getById( int idMeuble,int idVolume)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
        String req = "select * from v_meuble where idMeuble="+idMeuble+" and idVolume="+idVolume;
        ResultSet render = stmt.executeQuery(req);
        Vector<MeubleVolume> result = new Vector<MeubleVolume>();
        while(render.next()){
            result.add(new MeubleVolume(render.getInt(1),render.getInt(2),render.getString(3),render.getString(4)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
