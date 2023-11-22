#ifndef ANALIZADOR_H_
#define ANALIZADOR_H_
#include <string>
#include <iostream>
#include <fstream>  
#include <cstring>
#include <stdio.h>
using namespace std;

const int MAX = 100;


union c_valor{
	int c_entero;
	float c_real;
	char c_cadena[100];
	bool c_bool;
};

struct analizador{
	char id[20];
	c_valor valor;
	int tipo;    //entero=0    real=1     logico=2     cadena=3
	int linea;
};

typedef analizador vectorAux[MAX];

struct analizadorAux{
	vectorAux datos;
	int ocupadas;
};


void iniciar (analizadorAux &a);
bool insertar (analizadorAux &a,analizador b);
bool buscar (analizadorAux &a, char* c_cadena, analizador &b);
void escribir(analizadorAux a, int n_lineas);
void crearFichero(analizadorAux a, char* nombreFichero);



#endif /* ANALIZADOR_H_ */

