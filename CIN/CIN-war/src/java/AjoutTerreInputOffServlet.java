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

/**
 *
 * @author tahir
 */
@WebServlet(urlPatterns = {"/AjoutTerreInputOffServlet"})
public class AjoutTerreInputOffServlet extends HttpServlet {

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
            request.setAttribute("cin",cin);

            String localisation=request.getParameter("localisation");
            int nbrBorne=Integer.valueOf(request.getParameter("nbrBorne"));
            ArrayList<Double> latitudes = new ArrayList<Double>();
            ArrayList<Double> longitudes=new ArrayList<Double>();
            for(int i=0;i<nbrBorne;i++)
            {
                latitudes.add(Double.parseDouble(request.getParameter("lat"+String.valueOf(i))));
                longitudes.add(Double.parseDouble(request.getParameter("long"+String.valueOf(i))));
            }
            double surface=bornes.calculerAire(latitudes, longitudes);
            double perimetre=bornes.getPerimetre(latitudes, longitudes);
            int idTerre=tany.insertTerre(Integer.parseInt(cin), localisation, surface,perimetre);
            for(int j=0;j<nbrBorne;j++)
            {
                bornes.insertBornes(idTerre, latitudes.get(j), longitudes.get(j));
            }
            response.sendRedirect("Valiny?cin=" + cin+"&error=0");
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
