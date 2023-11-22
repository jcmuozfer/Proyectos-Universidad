<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="">

<head>
<title>Cualquier lugar - Alojamientos - Airbnb</title>
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
					<form action="Localizacion" method="get">

						<input type="submit" value="Localización" class="menu">
					</form>
				<li>
					<form action="Categoria" method="post">

						<input type="submit" value="Categoría" class="menu">
					</form>
					<ul>
						<c:forEach var="categoria" items="${Categorias}">
							<form action="Categoria" method="post">
								<li> <input name="categoria" type="submit" value="${categoria.name}"></li>
							</form>
						</c:forEach>
					</ul>
				</li>
			</ul>
			<ul>
				<li>Ordenar
					<ul>
						<form action="Categoria" method="post">
							<li> <input name="ordenar" type="submit" value="Más Me gustas"></li>
							<li> <input name="ordenar" type="submit" value="Menos Me gustas"></li>
						</form>
					</ul>
				</li>
				<li>Disponibilidad
					<ul>
						<form action="Categoria" method="post">		
						<li>
						<input name="dis" type="submit" value="Todos"></li>			
						<li>
						<input name="dis" type="submit" value="Disponible"></li>			
						<li>
						<input name="dis" type="submit" value="Reservado"></li>				

						</form>
					</ul>
				</li>
			</ul>
			<form action="Categoria" method="post">
				<input class="buscar" type="search" name="bus" placeholder="Buscar">
			</form>




		</nav>
	</div>
	<div class="fondo">

		<div class="cuerpo">

			<c:forEach var="Hosting" items="${HostingCategoria}">
				<div class="info">
					<form action="DetallesAlojamiento" method="post">

						<input type="hidden" name="idHosting" value="${Hosting.id}">

						<div>
							<div>
								<b>${Hosting.title}</b>(${Hosting.location})
							</div>
							<div>Numero de Me Gustas: ${Hosting.likes}</div>
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