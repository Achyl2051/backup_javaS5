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
public class PanneauBatterie {
    int idPanneau;
    int idBatterie;

    public PanneauBatterie() {
    }

    public PanneauBatterie(int idPanneau, int idBatterie) {
        setIdPanneau(idPanneau);
        setIdBatterie(idBatterie);
    }

    public int getIdPanneau() {
        return idPanneau;
    }

    public void setIdPanneau(int idPanneau) {
        this.idPanneau = idPanneau;
    }

    public int getIdBatterie() {
        return idBatterie;
    }

    public void setIdBatterie(int idBatterie) {
        this.idBatterie = idBatterie;
    }
    
    public Vector<PanneauBatterie> getByPanneau(int idPanneau)throws Exception{
        Connection connecting=null;
	Connect connection=new Connect("postgres","");
	connecting=connection.get_connex();
        Statement stmt = connecting.createStatement();
   	String req = "select * from panneauBatterie where idPanneau="+idPanneau;
        ResultSet render = stmt.executeQuery(req);
        Vector<PanneauBatterie> result = new Vector<PanneauBatterie>();
        while(render.next()){
            result.add(new PanneauBatterie(render.getInt(1),render.getInt(2)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}

