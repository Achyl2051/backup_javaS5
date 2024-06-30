<%-- 
    Document   : ResultBenefice
    Created on : 16 janv. 2024, 11:49:07
    Author     : Lenovo Legion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.*, java.util.*" %>
<%
    String username = (String)session.getAttribute("username");
    Vector<StockVente> result = (Vector<StockVente>)request.getAttribute("stockVente");
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
                                                            <th>Nom</th>
                                                            <th>Quantite</th>

                                                    </tr>
                                                    <% for (int i = 0; i < result.size(); i++) { %>
                                                    <tr>

                                                            <td> <%= result.get(i).getNom() %></td>
                                                            <td> <%= result.get(i).getQuantite()%></td>

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