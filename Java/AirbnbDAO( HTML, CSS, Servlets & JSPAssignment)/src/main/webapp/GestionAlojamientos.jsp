<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="">
<head>
<title>Gestión Alojamientos - Airbnb</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="principal/logo.png">
<link rel="stylesheet" type="text/css"
	href="css/categoriaLocalizacion.css">
<link rel="stylesheet" type="text/css" href="css/comun.css">

</head>

<body>

	<header class="cabecera">

		<img src="principal/header-logo.png" class="imgHeaderLogo" alt="">

		<div class="elDer">

			<form action="Perfil" method="post">

				<input class="imgheaderPerfil" type="image"
					src="principal/header-perfil.png" alt="  ">
			</form>
		</div>

	</header>
	<div class="cabeceraMenu">
		<nav>

			<ul>
				<li>
					<form action="AnadirAlojamiento" method="get">

						<input  type="submit"value="Añadir Alojamiento" class="menu" >
					</form>



				</li>

			</ul>
						<ul>
				<li><form action="Categoria" method="post">

						<input type="submit" value="Volver a Categoría" class="menu">
					</form></li>
			</ul>
			

		</nav>
	</div>
	<div class="cuerpo-entero">

	<div class="cuerpo">
				
			
				<c:forEach var="Hosting" items="${Hostings}">
				<div class="fondo">
					<form action="GestionAlojamientos" method="post">
						<input type="submit" value="Editar" >
						<input type="hidden" name="idHosting" value="${Hosting.id}">  
						<div>
							<div>
								<b>${Hosting.title}</b>(${Hosting.location})
							</div>
						</div>
						<div>
							<div>${Hosting.description}</div>
							<div>Contacto: ${Hosting.telephone}, ${Hosting.contactEmail} </div>
							
						</div>
					</form>
					</div>
		    	</c:forEach>
		   
			</div>
		</div>
</body>
</html>
