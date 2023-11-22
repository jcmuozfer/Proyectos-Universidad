angular.module('airbnbApp')
.controller('perfilCtrl', ['usuarioFactory','$scope','$routeParams','$location',function(usuarioFactory,$scope,$routeParams,$location){
   
    $scope.usuario = {};
    var perfilUsuario = this;
    var mensajeError = this;
    mensajeError = {};
    perfilUsuario.usuario={};

    $scope.editarUsuario= function(){
		
		var boolError = false;
		
		console.log( $scope.usuario.username);	
		if($scope.usuario.username!=undefined )
		
		usuarioFactory.exitenciaUsuario( $scope.usuario.username)
		.then(function(response){
		console.log(response);		
		
		if(response == true){	//Comprobamos que no hay ningún usuario registrado con ese nombre
			perfilUsuario.mensajeError = "ERROR:  El usuario introducido ya se encuentra registrado";
			boolError = true;	
			}											
		})
		
		console.log( $scope.usuario.email);	
		if($scope.usuario.email!=undefined ){ 
		var correo = $scope.usuario.email;
		var regExp = /^[^@]+@[^@]+\.[a-zA-Z]{2,}$/;
		var found = correo.match(regExp);
		
		if(found==null){ //Comprobamos que tiene formato email
		perfilUsuario.mensajeError = "ERROR:  El correo introducido no presenta el formato correcto";
		boolError = true;	

		}		
		}						
			
		var contraseña = $scope.usuario.password;
		if(contraseña != undefined){
		if(contraseña.length < 6){ //Tiene que cumplir que almenos tenga 6 digitos
		perfilUsuario.mensajeError = "ERROR:  La contraseña introducida es demasiado corta. Tiene que tener almenos 6 carácteres";
		boolError = true;	
		}else
			if(contraseña != $scope.usuario.password2){
			perfilUsuario.mensajeError = "ERROR:  Las contraseña introducidas no coinciden";
			boolError = true;	
			}
		
		}

		if(boolError == false){
		usuarioFactory.putUsuario( $scope.usuario)
		.then(function(response){
		console.log("Usuario modificado");
		window.location.replace("/Airbnb/pages/index.html#!/");		
		}, function(response){
		console.log("Error al modificar usuario");			
		})		
		}else window.location.replace("/Airbnb/pages/index.html#!/Perfil");		

	

	}									

	    $scope.registrarUsuario= function(){
		
		console.log($scope.usuario);

		}	

	   
	
	perfilUsuario.obtenerUsuario = function(){

			usuarioFactory.getUsuario()
				.then(function(response){
				 perfilUsuario.usuario = response;
				console.log("Obtenemos el usario: ",perfilUsuario.usuario.username );				
				}, function(response){
					console.log("Error al obtener el usuario");
				})			
			
	}
			
	perfilUsuario.eliminarUsuario = function(){
			usuarioFactory.deleteUsuario()
				.then(function(response){
				console.log("Usuario eliminado con exito");	
				  window.location.replace("/Airbnb/LogoutServlet");		
				}, function(response){
					console.log("Error al eliminar usuario");
				})			
			
	}
		
    
	var ruta = location.hash;
	if( ruta == "#!/Perfil")perfilUsuario.obtenerUsuario();
	if( ruta == "#!/EliminarUsuario")perfilUsuario.eliminarUsuario();


    
}]);