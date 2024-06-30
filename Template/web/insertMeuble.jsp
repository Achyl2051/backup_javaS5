<%-- 
    Document   : insertMateriel
    Created on : 12 déc. 2023, 16:19:05
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.*, java.util.*" %>
<%
    String username = (String)session.getAttribute("username");
    Vector<Style> styles = (Vector<Style>) request.getAttribute("styles");
    Vector<Categorie> cat = (Vector<Categorie>) request.getAttribute("cat");
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

                <form id="login" class="row g-3 needs-validation" method="post" action="InsertMeuble" novalidate>

                    <div class="row mb-3">
                        <label for="inputText" class="col-sm-3 col-form-label">Categorie</label>
                        <div class="col-sm-9 input-group">
                          <select class="form-select" aria-label="Default select example" name="cat">
                                <option value="#"> Choisir ...</option>
                                <% for (int i = 0; i < cat.size(); i++) { %>
                                        <option value="<%= cat.get(i).getIdCategorie() %>"><%= cat.get(i).getNom() %></option>
                                <% } %>
                          </select>
                        </div>
                    </div>
                          
                    <div class="row mb-3">
                        <label for="inputText" class="col-sm-3 col-form-label">Style</label>
                        <div class="col-sm-9 input-group">
                          <select class="form-select" aria-label="Default select example" name="style">
                                <option value="#"> Choisir ...</option>
                                <% for (int i = 0; i < styles.size(); i++) { %>
                                        <option value="<%= styles.get(i).getIdStyle() %>"><%= styles.get(i).getNom() %></option>
                                <% } %>
                          </select>
                        </div>
                    </div>
                          
                    <div class="row mb-3">
                        <label for="inputText" class="col-sm-3 col-form-label">Nombre Mpiasa</label>
                        <div class="col-sm-9 input-group has-validation">
                          <input type="number" class="form-control" name="nombreMpiasa" required>
                          <div class="invalid-feedback">Entrer le nombre</div>
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
