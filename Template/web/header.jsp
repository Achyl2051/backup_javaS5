<%-- 
    Document   : header
    Created on : 12 déc. 2023, 08:58:34
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.*, java.util.*" %>
<!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Projet Meuble</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="assets/img/meuble.png" rel="icon">

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">

        <!-- =======================================================
  * Template Name: NiceAdmin - v2.2.0
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->

    </head>

    <body>

        <!-- ======= Header ======= -->
        <header id="header" class="header fixed-top d-flex align-items-center">

            <div class="d-flex align-items-center justify-content-between">
                <a href="#" class="logo d-flex align-items-center">
                    <img src="assets/img/meuble.png" alt="">
                    <span class="d-none d-lg-block">
                        <h4 style="margin-left: 10px; padding-top: 10px;">Projet Meuble</h4>
                    </span>
                </a>
                <i class="bi bi-list toggle-sidebar-btn"></i>
            </div><!-- End Logo -->

           <nav class="header-nav ms-auto">
                <ul class="d-flex align-items-center">

                    <li class="nav-item d-block d-lg-none">
                        <a class="nav-link nav-icon search-bar-toggle " href="#">
                            <i class="bi bi-search"></i>
                        </a>
                    </li><!-- End Search Icon-->



                    <li class="nav-item dropdown pe-3">

                        <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#"
                            data-bs-toggle="dropdown">
                            <img src="assets/img/meuble.png" alt="Profil"
                                class="rounded-circle">
                            <span class="d-none d-md-block dropdown-toggle ps-2">
                            </span>
                        </a><!-- End Profile Iamge Icon -->

                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                            <li class="dropdown-header">
                                <span>Admin</span>
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>

                            <li>
                                <a class="dropdown-item d-flex align-items-center" href="Deconnexion">
                                    <i class="bi bi-box-arrow-right"></i>
                                    <span>Deconnexion</span>
                                </a>
                            </li>

                        </ul><!-- End Profile Dropdown Items -->
                    </li><!-- End Profile Nav -->

                </ul>
            </nav><!-- End Icons Navigation -->

        </header><!-- End Header -->

        <!-- ======= Sidebar ======= -->
        <aside id="sidebar" class="sidebar">

            <ul class="sidebar-nav" id="sidebar-nav">

                <li class="nav-item">
                    <a class="nav-link collapsed" href="result.jsp">
                        <i class="bi bi-house"></i>
                        <span>Accueil</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="P_statistique">
                        <i class="bi bi-bar-chart"></i><span>Statistiques</span>
                    </a>
                </li>
                
                <li class="nav-heading">Creation simple</li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="P_InsertStyle">
                        <i class="bi bi-person-plus"></i><span>Ajout Style</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="P_InsertCategorie">
                        <i class="bi bi-person-plus"></i><span>Ajout Categorie</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="P_InsertMateriel">
                        <i class="bi bi-person-plus"></i><span>Ajout Materiel</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="P_InsertMeuble">
                        <i class="bi bi-person-plus"></i><span>Ajout Meuble</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="P_InsertMpiasa">
                        <i class="bi bi-person-plus"></i><span>Ajout Mpiasa</span>
                    </a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="P_InsertPersonne">
                        <i class="bi bi-person-plus"></i><span>Ajout Personne</span>
                    </a>
                </li>
                
                <li class="nav-heading">Assemblage</li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="P_detailStyle">
                        <i class="bi bi-collection"></i><span>Assemblage Detail Style</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="P_InsertVM">
                        <i class="bi bi-collection"></i><span>Assemblage Materiel pour Meuble</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="P_Mpiasa_Meuble">
                        <i class="bi bi-collection"></i><span>Assemblage Mpiasa pour Meuble</span>
                    </a>
                </li>
                
                <li class="nav-heading">Liste</li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="P_listMaterielChoice">
                        <i class="bi bi-list"></i><span>Liste Materiel par style</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="P_MaterielChoice">
                        <i class="bi bi-list"></i><span>Liste Meuble par materiel</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="P_MontantChoix">
                        <i class="bi bi-list"></i><span>Liste Meuble par prix</span>
                    </a>
                </li>
                <li class="nav-item">
                        <a class="nav-link collapsed"  href="P_ListeEmployer">
                        <i class="bi bi-list"></i><span>Liste Employer</span>
                    </a>
                </li>
                
                <li class="nav-heading">Stock</li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="P_EntreDeStock">
                        <i class="bi bi-box-seam"></i><span>Entre de Stock</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="P_Fabrication">
                        <i class="bi bi-box-seam"></i><span>Fabrication de meuble</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="P_EtatDeStock">
                        <i class="bi bi-box-seam"></i><span>Etat de Stock</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="P_ProduitFini">
                        <i class="bi bi-box-seam"></i><span>Produit fini</span>
                    </a>
                </li>
                
                <li class="nav-heading">Vente</li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="P_PrixDeVente">
                        <i class="bi bi-calculator"></i><span>Insert Prix de Vente</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="P_CheckBenefice">
                        <i class="bi bi-calculator"></i><span>Check benefice</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="P_vente">
                        <i class="bi bi-calculator"></i><span>Vente</span>
                    </a>
                </li>
            </ul>

        </aside><!-- End Sidebar-->

