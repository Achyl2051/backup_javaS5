/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Foncier.EjbBornes;
import Foncier.EjbFoncier;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author tahir
 */
@WebServlet(urlPatterns = {"/AjoutTerreMapOnServlet"})
public class AjoutTerreMapOnServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    EjbFoncier tany;
    @EJB
    EjbBornes bornes;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String cin=request.getParameter("cin");
            
            String localisation=request.getParameter("localisation");
            float superficie=Float.valueOf(request.getParameter("superficie"));
            float perimetre=Float.valueOf(request.getParameter("perimetre"));

            String jsonData=request.getParameter("coordinates");
            
            ArrayList<Float> latitudes = new ArrayList<>();
            ArrayList<Float> longitudes = new ArrayList<>();

            // Utilisez JSONTokener pour traiter la chaîne JSON
            JSONTokener jsonTokener = new JSONTokener(jsonData);
            JSONArray jsonArray = new JSONArray(jsonTokener);

            // Parcourez le tableau JSON et extrayez les latitudes et longitudes
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                float lat = (float) jsonObject.getDouble("lat");
                float lng = (float) jsonObject.getDouble("lng");
                latitudes.add(lat);
                longitudes.add(lng);
            }
            
            if(latitudes.size()<3)
            {
                response.sendRedirect("Valiny?cin=" + cin+"&error=1");
            }
            else
            {
                // double surface=bornes.calculerAire(latitudes, longitudes);
                int idTerre=tany.insertTerre(Integer.parseInt(cin), localisation, superficie,perimetre);
                for(int j=0;j<latitudes.size();j++)
                {
                    bornes.insertBornes(idTerre, latitudes.get(j), longitudes.get(j));
                }

                response.sendRedirect("Valiny?cin=" + cin+"&error=0");   
            }
        }
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
