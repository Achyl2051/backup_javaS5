
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.*, java.util.*" %>
<%
    String username = (String)session.getAttribute("username");
    Vector<MeubleVolume> meuble = (Vector<MeubleVolume>) request.getAttribute("meuble");
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
                  <h5 class="card-title text-center pb-0 fs-4">Prix de Vente</h5>
                  
                 
                </div>

                <form id="login" class="row g-3 needs-validation" method="post" action="InsertionPrixVente" novalidate>
                  
                    <div class="row mb-3">
                        <label for="inputText" class="col-sm-3 col-form-label">Meuble</label>
                        <div class="col-sm-9 input-group">
                          <select class="form-select" aria-label="Default select example" name="meuble">
                              <option value="#"> Choisir ...</option>
                                <% for (int i = 0; i < meuble.size(); i++) { %>
                                        <option value="<%= meuble.get(i).getIdMeuble() %>&&<%=meuble.get(i).getIdVolume() %>"><%= meuble.get(i).getMeuble() %> <%= meuble.get(i).getVolume() %></option>
                                <% } %>
                          </select>
                        </div>
                    </div>
                    <div class="row mb-3">
                    <label for="inputText" class="col-sm-3 col-form-label">Prix de Vente</label>
                    <div class="col-sm-9 input-group has-validation">
                      <input type="text" class="form-control" name="prix" required>
                      <div class="invalid-feedback">Prix</div>
                    </div>
                    <div class="row mb-3">
                    <label for="inputText" class="col-sm-5 col-form-label">duree de fabrication</label>
                    <div class="col-sm-9 input-group has-validation">
                      <input type="text" class="form-control" name="duree" required>
                      <div class="invalid-feedback">duree de fabrication</div>
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
