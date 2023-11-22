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



<title>Añadir Alojamiento - Airbnb</title>


</head>

<body>


	<div class="registro">
		<form class="form-login" action="AnadirAlojamiento" method="post">
			<h1>Añadir Alojamiento en Airbnb</h1>
			<br>
			<h4 class="error">${error}</h4>

			<div class="formulario">Introduce el nombre del Alojamiento:</div>
			<div>
				<input type="text" name="nombre" placeholder="Nombre Alojamiento"
					class="correo">
			</div>

			<div class="formulario">Introduce la descripcion del
				Alojamiento:</div>
			<div>
				<textarea name="desc" class="correo"> Descripción </textarea>
			</div>

			<div class="formulario">Introduce un número de contacto:</div>
			<div>
				<input type="tel" name="tlf" placeholder="Teléfono" class="correo">
			</div>

			<div class="formulario">Introduce un correo electrónico:</div>
			<div>
				<input type="email" name="correo" placeholder="Correo"
					class="correo">
			</div>

			<div class="formulario">Introduce el precio del alojamiento:</div>
			<div>
				<input type="number" name="precio" placeholder="Precio"
					class="correo">
			</div>

			<div class="formulario">Seleccione la categoría del
				Alojamiento:</div>
			<div class="textCategoria"s>

			<c:forEach var="categoria" items="${categorias}">
					<input type="checkbox" name="${categoria.name}" value="1"> ${categoria.name} 
		    	</c:forEach>

			</div>
			<div class="formulario">Introduce la localidad Alojamiento:</div>
			<div>
				<input type="text" name="localidad" placeholder="Localidad"
					class="correo">
			</div>

			<div class="text">
				<input type="checkbox" name="serv"> Incluye servicios
				adicionales
			</div>

			<input name="accion" class="buttons" type="submit" value="Aceptar y continuar" />
			<input name="accion" class="buttons" type="submit" value="Atrás" />
			
		</form>
	</div>
</body>
</html>
