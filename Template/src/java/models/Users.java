/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import connection.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author tahir
 */
public class Users {
    int id;
    String pseudo;
    String email;
    String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users(int id, String pseudo, String email, String password) {
        this.id = id;
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
    }

    public Users() {
    }
    
    public Users authentification(String pseudo , String pass)throws Exception{
        Connection connecting=new Connect().getConnection();
        Statement stmt = connecting.createStatement();
   	String req = "select * from users where pseudo='"+pseudo+"' and password='"+pass+"'";
        ResultSet render = stmt.executeQuery(req);
        Users result = null;
        while(render.next()){
            result=new Users(render.getInt(1),render.getString(2),render.getString(3),render.getString(4));
	}
        stmt.close();
        connecting.close();
        return result;
    }
}
