/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ITU
 */
import Connection.Connect;
import java.sql.Connection;
import java.util.Date;
import java.sql.Time;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.Vector;

public class Presence {
    Date date;
    int idSalle;
    int type;
    int nbEleve;
    double consommation;

    public Presence(Date date, int idSalle, int type, int nbEleve, double consommation) {
        setDate(date);
        setIdSalle(idSalle);
        setType(type);
        setNbEleve(nbEleve);
        setConsommation(consommation);
    }

    public Presence() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNbEleve() {
        return nbEleve;
    }

    public void setNbEleve(int nbEleve) {
        this.nbEleve = nbEleve;
    }

    public double getConsommation() {
        return consommation;
    }

    public void setConsommation(double consommation) {
        this.consommation = consommation;
    }
    
    public Vector<Presence> getAll()throws Exception{
        Connection connecting=null;
	Connect connection=new Connect("postgres","");
	connecting=connection.get_connex();
        Statement stmt = connecting.createStatement();
   	String req = "select * from presence";
        ResultSet render = stmt.executeQuery(req);
        Vector<Presence> result = new Vector<Presence>();
        while(render.next()){
            result.add(new Presence(render.getDate(1),render.getInt(2),render.getInt(3),render.getInt(4),render.getDouble(5)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    
    public int getNumDate(Date date)throws Exception{
        int result = 0;        
        Connection connecting=null;
	Connect connection=new Connect("postgres","");
	connecting=connection.get_connex();
        Statement stmt = connecting.createStatement();
   	String req = "SELECT EXTRACT(DOW FROM '"+date+"'::date) as numJour";
        ResultSet render = stmt.executeQuery(req);
        while(render.next()){
            result = render.getInt(1);
	}
        stmt.close();
        connecting.close();
        return result;
    }
    
    public int getEleve(Date date,int heure,int idPanneau)throws Exception{
        Connection connecting=null;
	Connect connection=new Connect("postgres","");
	connecting=connection.get_connex();
        Panneau pan = new Panneau().getById(idPanneau);
        Vector<Salle> listSalle = pan.getSalle();
        int result = 0;
        int numeroDate = this.getNumDate(date);
        for(int i = 0; i<listSalle.size();i++){
            Statement stmt = connecting.createStatement();
            String req = "select avg(nbEleve) from presence where (SELECT EXTRACT(DOW FROM date))= "+ numeroDate +" and idSalle = "+listSalle.get(i).getIdSalle()+" and type = 1";
            if(heure>13){
                req="select avg(nbEleve) from presence where (SELECT EXTRACT(DOW FROM date))= "+ numeroDate +" and idSalle = "+listSalle.get(i).getIdSalle()+" and type = 5";
            }
            ResultSet render = stmt.executeQuery(req);
            while(render.next()){
                result += render.getInt(1);
            }
            stmt.close();
        }
        connecting.close();
        return result;
    }
    public double getConsommation(Date date,int idPanneau,Vector<Historique> historiques,Vector<Luminosite> luminosites,Vector<Panneau> listPanneau)throws Exception{
        double result = 0;
        double min = 20;
        double max = 100;
        for(int i = 0;i<historiques.size();i++){
            int heureSim = 8;
            int minuteSim = 0;
            int heureCoup = 18;
            int minuteCoup = 0;
            double consoTemp = 0;
            while(true){
                consoTemp = (min+max)/2;
                System.out.print("conso"+i+": "+consoTemp);
                Time simulation = this.simulation(historiques.get(i).getDate(),consoTemp,luminosites,listPanneau
                );
                Time histoCoupure = new Time(historiques.get(i).getHeure(),historiques.get(i).getMinute(),0);
                if(simulation==null){
                    simulation = new Time(18,0,0);
                }
                heureSim = simulation.getHours();
                minuteSim = simulation.getMinutes();
                heureCoup = histoCoupure.getHours();
                minuteCoup = histoCoupure.getMinutes();
                if(heureSim==heureCoup){
                    if(minuteSim==minuteCoup||minuteSim==minuteCoup+1||minuteSim==minuteCoup+1){
                        break;
                    }
                }
                if(simulation.after(histoCoupure)){
                    min=consoTemp;
                    continue;
                }
                if(simulation.before(histoCoupure)){
                    max=consoTemp;
                }
            }
            result += consoTemp;
            min = 20;
            max = 100;
        }
        return result/historiques.size();
    }
    public Time simulation(Date date,double consommation,Vector<Luminosite> luminosites,Vector<Panneau> listPanneau)throws Exception{
        Time coupure = null;
        for(int i = 0; i<listPanneau.size();i++){
            double batterie = listPanneau.get(i).getConsoBat() / 2;
            double batMax = listPanneau.get(i).getConsoBat() / 2;
            for(int j=0;j<luminosites.size();j++){
                int eleve = new Presence().getEleve(date,luminosites.get(j).getHeure(),listPanneau.get(i).getIdPanneau());
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
                if(coupure!=null){
                    break;
                }
            }
        }
        return coupure;
    }
}
