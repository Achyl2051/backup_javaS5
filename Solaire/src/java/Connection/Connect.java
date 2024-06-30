/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;
import java.sql.*;

/**
 *
 * @author ITU
 */
public class Connect {
        String username;
	String password="root";

	public Connect(String username,String password){
		set_user(username);
		set_pass("root");
	}
        public Connect(){}
	public void set_user(String username){
		if (username!=" ") {
			this.username=username;
		}
	}
	public void set_pass(String password){
		if (password!=" ") {
			this.password=password;
		}
	}

	public Connection get_connex() throws ClassNotFoundException,SQLException{
		Class.forName("org.postgresql.Driver");
            Connection result = DriverManager.getConnection("jdbc:postgresql://localhost:5432/solaire",this.username,this.password);
            return result;
	}
}
