angular.module('airbnbApp')
.factory("alojamientosFactory", ['$http',function($http){
	
	
	var url = 'https://localhost:8443/Airbnb/rest/alojamientos/'; 
    var interfazAlojamientos = {
    	obtenerAlojamientos: function(){
    		return $http.get(url)
    			.then(function(response){
					return response.data;
			});
    		
    	},
    	
    	 getAlojamientosUsuario: function(){
    		urlnueva = url + "alojamientosUsuario";

    		return $http.get(urlnueva)
    			.then(function(response){
					return response.data;
			});
    		
    	},
    	 getAlojamientosDisponibilidad: function(disponibilidad){
    		urlnueva = url + "disponibilidad/"+ disponibilidad ;

    		return $http.get(urlnueva)
    			.then(function(response){
					return response.data;
			});
    		
    	},
    	
    	getAlojamientosCategoria: function(categoriaID){
    		urlnueva = url + "categoria/"+ categoriaID ;
    		return $http.get(urlnueva)
    			.then(function(response){
					return response.data;
			});
    		
    	},
    	
    	
    	
    	obtenerCategoriasPertenece: function(alojamientoID){
    		urlnueva = url + "CategoriasPertenece/"+ alojamientoID ;
    		return $http.get(urlnueva)
    			.then(function(response){
					return response.data;
			});
    		
    	},
    	obtenerCategoriasNoPertenece: function(alojamientoID){
    		urlnueva = url + "CategoriasNoPertenece/"+ alojamientoID ;
    		return $http.get(urlnueva)
    			.then(function(response){
					return response.data;
			});
    		
    	},
    	
    obtenerAlojamientosRelacioandos: function(alojamientoID){
    		urlnueva = url + "alojamientosRelacionados/" + alojamientoID;
    		return $http.get(urlnueva)
    			.then(function(response){
					return response.data;
			});
    		
    	},
    	
    	
    	
    	getAlojamientosOrdenados: function(ordenar){
    		urlnueva = url + "ordenar/"+ ordenar ;
    		return $http.get(urlnueva)
    			.then(function(response){
					return response.data;
			});
    		
    	},

    	  postAlojamiento:  function(alojamiento){
			return $http.post(url, alojamiento)
				.then(function(response){
					return response.status;
			})
						
    	},
    	

    	  asignarCategoriaAlojamientoNuevo:  function(categoria){
			urlNueva = url + "asignarCategoria" ; 
			return $http.post(urlNueva, categoria)
				.then(function(response){
					return response.status;
			})
						
    	},
    	
    	asignarCategoriasAlojamientoID:  function(categoria, alojamientoID){
			urlNueva = url + "asignarCategoria/"+ alojamientoID ; 
			console.log(urlNueva);
			return $http.post(urlNueva, categoria)
				.then(function(response){
					return response.status;
			})
						
    	},
    	
    	putAlojamiento:  function(alojamiento,categoria){
	      	var urlid = url + alojamiento.id+"/"+categoria;
			return $http.put(urlid, alojamiento)
				.then(function(response){
					return response.status;
			});
    	},
    	
    	putMegusta:  function(id){
		  	var urlid = url +"meGusta/" + id;

			return $http.put(urlid)
				.then(function(response){
					return response.data;
			});
		},
    	
    	  deleteAlojamiento:  function(id){
	      	var urlid = url + id;

			return $http.delete(urlid)
				.then(function(response){
					return response.status;
			});
    	},
    	
    	getAlojamiento : function(id){

			var urlid = url + id;

			return $http.get(urlid)
				.then(function(response){
					return response.data;
			});
    	
    	},
    	
    	getAlojamientoID : function(id){

			var urlid = url +"infoAlojamiento/" + id;

			return $http.get(urlid)
				.then(function(response){
					return response.data;
			});
    	
    	},
    	
    	getBuscarAlojamientos: function(nombreAlojamiento){

			var urlid = url +"buscarAlojamiento/" + nombreAlojamiento;

			return $http.get(urlid)
				.then(function(response){
					return response.data;
			});
    	
    	},
    	
    	getMegustaAlojamiento: function(id){
    		urlnueva = url + "meGusta/"+ id ;
    		return $http.get(urlnueva)
    			.then(function(response){
					return response.data;
			});
    		
    	}
    	
    }
    return interfazAlojamientos;
}])