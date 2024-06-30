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
public class Solaire {
    int idSolaire;
    String nom;
    double puissance;

    public Solaire() {
    }

    public Solaire(int idSolaire, String nom, double puissance) {
        setIdSolaire(idSolaire);
        setNom(nom);
        setPuissance(puissance);
    }

    
    public int getIdSolaire() {
        return idSolaire;
    }

    public void setIdSolaire(int idSolaire) {
        this.idSolaire = idSolaire;
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
    
    public Vector<Solaire> getAll()throws Exception{
        Connection connecting=null;
	Connect connection=new Connect("postgres","");
	connecting=connection.get_connex();
        Statement stmt = connecting.createStatement();
   	String req = "select * from Solaire";
        ResultSet render = stmt.executeQuery(req);
        Vector<Solaire> result = new Vector<Solaire>();
        while(render.next()){
            result.add(new Solaire(render.getInt(1),render.getString(2),render.getDouble(3)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    public Solaire getById(int idSolaire)throws Exception{
        Connection connecting=null;
	Connect connection=new Connect("postgres","");
	connecting=connection.get_connex();
        Statement stmt = connecting.createStatement();
   	String req = "select * from Solaire where idSolaire="+idSolaire;
        ResultSet render = stmt.executeQuery(req);
        Solaire result = null;
        while(render.next()){
            result = new Solaire(render.getInt(1),render.getString(2),render.getDouble(3));
	}
        stmt.close();
        connecting.close();
        return result;
    }    
}
