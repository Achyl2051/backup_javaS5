<%-- 
    Document   : InsertMpiasa
    Created on : 16 janv. 2024, 12:10:58
    Author     : Lenovo Legion
--%>

<%-- 
    Document   : insertStyle
    Created on : 12 déc. 2023, 16:15:03
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
                  <h5 class="card-title text-center pb-0 fs-4">Insert mpiasa</h5>
                
                </div>

                <form id="login" class="row g-3 needs-validation" method="post" action="InsertMpiasa" novalidate>
                  
                  <div class="row mb-3">
                    <label for="inputText" class="col-sm-3 col-form-label">Nom</label>
                    <div class="col-sm-9 input-group has-validation">
                      <input type="text" class="form-control" name="nom" required>
                      <div class="invalid-feedback">Entrer le nom</div>
                    </div>
                  </div>
                    <div class="row mb-3">
                    <label for="inputText" class="col-sm-3 col-form-label">tarif</label>
                    <div class="col-sm-9 input-group has-validation">
                      <input type="text" class="form-control" name="tarif" required>
                      <div class="invalid-feedback">Entrer le tarif</div>
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
