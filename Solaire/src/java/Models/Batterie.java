/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Connection.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author ITU
 */
public class Batterie {
    int idBatterie;
    String nom;
    double puissance;

    public Batterie() {
    }

    public Batterie(int idBatterie, String nom, double puissance) {
        setIdBatterie(idBatterie);
        setNom(nom);
        setPuissance(puissance);
    }

    
    public int getIdBatterie() {
        return idBatterie;
    }

    public void setIdBatterie(int idBatterie) {
        this.idBatterie = idBatterie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPuissance() {
        return puissance;
    }

    public void setPuissance(double puissance) {
        this.puissance = puissance;
    }
    
    public Vector<Batterie> getAll()throws Exception{
        Connection connecting=null;
	Connect connection=new Connect("postgres","");
	connecting=connection.get_connex();
        Statement stmt = connecting.createStatement();
   	String req = "select * from batterie";
        ResultSet render = stmt.executeQuery(req);
        Vector<Batterie> result = new Vector<Batterie>();
        while(render.next()){
            result.add(new Batterie(render.getInt(1),render.getString(2),render.getDouble(3)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    public Batterie getById(int idBatterie)throws Exception{
        Connection connecting=null;
	Connect connection=new Connect("postgres","");
	connecting=connection.get_connex();
        Statement stmt = connecting.createStatement();
   	String req = "select * from batterie where idBatterie="+idBatterie;
        ResultSet render = stmt.executeQuery(req);
        Batterie result = null;
        while(render.next()){
            result = new Batterie(render.getInt(1),render.getString(2),render.getDouble(3));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
