/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author tahir
 */
public class Candidat {
    int numero;
    String nom;
    String antoko;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAntoko() {
        return antoko;
    }

    public void setAntoko(String antoko) {
        this.antoko = antoko;
    }

    public Candidat() {
    }

    public Candidat(int numero, String nom, String antoko) {
        this.setNumero(numero);
        this.setNom(nom);
        this.setAntoko(antoko);
    }
}
