/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import connection.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author tahir
 */
public class Maladie {
    int idMaladie;
    String designation;

    public int getIdMaladie() {
        return idMaladie;
    }

    public void setIdMaladie(int idMaladie) {
        this.idMaladie = idMaladie;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Maladie() {
    }

    public Maladie(int idMaladie, String designation) {
        this.idMaladie = idMaladie;
        this.designation = designation;
    }

    public Maladie(String designation) {
        this.designation = designation;
    }
    
    public Vector<Maladie> listeMaladieParSymptome() throws SQLException
    {
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select*from v_listeMaladieParSymptome where idsymptome=1 and intensite=5 and agedebut<=3 and agefin>=3";
        ResultSet render = stmt.executeQuery(req);
        Vector<DetailMaladie> temp = new Vector<DetailMaladie>();
        while(render.next()){
            temp.add(new DetailMaladie(render.getInt(1),render.getInt(2),render.getInt(3),render.getInt(4),render.getInt(5),render.getDouble(6),render.getString(7),render.getString(8)));
	}
        Vector<Maladie> result=new Vector<Maladie>();
        for(int i=0;i<temp.size();i++)
        {
            result.add(new Maladie(temp.get(i).getIdMaladie(),temp.get(i).getMaladie()));
        }
        stmt.close();
        connecting.close();
        return result;
    }
}
