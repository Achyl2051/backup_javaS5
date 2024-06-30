<%-- 
    Document   : insertMateriel
    Created on : 12 déc. 2023, 16:19:05
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.*, java.util.*" %>
<%
    String username = (String)session.getAttribute("username");
    Vector<Materiel> mat = (Vector<Materiel>) request.getAttribute("mat");
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
                  <h5 class="card-title text-center pb-0 fs-4">Entre de Stock</h5>
                  <p class="text-center small">Information sur l entre de stock.
                  </p>
                </div>

                <form id="login" class="row g-3 needs-validation" method="post" action="InsertEntreDeStock" novalidate>
                  
                    <div class="row mb-3">
                        <label for="inputText" class="col-sm-3 col-form-label">Materiel</label>
                        <div class="col-sm-9 input-group">
                          <select class="form-select" aria-label="Default select example" name="materiel">
                                 <option value="#"> Choisir ...</option>
                                <% for (int i = 0; i < mat.size(); i++) { %>
                                        <option value="<%= mat.get(i).getIdMateriel() %>"><%= mat.get(i).getNom() %></option>
                                <% } %>
                          </select>
                        </div>
                    </div>
                    <div class="row mb-3">
                    <label for="inputText" class="col-sm-3 col-form-label">Quantite</label>
                    <div class="col-sm-9 input-group has-validation">
                      <input type="number" class="form-control" name="qte" required>
                      <div class="invalid-feedback">Entrer la quantite</div>
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
