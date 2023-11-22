#include "analizador.h"




void iniciarListas(listas &l){
	l.ocupadas = 0;
}


void crearLista (listas &l){

	listaAux lista;
	lista.ocupadas = 0;
	l.lista[l.ocupadas] = lista;
	l.ocupadas++;

}


bool asignarNombreLista (listas &l, char nombreID[25]){
	listaAux lista;
	bool enc = false;
	if(!buscarLista(l,nombreID,lista)){
	int UltPos = l.ocupadas -1;
	listaAux lista = l.lista[UltPos];
	strcpy(lista.id , nombreID );
	l.lista[UltPos ] = lista;
	enc = true;
	}

	return enc;

}

bool  insertarDatoListas(listas &l, analizador dato ){
	
	bool enc = true;

	int UltPos = l.ocupadas -1;
	listaAux lista = l.lista[UltPos];
	if(lista.ocupadas >1)
		if(dato.tipo != lista.datos[lista.ocupadas-1].tipo){
		enc = false;
		dato.tipo = lista.datos[lista.ocupadas-1].tipo;
		};
		
	lista.datos[lista.ocupadas] = dato;
	lista.ocupadas++;
	l.lista[UltPos ] = lista;
	
	return enc;

}




bool insertarDatosSecuencia (listas &l, int inicio, int fin){
	
	if(inicio < fin){
	int UltPos = l.ocupadas -1;
	listaAux lista = l.lista[UltPos];
	for(int i = inicio; i<=fin; i++){
	analizador aAux;
	aAux.valor.c_entero = i;
	aAux.tipo = 0;
	lista.datos[lista.ocupadas] = aAux;
	lista.ocupadas++;
	}
	l.lista[UltPos ] = lista;
	return true;
	}else return false;

}

void iniciarVariables(variables &v){
	v.ocupadas = 0;
}


bool crearVariable (variables &v, char nombreVariable[25]){
	analizador a;
	bool enc  =false;
	if(!buscar (v, a, nombreVariable )){
	VariableAux var;
	strcpy(var.nombreVariable, nombreVariable );
	var.valor.tipo = -1;
	v.variable[v.ocupadas] = var;
	v.ocupadas++;
	enc = true;
	}
	return enc;
}


bool asignarTipo(listas &l,variables &v,analizador a){

bool enc = true;
for(int i = 0; i< v.ocupadas; i++){

	if(v.variable[i].valor.tipo == -1){
	
	v.variable[i].valor.tipo = a.tipo;
	if(a.tipo == 3){ 
	listaAux lista;
	if(buscarLista(l,a.valor.c_cadena,lista)){
	strcpy(v.variable[i].valor.nombreTipo,a.nombreTipo  );
	}else enc = false;
	}
	}
}
return enc;
}


void valoresLista(listas &l){

	for(int i = 0; i< l.ocupadas;i++){
		
		listaAux auxLista = l.lista[i];
		cout<<auxLista.id<< " = ";
		
		
		for(int j = 0; j<  auxLista.ocupadas; j++){
			
			switch( auxLista.datos[j].tipo){
		    	
		    	case 0:
		    	cout<<   auxLista.datos[j].valor.c_entero<<"  tipo: "<< auxLista.datos[j].tipo<< "|";
		    	break;
		    	
		    	
		    	case 1:
		    	cout<<   auxLista.datos[j].valor.c_real<<"  tipo: "<< auxLista.datos[j].tipo<< "|";
		    	break;
		    	
		    	
		    	case 2:
		    	cout<<  auxLista.datos[j].valor.c_bool<<"  tipo: "<< auxLista.datos[j].tipo<< "|";
		    	break; 
		    	
		    	case 3:
		    	cout<<  auxLista.datos[j].valor.c_cadena<<"  tipo: "<< auxLista.datos[j].tipo<< "|";
		    	break; 
	    		
	
    			}
    		}
    		
    	cout<<endl;	
	}
}


void valoresVariables(variables &v){


		for(int j = 0; j<  v.ocupadas; j++){
			
			switch( v.variable[j].valor.tipo){
		    	
		    	case 0:
		    	cout<<v.variable[j].nombreVariable<< " de tipo: "<<  v.variable[j].valor.tipo   << " y valor: " <<   v.variable[j].valor.valor.c_entero<<"  ";
		    	break;
		    	
		    	
		    	case 1:
		    	cout<<v.variable[j].nombreVariable<< " de tipo: "<<  v.variable[j].valor.tipo   << " y valor: " <<   v.variable[j].valor.valor.c_real<<"  ";
		    	break;
		    	
		    	
		    	case 2:
		    	cout<<v.variable[j].nombreVariable<< " de tipo: "<<  v.variable[j].valor.tipo   << " y valor: " << v.variable[j].valor.valor.c_bool<<"  ";
		    	break; 
		    	
		    	case 3:
		    	cout<<v.variable[j].nombreVariable<< " de tipo: "<<  v.variable[j].valor.tipo   << " y valor: " << v.variable[j].valor.valor.c_cadena<<"  ";
		    	break; 
	
    			}
    		
    	cout<<endl;	
    	
	}
}

