/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author tahir
 */
public class Bureau {
    int idBureau;
    String region;
    String district;
    String commune;
    String fokontany;
    String centreVote;
    String codeBV;
    String bureauVote;

    public int getIdBureau() {
        return idBureau;
    }

    public void setIdBureau(int idBureau) {
        this.idBureau = idBureau;
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

    public String getCentreVote() {
        return centreVote;
    }

    public void setCentreVote(String centreVote) {
        this.centreVote = centreVote;
    }

    public String getCodeBV() {
        return codeBV;
    }

    public void setCodeBV(String codeBV) {
        this.codeBV = codeBV;
    }

    public String getBureauVote() {
        return bureauVote;
    }

    public void setBureauVote(String bureauVote) {
        this.bureauVote = bureauVote;
    }

    public Bureau() {
    }

    public Bureau(int idBureau, String region, String district, String commune, String fokontany, String centreVote, String codeBV, String bureauVote) {
        this.setIdBureau(idBureau);
        this.setRegion(region);
        this.setDistrict(district);
        this.setCommune(commune);
        this.setFokontany(fokontany);
        this.setCentreVote(centreVote);
        this.setCodeBV(codeBV);
        this.setBureauVote(bureauVote);
    }
    
}
