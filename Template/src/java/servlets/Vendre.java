/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ParametreFabrication;
import models.StockVente;
import models.V_produit;
import models.Vente;


/**
 *
 * @author Lenovo Legion
 */
@WebServlet(name = "Vendre", urlPatterns = {"/Vendre"})
public class Vendre extends HttpServlet {

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
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String error="tsy ampy le stock";
            String nom = request.getParameter("nom");
            String[] meubleSplit=nom.split("&&");
            int idMeuble=Integer.valueOf(meubleSplit[0]);
            int idVolume=Integer.valueOf(meubleSplit[1]);
            int qte = Integer.valueOf(request.getParameter("qte"));
            int genre = Integer.valueOf(request.getParameter("genre"));
            
            if(new StockVente().testStock(idMeuble, idVolume, qte)==true){
                String date = request.getParameter("date");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date utilDate = sdf.parse(date);
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                Vector<V_produit> produit= new V_produit().getById(idMeuble, idVolume);
                Vector<ParametreFabrication> param = new ParametreFabrication().getById(idMeuble, idVolume);
                
                StockVente temp= new StockVente().getMeuble(idMeuble, idVolume);
                new StockVente(temp.getNom(),idMeuble,idVolume,qte*(-1)).insert();
                new Vente(produit.get(0).getNom(),idMeuble,idVolume,param.get(0).getPrixVente(),sqlDate,genre,qte).insert();
                error=" ";
            }
            
            request.setAttribute("error", error);
            request.setAttribute("produit", new V_produit().getAll());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/vente.jsp");
            dispatcher.forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Vente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Vente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
