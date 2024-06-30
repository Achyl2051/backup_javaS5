<%-- 
    Document   : listMateriel
    Created on : 12 déc. 2023, 17:10:02
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.*, java.util.*" %>
<%
    String username = (String)session.getAttribute("username");
    Vector<MeubleMontant> result = (Vector<MeubleMontant>)request.getAttribute("list");
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
                                                            <th>meuble</th>
                                                            <th>montant</th>

                                                    </tr>
                                                    <% for (int i = 0; i < result.size(); i++) { %>
                                                    <tr>

                                                            <td> <%= result.get(i).getCategorie() %> <%= result.get(i).getStyle() %> <%= result.get(i).getVolume() %></td>
                                                            <td> <%= result.get(i).getMontant()%>Ar</td>

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
