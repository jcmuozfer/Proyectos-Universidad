#include "analizador.h"



void iniciar (analizadorAux &a){
a.ocupadas = 0;
}

bool insertar (analizadorAux &a,analizador b){
	bool enc=false;
	bool err = false;
	for(int i=0;i<a.ocupadas && !enc;i++)
		if( strcmp(a.datos[i].id,b.id) == 0)
			if(a.datos[i].tipo==b.tipo){
			enc=true;
			a.datos[i]=b;
			}else {
			err = true;
		
			}
		
	
	
	if(!enc && !err){
		
		a.datos[a.ocupadas]=b;
		a.ocupadas++;
		enc =true;
	}
 	return enc;
}


bool buscar (analizadorAux &a, char c_cadena[20], analizador &b){
	bool enc=false;
	for(int i = 0 ; i<a.ocupadas && !enc; i++)
		if(strcmp(a.datos[i].id,c_cadena) == 0){
		b=a.datos[i];
		enc = true;
		}
	
	return enc;
}


void escribir(analizadorAux a, int n_lineas){

	 cout<<endl;
	 cout<<"Lista de identificadores:"<<endl;
	 cout<<endl;
	 for(int i=0;i<a.ocupadas;i++){
		 cout<<a.datos[i].id<<"     "<<a.datos[i].linea<<endl;
		 cout<<endl;
	 }

	
 }
 
 
void crearFichero(analizadorAux a, char* nombreFichero){
 
    fstream f;
    f.open(nombreFichero, ios::out);
    
	 for(int i=0;i<a.ocupadas;i++){
    
    	switch(a.datos[i].tipo){
    	
    	case 0:
    	f<< a.datos[i].id<< "  entero  "<< a.datos[i].valor.c_entero<<endl;
    	break;
    	
    	
    	case 1:
    	f<< a.datos[i].id<< "  real  "<< a.datos[i].valor.c_real<<endl;
    	break;
    	
    	
    	case 2:
    	if(a.datos[i].valor.c_bool == true) f<< a.datos[i].id<<"  lógico  cierto" <<endl;
    	else f<< a.datos[i].id<< "  lógico  falso" <<endl;
    	break; 	
    	
	
    	} 
    }

    f.close();
 }
 
 
