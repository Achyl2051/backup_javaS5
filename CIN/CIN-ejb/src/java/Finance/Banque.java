/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package Finance;

import jakarta.ejb.Stateless;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author tahir
 */
@Stateless
public class Banque implements EjbFinance{
    int id;
    int cin;
    String banque_nom;
    String banque_compte;

    public Banque(int id, int cin, String banque_nom, String banque_compte) {
        this.id = id;
        this.cin = cin;
        this.banque_nom = banque_nom;
        this.banque_compte = banque_compte;
    }

    public Banque() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getBanque_nom() {
        return banque_nom;
    }

    public void setBanque_nom(String banque_nom) {
        this.banque_nom = banque_nom;
    }

    public String getBanque_compte() {
        return banque_compte;
    }

    public void setBanque_compte(String banque_compte) {
        this.banque_compte = banque_compte;
    }
    /**
     */
    @Override
    public Banque getBanque(String cin){
        Connection connecting=null;
	ConFinance connection=new ConFinance();
	connecting=connection.getConnection();
        Banque result=new Banque();
        try{
            Statement stmt = connecting.createStatement();
            String req = "select * from banque where cin=" + cin;
            ResultSet render = stmt.executeQuery(req);
            while(render.next()){
                result.setId(render.getInt(1));
                result.setCin(render.getInt(2));
                result.setBanque_nom(render.getString(3));
                result.setBanque_compte(render.getString(4));
            }
            stmt.close();
            connecting.close();
        }
        catch(Exception e)
        {}
        return result;
    }
}
