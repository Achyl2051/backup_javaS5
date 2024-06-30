/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Foncier;

import jakarta.ejb.Stateless;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author tahir
 */
@Stateless
public class Devis implements EjbDevis{
    int id;
    String nom;
    double ta;
    double tv;
    Date daty; 

    public Devis() {
    }

    public Devis(int id, String nom, double ta, double tv, Date daty) {
        this.id = id;
        this.nom = nom;
        this.ta = ta;
        this.tv = tv;
        this.daty = daty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getTa() {
        return ta;
    }

    public void setTa(double ta) {
        this.ta = ta;
    }

    public double getTv() {
        return tv;
    }

    public void setTv(double tv) {
        this.tv = tv;
    }

    public Date getDaty() {
        return daty;
    }

    public void setDaty(Date daty) {
        this.daty = daty;
    }
    
    @Override
    public ArrayList<Devis> getDevis(){
        Connection connecting=null;
	ConFoncier connection=new ConFoncier();
	connecting=connection.getConnection();
        ArrayList<Devis> result = new ArrayList<Devis>();
        try{
            Statement stmt = connecting.createStatement();
            String req = "select*from devis where daty=(select max(daty) from devis as dev where devis.nom=dev.nom)";
            ResultSet render = stmt.executeQuery(req);
            while(render.next()){
                Devis temp=new Devis(render.getInt(1),render.getString(2),render.getDouble(3),render.getDouble(4),render.getDate(5));
                result.add(temp);
            }
            stmt.close();
            connecting.close();
        }
        catch(Exception e)
        {}
        return result;
    }
    
    @Override
        public Devis getDevi(String id){
        Connection connecting=null;
	ConFoncier connection=new ConFoncier();
	connecting=connection.getConnection();
        Devis result = new Devis();
        try{
            Statement stmt = connecting.createStatement();
            String req = "select*from devis where id="+id;
            ResultSet render = stmt.executeQuery(req);
            while(render.next()){
                result.setId(render.getInt(1));
                result.setNom(render.getString(2));
                result.setTa(render.getDouble(3));
                result.setTv(render.getDouble(4));
                result.setDaty(render.getDate(5));
            }
            stmt.close();
            connecting.close();
        }
        catch(Exception e)
        {}
        return result;
    }
}
