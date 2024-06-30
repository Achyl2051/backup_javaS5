/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mamaky;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author tahir
 */
public class Mamaky {
    public static void main(String[] args) {
        // Spécifiez le chemin du fichier
        String cheminFichier = "D:/bv2a/110101010101.pdf.txt";
        int codeBV=10;
        int inscrits=11;
        int votants=12;
        int bn=13;
        int total=14;

        String numeroBureauString="";
        String inscritString="";
        String votantString="";
        String blancString="";
        String nulString="";
        String totalString="";

        try (BufferedReader lecteur = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            int count=1;

            while ((ligne = lecteur.readLine()) != null) {
                if(count==codeBV)
                {
                    numeroBureauString = makaChiffreApres(ligne,"BureaudeVote:");

                    System.out.println("code bureau de vote => "+numeroBureauString);    
                }
                else if(count==inscrits)
                {
                    inscritString = makaChiffreApres(ligne,"Inscrits:");
                    System.out.println("Inscrits => "+inscritString); 
                }
                else if(count==votants)
                {
                    votantString = makaChiffreApres(ligne,"Votants:");
                    System.out.println("votants => "+votantString); 
                }
                else if(count==bn)
                {
                    blancString = makaChiffreApres(ligne,"Blancs:");
                    System.out.println("Blancs => "+blancString); 

                    nulString = makaChiffreApres(ligne,"Nuls:");
                    System.out.println("Nuls => "+nulString); 
                }
                else if(count==total)
                {
                    totalString = makaChiffreApres(ligne,"Suffragesexprimés:");
                    System.out.println("Total => "+totalString); 

                    try{
                        System.out.println("connex => "+getConnection());
                        insertResultat(Integer.parseInt(totalString),numeroBureauString,Integer.parseInt(inscritString),Integer.parseInt(votantString),Integer.parseInt(blancString),Integer.parseInt(nulString));
                    }
                    catch(Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String makaChiffreApres(String ligne,String mot)
    {
        ligne = ligne.replace(" ", "");

        int debutIndex = ligne.indexOf(mot);

        int finIndex = debutIndex + mot.length();
        while (finIndex < ligne.length() && !Character.isDigit(ligne.charAt(finIndex))) {
            finIndex++;
        }

        int finNombreIndex = finIndex;
        while (finNombreIndex < ligne.length() && Character.isDigit(ligne.charAt(finNombreIndex))) {
            finNombreIndex++;
        }
        String result = ligne.substring(finIndex, finNombreIndex);
        return result;
    }

    public static Connection getConnection() {
        Connection connection = null;

        try {
            // Charger le pilote JDBC PostgreSQL.
            Class.forName("org.postgresql.Driver");

            // Établir une connexion à la base de données.
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/fifidianana","postgres","root");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    public static int insertResultat(int total,String codeBV,int inscrits,int votants,int blancs,int nullls)throws Exception
    {
        Connection connecting = getConnection();
        String req = "INSERT INTO resultat (total, codeBV, inscrits, votants, blancs, nuls) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connecting.prepareStatement(req); 
        pstmt.setInt(1, total);
        pstmt.setString(2, codeBV);
        pstmt.setInt(3, inscrits);
        pstmt.setInt(4, votants);
        pstmt.setInt(5, blancs);
        pstmt.setInt(6, nullls);
        pstmt.executeUpdate();

        ResultSet generatedKeys = pstmt.getGeneratedKeys();
        int idResultat = -1;
        if (generatedKeys.next()) {
            idResultat = generatedKeys.getInt(1);
        }
        
        connecting.close();

        return idResultat;
    }  
}
