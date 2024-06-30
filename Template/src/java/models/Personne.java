/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import connection.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

/**
 *
 * @author tahir
 */
public class Personne {
    int idPersonne;
    int idMpiasa;
    String nom;
    double tauxHoraire;
    Date dateEntre;
    String poste;
    int genre;

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public int getIdMpiasa() {
        return idMpiasa;
    }

    public void setIdMpiasa() {
        LocalDate localDateFromSql = this.getDateEntre().toLocalDate();
        LocalDate currentDate = LocalDate.now();
        
        LocalDate fiveYearsBefore = currentDate.minusYears(5);
        boolean isFiveYearsBefore = localDateFromSql.isBefore(fiveYearsBefore) || localDateFromSql.isEqual(fiveYearsBefore);
        
        LocalDate twoYearsBefore = currentDate.minusYears(2);
        boolean isTwoYearsBefore = localDateFromSql.isBefore(twoYearsBefore) || localDateFromSql.isEqual(twoYearsBefore);
        
        if (isFiveYearsBefore) {
            this.idMpiasa = 3;
        }
        else if(isTwoYearsBefore){
            this.idMpiasa = 2;
        }
        else{
            this.idMpiasa = 1;
        }
    }

    public void setIdMpiasa(int idMpiasa) {
        this.idMpiasa = idMpiasa;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }
    
    public void setTauxHoraire(double tauxHoraire,String test) {
        this.tauxHoraire = tauxHoraire*this.getIdMpiasa();
    }

    public Date getDateEntre() {
        return dateEntre;
    }

    public void setDateEntre(Date dateEntre) {
        this.dateEntre = dateEntre;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }
    

    public Personne() {
    }

    public Personne(int idPersonne, int idMpiasa, String nom, double tauxHoraire, Date dateEntre) {
        this.idPersonne = idPersonne;
        this.idMpiasa = idMpiasa;
        this.nom = nom;
        this.tauxHoraire = tauxHoraire;
        this.dateEntre = dateEntre;
    }

    public Personne(int idMpiasa, String nom, double tauxHoraire, Date dateEntre) {
        this.idMpiasa = idMpiasa;
        this.nom = nom;
        this.tauxHoraire = tauxHoraire;
        this.dateEntre = dateEntre;
    }

    public Personne(int idPersonne, int idMpiasa, String nom, double tauxHoraire, Date dateEntre, String poste) {
        this.idPersonne = idPersonne;
        this.idMpiasa = idMpiasa;
        this.nom = nom;
        this.tauxHoraire = tauxHoraire;
        this.dateEntre = dateEntre;
        this.poste = poste;
    }

    
    public void insert()throws Exception
    {
        Connection connecting = new Connect().getConnection();
        String req = "INSERT INTO personne(idMpiasa,nom,dateEntre,tauxHoraire,genre) VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
        pstmt.setInt(1, this.getIdMpiasa());
        pstmt.setString(2, this.getNom());
        pstmt.setDate(3, this.getDateEntre());
        pstmt.setDouble(4, this.getTauxHoraire());
        pstmt.setInt(5, this.getGenre());
        pstmt.executeUpdate();
        connecting.close();
    }
    
    public void update()throws Exception
    {
        Connection connecting = new Connect().getConnection();
        String req = "UPDATE personne SET idMpiasa=?, tauxHoraire=? WHERE idPersonne=?";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
        
        double salaire=this.getTauxHoraire()/this.getIdMpiasa();
        this.setIdMpiasa();
        
        pstmt.setInt(1, this.getIdMpiasa());
        pstmt.setDouble(2, salaire*this.getIdMpiasa());
        pstmt.setInt(3, this.getIdPersonne());
        pstmt.executeUpdate();
        connecting.close();
    }

    
    public Vector<Personne> getAll()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from v_personne";
        ResultSet render = stmt.executeQuery(req);
        Vector<Personne> result = new Vector<Personne>();
        while(render.next()){
            result.add(new Personne(render.getInt("idpersonne"),render.getInt("idmpiasa"),render.getString("nom"),render.getDouble("tauxhoraire"),render.getDate("dateentre"),render.getString("poste")));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
