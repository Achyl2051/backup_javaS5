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
public class V_resultat {
    String bureauVote;
    String region;
    String district;
    String commune;
    String fokontany;
    String codeBv;
    int inscrits;
    int votants;
    int blancs;
    int nuls;
    int total;

    public String getBureauVote() {
        return bureauVote;
    }

    public void setBureauVote(String bureauVote) {
        this.bureauVote = bureauVote;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getFokontany() {
        return fokontany;
    }

    public void setFokontany(String fokontany) {
        this.fokontany = fokontany;
    }

    public String getCodeBv() {
        return codeBv;
    }

    public void setCodeBv(String codeBv) {
        this.codeBv = codeBv;
    }

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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public V_resultat(String bureauVote, String region, String district, String commune, String fokontany, String codeBv, int inscrits, int votants, int blancs, int nuls, int total) {
        this.setBureauVote(bureauVote);
        this.setRegion(region);
        this.setDistrict(district);
        this.setCommune(commune);
        this.setFokontany(fokontany);
        this.setCodeBv(codeBv);
        this.setInscrits(inscrits);
        this.setVotants(votants);
        this.setBlancs(blancs);
        this.setNuls(nuls);
        this.setTotal(total);
    }

    public V_resultat() {
    }
    
    public V_resultat getResultatByBureau(String code)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select b.bureauvote,region,district,commune,fokontany,r.codebv,inscrits,votants,blancs,nuls,total from resultat as r join bureau as b on b.codebv=r.codebv where r.codebv='"+code+"'";
        ResultSet render = stmt.executeQuery(req);
        V_resultat result = new V_resultat();
        while(render.next()){
            result=new V_resultat(render.getString(1),render.getString(2),render.getString(3),render.getString(4),render.getString(5),render.getString(6),render.getInt(7),render.getInt(8),render.getInt(9),render.getInt(10),render.getInt(11));
        }
        stmt.close();
        connecting.close();
        return result;
    }
    
}
