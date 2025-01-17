<%-- 
    Document   : index
    Created on : 9 déc. 2023, 16:52:12
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">
        <link href="assets/css/style.css" rel="stylesheet">
    </head>
    <body>
        <main>
          <div class="container">
            <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
              <div class="container">
                <div class="row justify-content-center">
                  <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

                    <div class="d-flex justify-content-center py-4">
                      <a href="index.html" class="logo d-flex align-items-center w-auto">
                        <img src="assets/img/meuble.png" alt="">
                        <span class="d-none d-lg-block">Projet Meuble</span>
                      </a>
                    </div><!-- End Logo -->

                    <div class="card mb-3">

                      <div class="card-body">

                        <div class="pt-4 pb-2">
                          <h5 class="card-title text-center pb-0 fs-4">Login to Your Account</h5>
                          <p class="text-center small">Enter your username & password to login</p>
                        </div>

                        <form class="row g-3 needs-validation" action="Login" method="post" novalidate>

                          <div class="col-12">
                            <label for="yourUsername" class="form-label">Username</label>
                            <div class="input-group has-validation">
                              <span class="input-group-text" id="inputGroupPrepend">@</span>
                              <input type="text" name="username" class="form-control" id="yourUsername" value="achyl" required>
                              <div class="invalid-feedback">Please enter your pseudo.</div>
                            </div>
                          </div>

                          <div class="col-12">
                            <label for="yourPassword" class="form-label">Password</label>
                            <input type="password" name="pass" class="form-control" id="yourPassword" value="root" required>
                            <div class="invalid-feedback">Please enter your password!</div>
                          </div>
                            
                          <div class="col-12">
                            <button class="btn btn-primary w-100" type="submit">Login</button>
                          </div>
                          <div class="col-12">
                            <p class="small mb-0">Don't have account? <a href="#"> sign in</a></p>
                          </div>
                        </form>

                      </div>
                    </div>

                  </div>
                </div>
              </div>

            </section>

          </div>
        </main><!-- End #main -->
        
        <!-- Vendor JS Files -->
        <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/chart.js/chart.min.js"></script>
        <script src="assets/vendor/echarts/echarts.min.js"></script>
        <script src="assets/vendor/quill/quill.min.js"></script>
        <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
        <script src="assets/vendor/tinymce/tinymce.min.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>
    </body>
</html>
