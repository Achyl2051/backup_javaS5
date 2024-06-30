/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Lenovo Legion
 */
public class V_StockMeuble {
    int idVolume;
    int idMateriel;
    int idMeuble;
    String categorie;
    String style;
    String volume;
    double quantite;
    String nateriel;

    public int getIdVolume() {
        return idVolume;
    }

    public void setIdVolume(int idVolume) {
        this.idVolume = idVolume;
    }

    public int getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public int getIdMeuble() {
        return idMeuble;
    }

    public void setIdMeuble(int idMeuble) {
        this.idMeuble = idMeuble;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public String getNateriel() {
        return nateriel;
    }

    public void setNateriel(String nateriel) {
        this.nateriel = nateriel;
    }

    public V_StockMeuble() {
    }

    public V_StockMeuble(int idVolume, int idMateriel, int idMeuble, String categorie, String style, String volume, double quantite, String nateriel) {
        this.idVolume = idVolume;
        this.idMateriel = idMateriel;
        this.idMeuble = idMeuble;
        this.categorie = categorie;
        this.style = style;
        this.volume = volume;
        this.quantite = quantite;
        this.nateriel = nateriel;
    }
    
    
          
}
