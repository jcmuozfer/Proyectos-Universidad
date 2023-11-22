/**

	INTRODUCCIÓN A LA PROGRAMACIÓN / FUNDAMENTOS DE PROGRAMACIÓN
	Curso 2019/2020

	Nombre: TAD_Casilla.cpp
	Descripción: TAD Casilla gestionar la información de una casilla del tablero. Cada casilla puede estar vacía o no. Si no está
	vacía, tendrá un número.
	Autor:	Juan Carlos MUñoz Fernández
    Fecha:	21/12/2019
 */

#include "TAD_Casilla.h"

void iniciar(Casilla &c){

	c.ocupada = false;
}


void ponerValor(Casilla &c, int n){

	c.valor = n;
	c.ocupada = true;
}


int obtenerValor (Casilla c){

	return c.valor;
}



bool obtenerSiOcupada (Casilla c){

	return c.ocupada;
}


void vaciar(Casilla &c){

	c.ocupada = false;
}







