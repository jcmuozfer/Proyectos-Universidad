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



<title>Gestíon Categorías - Airbnb</title>


</head>

<body>


	<div class="registro">
		<div class="form-login">
			<form action="GestionCategorias" method="post">
				<h1>Gestíon Categorías de Airbnb</h1>
				<br>

				<div class="text">Introduce el nombre de la nueva categoría
					que se desea crear</div>
				<div>
					<input type="text" name="nombre" placeholder="Nombre Categoría"
						class="correo">
				</div>
				<div class="text">Introduce la descripción de la nueva
					categoría que se desea crear</div>
				<div>
					<input type="text" name="desc" placeholder="Descripción Categoría"
						class="correo">
				</div>
				<input name="opcion" class="buttons" type="submit"
					value="Crear Categoria" />



				<div class="text">Indica la categoría que se desea modificar</div>
				<select name="update" class="correo">
					<c:forEach var="Category" items="${categorias}">
						<option value="${Category.id}">${Category.name}</option>
					</c:forEach>

				</select>

				<div class="text">Introduce el nuevo nombre de la categoría</div>
				<div>
					<input type="text" name="nombreC" placeholder="Nombre Categoría"
						class="correo">
				</div>
				<div class="text">>Introduce la nueva descripción de la
					categoría</div>
				<div>
					<input type="text" name="descC" placeholder="Descripción Categoría"
						class="correo">
				</div>
				<input name="opcion" class="buttons" type="submit"
					value="Modificar Categoria" />






				<div class="text">Introdica la categoría que se desee eliminar
				</div>


				<div class="textCategoria">
					<c:forEach var="Category" items="${categorias}">

						<input type="checkbox" name="${Category.id}" value="1"> ${Category.name} 
		    	</c:forEach>
				</div>
				<input name="opcion" class="buttons" type="submit"
					value="Eliminar Categoria"> <input name="opcion"
					class="gestion" type="submit" value="Atrás">
			</form>


		</div>
	</div>
</body>
</html>