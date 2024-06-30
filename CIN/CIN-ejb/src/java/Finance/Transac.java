/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Finance;

import jakarta.ejb.Stateless;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author tahir
 */
@Stateless
public class Transac implements EjbTransac{
    int id;
    int cinsend;
    int cinreceive;
    double valeur;

    public Transac() {
    }

    public Transac(int id, int cinsend, int cinreceive, double valeur) {
        this.id = id;
        this.cinsend = cinsend;
        this.cinreceive = cinreceive;
        this.valeur = valeur;
    }

    public Transac(int cinsend, int cinreceive, double valeur) {
        this.cinsend = cinsend;
        this.cinreceive = cinreceive;
        this.valeur = valeur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCinsend() {
        return cinsend;
    }

    public void setCinsend(int cinsend) {
        this.cinsend = cinsend;
    }

    public int getCinreceive() {
        return cinreceive;
    }

    public void setCinreceive(int cinreceive) {
        this.cinreceive = cinreceive;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
    
    @Override
    public double getSolde(String cin){
        Connection connecting=null;
	ConFinance connection=new ConFinance();
	connecting=connection.getConnection();
        double result = 0;
        try{
            Statement stmt = connecting.createStatement();
            String req = "select (select sum(valeur) from transac where cinreceive="+cin+")-(select sum(valeur) from transac where cinsend="+cin+") as difference";
            ResultSet render = stmt.executeQuery(req);
            while(render.next()){
                result+=render.getDouble(1);
            }
            stmt.close();
            connecting.close();
        }
        catch(Exception e)
        {}
        return result;
    }
    @Override
    public String transferer(String cinsend,String cinreceive,String valeur,String solde,String ta,String tv){
        Connection connecting=null;
	ConFinance connection=new ConFinance();
	connecting=connection.getConnection();
        double volaVidina=Double.parseDouble(ta)*Double.parseDouble(valeur);
        double volaAlefa=Double.parseDouble(tv)*Double.parseDouble(valeur);
        try{
            if(Double.parseDouble(solde)>=volaVidina&&Double.parseDouble(valeur)>=0)
            {
                String req = "INSERT INTO transac (cinSend,cinReceive,valeur) VALUES ("+cinsend+",0,"+Double.toString(volaVidina)+")";
                PreparedStatement preparedStatement = connecting.prepareStatement(req);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                String reqs = "INSERT INTO transac (cinSend,cinReceive,valeur) VALUES (0,"+cinreceive+","+Double.toString(volaAlefa)+")";
                PreparedStatement preparedStatements = connecting.prepareStatement(reqs);
                preparedStatements.executeUpdate();
                preparedStatement.executeUpdate();
                preparedStatement.close();
                connecting.close();
            }
            else
            {}

            return "0";
        }
        catch(Exception e)
        {}
        return "1";
    }
}
