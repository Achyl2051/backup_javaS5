<%-- 
    Document   : listPersonne
    Created on : 23 janv. 2024, 14:45:04
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.*, java.util.*" %>
<%
    String username = (String)session.getAttribute("username");
    Vector<Personne> personne = (Vector<Personne>) request.getAttribute("personne");
%>

<%@ include file="header.jsp" %>

<main>
    <section class="section">
            <div class="container">
                    <div class="row justify-content-center" style="background-color:whitesmoke;border-color:whitesmoke ">
                            <div class="col-lg-8" style="margin-top: 100px;">
                                    <div class="card mb-3">
                                            <div class="card-body">
                                                <table class="table">
                                                    <tr>
                                                            <th>idPersonne</th>
                                                            <th>nom</th>
                                                            <th>taux horaire</th>
                                                            <th>poste</th>
                                                            <th>date entre</th>

                                                    </tr>
                                                    <% for (int i = 0; i < personne.size(); i++) { %>
                                                    <tr>

                                                            <td> <%= personne.get(i).getIdPersonne() %></td>
                                                            <td> <%= personne.get(i).getNom()%></td>
                                                            <td> <%= personne.get(i).getTauxHoraire()%></td>
                                                            <td> <%= personne.get(i).getPoste()%></td>
                                                            <td> <%= personne.get(i).getDateEntre()%></td>

                                                    </tr>

                                                        <% } %>
                                                </table>
                                            </div>
                                    </div> 
                            </div>
                    </div>
            </div>
    </section>
</main>                                                        
                                                        
<%@ include file="footer.jsp" %>
