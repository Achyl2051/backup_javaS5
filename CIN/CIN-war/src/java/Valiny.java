/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Finance.Banque;
import Finance.EjbFinance;
import Finance.EjbTransac;
import Foncier.Devis;
import Foncier.EjbDevis;
import Foncier.EjbFoncier;
import Foncier.Terre;
import Service.WebServiceSante;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author tahir
 */
@WebServlet(urlPatterns = {"/Valiny"})
public class Valiny extends HttpServlet {
    @EJB
    EjbFinance finance;
    @EJB
    EjbFoncier foncier;
    @EJB
    EjbTransac transac;
    @EJB 
    EjbDevis devis;
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
            String cin=request.getParameter("cin");
            String error=request.getParameter("error");
            request.setAttribute("error",error);
            
            Banque banques=finance.getBanque(cin);
            request.setAttribute("banques",banques);
            
            ArrayList<Devis> vola=devis.getDevis();
            request.setAttribute("devis",vola);
            
            ArrayList<Terre> terres=foncier.getTerre(cin);
            request.setAttribute("terres",terres);
            
            WebServiceSante webservice=new WebServiceSante();
            Map<String, Object> sante=webservice.parseSante(cin);
            request.setAttribute("sante",sante);
            
            Map<Integer, Map<String, String>> personne=webservice.parsePersonneWihtoutMe(cin);
            request.setAttribute("personne",personne);
            
            double solde=transac.getSolde(cin);
            request.setAttribute("solde",solde);
             
            RequestDispatcher dispatcher=request.getRequestDispatcher("/result.jsp");
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
