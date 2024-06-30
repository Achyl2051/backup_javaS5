<%-- 
    Document   : listMaterielChoice
    Created on : 12 déc. 2023, 16:54:28
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.*, java.util.*" %>
<%
    String username = (String)session.getAttribute("username");
    Vector<Style> styles = (Vector<Style>) request.getAttribute("styles");
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
                  <h5 class="card-title text-center pb-0 fs-4">Choisi ton style</h5>
                </div>

                <form id="login" class="row g-3 needs-validation" method="post" action="showListMateriel" novalidate>
                  
                 <div class="row mb-3">
                        <label class="col-sm-3 col-form-label">Style</label>
                        <div class="col-sm-9">
                          <select class="form-select" aria-label="Default select example" name="style">
                                <option value="#"> Choisir ...</option>
                                <% for (int i = 0; i < styles.size(); i++) { %>
                                        <option value="<%= styles.get(i).getIdStyle() %>"><%= styles.get(i).getNom() %></option>
                                <% } %>
                          </select>
                        </div>
                </div>

                <div>
                  <button class="btn btn-primary w-100 " type="submit">Search</button>
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
