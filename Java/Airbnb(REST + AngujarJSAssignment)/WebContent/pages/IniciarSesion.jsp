<!DOCTYPE html>
<html lang="es">
<head>
<title>Iniciar Sesión - Airbnb</title>
<link rel="stylesheet" type="text/css"
	href="css/iniciasesionoregistrate.css">
<link rel="shortcut icon" href="principal/logo.png">
<link rel="stylesheet" type="text/css" href="css/comun.css">


<meta charset="utf-8">

</head>
<body>
	<div class="form-login">
		<h1>¡Te damos la bienvenida a Airbnb!</h1>


		<form action="IniciarSesion" method="post">
			<table>
				<tr>
					<td>Usuario</td>

				</tr>
				<tr>
					<td><input class="correo" name="user" placeholder="Usuario" /></td>
				</tr>
				<tr>
					<td>Contraseña</td>
				</tr>
				<tr>
					<td><input class="correo" name="password" 
						placeholder="Contraseña" type="password" /></td>
				</tr>
			</table>
			<input class="buttons" type="submit" value="Iniciar sesion" />
		</form>
		
				<h4 class="Error">${error}</h4>
		

			<form action="RegistrarUsuario" method="get">
				<input type="submit" value="Registrarse" class="registrarse">
			</form>
</div>
</body>
</html>
