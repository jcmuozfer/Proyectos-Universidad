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
		<form class="form-login" action="Registro" method="post">
			<h1>Crea una cuenta de Airbnb</h1>
			<br>
			<h4>${error}</h4>
			<div class="text">Introduce un nombre de usuario:</div>
			<div>
				<input name="usuario" placeholder="Usuario" class="correo">
			</div>


			<div class="text">Introduce un correo electr�nico:</div>

			<div>
				<input name="correo" placeholder="Correo electr�nico"
					class="correo">
			</div>

			<div class="text">Introduce una contrase�a:</div>

			<div>
				<input name="contra1" type="password" class="correo" placeholder="Contrase�a" >
			</div>
			<div class="text">Repite la contrase�a:</div>

			<div>
				<input name="contra2" class="correo"
					placeholder="Repite la contrase�a" type="password">
			</div>


			<div class="text">
				Al seleccionar <b> Aceptar y continuar </b>, acepto las Condiciones
				del sevicio, las Condiciones sobre pagos y la Pol�tica contra la
				Discriminaci�n de Airbnb, as� como su Pol�tica de Priacidad
			</div>

			<input name="accion" class="buttons" type="submit"
				value="Aceptar y continuar" /> <input name="accion" class="buttons"
				type="submit" value="Atr�s" />

		</form>
	</div>
</body>
</html>
