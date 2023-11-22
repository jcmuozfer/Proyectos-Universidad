 angular.module('airbnbApp')
.factory('categoriaFactory',['$http', function($http){
	
	var url = 'https://localhost:8443/Airbnb/rest/categorias/'; 
	
	 var interfazUsuario = {
	
	
	obtenerCategorias:  function(){
			return $http.get(url)
				.then(function(response){
					return response.data;
			});

    	},
    	
    putCategoria:  function(categoria){
			return $http.put(url,categoria)
				.then(function(response){
					return response.data;
			});

    	},
	
	   exitenciaCategoria:  function(nombreCategoria){
        urlNueva = url + "existencia/"+ nombreCategoria;
			return $http.get(urlNueva)
				.then(function(response){
					return response.data;
			});

    	},
    	
    crearCategoria:  function(categoria){
			return $http.post(url,categoria)
				.then(function(response){
					return response.status;
			});

    	},
    	
    eliminarCategoria:  function(categoriaEliminar){
	var urlNueva  = url + categoriaEliminar;
	console.log(urlNueva);
			return $http.delete(urlNueva)
				.then(function(response){
					return response.status;
			});

    	}
    				  
    }
    return interfazUsuario;
}])