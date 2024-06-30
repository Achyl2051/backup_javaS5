<%-- 
    Document   : listEtatStock
    Created on : 13 janv. 2024, 11:27:20
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.*, java.util.*" %>
<%
    String username = (String)session.getAttribute("username");
    Vector<EtatDeStock> stock = (Vector<EtatDeStock>) request.getAttribute("stock");
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
                                                            <th>idMateriel</th>
                                                            <th>materiel</th>
                                                            <th>prix unitaire</th>
                                                            <th>stock actuel</th>
                                                            <th>montant total</th>

                                                    </tr>
                                                    <% for (int i = 0; i < stock.size(); i++) { %>
                                                    <tr>

                                                            <td> <%= stock.get(i).getIdMateriel() %></td>
                                                            <td> <%= stock.get(i).getMateriel()%></td>
                                                            <td> <%= stock.get(i).getPu()%></td>
                                                            <td> <%= stock.get(i).getStock_actuel()%></td>
                                                            <td> <%= stock.get(i).getPrixTotal()%></td>

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