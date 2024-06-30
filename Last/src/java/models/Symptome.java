/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import connection.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author tahir
 */
public class Symptome {
    int idSymptome;
    String designation;

    public int getIdSymptome() {
        return idSymptome;
    }

    public void setIdSymptome(int idSymptome) {
        this.idSymptome = idSymptome;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Symptome() {
    }

    public Symptome(int idSymptome, String designation) {
        this.idSymptome = idSymptome;
        this.designation = designation;
    }

    public Symptome(String designation) {
        this.designation = designation;
    }
    
    public Vector<Symptome> getAll()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
        String req = "select * from symptome";
        ResultSet render = stmt.executeQuery(req);
        Vector<Symptome> result = new Vector<Symptome>();
        while(render.next()){
            result.add(new Symptome(render.getInt(1),render.getString(2)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
