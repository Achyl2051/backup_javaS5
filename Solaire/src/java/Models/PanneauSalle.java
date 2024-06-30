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
public class PanneauSalle {
    int idPanneau;
    int idSalle;

    public PanneauSalle() {
    }

    public PanneauSalle(int idPanneau, int idSalle) {
        setIdPanneau(idPanneau);
        setIdSalle(idSalle);
    }

    public int getIdPanneau() {
        return idPanneau;
    }

    public void setIdPanneau(int idPanneau) {
        this.idPanneau = idPanneau;
    }

    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }
    public Vector<PanneauSalle> getByPanneau(int idPanneau)throws Exception{
        Connection connecting=null;
        Connect connection=new Connect("postgres","");
        connecting=connection.get_connex();
        Statement stmt = connecting.createStatement();
        String req = "select * from panneauSalle where idPanneau="+idPanneau;
        ResultSet render = stmt.executeQuery(req);
        Vector<PanneauSalle> result = new Vector<PanneauSalle>();
        while(render.next()){
            result.add(new PanneauSalle(render.getInt(1),render.getInt(2)));
        }
        stmt.close();
        connecting.close();
        return result;
    }
}

