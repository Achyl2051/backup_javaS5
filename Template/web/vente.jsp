<%-- 
    Document   : vente
    Created on : 25 janv. 2024, 15:35:17
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.*, java.util.*" %>
<%
    String username = (String)session.getAttribute("username");
    Vector<V_produit> produit = (Vector<V_produit>) request.getAttribute("produit");
    String error = (String) request.getAttribute("error");
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
                  <h5 class="card-title text-center pb-0 fs-4">Vente</h5>
                  <p class="text-center small">Entrez les informations concerant la vente.
                  </p>
                  <h1 style="color: red"><%= error %></h1>
                </div>

                <form id="login" class="row g-3 needs-validation" method="post" action="Vendre" novalidate>
                  
                    <div class="row mb-3">
                        <label for="inputText" class="col-sm-3 col-form-label">nom</label>
                        <div class="col-sm-9 input-group">
                          <select class="form-select" aria-label="Default select example" name="nom">
                                <option value="#"> Choisir ...</option>
                                <% for (int i = 0; i < produit.size(); i++) { %>
                                        <option value="<%= produit.get(i).getIdMeuble() %>&&<%=produit.get(i).getIdVolume() %>"><%= produit.get(i).getNom() %></option>
                                <% } %>
                          </select>
                        </div>
                    </div>
                    
                  <div class="row mb-3">
                    <label for="inputText" class="col-sm-3 col-form-label">Quantite</label>
                    <div class="col-sm-9 input-group has-validation">
                      <input type="number"  class="form-control" name="qte" required>
                      <div class="invalid-feedback">Entrer la quantite</div>
                    </div>
                  </div>
                          
                    <div class="row mb-3">
                        <label for="inputText" class="col-sm-3 col-form-label">genre</label>
                        <div class="col-sm-9 input-group">
                          <select class="form-select" aria-label="Default select example" name="genre">
                                <option value="#"> Choisir ...</option>
                                <option value="1"> Homme </option>
                                <option value="0"> Femme </option>
                          </select>
                        </div>
                    </div>
                    
                  <div class="row mb-3">
                    <label for="inputText" class="col-sm-3 col-form-label">Date entre</label>
                    <div class="col-sm-9 input-group has-validation">
                      <input type="date" class="form-control" name="date" required>
                      <div class="invalid-feedback">Entrer la date</div>
                    </div>
                  </div>

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