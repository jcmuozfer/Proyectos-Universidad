 angular.module('airbnbApp')
.factory('usuarioFactory',['$http', function($http){
	
	var url = 'https://localhost:8443/Airbnb/rest/usuarios/'; 
	
	 var interfazUsuario = {

    	postUsuario:  function(usario){
        
			return $http.post(url, usario)
				.then(function(response){
					return response.status;
			});

    	},
    	 getUsuario: function(){
    		return $http.get(url)
    			.then(function(response){
					return response.data;
			});
    		
    	} ,
    	exitenciaUsuario: function(usuarioNombre){

		urlid = url +"nombre/"+ usuarioNombre;
		console.log(urlid);
    		return $http.get(urlid)
    			.then(function(response){
					return response.data;
			});
    		
    	} ,
    	 putUsuario: function(usuarioModificado){
    		return $http.put(url,usuarioModificado)
    			.then(function(response){
					return response.data;
			});
    		
    	},
    	 deleteUsuario: function(){
    		return $http.delete(url)
    			.then(function(response){		
					return $http.status;
			});
    		
    	}
    	
    				  
    }
    return interfazUsuario;
}])