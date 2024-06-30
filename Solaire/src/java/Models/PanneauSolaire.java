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
public class PanneauSolaire {
    int idPanneau;
    int idSolaire;

    public PanneauSolaire() {
    }

    public PanneauSolaire(int idPanneau, int idSolaire) {
        setIdPanneau(idPanneau);
        setIdSolaire(idSolaire);
    }

    public int getIdPanneau() {
        return idPanneau;
    }

    public void setIdPanneau(int idPanneau) {
        this.idPanneau = idPanneau;
    }

    public int getIdSolaire() {
        return idSolaire;
    }

    public void setIdSolaire(int idSolaire) {
        this.idSolaire = idSolaire;
    }
    
    public Vector<PanneauSolaire> getByPanneau(int idPanneau)throws Exception{
        Connection connecting=null;
	Connect connection=new Connect("postgres","");
	connecting=connection.get_connex();
        Statement stmt = connecting.createStatement();
   	String req = "select * from panneauSolaire where idPanneau="+idPanneau;
        ResultSet render = stmt.executeQuery(req);
        Vector<PanneauSolaire> result = new Vector<PanneauSolaire>();
        while(render.next()){
            result.add(new PanneauSolaire(render.getInt(1),render.getInt(2)));
	}
        stmt.close();
        connecting.close();
        return result;
    }    
}
