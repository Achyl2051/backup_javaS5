/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Connection.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
/**
 *
 * @author ITU
 */
public class Historique {
    int idHistorique;
    int heure;
    int minute;
    Date date;
    int idPanneau; 

    public Historique() {
    }

    public Historique(int idHistorique, int heure, int minute, Date date, int idPanneau) {
        setIdHistorique(idHistorique);
        setHeure(heure);
        setMinute(minute);
        setDate(date);
        setIdPanneau(idPanneau);
    }

    public int getIdHistorique() {
        return idHistorique;
    }

    public void setIdHistorique(int idHistorique) {
        this.idHistorique = idHistorique;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdPanneau() {
        return idPanneau;
    }

    public void setIdPanneau(int idPanneau) {
        this.idPanneau = idPanneau;
    }
    
    public Vector<Historique> getByDate(Date date,int idPanneau)throws Exception{
        Connection connecting=null;
	Connect connection=new Connect("postgres","");
	connecting=connection.get_connex();
        Statement stmt = connecting.createStatement();
   	String req = "select * from historique where idPanneau= "+idPanneau;
        ResultSet render = stmt.executeQuery(req);
        Vector<Historique> result = new Vector<Historique>();
        while(render.next()){
            result.add(new Historique(render.getInt(1),render.getInt(2),render.getInt(3),render.getDate(4),render.getInt(5)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    
    
}
