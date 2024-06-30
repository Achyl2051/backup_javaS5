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
 * @author tahir
 */
public class DetailStyle {
    int idDetail;
    int idStyle;
    int idMateriel;

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
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

    public DetailStyle() {
    }

    public DetailStyle(int idDetail, int idStyle, int idMateriel) {
        this.setIdDetail(idDetail);
        this.setIdStyle(idStyle);
        this.setIdMateriel(idMateriel);
    }
    
    public DetailStyle(int idStyle, int idMateriel) {
        this.setIdStyle(idStyle);
        this.setIdMateriel(idMateriel);
    }
    
    public void insert()throws Exception
    {
        Connection connecting = new Connect().getConnection();
        String req = "INSERT INTO detailStyle(idStyle,idMateriel) VALUES (?,?)";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
        pstmt.setInt(1, this.getIdStyle());
        pstmt.setInt(2, this.getIdMateriel());
        pstmt.executeUpdate();
        connecting.close();
    }
    
    public Vector<DetailStyle> getDetailByStyle()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from detailStyle where idStyle="+this.getIdStyle();
        ResultSet render = stmt.executeQuery(req);
        Vector<DetailStyle> result = new Vector<DetailStyle>();
        while(render.next()){
            result.add(new DetailStyle(render.getInt(1),render.getInt(2),render.getInt(3)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
