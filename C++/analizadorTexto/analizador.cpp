#include "analizador.h"



void iniciar (analizadorAux &a){

a.ocupadas = 0;


}
void analizar(analizadorAux &a,string identificador,int nlinea){

bool enc=false;

	for(int i = 0 ; i<a.ocupadas && !enc; i++){
	if(a.datos[i].id == identificador){
	enc = true;

	}
	}
	if(!enc){
	a.datos[a.ocupadas].id=identificador;
	a.datos[a.ocupadas].linea=nlinea;
	a.ocupadas = a.ocupadas+1;
	}
}

 void escribir(analizadorAux a, int n_lineas){

	 cout<<endl;
	 cout<<"Lista de identificadores:"<<endl;
	 cout<<endl;
	 for(int i=0;i<a.ocupadas;i++){
		 cout<<a.datos[i].id<<"     "<<a.datos[i].linea<<endl;
		 cout<<endl;
	 }
	 cout<<"Número total de líneas del fichero de entrada:"<<n_lineas<<endl;
 }
