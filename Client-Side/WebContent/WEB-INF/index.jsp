<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/template/head.jsp"/>
<title>CoronaTickets UY - Inicio</title>
</head>
<body>

<div class="wrapper">
		<jsp:include page="/WEB-INF/template/header_menulateral.jsp"/>
        <!-- Page Content  -->
        <div id="content">
		<jsp:include page="/WEB-INF/template/header_menusup.jsp"/>
	
            <h2>Espectáculos disponibles en Twitter Live</h2>
            <div class="mb-sm-4 container-fluid"></div>
            <div class="container-fluid media mb-sm-5">
            <a href="#" class="pull-left">
            	<img src="https://www.revistamoi.com/wp-content/uploads/2016/08/cuando-cumples-30-an%CC%83os.jpg" class="rounded float-left media-object" alt="SPRINGSTEEN BROADWAY" width=150em>
            </a>
            <div class="media-body ml-sm-4">
            <a href="#" class="media-heading"><h4>30 años</h4></a>
            <p>Espectáculo conmemorando los 30 años de Violeta. <u><a href="#">Leer más</a></u></p>
            </div>
            </div>
            
            <div class="container-fluid media mb-sm-5">
            <a href="#" class="pull-left">
            	<img src="https://bit.ly/2FWyB0B" class="rounded float-left media-object" alt="BIEN DE FAMILIA" width=150em>
            </a>
            <div class="media-body ml-sm-4">
            <a href="#" class="media-heading"><h4>Bien de Familia</h4></a>
            <p> El dúo estará presentando sus más sonados éxitos y también nuevas canciones. <u><a href="../Client-Side/HTMLs/consultaEspectaculo.html">Leer más</a></u></p>
            </div>
            </div>
            
            <div class="container-fluid media mb-sm-5">
            <a href="#" class="pull-left">
            	<img src="https://www.memphisbluesbbq.com/wp-content/uploads/2019/05/Colour.png" class="rounded float-left media-object" alt="GLOBAL SPIRIT" width=150em>
            </a>
            <div class="media-body ml-sm-4">
            <a href="#" class="media-heading"><h4>Memphis Blues World</h4></a>
            <p> Espectáculo promoviendo álbum Memphis Blues. <u><a href="#">Leer más</a></u></p> 
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