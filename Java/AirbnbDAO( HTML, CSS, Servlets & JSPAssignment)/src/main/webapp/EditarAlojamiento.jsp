<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="principal/logo.png">
<link rel="stylesheet" type="text/css"
	href="css/iniciasesionoregistrate.css">
<link rel="stylesheet" type="text/css" href="css/comun.css">



<title>Editar Alojamiento - Airbnb</title>


</head>

<body>


	<div class="registro">
		<form class="form-login" action="EditarAlojamient" method="post">
			<h1>Editar Alojamiento ${HostingAux.title}</h1>
			<input type="hidden" name="idHosting" value="${HostingAux.id}">


			<div class="formulario">Introduce el nombre del Alojamiento (Su
				nombre actual es: ${HostingAux.title})</div>
			<div>
				<input type="text" name="nombre" placeholder="Nombre Alojamiento"
					class="correo">
			</div>

			<div class="formulario">Introduce la descripcion del
				Alojamiento:</div>
			<div>
				<textarea name="desc" class="correo"> ${HostingAux.description} </textarea>
			</div>

			<div class="formulario">Introduce un número de contacto:</div>
			<div>
				<input type="tel" name="tlf" placeholder="${HostingAux.telephone}"
					class="correo">
			</div>

			<div class="formulario">Introduce un correo electrónico:</div>
			<div>
				<input type="email" name="correo"
					placeholder="${HostingAux.contactEmail}" class="correo">
			</div>

			<div class="formulario">Introduce el precio del alojamiento:</div>
			<div>
				<input type="number" name="precio" placeholder="Precio"
					class="correo">
			</div>
			<div class="formulario">Seleccione la categoría del
				Alojamiento:</div>

			<div class="textCategoria">


				<c:forEach var="categoria" items="${CategoriaNoPertenece}">
					<input type="checkbox" name="${categoria.id}" > ${categoria.name} 
		    	</c:forEach>

				<c:forEach var="categoria" items="${CategoriaPertenece}">
					<input type="checkbox" name="${categoria.id}" 
						checked="checked"> ${categoria.name} 
		    	</c:forEach>



			</div>
			<div class="formulario">Introduce la localidad Alojamiento:</div>
			<input type="text" name="localidad"
				placeholder="${HostingAux.location}" class="correo">

			<div class="formulario">Indica si el alojamiento se encuentra
				disponible o no:</div>
			<div>


				<c:choose>
					<c:when test='${HostingAux.disponible   eq 0}'>
						<select name="dis" class="correo">
							<option value="1">Disponible</option>
							<option value="0" selected="selected">Reservado</option>
						</select>


					</c:when>
					<c:otherwise>
						<select name="dis" class="correo">
							<option value="1" selected="selected">Disponible</option>
							<option value="0" >Reservado</option>
						</select>
					</c:otherwise>
				</c:choose>



			</div>

			<div class="text">
				<c:choose>
					<c:when test='${HostingAux.available   eq 0}'>
						<input name="av" value="1" type="checkbox">Incluye servicios adicionales   
					</c:when>
					<c:otherwise>
						<input name="av" value="0" type="checkbox" checked="checked"> Incluye servicios adicionales 
					</c:otherwise>
				</c:choose>
			</div>


			<input name="boton" class="buttons" type="submit"
				value="Aceptar y continuar" /> <input name="boton" class="buttons"
				type="submit" value="Cancelar" /> <input name="boton"
				class="eliminar" type="submit" value="Eliminar Alojamiento" />




		</form>
	</div>
</body>
</html>