<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="css/categoriaLocalizacion.css">
<link rel="shortcut icon" href="principal/logo.png">
<link rel="stylesheet" type="text/css" href="css/comun.css">
<title>Localización - Airbnb</title>
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
				<li><form action="Categoria" method="post">

						<input type="submit" value="Categoría" class="menu">
					</form></li>
			</ul>


		</nav>
	</div>
	<div class="fondo">
		<div class="cuerpo">
			<iframe class="mapa"
				src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d47888.53433533087!2d-7.9742413!3d41.3950811!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd24c8adf428ce8b%3A0xda491b3ba3e6dd30!2sMondim%20de%20Basto%2C%20Portugal!5e0!3m2!1ses!2ses!4v1645985532114!5m2!1ses!2ses"
				style="border: 0;" allowfullscreen="" loading="lazy"></iframe>
			<c:forEach var="Hosting" items="${HostingLoc}">
				<div class="info">
					<form action="DetallesAlojamiento" method="post">

						<input type="hidden" name="idHosting" value="${Hosting.id}">

						<div>
							<div>
								<b>${Hosting.title}</b>(${Hosting.location})
							</div>
						</div>
						<div>
							<div>${Hosting.description}</div>
							<div>Contacto: ${Hosting.telephone},
								${Hosting.contactEmail}</div>
							<input type="submit" value="Más Información">
						</div>
					</form>
				</div>
			</c:forEach>

		</div>

	</div>



</body>
</html>
