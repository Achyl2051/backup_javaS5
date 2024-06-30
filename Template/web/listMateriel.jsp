<%-- 
    Document   : listMateriel
    Created on : 12 déc. 2023, 17:10:02
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.*, java.util.*" %>
<%
    String username = (String)session.getAttribute("username");
    Vector<V_detailStyle> materiel = (Vector<V_detailStyle>) request.getAttribute("materiel");
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
                                                            <th>id</th>
                                                            <th>nom</th>
                                                            <th>unite</th>

                                                    </tr>
                                                    <% for (int i = 0; i < materiel.size(); i++) { %>
                                                    <tr>

                                                            <td> <%= materiel.get(i).getId() %></td>
                                                            <td> <%= materiel.get(i).getMateriel()%></td>
                                                            <td> <%= materiel.get(i).getUnite()%></td>

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
