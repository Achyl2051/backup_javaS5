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
public class Panneau {
    int idPanneau;
    String nom;

    public Panneau() {
    }

    public Panneau(int idPanneau, String nom) {
        setIdPanneau(idPanneau);
        setNom(nom);
    }

    public int getIdPanneau() {
        return idPanneau;
    }

    public void setIdPanneau(int idPanneau) {
        this.idPanneau = idPanneau;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public Vector<Panneau> getAll()throws Exception{
        Connection connecting=null;
	Connect connection=new Connect("postgres","");
	connecting=connection.get_connex();
        Statement stmt = connecting.createStatement();
   	String req = "select * from panneau";
        ResultSet render = stmt.executeQuery(req);
        Vector<Panneau> result = new Vector<Panneau>();
        while(render.next()){
            result.add(new Panneau(render.getInt(1),render.getString(2)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    public Panneau getById(int idPanneau)throws Exception{
        Connection connecting=null;
	Connect connection=new Connect("postgres","");
	connecting=connection.get_connex();
        Statement stmt = connecting.createStatement();
   	String req = "select * from panneau where idPanneau="+idPanneau;
        ResultSet render = stmt.executeQuery(req);
        Panneau result = null;
        while(render.next()){
            result = new Panneau(render.getInt(1),render.getString(2));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    public Vector<Salle> getSalle()throws Exception{
        Vector<Salle> result = new Vector<Salle>();
        Vector<PanneauSalle> ps = new PanneauSalle().getByPanneau(this.idPanneau);
        for(int i=0;i<ps.size();i++){
            result.add(new Salle().getById(ps.get(i).getIdSalle()));
        }
        return result;
    }
    public Vector<Batterie> getBatterie()throws Exception{
        Vector<Batterie> result = new Vector<Batterie>();
        Vector<PanneauBatterie> pb = new PanneauBatterie().getByPanneau(this.idPanneau);
        for(int i=0;i<pb.size();i++){
            result.add(new Batterie().getById(pb.get(i).getIdBatterie()));
        }
        return result;
    }
    public Vector<Solaire> getSolaire()throws Exception{
        Vector<Solaire> result = new Vector<Solaire>();
        Vector<PanneauSolaire> ps = new PanneauSolaire().getByPanneau(this.idPanneau);
        for(int i=0;i<ps.size();i++){
            result.add(new Solaire().getById(ps.get(i).getIdSolaire()));
        }
        return result;
    }  
    public double getPuissance()throws Exception{
        double result = 0;
        Vector<Solaire> sols = this.getSolaire();
        for(int i= 0;i<sols.size();i++){
            result+=sols.get(i).getPuissance();
        }
        return result;
    }
    public double getConsoBat()throws Exception{
        double result = 0;
        Vector<Batterie> bats = this.getBatterie();
        for(int i= 0;i<bats.size();i++){
            result+=bats.get(i).getPuissance();
        }
        return result;
    }
}
