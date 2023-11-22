angular.module('airbnbApp')
.controller('categoriaCtrl', ['categoriaFactory','$scope',function(categoriaFactory,$scope){
		
    var categoriaInfo = this;
    categoriaInfo.categorias = []
      categoriaInfo.functions = {
	
		obtenerCategorias : function(){
			categoriaFactory.obtenerCategorias()
				.then(function(response){
				categoriaInfo.categorias = response;
				console.log("Obtenemos las categorias: ",categoriaInfo.categorias);				
				}, function(response){
					console.log("Error al obtener las categorias");
				})			
			
		}
		
}
    
		$scope.actualizarCategoria = function(){
		
		if($scope.categoriaModifica !=undefined){
			var id = $scope.categoriaModifica.id;
			Boolean(id);
			console.log(id);
			if(id != undefined ){
				var nombre = $scope.categoriaModifica.name;
				var desc = $scope.categoriaModifica.description;
				console.log("nombre = ",nombre);
				console.log("descripción= ",desc);
				
				if( (nombre ===  "" || nombre === undefined) && (desc ===  "" || desc === undefined) ){
				categoriaInfo.mensajeError = "ERROR: No se puede modificar usuario porque no hay datos para hacerlo";
	 			window.location.replace("/Airbnb/pages/index.html#!/GestionCategorias");
					
				}else{
					
					var categoriaExiste= false;
					if(!(nombre ===  "" || nombre === undefined)){
							categoriaFactory.exitenciaCategoria( $scope.categoriaModifica.name)
							.then(function(response){
							if(response == true){	//Comprobamos que no hay ningún usuario registrado con ese nombre
							categoriaInfo.mensajeError = "ERROR: El nombre de la categoría introducida ya existe";
	 						window.location.replace("/Airbnb/pages/index.html#!/GestionCategorias");
	 						categoriaExiste = true;
				}
						if(categoriaExiste == false){
							categoriaFactory.putCategoria( $scope.categoriaModifica)
							.then(function(response){
							console.log("Categoria modificada");
							window.location.replace("/Airbnb/pages/index.html#!/Perfil");		
							}, function(response){
							console.log("Error al modificadar categoria");		
								
		})}
															
			})						
					}
	
					
				}

			}else{
				categoriaInfo.mensajeError = "ERROR:  No se ha selecionado la categoria a modificar";
				window.location.replace("/Airbnb/pages/index.html#!/GestionCategorias");	

			}
		}
		}
		
		
		
		$scope.crearCategoria = function(){
		
		if($scope.categoria != (undefined || null)){
			
		//Comprobamos si ha introducido los 2 parámetros obligatorios
			var nombre = $scope.categoria.name;			
			var descripcion = $scope.categoria.description;			

			Boolean(nombre); 
			Boolean(descripcion); 
			
			
			if(!nombre || !descripcion){
				
				categoriaInfo.mensajeError = "ERROR:  No se han rellenado todos los parámetros";
				console.log("ERROR:  No se han rellenado todos los parámetros");
				window.location.replace("/Airbnb/pages/index.html#!/GestionCategorias");	
	
				
		}else{
			
				//Comprobamos que el usuario no existe 
		
		categoriaFactory.exitenciaCategoria( $scope.categoria.name)
		.then(function(response){	
		if(response == true){	//Comprobamos que no hay ningún usuario registrado con ese nombre
			categoriaInfo.mensajeError = "ERROR: La categoría introducida ya existe";
			console.log("ERROR: La categoría introducida ya existe");
			window.location.replace("/Airbnb/pages/index.html#!/GestionCategorias");	
			}else{
				//Si no hay error
			categoriaFactory.crearCategoria( $scope.categoria)
		.then(function(response){
		console.log("Categoria creda");
		window.location.replace("/Airbnb/pages/index.html#!/Perfil");		
		}, function(response){
		console.log("Error al crear categoria");			
		})	
			}											
		})	
		}
		}
		}
		
		
		
		
		$scope.eliminarCategoria = function(){
		if($scope.categoriaEliminar != undefined){
		
		categoriaFactory.eliminarCategoria( $scope.categoriaEliminar)
		.then(function(response){
		console.log("Categoria eliminada");
		window.location.replace("/Airbnb/pages/index.html#!/Perfil");		
		}, function(response){
		console.log("Error al crear eliminada");			
		})	
			
		}
		
		}
		
		
		
	categoriaInfo.functions.obtenerCategorias();

}]);