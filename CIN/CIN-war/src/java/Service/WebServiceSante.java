/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Service;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author tahir
 */
@WebServlet(urlPatterns = {"/WebServiceSante"})
public class WebServiceSante extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }
    
    public static String fetchDataFromWebService()
    {
        try {
            URL url=new URL("http://localhost:31076/api/sante");
            HttpURLConnection con=(HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader reader=new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response=new StringBuilder();
            String line;
            while((line=reader.readLine())!=null)
            {
                response.append(line);
            }
            con.disconnect();
            return response.toString();
        } catch (Exception ex) {
        }
        return null;
    }
    
    public static String personneWithoutMe(String cin)
    {
        try {
            URL url=new URL("http://localhost:31076/api/sante/cin?cin="+cin);
            HttpURLConnection con=(HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader reader=new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response=new StringBuilder();
            String line;
            while((line=reader.readLine())!=null)
            {
                response.append(line);
            }
            con.disconnect();
            return response.toString();
        } catch (Exception ex) {
        }
        return null;
    }
    
    public String WebServiceSante(String cin)
    {
        try {
            URL url=new URL("http://localhost:31076/api/sante/id?id="+cin);
            HttpURLConnection con=(HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader reader=new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response=new StringBuilder();
            String line;
            while((line=reader.readLine())!=null)
            {
                response.append(line);
            }
            con.disconnect();
            return response.toString();
        } catch (Exception ex) {
        }
        return null;
    }
    
    public Map<Integer, Map<String, String>> parsePersonne() {
        Map<Integer, Map<String, String>> resultMap = new HashMap<>();

        try {
            String jsonData=fetchDataFromWebService();
            // Convertir la chaîne JSON en un tableau JSON
            JSONArray jsonArray = new JSONArray(jsonData);

            for (int i = 0; i < jsonArray.length(); i++) {
                // Obtenir un objet JSON individuel à partir du tableau JSON
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                // Extraire les données du patient de l'objet JSON
                int cin = jsonObject.getInt("cin");

                // Créer un sous-map pour stocker les autres détails du patient
                Map<String, String> patientDetails = new HashMap<>();
                patientDetails.put("pat_name", jsonObject.getString("pat_name"));
                patientDetails.put("pat_forename", jsonObject.getString("pat_forename"));
                patientDetails.put("genre", jsonObject.getString("genre"));

                // Ajouter le sous-map au résultat avec "cin" comme clé
                resultMap.put(cin, patientDetails);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Gérer les exceptions en conséquence
        }

        return resultMap;
    }
    
    public Map<Integer, Map<String, String>> parsePersonneWihtoutMe(String id) {
        Map<Integer, Map<String, String>> resultMap = new HashMap<>();

        try {
            String jsonData=personneWithoutMe(id);
            // Convertir la chaîne JSON en un tableau JSON
            JSONArray jsonArray = new JSONArray(jsonData);

            for (int i = 0; i < jsonArray.length(); i++) {
                // Obtenir un objet JSON individuel à partir du tableau JSON
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                // Extraire les données du patient de l'objet JSON
                int cin = jsonObject.getInt("cin");

                // Créer un sous-map pour stocker les autres détails du patient
                Map<String, String> patientDetails = new HashMap<>();
                patientDetails.put("pat_name", jsonObject.getString("pat_name"));
                patientDetails.put("pat_forename", jsonObject.getString("pat_forename"));
                patientDetails.put("genre", jsonObject.getString("genre"));

                // Ajouter le sous-map au résultat avec "cin" comme clé
                resultMap.put(cin, patientDetails);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Gérer les exceptions en conséquence
        }

        return resultMap;
    }
    
    public Map<String, Object> parseSante(String cin) {
        WebServiceSante ty=new WebServiceSante();
        String jsonString=ty.WebServiceSante(cin);
        JSONObject jsonObject = new JSONObject(jsonString);
        Map<String, Object> map = new HashMap<>();

        for (String key : jsonObject.keySet()) {
            map.put(key, jsonObject.get(key));
        }

        return map;
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
