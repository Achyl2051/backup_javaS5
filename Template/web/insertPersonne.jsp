<%-- 
    Document   : insertPersonne
    Created on : 23 janv. 2024, 14:50:57
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.*, java.util.*" %>
<%
    String username = (String)session.getAttribute("username");
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
                  <h5 class="card-title text-center pb-0 fs-4">Ajout personne</h5>
                  <p class="text-center small">Entrez les informations concerant la personne.
                  </p>
                </div>

                <form id="login" class="row g-3 needs-validation" method="post" action="InsertPersonne" novalidate>
                  
                  <div class="row mb-3">
                    <label for="inputText" class="col-sm-3 col-form-label">Nom</label>
                    <div class="col-sm-9 input-group has-validation">
                      <input type="text" class="form-control" name="nom" required>
                      <div class="invalid-feedback">Entrer le nom</div>
                    </div>
                  </div>
                    
                  <div class="row mb-3">
                    <label for="inputText" class="col-sm-3 col-form-label">Taux horaire</label>
                    <div class="col-sm-9 input-group has-validation">
                      <input type="number" step="0.01" class="form-control" name="tauxHoraire" required>
                      <div class="invalid-feedback">Entrer le taux horaire</div>
                    </div>
                  </div>
                    
                  <div class="row mb-3">
                    <label for="inputText" class="col-sm-3 col-form-label">Date entre</label>
                    <div class="col-sm-9 input-group has-validation">
                      <input type="date" class="form-control" name="date" required>
                      <div class="invalid-feedback">Entrer la date</div>
                    </div>
                  </div>
                    
                    <div class="row mb-3">
                        <label for="inputText" class="col-sm-3 col-form-label">Genre</label>
                        <div class="col-sm-9 input-group">
                          <select class="form-select" aria-label="Default select example" name="genre">              
                                <option value="1">Homme</option>
                                <option value="0">Femme</option> 
                          </select>
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
