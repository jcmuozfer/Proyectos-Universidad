angular.module('airbnbApp', ['ngRoute'])
.config(function($routeProvider){
	$routeProvider
    	.when("/", {	
    		controller: "alojamientosCategoriaCtrl",
    		controllerAs: "alojamientoCat",
    		templateUrl: "Categorias.html",
    		resolve: {
    			// produce 500 miliseconds (0,5 seconds) of delay that should be enough to allow the server
    			//does any requested update before reading the orders.
    			// Extracted from script.js used as example on https://docs.angularjs.org/api/ngRoute/service/$route
    			delay: function($q, $timeout) {
    			var delay = $q.defer();
    			$timeout(delay.resolve, 500);
    			return delay.promise;
    			}
    		}
    	})
    	.when("/Perfil", {
			controller: "perfilCtrl",
			controllerAs: "perfilU",
			templateUrl: "Perfil.html",
			
    	})
    	.when("/GestionAlojamientos", {
			controller: "listaAlojamientoUsuarioCtrl",
			controllerAs: "alojamientosUsuario",
			templateUrl: "GestionAlojamientos.html",
			    		resolve: {
    			// produce 500 miliseconds (0,5 seconds) of delay that should be enough to allow the server
    			//does any requested update before reading the orders.
    			// Extracted from script.js used as example on https://docs.angularjs.org/api/ngRoute/service/$route
    			delay: function($q, $timeout) {
    			var delay = $q.defer();
    			$timeout(delay.resolve, 500);
    			return delay.promise;
    			}
    		}
			
    	})
    	.when("/CrearAlojamiento", {
			controller: "gestionAlojamientoCtrl",
			controllerAs: "nuevoAlojamiento",
			templateUrl: "AnadirAlojamiento.html",
			
    	})
    	.when("/EditarAlojamiento/:ID", {        	
			 controller: "gestionAlojamientoCtrl",
    		controllerAs: "infoAlojamiento",
    		templateUrl: "EditarAlojamiento.html",        	
        })
        .when("/EliminarUsuario", {        	
			 controller: "perfilCtrl",
    		controllerAs: "perfilU",
    		templateUrl: "Perfil.html",        	
        })
         .when("/InfomacionAlojamiento/:ID", {        	
			 controller: "alojamientosCategoriaCtrl",
    		controllerAs: "alojamientoCat",
    		templateUrl: "detalleAlojamiento.html",        	
        })
        .when("/GestionCategorias", {        	
			 controller: "categoriaCtrl",
    		controllerAs: "categoriaIn",
    		templateUrl: "GestionCategorias.html",        	
        })
    	;
})
