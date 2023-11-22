<!DOCTYPE html>
<html lang="">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="principal/logo.png">
<link rel="stylesheet" type="text/css"
	href="css/iniciasesionoregistrate.css">
<link rel="stylesheet" type="text/css" href="css/comun.css">



<title>Perfil - Airbnb</title>


</head>

<body>


	<div class="registro">
		<div class="form-login">
			<form action="Modificar" method="post">
				<h1>Modificar Perfil de Airbnb</h1>
				<br>


				<h2>Bienvenido, ${nombre}</h2>

				<div class="text">Introduce el nuevo usuario que desees tener
					</div>
				<div>
					<input name="usuario" placeholder="Modificar Usuario (${nombre})"
						class="correo">
				</div>


				<div class="text">Introduce el nuevo correo que quieras
					asignar al usuario </div>
				<div>
					<input name="correo" placeholder="Modificar Correo electrónico (${correo})"
						class="correo">
				</div>
				<div class="text">Introduce la nueva contraseña que quieras
					asignar al usuario</div>


				<div>
					<input name="contra1" class="correo"
						placeholder=" Modificar Contraseña" type="password">
				</div>
				<div>
					<input name="contra2" class="correo"
						placeholder="Repite la Contraseña" type="password">
				</div>
				
				<h4 class="error">${error}</h4>


				<div class="text">
					Al seleccionar <b> Aceptar y continuar </b>, modificaras los
					parámetros que hayas modificado
				</div>
				<input name="opcion" class="buttons" type="submit" value="Aceptar y continuar" /> 
					<input name="opcion" class="buttons" type="submit" value="Gestión de Alojamientos">
				<input name="opcion" class="gestion" type="submit" value="Gestión de Categorias"> 
					<input name="opcion" class="cerrar" type="submit" value="Cerrar Sesión" />
					
<input  name="opcion" class="eliminar" type="submit"  value="Eliminar Usuario" />
			</form>


		</div>
	</div>
</body>
</html>
