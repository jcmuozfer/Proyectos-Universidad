<!DOCTYPE html>
<html lang="">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="principal/logo.png">
<link rel="stylesheet" type="text/css"
	href="css/iniciasesionoregistrate.css">
<link rel="stylesheet" type="text/css" href="css/comun.css">



<title>Crear cuenta - Airbnb</title>


</head>

<body>


	<div class="registro">
		<form class="form-login" action="RegistrarUsuario" method="post">
			<h1>Crea una cuenta de Airbnb</h1>
			<br>
			<h4>${error}</h4>
			<div class="text">Introduce un nombre de usuario:</div>
			<div>
				<input name="usuario" placeholder="Usuario" class="correo">
			</div>


			<div class="text">Introduce un correo electrónico:</div>

			<div>
				<input name="correo" placeholder="Correo electrónico"
					class="correo">
			</div>

			<div class="text">Introduce una contraseña:</div>

			<div>
				<input name="contra1" class="correo" placeholder="Contraseña" type="password">
			</div>
			<div class="text">Repite la contraseña:</div>

			<div>
				<input name="contra2" class="correo"
					placeholder="Repite la contraseña" type="password">
			</div>


			<div class="text">
				Al seleccionar <b> Aceptar y continuar </b>, acepto las Condiciones
				del sevicio, las Condiciones sobre pagos y la Política contra la
				Discriminación de Airbnb, así como su Política de Priacidad
			</div>

			<input name="accion" class="buttons" type="submit"
				value="Aceptar y continuar" /> <input name="accion" class="buttons"
				type="submit" value="Atrás" />

		</form>
	</div>
</body>
</html>
