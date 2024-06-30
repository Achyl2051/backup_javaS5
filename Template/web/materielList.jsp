<%-- 
    Document   : listMaterielChoice
    Created on : 12 déc. 2023, 16:54:28
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.*, java.util.*" %>
<%
    String username = (String)session.getAttribute("username");
    Vector<V_result> v_result = (Vector<V_result>) request.getAttribute("v_result");
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
                                                            <th>nom</th>
                                                            <th>quantite</th>

                                                    </tr>
                                                    <% for (int i = 0; i < v_result.size(); i++) { %>
                                                    <tr>

                                                            <td> <%= v_result.get(i).getCategorie() %> <%= v_result.get(i).getStyle() %> <%= v_result.get(i).getVolume() %></td>
                                                            <td> <%= v_result.get(i).getQuantite()%></td>

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

