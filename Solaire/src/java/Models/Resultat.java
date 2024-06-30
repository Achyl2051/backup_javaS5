/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author ITU
 */
public class Resultat {
    Date date;
    int heure;
    double consommation;
    int eleve;
    String secteur;
    double panneau;
    double batterie;
    double luminosite;
    Time coupure;

    public Resultat() {
    }
    
    public Resultat(Date date, int heure, double consommation, int eleve, String secteur, double panneau, double batterie, double luminosite, Time coupure) {
        setDate(date);
        setHeure(heure);
        setConsommation(consommation);
        setEleve(eleve);
        setSecteur(secteur);
        setPanneau(panneau);
        setBatterie(batterie);
        setLuminosite(luminosite);
        setCoupure(coupure);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public double getConsommation() {
        return consommation;
    }

    public void setConsommation(double consommation) {
        this.consommation = consommation;
    }

    public int getEleve() {
        return eleve;
    }

    public void setEleve(int eleve) {
        this.eleve = eleve;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public double getPanneau() {
        return panneau;
    }

    public void setPanneau(double panneau) {
        this.panneau = panneau;
    }

    public double getBatterie() {
        return batterie;
    }

    public void setBatterie(double batterie) {
        this.batterie = batterie;
    }

    public double getLuminosite() {
        return luminosite;
    }

    public void setLuminosite(double luminosite) {
        this.luminosite = luminosite;
    }

    public Time getCoupure() {
        return coupure;
    }

    public void setCoupure(Time coupure) {
        this.coupure = coupure;
    }
    
    public Vector<Resultat> simulation(Date date)throws Exception{
        Vector<Resultat> result = new Vector<Resultat>();
        Vector<Panneau> listPanneau = new Panneau().getAll();
        Vector<Luminosite> luminosites = new Luminosite().getByDate(date);
        double consommation = 79.285234375;
        for(int i = 0; i<listPanneau.size();i++){
            //Vector<Historique> historiques = new Historique().getByDate(date,listPanneau.get(i).getIdPanneau());
            //double consommation = new Presence().getConsommation(date,listPanneau.get(i).getIdPanneau(),historiques,luminosites,listPanneau);
            System.out.println("consommation: "+consommation);
            double batterie = listPanneau.get(i).getConsoBat() / 2;
            double batMax = listPanneau.get(i).getConsoBat() / 2;
            for(int j=0;j<luminosites.size();j++){
                String secteur = "Secteur "+listPanneau.get(i).getIdPanneau();                
                int eleve = new Presence().getEleve(date,luminosites.get(j).getHeure(),listPanneau.get(i).getIdPanneau());
                Time coupure = null;
                double puissancePanneau = (listPanneau.get(i).getPuissance()*luminosites.get(j).getPuissance()*10)/100;
                double utilisation = eleve*consommation;
                if(utilisation>puissancePanneau){
                    double reste = (eleve*consommation) - puissancePanneau;
                    if(batterie-reste>0){
                        batterie -= reste;
                    }
                    else{
                        int minute = (int) Math.ceil((batterie*60)/reste);
                        coupure = new Time(luminosites.get(j).getHeure(),minute,0);
                        batterie = 0;
                    }
                }else{
                    double surplus = puissancePanneau-utilisation;
                    batterie += surplus;
                    if(batterie>batMax){
                        batterie=batMax;
                    }
                }
                result.add(new Resultat(date,luminosites.get(j).getHeure(),utilisation,eleve,
                secteur,puissancePanneau,
                batterie,luminosites.get(j).getPuissance(),coupure));
                if(coupure!=null){
                    break;
                }
            }
        }
        return result;
    }
}