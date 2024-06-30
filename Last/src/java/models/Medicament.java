/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author tahir
 */
public class Medicament {
    int idMedicament;
    String designation;
    double prix;
    int quantite;

    public int getIdMedicament() {
        return idMedicament;
    }

    public void setIdMedicament(int idMedicament) {
        this.idMedicament = idMedicament;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Medicament() {
    }

    public Medicament(int idMedicament, String designation, double prix) {
        this.idMedicament = idMedicament;
        this.designation = designation;
        this.prix = prix;
    }
    
}
