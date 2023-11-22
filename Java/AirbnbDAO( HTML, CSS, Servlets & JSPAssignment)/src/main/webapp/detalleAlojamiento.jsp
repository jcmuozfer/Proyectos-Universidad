<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/comun.css">

<link rel="stylesheet" type="text/css" href="css/detalleAlojamiento.css">
<link rel="shortcut icon" href="principal/logo.png">
<title>Detalle Alojamiento - Airbnb</title>
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

	<div class="fondo">
		<div>
			<form action="Categoria" method="post">

				<input type="image" src="imgDetalles/atras.png" alt=" ">

			</form>

			<h2>${HostingAux.title}</h2>
		</div>
		<div class="encabezado">
			<div class="encabezadoIzq">
				<img src="imgDetalles/exclamaci%C3%B3n.png" alt=""> <a
					href="#"> ${HostingAux.location}</a>
			</div>
			<div class="encabezadoDer">

				<form action="DetallesAlojamiento" method="post">

					<input type="image" src="${corazon}" alt=" "> Me gustas
					Totales: ${HostingAux.likes} <input type="hidden" name="idHosting"
						value="${HostingAux.id}"> <input type="hidden"
						name="meGusta" value="meGusta">

				</form>


			</div>
		</div>

		<div class="encabezado2">
			<div class="encabezado2T">
				<h3>${HostingAux.title}.Propietario:${propietario}</h3>
			</div>

		</div>
		<div class="cuerpo">
			<div class="info">
				<div class="texto">${ HostingAux.description}</div>

				<div class="text">
					<c:choose>
						<c:when test='${HostingAux.available   eq 1}'>
						 Este alojamiento incluye servicios adicionales    
					</c:when>
						<c:otherwise>
						 Este alojamiento no incluye servicios adicionales
					</c:otherwise>
					</c:choose>
				</div>

			</div>

		</div>

		<h5 class="h5Relacioandos">Alojamientos relacionados:</h5>
		<div >


			<c:forEach var="Hosting" items="${alojamientosRelacionados}">
				<div class="alojamientoRelacionado">
					<form action="DetallesAlojamiento" method="post">

						<input type="hidden" name="idHosting" value="${Hosting.id}">

						<div>
							<div>
								<b>${ Hosting.title }</b>(${ Hosting.location })
							</div>
							<div>Me Gustas: ${ Hosting.likes }</div>
							<input  class="obtener" type="submit" value="Obtener Detalles">

						</div>

					</form>
				</div>
			</c:forEach>
		</div>








	</div>



</body>
</html>
