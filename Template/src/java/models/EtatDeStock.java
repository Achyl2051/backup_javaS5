/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import connection.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Lenovo Legion
 */
public class EtatDeStock {
        int idMateriel;
        String materiel;
        double pu;
        double stock_actuel;
        double prixTotal;

    public int getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public String getMateriel() {
        return materiel;
    }

    public void setMateriel(String materiel) {
        this.materiel = materiel;
    }

    public double getPu() {
        return pu;
    }

    public void setPu(double pu) {
        this.pu = pu;
    }

    public double getStock_actuel() {
        return stock_actuel;
    }

    public void setStock_actuel(double stock_actuel) {
        this.stock_actuel = stock_actuel;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public EtatDeStock() {
    }

    public EtatDeStock(int idMateriel, String materiel, double pu, double stock_actuel) {
        this.idMateriel = idMateriel;
        this.materiel = materiel;
        this.pu = pu;
        this.stock_actuel = stock_actuel;
        this.setPrixTotal(this.getPu()*this.getStock_actuel());
    }
    
    public double total(Vector<EtatDeStock> liste)
    {
        double result=0;
        for(int i=0;i<liste.size();i++)
        {
            result+=liste.get(i).getPrixTotal();
        }
        return result;
    }
        
    public Vector<EtatDeStock> getAll(String idmateriel)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
        String req="";
        if(idmateriel.equalsIgnoreCase("#"))
        {
            req = "select * from v_etat_stock";
        }
        else
        {
            req = "select * from v_etat_stock where idmateriel="+idmateriel;
        }
        ResultSet render = stmt.executeQuery(req);
        Vector<EtatDeStock> result = new Vector<EtatDeStock>();
        while(render.next()){
            result.add(new EtatDeStock(render.getInt(1),render.getString(2),render.getDouble(3),render.getDouble(4)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
