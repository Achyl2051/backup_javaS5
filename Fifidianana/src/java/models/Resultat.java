/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import connection.Connect;
import java.util.Vector;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author tahir
 */
public class Resultat {
    int idResultat;
    int total;
    String codeBV;
    int inscrits;
    int votants;
    int blancs;
    int nuls;

    public int getInscrits() {
        return inscrits;
    }

    public void setInscrits(int inscrits) {
        this.inscrits = inscrits;
    }

    public int getVotants() {
        return votants;
    }

    public void setVotants(int votants) {
        this.votants = votants;
    }

    public int getBlancs() {
        return blancs;
    }

    public void setBlancs(int blancs) {
        this.blancs = blancs;
    }

    public int getNuls() {
        return nuls;
    }

    public void setNuls(int nuls) {
        this.nuls = nuls;
    }

    public int getIdResultat() {
        return idResultat;
    }

    public void setIdResultat(int idResultat) {
        this.idResultat = idResultat;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCodeBV() {
        return codeBV;
    }

    public void setCodeBV(String codeBV) {
        this.codeBV = codeBV;
    }

    public Resultat() {
    }

    public Resultat(int idResultat, int total, String codeBV, int inscrits, int votants, int blancs, int nuls) {
        this.setIdResultat(idResultat);
        this.setTotal(total);
        this.setCodeBV(codeBV);
        this.setInscrits(inscrits);
        this.setVotants(votants);
        this.setBlancs(blancs);
        this.setNuls(nuls);
    }
    
    public Vector<Resultat> getListResultat()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from resultat";
        ResultSet render = stmt.executeQuery(req);
        Vector<Resultat> result = new Vector<Resultat>();
        while(render.next()){
            result.add(new Resultat(render.getInt(1),render.getInt(2),render.getString(3),render.getInt(4),render.getInt(5),render.getInt(6),render.getInt(6)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    
    public Resultat getListResultatByBureau(String codeBV)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from resultat where codeBV='"+codeBV+"'";
        ResultSet render = stmt.executeQuery(req);
        Resultat result = new Resultat();
        while(render.next()){
            result=new Resultat(render.getInt(1),render.getInt(2),render.getString(3),render.getInt(4),render.getInt(5),render.getInt(6),render.getInt(6));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
