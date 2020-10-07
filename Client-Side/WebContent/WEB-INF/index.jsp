<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="icon" type="image/png" href="images/favicon/favicon.png">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link rel="stylesheet" href="style.css">
	<!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="styles/menu.css">

    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
<title>CoronaTickets UY - Inicio</title>
</head>
<body>

<div class="wrapper">
		<!-- INICIO MENU LATERAL -->
        <!-- Sidebar  -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <h4>CORONATICKETS</h4>
            </div>

            <ul class="list-unstyled components">
            	<li>
            	<a href="#accionesSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">ACCIONES</a>
                    <ul class="collapse list-unstyled" id="accionesSubmenu">
                        <li>
                            <a href="#">Registro a Función</a>
                        </li>
                    </ul>
            	</li>
                <li>
                    <a href="#plataformasSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">PLATAFORMAS</a>
                    <ul class="collapse list-unstyled" id="plataformasSubmenu">
                        <li>
                            <a href="#">Instagram Live</a>
                        </li>
                        <li>
                            <a href="#">Facebook Watch</a>
                        </li>
                        <li>
                            <a href="#">Twitter Live</a>
                        </li>
                        <li>
                            <a href="#">Youtube</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#categoriasSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">CATEGORIAS</a>
                    <ul class="collapse list-unstyled" id="categoriasSubmenu">
                        <li>
                            <a href="#">Música</a>
                        </li>
                        <li>
                            <a href="#">Teatro</a>
                        </li>
                        <li>
                            <a href="#">Literatura</a>
                        </li>
                        <li>
                            <a href="#">Danza</a>
                        </li>
                        <li>
                            <a href="#">Carnaval</a>
                        </li>
                    </ul>
                </li>
            </ul>

           <!--
           NO LO BORRO POR LAS DUDAS, MAYBE LUEGO NOS SIRVE
             <ul class="list-unstyled CTAs">
                <li>
                    <a href="https://bootstrapious.com/tutorial/files/sidebar.zip" class="download">Download source</a>
                </li>
                <li>
                    <a href="https://bootstrapious.com/p/bootstrap-sidebar" class="article">Back to article</a>
                </li>
            </ul>  -->
        </nav>
		<!-- FIN MENU LATERAL -->
        <!-- Page Content  -->
        <div id="content">
		<!-- INICIO MENU ARRIBA -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light" id="menuSuperior">
                <div class="container-fluid">
                    <button type="button" id="sidebarCollapse" class="btn btn-info">
                        <i class="fas fa-align-left"></i>
                    </button>
                    <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fas fa-align-justify"></i>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <div class="navbar-header mx-auto ml-sm-5"><a href="#">CORONATICKETS.UY</a></div>
    <ul class="navbar-nav ml-auto container-fluid">
    <li class="nav-item mx-auto">
    	<form class="form-inline my-2 my-lg-0 mx-auto">
      		<input class="form-control mr-sm-2" type="search" placeholder="Nickname, Espectáculo..." aria-label="Search">
      		<button class="rounded-circle btn btn-outline-success my-2 mr-sm-2" type="submit"><i class="fas fa-search"></i></button>
    	</form>
    </li>
    <li class="nav-item dropdown">
       	<a class="nav-link" style="border-radius:0.25em;" href="#" id="UsernavbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
       		<img src="https://us.123rf.com/450wm/amitspro/amitspro1706/amitspro170600016/80099376-mandala-de-flor-abstracta-patr%C3%B3n-decorativo-fondo-azul-imagen-cuadrada-imagen-de-ilusi%C3%B3n-patr%C3%B3n-fondo-photo.jpg?ver=6" width=32em class="rounded-circle img-responsive img-fluid"> 
    		NombreUsuario
    		<i class="fas fa-sort-down"></i>
    	</a>
    	<div class="dropdown-menu dropdown-menu-right" aria-labelledby="UsernavbarDropdown">
          <a class="dropdown-item" href="PerfilUsuario.html">Mi Perfil</a>
          <a class="dropdown-item" href="#">Configuración</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Cerrar Sesión</a>
        </div>
    </li>
	</ul>
                    </div>
                </div>
            </nav>
	<!-- FIN MENU ARRIBA -->
	
            <h1>Novedades</h1>
            <div class="mb-sm-4 container-fluid"></div>
            <div class="container-fluid media mb-sm-5">
            <a href="#" class="pull-left">
            	<img src="https://bit.ly/32V2lUD" class="rounded float-left media-object" alt="SPRINGSTEEN BROADWAY" width=150em>
            </a>
            <div class="media-body ml-sm-4">
            <a href="#" class="media-heading"><h4>Springsteen On Broadway</h4></a>
            <p> Springsteen tocando guitarra o piano y relatando anécdotas recogidas en su autobiografía de 2016, Burn to Run. <u><a href="#">Leer más</a></u></p>
            </div>
            </div>
            
            <div class="container-fluid media mb-sm-5">
            <a href="#" class="pull-left">
            	<img src="https://bit.ly/2FWyB0B" class="rounded float-left media-object" alt="BIEN DE FAMILIA" width=150em>
            </a>
            <div class="media-body ml-sm-4">
            <a href="#" class="media-heading"><h4>Bien de Familia</h4></a>
            <p> El dúo estará presentando sus más sonados éxitos y también nuevas canciones <u><a href="#">Leer más</a></u></p>
            </div>
            </div>
            
            <div class="container-fluid media mb-sm-5">
            <a href="#" class="pull-left">
            	<img src="https://bit.ly/36dXLmH" class="rounded float-left media-object" alt="GLOBAL SPIRIT" width=150em>
            </a>
            <div class="media-body ml-sm-4">
            <a href="#" class="media-heading"><h4>Global Spirit</h4></a>
            <p> Espectáculo donde se presenta el álbum Spirit. <u><a href="#">Leer más</a></u></p> 
            </div>
            </div>
        </div>
    </div>


	<!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
	
	<script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
    </script>

<!--
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    	<span class="navbar-toggler-icon"></span>
  	</button>
  	<div class="collapse navbar-collapse" id="navbarSupportedContent">
  		<div class="navbar-header">CORONATICKETS.UY</div>
    <form class="form-inline my-2 my-lg-0 mx-auto">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
    <ul class="nav navbar-nav ml-auto">
    <li class="nav-item dropdown">
       	<a class="nav-link dropdown-toggle" href="#" id="UsernavbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
       		<img src="https://us.123rf.com/450wm/amitspro/amitspro1706/amitspro170600016/80099376-mandala-de-flor-abstracta-patr%C3%B3n-decorativo-fondo-azul-imagen-cuadrada-imagen-de-ilusi%C3%B3n-patr%C3%B3n-fondo-photo.jpg?ver=6" width=32em class="rounded-circle img-responsive img-fluid"> 
    		NombreUsuario
    	</a>
    	<div class="dropdown-menu dropdown-menu-right" aria-labelledby="UsernavbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
    </li>
	</ul>
  	</div>
  
  
</nav>-->
</body>
</html>