/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tahir
 */
public class Connect {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/meuble";
    private static final String DATABASE_USER = "postgres";
    private static final String DATABASE_PASSWORD = "root";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            // Charger le pilote JDBC PostgreSQL.
            Class.forName("org.postgresql.Driver");

            // Établir une connexion à la base de données.
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
}
