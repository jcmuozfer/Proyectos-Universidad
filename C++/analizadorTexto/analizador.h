#ifndef ANALIZADOR_H_
#define ANALIZADOR_H_
#include <string>
#include <iostream>
using namespace std;

const int MAX = 100;

struct analizador{
	string id;
	int linea;
};

typedef analizador vectorAux[MAX];

struct analizadorAux{
	vectorAux datos;
	int ocupadas;
};


void iniciar (analizadorAux &a);
void analizar(analizadorAux &a, string identificador,int nlinea);
void escribir(analizadorAux a, int n_lineas);



#endif /* ANALIZADOR_H_ */
