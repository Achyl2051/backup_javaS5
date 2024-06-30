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
public class V_detailStyle {
    int id;
    int idStyle;
    int idMateriel;
    String materiel;
    String unite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(int idStyle) {
        this.idStyle = idStyle;
    }

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

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public V_detailStyle() {
    }

    public V_detailStyle(int id, int idStyle, int idMateriel, String materiel,String unite) {
        this.setId(id);
        this.setIdStyle(idStyle);
        this.setIdMateriel(idMateriel);
        this.setMateriel(materiel);
        this.setUnite(unite);
    }
    
    public Vector<V_detailStyle> getDetailByStyle(int style)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select d.*,m.nom as materiel,u.nom as unite from detailStyle as d join materiel m on m.idmateriel=d.idmateriel join unite u on m.idunite=u.idunite where idstyle="+style;
        ResultSet render = stmt.executeQuery(req);
        Vector<V_detailStyle> result = new Vector<V_detailStyle>();
        while(render.next()){
            result.add(new V_detailStyle(render.getInt(1),render.getInt(2),render.getInt(3),render.getString(4),render.getString(5)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    
}
