angular.module('airbnbApp')
.controller('alojamientosCategoriaCtrl', ['alojamientosFactory','categoriaFactory','$scope','$routeParams',function(alojamientosFactory,categoriaFactory,$scope,$routeParams){
   
    var listaAlojamientos = this;
	listaAlojamientos.alojamientoID = {};
    listaAlojamientos.alojamientos=[];
    listaAlojamientos.categorias=[];

    listaAlojamientos.functions = {
    	
		leerAlojamientos : function(){
			alojamientosFactory.obtenerAlojamientos()
				.then(function(response){
				listaAlojamientos.alojamientos = response;
				console.log("Obtenemos el alojamiento alojamientos: ",listaAlojamientos.alojamientos);				
				}, function(response){
					console.log("Error al obtener la información del el alojamiento");
				})			
			
		},
		obtenerAlojamientoID : function(id){
			alojamientosFactory.getAlojamientoID(id)
				.then(function(response){
				listaAlojamientos.alojamientoID = response;
				alojamientosFactory.getMegustaAlojamiento(id)
				.then(function(response){
				listaAlojamientos.alojamientoID.meGusta= response;
				console.log("¿Tiene el alojamiento un megusta?: ",listaAlojamientos.alojamientoID.meGusta);							
				var bool = listaAlojamientos.alojamientoID.meGusta;
				Boolean(bool);  
				if(!bool) listaAlojamientos.alojamientoID.meGusta = "../img/imgDetalles/corazon.png";
				else listaAlojamientos.alojamientoID.meGusta = "../img/imgDetalles/corazonMegusta.png";


				if(document.getElementById("infoAvailable" )==null){
   				    var newDiv = document.createElement("div");
					if(listaAlojamientos.alojamientoID.available == 1) var newContent = document.createTextNode("Este alojamiento incluye servicios adicionales ");
					else var newContent = document.createTextNode("Este alojamiento no incluye servicios adicionales ");    				
					newDiv.appendChild(newContent);
					
						//Añadi ID
					newDiv.setAttribute("id","infoAvailable");

					var currentDiv = document.getElementById("detalleAlojamiento");
					currentDiv.appendChild(newDiv);
					
					}
					
   				
   			alojamientosFactory.obtenerAlojamientosRelacioandos(id)
				.then(function(response){
				listaAlojamientos.alojamientosRelacionados = response;
				console.log("Obtenemos la lista de los alojamientos relacionados: ",listaAlojamientos.alojamientosRelacionados);				
				}, function(response){
					console.log("Error al obtener la lista de los alojamientos relacionados");
				})
   				
   				
   				
   				
   				
				}, function(response){
					console.log("Error al obtener la información de los likes del alojamiento");
				})	
								
				}, function(response){
					console.log("Error al leer los alojamientos");
				})			
			
		},		
		
		obtenerCategorias : function(){
			
			categoriaFactory.obtenerCategorias()
				.then(function(response){
				listaAlojamientos.categorias = response;
				console.log("Obtenemos las categorias: ",listaAlojamientos.categorias);				
				}, function(response){
					console.log("Error al obtener las categorias");
				})
			
		}
    }
    
    $scope.buscarAlojamiento= function(){
			var alojamientoAux =$scope.buscar;			
			Boolean(alojamientoAux); 
			if(!alojamientoAux)alojamientoAux = "null";
			else alojamientoAux =$scope.buscar;
			
			alojamientosFactory.getBuscarAlojamientos(alojamientoAux)
			.then(function(response){
			listaAlojamientos.alojamientos = response;
			console.log("Obtenemos los alojamientos: ", alojamientosFactory.alojamientos);				
			}, function(response){
				console.log("Error al realizar la busqueda de los alojamientos");
			})		
	
	
	}
	
	    window.disponibilidadAlojamientos= function(){
			
			var disponibilidad = document.getElementById("disponible")
			alojamientosFactory.getAlojamientosDisponibilidad(disponibilidad.value)
			.then(function(response){
			listaAlojamientos.alojamientos = response;
			console.log("Obtenemos los alojamientos: ", alojamientosFactory.alojamientos);				
			}, function(response){
				console.log("Error al realizar realizar el filtrad por disponibilidad");
			})
			}
			
		window.categoriasdAlojamientos= function(){
			
			var categoriaID = document.getElementById("categoriaID")
			
			console.log(categoriaID.value);
			
			alojamientosFactory.getAlojamientosCategoria(categoriaID.value)
			.then(function(response){
			listaAlojamientos.alojamientos = response;
			console.log("Obtenemos los alojamientos: ", alojamientosFactory.alojamientos);				
			}, function(response){
				console.log("Error al realizar realizar el filtrad por categoria");
			})


	}
	 window.ordenarAlojamientos = function(){
			var ordena = document.getElementById("ordenar");
			alojamientosFactory.getAlojamientosOrdenados(ordena.value)
			.then(function(response){
			listaAlojamientos.alojamientos = response;
			console.log("Obtenemos los alojamientos ordenados: ", alojamientosFactory.alojamientos);				
			}, function(response){
				console.log("Error al realizar realizar el ordenado de alojamientos");
			})

		
	}

	
	
	    $scope.modificarMegusta= function(){
		
		alojamientosFactory.putMegusta($routeParams.ID)
			.then(function(response){
			listaAlojamientos.functions.obtenerAlojamientoID($routeParams.ID);
			console.log("Se ha modificado el me gusta del usuario al alojamiento");				
			}, function(response){
				console.log("Error al modifcar me gusta del alojamiento");
			})		
	
	
	}
	if($routeParams.ID == undefined){
     listaAlojamientos.functions.leerAlojamientos();
     listaAlojamientos.functions.obtenerCategorias();

     }else  listaAlojamientos.functions.obtenerAlojamientoID($routeParams.ID);
      
}])