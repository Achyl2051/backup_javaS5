/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Salles/Class.java to edit this template
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
public class Salle {
    int idSalle;
    String nom;

    public Salle(int idSalle, String nom) {
        setIdSalle(idSalle);
        setNom(nom);
    }

    public Salle() {
    }

    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public Vector<Salle> getAll()throws Exception{
        Connection connecting=null;
	Connect connection=new Connect("postgres","");
	connecting=connection.get_connex();
        Statement stmt = connecting.createStatement();
   	String req = "select * from Salle";
        ResultSet render = stmt.executeQuery(req);
        Vector<Salle> result = new Vector<Salle>();
        while(render.next()){
            result.add(new Salle(render.getInt(1),render.getString(2)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    public Salle getById(int idSalle)throws Exception{
        Connection connecting=null;
	Connect connection=new Connect("postgres","");
	connecting=connection.get_connex();
        Statement stmt = connecting.createStatement();
   	String req = "select * from Salle where idSalle="+idSalle;
        ResultSet render = stmt.executeQuery(req);
        Salle result = null;
        while(render.next()){
            result = new Salle(render.getInt(1),render.getString(2));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
