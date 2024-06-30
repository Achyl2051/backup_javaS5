/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import connection.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author tahir
 */
public class Relation {
    int idRelation;
    String mot;
    String sql;
    String ordre;

    public int getIdRelation() {
        return idRelation;
    }

    public void setIdRelation(int idRelation) {
        this.idRelation = idRelation;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getOrdre() {
        return ordre;
    }

    public void setOrdre(String ordre) {
        this.ordre = ordre;
    }

    public Relation() {
        this.setIdRelation(0);
    }

    public Relation(int idRelation, String mot, String sql, String ordre) {
        this.idRelation = idRelation;
        this.mot = mot;
        this.sql = sql;
        this.ordre = ordre;
    }
    
    public Vector<Relation> getAll()throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from relation";
        ResultSet render = stmt.executeQuery(req);
        Vector<Relation> result = new Vector<Relation>();
        while(render.next()){
            result.add(new Relation(render.getInt(1),render.getString(2),render.getString(3),render.getString(4)));
	}
        stmt.close();
        connecting.close();
        return result;
    }
    
    // mitady ilay string mifanaraka aminy le relation
    public Relation searchRelation(String[] liste) throws Exception
    {
        Relation result=new Relation();
        Vector<Relation> relations=this.getAll();
        boolean misyCher=false;
        boolean misyAvantCher=false;
        String stringCher="";
        //mitest sao dia misy cher ilay izy
        for(int t=0;t<liste.length;t++)
        {
            if(liste[t].equalsIgnoreCase("cher"))
            {
                misyCher=true;
                for(int t2=0;t2<liste.length;t2++)
                {
                    if(liste[t2].equalsIgnoreCase("moins") || liste[t2].equalsIgnoreCase("plus"))
                    {
                        misyAvantCher=true;
                        stringCher+=liste[t2]+" "+"cher";
                    }
                }
            }
        }
        //mamerina ilay relation mifanaraka aminy le fangatahana
        for(int i=0;i<liste.length;i++)
        {
            for(int j=0;j<relations.size();j++)
            {
                //testena ilay check teo fa lasa diso le sql raha moins fotsiny fa tsy moins cher ohatra
                if(misyCher==true && misyAvantCher==true)
                {
                    if(stringCher.equalsIgnoreCase(relations.get(j).getMot()))
                    {
                        return relations.get(j);
                    }
                }
                else{
                    if(liste[i].equalsIgnoreCase(relations.get(j).getMot()))
                    {
                        return relations.get(j);
                    }
                }
            }
        }
        return result;
    }
    
    //mitady ilay sql atsofoka anaty fonction getAll
    public String getSQL(String afterOrderBy,String afterWhere,String[] liste)throws Exception
    {
        
        String base="select*from V_Produit";
        if(afterWhere.equalsIgnoreCase(""))
        {
            //midika hoe tsy nahita zavatra atao eo aminy le where izy
            return base;
        }
        
        Relation relation=this.searchRelation(liste);
        try{
            if(relation.getSql().contains("prix")==true)
            {
                afterOrderBy="prix";
            }
        }
        catch(Exception excep)
        {}
        base+=" where idCategorie = "+afterWhere;
        //test sao dia tsy nahita relation akory izy
        if(relation.getIdRelation()!=0)
        {
            //jerena raha miys nombre de avy eo soloina le parametre sy le valeur
            for(int i=0;i<liste.length;i++)
            {
                if(estNombre(liste[i])==true)
                {
                    try{
                        base+=" "+relation.getSql().replace("#param#", afterOrderBy).replace("#valeur#", liste[i])+relation.getOrdre();
                        
                        for(int j=0;j<liste.length;j++)
                        {
                            if(liste[j].toLowerCase().contains("top")==true)
                            {
                                try{
                                    String[] topTemp=liste[j].split("_");
                                    if(estNombre(topTemp[0])==true)
                                    {
                                        base+=" limit "+topTemp[0];
                                    }
                                    else if(estNombre(topTemp[1])==true)
                                    {
                                        base+=" limit "+topTemp[1];
                                    }
                                }
                                catch(Exception except)
                                {
                                    break;
                                }
                            }
                        }
                        System.out.println("Ty le sql : "+base);
                        return base;
                    }
                    catch(Exception e)
                    {
                        break;
                    }
                }
            }
            //ny meilleur sy ny pire dia miova raha prix no resahana 
            if(afterOrderBy.equalsIgnoreCase("prix")&&relation.getMot().equalsIgnoreCase("meilleur") || afterOrderBy.equalsIgnoreCase("prix")&&relation.getMot().equalsIgnoreCase("pire"))
            {
                this.manovaOrdre(relation);
            }
            
            //mitest raha misy parametre de soloiny raha ohatra ka
            base+=" "+relation.getSql().replace("#param#", afterOrderBy)+relation.getOrdre();
            for(int i=0;i<liste.length;i++)
            {
                if(liste[i].toLowerCase().contains("top")==true)
                {
                    try{
                        String[] topTemp=liste[i].split("_");
                        if(estNombre(topTemp[0])==true)
                        {
                            base+=" limit "+topTemp[0];
                        }
                        else if(estNombre(topTemp[1])==true)
                        {
                            base+=" limit "+topTemp[1];
                        }
                    }
                    catch(Exception except)
                    {
                        break;
                    }
                }
            }
            
        }
        System.out.println("Ty le sql : "+base);
        return base;
    }
    
    public void manovaOrdre(Relation relation)
    {
        if(relation.getOrdre().equalsIgnoreCase("asc"))
        {
            relation.setOrdre("desc");
        }
        else{
            relation.setOrdre("asc");
        }
    }
    
    public static boolean estNombre(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
