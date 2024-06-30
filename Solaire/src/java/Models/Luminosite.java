/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Connection.Connect;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author ITU
 */
public class Luminosite {
    int idLuminosite;
    Date date;
    double puissance;
    int heure;

    public Luminosite() {
    }

    public Luminosite(int idLuminosite, Date date, double puissance, int heure) {
        setIdLuminosite(idLuminosite);
        setDate(date);
        setPuissance(puissance);
        setHeure(heure);
    }

    public int getIdLuminosite() {
        return idLuminosite;
    }

    public void setIdLuminosite(int idLuminosite) {
        this.idLuminosite = idLuminosite;
    }

    public double getPuissance() {
        return puissance;
    }

    public void setPuissance(double puissance) {
        this.puissance = puissance;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public Vector<Luminosite> getAll()throws Exception{
        Connection connecting=null;
	Connect connection=new Connect("postgres","");
	connecting=connection.get_connex();
        Statement stmt = connecting.createStatement();
   	String req = "select * from luminosite";
        ResultSet render = stmt.executeQuery(req);
        Vector<Luminosite> result = new Vector<Luminosite>();
        while(render.next()){
            result.add(new Luminosite(render.getInt(1),render.getDate(2),render.getDouble(3),render.getInt(4)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    
    public Vector<Luminosite> getByDate(Date date)throws Exception{
        Connection connecting=null;
	Connect connection=new Connect("postgres","");
	connecting=connection.get_connex();
        Statement stmt = connecting.createStatement();
   	String req = "select * from luminosite where date='"+date+"'";
        ResultSet render = stmt.executeQuery(req);
        Vector<Luminosite> result = new Vector<Luminosite>();
        while(render.next()){
            result.add(new Luminosite(render.getInt(1),render.getDate(2),render.getDouble(3),render.getInt(4)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
