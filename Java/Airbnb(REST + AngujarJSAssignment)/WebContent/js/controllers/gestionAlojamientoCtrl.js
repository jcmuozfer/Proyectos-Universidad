angular.module('airbnbApp')
.controller('gestionAlojamientoCtrl', ['alojamientosFactory','categoriaFactory','$scope','$routeParams','$location',function(alojamientosFactory,categoriaFactory,$scope,$routeParams,$location){
   
   		$scope.alojamiento = {};
   		var ifoAlojamiento = this;
   		ifoAlojamiento.alojamiento={};
   		ifoAlojamiento.categoriasPertenece = [];
   		ifoAlojamiento.categoriasNoPertenece = [];
   		
   		
      	$scope.crearAlojamiento = function(){
	
	
		var boolError = false;
		
			var tlf = $scope.alojamiento.telephone;
			var nombre =$scope.alojamiento.title;
			var desc =$scope.alojamiento.description;
			var correo =$scope.alojamiento.contactEmail;
			var precio =$scope.alojamiento.precio;
			var alojamiento =$scope.alojamiento.location;	
			var Categoria = $scope.categoriaAlojamiento;			
			var disponibilidad = $scope.alojamiento.disponible;			
			console.log($scope.alojamiento);
			Boolean(tlf); 
			Boolean(nombre); 
			Boolean(desc); 
			Boolean(correo); 
			Boolean(precio); 
			Boolean(alojamiento); 
			Boolean(Categoria); 
			Boolean(disponibilidad);
			
			console.log(tlf,nombre,desc,correo,precio,alojamiento,Categoria,disponibilidad);
			
			if(!tlf || !nombre || !desc || !correo || !precio || !alojamiento || !Categoria || !disponibilidad){
				
				ifoAlojamiento.mensajeError = "ERROR: Faltan parámetros por rellernar";
				boolError = true;	

		}else{
			
			tlf = $scope.alojamiento.telephone;
			var regExp = /^([\+][0-9]{1,2})?[-\s]?[0-9]{3}[-\s]?[0-9]{3}[-\s]?[0-9]{3}$/;
			var found = tlf.match(regExp);

			if(found==null){ //Comprobamos que tiene formato telefono
			ifoAlojamiento.mensajeError = "ERROR:  El teléfono introducido no presenta el formato correcto";
			var boolError = true;
			}else{
				
				var correo =$scope.alojamiento.contactEmail
				var regExp = /^[^@]+@[^@]+\.[a-zA-Z]{2,}$/;
				var found = correo.match(regExp);
		
				if(found==null){ //Comprobamos que tiene formato email
				ifoAlojamiento.mensajeError = "ERROR:  El correo introducido no presenta el formato correcto";
				boolError = true;	
				}					
			}		
		}
		
		if(boolError == false){ //Creamos alojamiento
			var available = $scope.alojamiento.available;
			Boolean (available);
			if(!available) $scope.alojamiento.available = 0;
			else  $scope.alojamiento.available = 1;		
					
			console.log("Se procede a crear: " + $scope.alojamiento);
				alojamientosFactory.postAlojamiento($scope.alojamiento)
				.then(function(response){
				console.log("Alojamiento creado");
			
						alojamientosFactory.asignarCategoriaAlojamientoNuevo($scope.categoriaAlojamiento)
						.then(function(response){
						console.log("Alojamiento asignado correctameinte a sus categoria");
						}, function(response){
						console.log("Error al asignar las categorias al alojamiento");
						})
		}, function(response){
			console.log("Error al crear el alojamiento del usuario");
		})
		
		window.location.replace("/Airbnb/pages/index.html#!/GestionAlojamientos");		
	
		}	
 
	
		
		};
		
		$scope.editarAlojamiento = function(){
			
		var boolError = false;
		
console.log("Pertenece a las siguietnes categorias:", $scope.categoriaPertenece);
			
		var categoriasID = [];
  		ifoAlojamiento.categorias.forEach(function(categoria) {
    		var recibido = document.getElementById(categoria.name);
    		
    		if(recibido.checked ==true)
				categoriasID.push(categoria.id);
  			}, this);
 			   
			var available = $scope.alojamiento.available;
			var tlf = $scope.alojamiento.telephone;
			var correo =$scope.alojamiento.contactEmail;
			Boolean(tlf); 
			Boolean(correo); 
			Boolean (available);
			if(!available) $scope.alojamiento.available = 0;
			else  $scope.alojamiento.available = 1;
			
						
			if(!!tlf){
			tlf = $scope.alojamiento.telephone;
			var regExp = /^([\+][0-9]{1,2})?[-\s]?[0-9]{3}[-\s]?[0-9]{3}[-\s]?[0-9]{3}$/;
			var found = tlf.match(regExp);
			if(found==null){ //Comprobamos que tiene formato telefono
			ifoAlojamiento.mensajeError = "ERROR:  El teléfono introducido no presenta el formato correcto";
			var boolError = true;				
			}else ifoAlojamiento.mensajeError = "";
 			
			}
			
			Boolean(correo);

			if(!!correo){
				correo =$scope.alojamiento.contactEmail;

				var regExp = /^[^@]+@[^@]+\.[a-zA-Z]{2,}$/;
				var found = correo.match(regExp);
				if(found==null){ //Comprobamos que tiene formato email
				ifoAlojamiento.mensajeError = "ERROR:  El correo introducido no presenta el formato correcto";
				boolError = true;	
				}					
			}		
		
		
		if(boolError == false){ //Modificamos alojamiento

				
		alojamientosFactory.asignarCategoriasAlojamientoID(categoriasID,$routeParams.ID)
			.then(function(response){
			console.log("Alojamiento editado su relación a sus categoria");
		}, function(response){
			console.log("Error al editar la asignación a las categorias del alojamiento");
		})	
				
				
			
		
		
			console.log("Se procede a modificar el alojamietno: " + ifoAlojamiento.alojamiento);
			$scope.alojamiento.id = $routeParams.ID;
			if($scope.alojamiento.Categoria == undefined) $scope.alojamiento.Categoria = -1;
			alojamientosFactory.putAlojamiento($scope.alojamiento,$scope.alojamiento.Categoria)
			.then(function(response){
			console.log("Alojamiento modificado");
			window.location.replace("/Airbnb/pages/index.html#!/GestionAlojamientos");		
		}, function(response){
			console.log("Error al modificar el alojamiento del usuario");
		})		}
		
		
		};
		
		$scope.eliminarAlojamiento = function(){
		console.log("Se procede a eliminar: "+ $routeParams.ID);
		alojamientosFactory.deleteAlojamiento($routeParams.ID)
		
		.then(function(response){
		console.log("Alojamiento eliminado");
		window.location.replace("/Airbnb/pages/index.html#!/GestionAlojamientos");		

		}, function(response){
			console.log("Error al eliminar el alojamiento del usuario");
		})		
		};
					
		ifoAlojamiento.functions = {
		obtenerAlojamiento : function(id){

			alojamientosFactory.getAlojamiento(id)
				.then(function(response){
				ifoAlojamiento.alojamiento = response;
				if(ifoAlojamiento.alojamiento.available == 0)ifoAlojamiento.alojamiento.available = false;
				else ifoAlojamiento.alojamiento.available = true;
				if(ifoAlojamiento.alojamiento.disponible == 0)ifoAlojamiento.alojamiento.disponible = false;
				else ifoAlojamiento.alojamiento.disponible = true;
				console.log("Obtenemos el alojamiento: ",ifoAlojamiento.alojamiento );		
						
				}, function(response){
					console.log("Error al obtener el alojamiento");
				})	
				
				
				
	
			
		},
		
		obtenerCategorias : function(){
			
						categoriaFactory.obtenerCategorias()
				.then(function(response){
				ifoAlojamiento.categorias = response;
				console.log("Obtenemos las categorias: ",ifoAlojamiento.categorias);				
				}, function(response){
					console.log("Error al obtener las categorias");
				})
			
		},
		
		obtenerCategoriasPertenece : function(id){
			
			alojamientosFactory.obtenerCategoriasPertenece(id)
				.then(function(response){
				ifoAlojamiento.categoriasPertenece = response;
				console.log("Obtenemos las categorias a las que pertenece el alojamiento" , ifoAlojamiento.categoriasPertenece );				
				}, function(response){
					console.log("Error al obtener las categorias a las que pertenece el alojamiento");
				})
		},
		
		obtenerCategoriasNoPertenece : function(id){
				
			alojamientosFactory.obtenerCategoriasNoPertenece(id)
				.then(function(response){
				ifoAlojamiento.categoriasNoPertenece = response;

				console.log("Obtenemos las categorias a las que no pertenece el alojamiento", ifoAlojamiento.categoriasNoPertenece);				
				}, function(response){
					console.log("Error al obtener las categorias a las no que pertenece el alojamiento");
				})
			
		}
		
		
    	};
    	
    
    	
			
	if($routeParams.ID != undefined){
		ifoAlojamiento.functions.obtenerAlojamiento($routeParams.ID);
		ifoAlojamiento.functions.obtenerCategoriasNoPertenece($routeParams.ID);
		ifoAlojamiento.functions.obtenerCategoriasPertenece($routeParams.ID);
		}
		ifoAlojamiento.functions.obtenerCategorias();
}]);