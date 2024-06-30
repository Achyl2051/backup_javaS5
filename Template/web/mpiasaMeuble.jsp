<%-- 
    Document   : mpiasaMeuble
    Created on : 20 janv. 2024, 18:04:41
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.*, java.util.*" %>
<%
    String username = (String)session.getAttribute("username");
    Vector<Volume> volume = (Vector<Volume>) request.getAttribute("volume");
    Vector<Mpiasa> mpiasa = (Vector<Mpiasa>) request.getAttribute("mpiasa");
    Vector<V_meuble> meuble = (Vector<V_meuble>) request.getAttribute("meuble");
%>

<%@ include file="header.jsp" %>

<main>
  <div class="container">

    <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-6 col-md-6 d-flex flex-column align-items-center justify-content-center">

            <div class="card mb-3">

              <div class="card-body">

                <div class="pt-4 pb-3">
                  <h5 class="card-title text-center pb-0 fs-4">Ajout meuble</h5>
                  <p class="text-center small">Entrez les informations concerant le meuble.
                  </p>
                </div>

                <form id="login" class="row g-3 needs-validation" method="post" action="InsertAssemblageMpiasaMeuble" novalidate>
                    
                    <div class="row mb-3">
                        <label for="inputText" class="col-sm-3 col-form-label">Meuble</label>
                        <div class="col-sm-9 input-group">
                          <select class="form-select" aria-label="Default select example" name="meuble">
                                <option value="#"> Choisir ...</option>
                                <% for (int i = 0; i < meuble.size(); i++) { %>
                                        <option value="<%= meuble.get(i).getIdMeuble() %>"><%= meuble.get(i).getCategorie() %> <%= meuble.get(i).getStyle() %></option>
                                <% } %>
                          </select>
                        </div>
                    </div>

                    <div class="row mb-3">
                        <label for="inputText" class="col-sm-3 col-form-label">Volume</label>
                        <div class="col-sm-9 input-group">
                          <select class="form-select" aria-label="Default select example" name="volume">
                                <option value="#"> Choisir ...</option>
                                <% for (int i = 0; i < volume.size(); i++) { %>
                                        <option value="<%= volume.get(i).getIdVolume() %>"><%= volume.get(i).getNom() %></option>
                                <% } %>
                          </select>
                        </div>
                    </div>
                          
                          <h3>mpiasa:</h3>
                    <%
                        for(int i=0;i<mpiasa.size();i++)
                        { %>
                            <div class="row mb-3">
                              <label for="inputNumber" class="col-sm-3 col-form-label"><%= mpiasa.get(i).getNom() %></label>
                              <div class="col-sm-9 input-group has-validation">
                                  <input type="number" class="form-control" name="<%= mpiasa.get(i).getIdMpiasa()%>" value="0" required>
                                <div class="invalid-feedback">Entrer la nombre de mpiasa</div>
                              </div>
                            </div>
                        <%}
                    %>
                          
                <input type="hidden" name="meuble" value="<%= meuble %>">

                <div class="col-6">
                  <button class="btn btn-secondary w-100" type="reset">Annuler</button>
                </div>

                <div class="col-6">
                  <button class="btn btn-primary w-100 " type="submit">Save</button>
                </div>
              </form>

              </div>
            </div>

          </div>
        </div>
      </div>

    </section>

  </div>
</main>

<%@ include file="footer.jsp" %>