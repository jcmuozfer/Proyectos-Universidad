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



<title>Gest�on Categor�as - Airbnb</title>


</head>

<body>


	<div class="registro">
		<div class="form-login">
			<form action="GestionCategorias" method="post">
				<h1>Gest�on Categor�as de Airbnb</h1>
				<br>

				<div class="text">Introduce el nombre de la nueva categor�a
					que se desea crear</div>
				<div>
					<input type="text" name="nombre" placeholder="Nombre Categor�a"
						class="correo">
				</div>
				<div class="text">Introduce la descripci�n de la nueva
					categor�a que se desea crear</div>
				<div>
					<input type="text" name="desc" placeholder="Descripci�n Categor�a"
						class="correo">
				</div>
				<input name="opcion" class="buttons" type="submit"
					value="Crear Categoria" />



				<div class="text">Indica la categor�a que se desea modificar</div>
				<select name="update" class="correo">
					<c:forEach var="Category" items="${categorias}">
						<option value="${Category.id}">${Category.name}</option>
					</c:forEach>

				</select>

				<div class="text">Introduce el nuevo nombre de la categor�a</div>
				<div>
					<input type="text" name="nombreC" placeholder="Nombre Categor�a"
						class="correo">
				</div>
				<div class="text">>Introduce la nueva descripci�n de la
					categor�a</div>
				<div>
					<input type="text" name="descC" placeholder="Descripci�n Categor�a"
						class="correo">
				</div>
				<input name="opcion" class="buttons" type="submit"
					value="Modificar Categoria" />






				<div class="text">Introdica la categor�a que se desee eliminar
				</div>


				<div class="textCategoria">
					<c:forEach var="Category" items="${categorias}">

						<input type="checkbox" name="${Category.id}" value="1"> ${Category.name} 
		    	</c:forEach>
				</div>
				<input name="opcion" class="buttons" type="submit"
					value="Eliminar Categoria"> <input name="opcion"
					class="gestion" type="submit" value="Atr�s">
			</form>


		</div>
	</div>
</body>
</html>