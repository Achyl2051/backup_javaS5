/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author tahir
 */
public class DetailMaladie {
    int idDetailMaladie;
    int idMaladie;
    int idSymptome;
    int ageDebut;
    int ageFin;
    double intensite;
    String maladie;
    String symptome;

    public int getIdDetailMaladie() {
        return idDetailMaladie;
    }

    public void setIdDetailMaladie(int idDetailMaladie) {
        this.idDetailMaladie = idDetailMaladie;
    }

    public int getIdMaladie() {
        return idMaladie;
    }

    public void setIdMaladie(int idMaladie) {
        this.idMaladie = idMaladie;
    }

    public int getIdSymptome() {
        return idSymptome;
    }

    public void setIdSymptome(int idSymptome) {
        this.idSymptome = idSymptome;
    }

    public int getAgeDebut() {
        return ageDebut;
    }

    public void setAgeDebut(int ageDebut) {
        this.ageDebut = ageDebut;
    }

    public int getAgeFin() {
        return ageFin;
    }

    public void setAgeFin(int ageFin) {
        this.ageFin = ageFin;
    }

    public double getIntensite() {
        return intensite;
    }

    public void setIntensite(double intensite) {
        this.intensite = intensite;
    }

    public String getMaladie() {
        return maladie;
    }

    public void setMaladie(String maladie) {
        this.maladie = maladie;
    }

    public String getSymptome() {
        return symptome;
    }

    public void setSymptome(String symptome) {
        this.symptome = symptome;
    }

    public DetailMaladie() {
    }

    public DetailMaladie(int idDetailMaladie, int idMaladie, int idSymptome, int ageDebut, int ageFin, double intensite) {
        this.idDetailMaladie = idDetailMaladie;
        this.idMaladie = idMaladie;
        this.idSymptome = idSymptome;
        this.ageDebut = ageDebut;
        this.ageFin = ageFin;
        this.intensite = intensite;
    }

    public DetailMaladie(int idDetailMaladie, int idMaladie, int idSymptome, int ageDebut, int ageFin, double intensite, String maladie, String symptome) {
        this.idDetailMaladie = idDetailMaladie;
        this.idMaladie = idMaladie;
        this.idSymptome = idSymptome;
        this.ageDebut = ageDebut;
        this.ageFin = ageFin;
        this.intensite = intensite;
        this.maladie = maladie;
        this.symptome = symptome;
    }
    
}
