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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author tahir
 */
public class Validation {
    int idValidation;
    int idArticle;
    int idMagasin;
    Date date;
    double quantite;
    Date date_validation;
    int etat;
    int idUnite;

    public int getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(int idUnite) {
        this.idUnite = idUnite;
    }
    
    public int getIdMagasin() {
        return idMagasin;
    }

    public void setIdMagasin(int idMagasin) {
        this.idMagasin = idMagasin;
    }

    public int getIdValidation() {
        return idValidation;
    }

    public void setIdValidation(int idValidation) {
        this.idValidation = idValidation;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite)throws Exception {
        if(quantite<0)
        {
            throw new Exception("nisy olana be tanaty insert quantite sortie");
        }
        this.quantite = quantite;
    }

    public Date getDate_validation() {
        return date_validation;
    }

    public void setDate_validation(Date date_validation) {
        this.date_validation = date_validation;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Validation() {
    }

    public Validation(int idValidation, int idArticle, Date date, double quantite, Date date_validation, int etat,int idMagasin)throws Exception {
        this.setIdValidation(idValidation);
        this.setIdArticle(idArticle);
        this.setDate(date);
        this.setQuantite(quantite);
        this.setDate_validation(date_validation);
        this.setEtat(etat);
        this.setIdMagasin(idMagasin);
    }
    
    public Validation(int idValidation, int idArticle, Date date, double quantite, Date date_validation, int etat,int idMagasin,int idUnite)throws Exception {
        this.setIdValidation(idValidation);
        this.setIdArticle(idArticle);
        this.setDate(date);
        this.setQuantite(quantite);
        this.setDate_validation(date_validation);
        this.setEtat(etat);
        this.setIdMagasin(idMagasin);
        this.setIdUnite(idUnite);
    }
    
    public Validation(int idArticle,  Date date, double quantite, Date date_validation, int etat,int idMagasin)throws Exception {
        this.setIdArticle(idArticle);
        this.setDate(date);
        this.setQuantite(quantite);
        this.setDate_validation(date_validation);
        this.setEtat(etat);
        this.setIdMagasin(idMagasin);
    }
    
    public Validation(int idArticle,  Date date, double quantite, int etat,int idMagasin)throws Exception {
        this.setIdArticle(idArticle);
        this.setDate(date);
        this.setQuantite(quantite);
        this.setEtat(etat);
        this.setIdMagasin(idMagasin);
    }
    
    public Validation(int idArticle,  Date date, double quantite, int etat,int idMagasin,int idUnite)throws Exception {
        this.setIdArticle(idArticle);
        this.setDate(date);
        this.setQuantite(quantite);
        this.setEtat(etat);
        this.setIdMagasin(idMagasin);
        this.setIdUnite(idUnite);
    }
    
    public void insertValidation(int idArticle, Date date, double quantite, int idMagasin,int idUnite)throws Exception
    {
        Validation val=new Validation(idArticle,date,quantite,10,idMagasin,idUnite);
        Equivalence equival=new Equivalence().getEquivalenceById(idUnite, idArticle);
        Connection connecting = new Connect().getConnection();
        String req = "INSERT INTO validation_sortie (idArticle,idMagasin, date, quantite, date_validation, etat,idUnite) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
        pstmt.setInt(1, val.getIdArticle());
        pstmt.setInt(2, val.getIdMagasin());
        pstmt.setDate(3, new java.sql.Date(val.getDate().getTime()));
        pstmt.setDouble(4, val.getQuantite()*equival.getPoids());
        pstmt.setNull(5, java.sql.Types.DATE);
        pstmt.setDouble(6, val.getEtat());
        pstmt.setInt(7, val.getIdUnite());
        pstmt.executeUpdate();
        connecting.close();
    }
    
    public Vector<Validation> getRequest()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req ="SELECT * FROM validation_sortie where date_validation is null and etat=10";
        ResultSet render = stmt.executeQuery(req);
        Vector<Validation> result = new Vector<Validation>();
        while(render.next()){
            result.add(new Validation(render.getInt(1),render.getInt(2),render.getDate(5),render.getDouble(6),render.getDate(7),render.getInt(8),render.getInt(3),render.getInt(4)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    
    public Validation getValidationById(int id)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req ="SELECT * FROM validation_sortie where idValidation="+id;
        ResultSet render = stmt.executeQuery(req);
        Validation result = new Validation();
        while(render.next()){
            result=new Validation(render.getInt(1),render.getInt(2),render.getDate(5),render.getDouble(6),render.getDate(7),render.getInt(8),render.getInt(3),render.getInt(4));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    
    public String transfEtat()
    {
        if(this.getEtat()==0){return "supprimer";}
        else if(this.getEtat()==10){return "attente";}
        else{return "valider";}
    }
    
    public void updateValidation(int idValidation,Date date,int etat)throws Exception
    {
        Connection connecting = new Connect().getConnection();
        String req = "UPDATE validation_sortie SET date_validation = ?, etat = ? WHERE idValidation = ?";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
         pstmt.setDate(1, new java.sql.Date(date.getTime()));
         pstmt.setInt(2, etat);
         pstmt.setDouble(3, idValidation);
        pstmt.executeUpdate();
        connecting.close();
    }
    
    public void valider(int idValidation, Date date,int idUnite)throws Exception{
        Validation temp=this.getValidationById(idValidation);
        new Sortie().sortiStock(temp.getIdArticle(), temp.getIdMagasin(), date, temp.getQuantite(),idValidation,idUnite);
        this.updateValidation(idValidation, date,20);
    }
    
    public void supprimer(int idValidation, Date date)throws Exception{
        this.updateValidation(idValidation, date,0);
    }
    
    public Date lastSortie(int idArticle,int idMagasin)throws Exception{
        Connection connecting=new Connect().getConnection();
        java.sql.Statement stmt = connecting.createStatement();
   	String req = " SELECT max(date_validation) FROM validation_sortie where idArticle="+idArticle+" and idMagasin="+idMagasin+" and etat=20";
        java.sql.ResultSet render = stmt.executeQuery(req);
        Date result = null;
        while(render.next()){
            result = render.getDate(1);
	}
        stmt.close();
        connecting.close();
        if(result!=null)
        {
            return result;
        }
        String dateString = "1990-01-01";
        String dateFormatPattern = "yyyy-MM-dd";
        DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);
        Date datyy = dateFormat.parse(dateString);
        return datyy;
    }
}
