<%-- 
    Document   : Result
    Created on : 7 oct. 2023, 12:22:43
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Finance.Banque" %>
<%@ page import="Foncier.Terre" %>
<%@ page import="Foncier.Devis" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%
    String error= (String)request.getAttribute("error");
    Banque banques= (Banque)request.getAttribute("banques");
    ArrayList<Terre> terres= (ArrayList<Terre>)request.getAttribute("terres");
    Map<String, Object> sante=(Map<String, Object>)request.getAttribute("sante");
    Map<Integer, Map<String, String>> personne=(Map<Integer, Map<String, String>>)request.getAttribute("personne");
    double solde=(double)request.getAttribute("solde");
    ArrayList<Devis> devis=(ArrayList<Devis>)request.getAttribute("devis");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(Double.parseDouble(error)!=0)
            {
            %>
                <h1 style="color: red;">
                    Verifieo ny logique anao azafady
                </h1>
            <%
            }
        %>
        <h1>CIN : <%= sante.get("idPat") %></h1>
        <hr>
        <h2>Sante:</h2>
        <p>
            Pois : <%= sante.get("poids") %> kg
        </p>
        <p>
            Date de naissance : <%= sante.get("dateNaissance") %>
        </p>
        <p>
            Date de deces :
            <%
                if("0001-01-01T00:00:00".equalsIgnoreCase(String.valueOf(sante.get("dateDeces"))))
                {out.println("encore en vie");}
                else{
                out.println(sante.get("dateDeces"));
            }
                
            %>
            
        </p>
        <hr>
        <h2>Finance:</h2>
        <h3>
            <%= banques.getBanque_nom() %>
        </h3>
        <p>
            Numéro de compte:
            <%= banques.getBanque_compte() %>
        </p>
        <p>
            Solde:
            <%= solde %> Ariary
        </p>
        <form action="TraitementTransfert" method="post">
            <h3>
                Tranferer de l'argent :
            </h3>
            <P>
                Choisir destinataire : 
                <select name="pers">
                    <%
                        for (Map.Entry<Integer, Map<String, String>> entry : personne.entrySet()) {
                            int cin = entry.getKey();
                            Map<String, String> personneDetails = entry.getValue();
                            %>
                                <option value="<%= cin %>"><%= personneDetails.get("pat_forename") %></option>
                            <%
                        }
                    %>
                </select>
            </P>
            <p>
                Montant de l'argent : 
                <input type="number" name="argent" step="0.01">
            </p>
            <P>
                Choisir devis : 
                <select name="devs">
                    <%
                        for(int i=0;i<devis.size();i++)
                        {
                        %>
                            <option value="<%= devis.get(i).getId() %>"><%= devis.get(i).getNom() %></option>
                        <%
                        }
                    %>
                </select>
            </P>
            <input type="hidden" name="cinsend" value="<%= sante.get("idPat") %>">
            <input type="hidden" name="solde" value="<%= solde %>">
            <p>
                <input type="submit" value="transferer">
            </p>
        </form>
        <hr>
        <h2>Foncier:</h2>
        <%
            for(int j=0;j<terres.size();j++)
            {
        %>
        <a href="Carte?id=<%= terres.get(j).getId() %>">
            <h3>
                Terre numéro <%= j+1 %> :
            </h3>
        </a>
        <p>
            Localisation : 
            <%= terres.get(j).getTerre_localisation() %>
        </p>
        <p>
            Superficie:
            <%= terres.get(j).getSuperficie() %> metres carres
        </p>
        <p>
            Perimetre
            <%= terres.get(j).getPerimetre() %> metres
        </p>
        <br>
        <%
            }
        %>
        <h2>
            Ajout de terre:
        </h2>
        <form action="TraitementAjoutTerre" method="post">
            <p>
                Localisation <input type="text" name="localisation">    
            </p>
            <p>
                Connais-tu la superficie? 
                <select name="superficie">
                    <option value="1">
                        Oui
                    </option>
                    <option value="0">
                        Non
                    </option>
                </select>
            </p>
            <p>
                input ou map?
                <select name="choice">
                    <option value="0">
                        input
                    </option>
                    <option value="1">
                        map
                    </option>
                </select>
            </p>
            <input type="hidden" name="cin" value="<%= sante.get("idPat") %>">
            <input type="submit" value="valider">
        </form>
    </body>
</html>