bool buscar (variables &v, analizador &a, char c_cadena[25] ){
	bool enc=false;
	for(int i = 0 ; i<v.ocupadas && !enc; i++){
		if(strcmp(v.variable[i].nombreVariable,c_cadena) == 0){
		a.tipo=v.variable[i].valor.tipo;
		a.valor=v.variable[i].valor.valor; 
		
		enc = true;
		}
}


	

	return enc;
}

bool asignarValor (listas &l,variables &v, analizador nuevoValor, char c_cadena[25]){
bool enc=false;
	for(int i = 0 ; i<v.ocupadas && !enc; i++)
		if(strcmp(v.variable[i].nombreVariable,c_cadena) == 0){
		
			switch(nuevoValor.tipo){

		    	case 0:
		    	v.variable[i].valor.valor.c_entero = nuevoValor.valor.c_entero;
		    	break;
		    	
		    	
		    	case 1:
		    	v.variable[i].valor.valor.c_real =  nuevoValor.valor.c_real;
		    	break;
		    	
		    	case 2:
		    	v.variable[i].valor.valor.c_bool =  nuevoValor.valor.c_bool;
		    	break; 
		    	
		    	case 3:
		    	strcpy(v.variable[i].valor.valor.c_cadena, nuevoValor.valor.c_cadena );
		    	break; 	
			
		    	}
			v.variable[i].valor.tipo = nuevoValor.tipo;
									
		enc = true;
		}
	
	return enc;
}


bool buscarLista(listas &l,char nombreLista[25], listaAux &lista){

bool enc = false;



for(int i = 0; i< l.ocupadas && !enc; i++)
	
	if(strcmp(l.lista[i].id,nombreLista) == 0){
	enc = true;
	lista = l.lista[i];
	}


return enc;
}




bool primero (listas &l,char id[25],analizador &valor ){
	
	listaAux lista;
	bool enc  =false;
 	if(buscarLista(l,id, lista)) {
	valor=lista.datos[0];
	enc  =true;
	}
	return enc;
}


bool ultimo (listas &l,char id[25], analizador &valor){

	listaAux lista;
	bool enc = false;	
 	if(buscarLista(l,id, lista)) {
 	int ultPos = lista.ocupadas -1;
	valor=lista.datos[ultPos];
	enc  =true;
	}
	return enc;
}



bool enesimo (listas &l,char id[25], int n, analizador &valor){
	
	
	listaAux lista;
	bool enc = false;
	
	
 	if(buscarLista(l,id, lista)) {
 	if(lista.ocupadas>= n){
	valor=lista.datos[n-1];
	enc = true;
	}else{
	cout<<"No se ha encontrado lista "<<id<< endl;
	}
	}
	

	
	return enc;
	
	}


void escribir (analizador dato , fstream &f){
	

	f<<'\t'<< "cout << "; 

	switch( dato.tipo){

	case 0:
	f<<dato.valor.c_entero;
	break;

	case 1:
	f<<dato.valor.c_real;
	break;
	
	case 2:
	if(dato.valor.c_bool==true)
	f<< "cierto" <<endl;
    	else f<<"falso" <<endl;
	break; 

	case 3:
	char aux= '"';
	if(dato.valor.c_cadena[0]!= aux)
	f<<'"'<<dato.valor.c_cadena<< '"';
	else f<<dato.valor.c_cadena;
	break; 
	}
	
	f<<";"<<endl;

}



void saltoLinea( fstream &f){


f<<'\t'<<"cout << endl;" <<endl;


}


void iniciarCPP(fstream &f){
f<< "#include <iostream>" <<endl;
f<< "using namespace std;" <<endl;
f<< "int main(){" <<endl;
f <<endl;
f<<'\t'<<"// Inicio del bloque de código" <<endl;

}

void finalizarCPP(fstream &f){

f<<'\t'<< "// Final del bloque de código" <<endl;
f <<endl;
f<<'\t'<< "return 0;" <<endl;
f<<"}" <<endl;

}

