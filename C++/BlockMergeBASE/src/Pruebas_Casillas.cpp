/*
 * Pruebas_Casillas.cpp
 *
 *  Created on: 30 dic. 2019
	Autor:	Juan Carlos Muñoz Fernández
 */

#include "Pruebas_Casillas.h"




void pruebaCasilla(){

	cout << "INICIO PRUEBAS " <<endl;
	cout <<"Inicio pruebas TAD_Casilla"<<endl;

	Casilla c;
	iniciar(c);

	if( obtenerSiOcupada(c) != false){
		cout<<"Error al obtener ocupadas"<<endl;
		cout<<"Error al iniciar casilla"<<endl;

	}
	ponerValor(c, 3);
	if (obtenerSiOcupada(c) !=true and obtenerValor(c) !=3){
		cout<<"Error al poner valor"<<endl;
	}
	if(obtenerValor(c) != 3){
		cout<<"Error al obtener valor"<<endl;

	}
	if( obtenerSiOcupada(c) != true){
		cout<<"Error al obtener ocupadas"<<endl;
	}
	vaciar(c);
	if( obtenerSiOcupada(c) != false){
		cout<<"Error al vaciar casilla"<<endl;
	}

	cout<<"Fin prubas TAD_Casillas"<<endl;
}

