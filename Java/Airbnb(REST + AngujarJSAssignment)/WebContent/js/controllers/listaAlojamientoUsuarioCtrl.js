angular.module('airbnbApp')
.controller('listaAlojamientoUsuarioCtrl', ['alojamientosFactory',function(alojamientosFactory){
   
    var listaAlojamientosU = this;
    listaAlojamientosU.alojamientos=[];
    listaAlojamientosU.functions = {
    	
		leerAlojamientos : function(id){
			alojamientosFactory.getAlojamientosUsuario()
				.then(function(response){
				listaAlojamientosU.alojamientos = response
				console.log("Obtenemos los alojamientos del usuario: ", listaAlojamientosU.alojamientos);				
				}, function(response){
					console.log("Error al leer los alojamientos del usuario");
				})			
			
		}
    }
     listaAlojamientosU.functions.leerAlojamientos();
}])