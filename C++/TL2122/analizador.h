#ifndef ANALIZADOR_H_
#define ANALIZADOR_H_
#include <string>
#include <iostream>
#include <fstream>  
#include <cstring>
#include <stdio.h>
#include <string.h>
using namespace std;

const int MAX = 100;


union c_valor{
	int c_entero;
	float c_real;
	char c_cadena[100];
	bool c_bool;
};

struct analizador{
	c_valor valor;
	int tipo;    //entero=0    real=1     logico=2     cadena=3
	char nombreTipo[100];
};


//Usado para almacenar las listas 
typedef analizador vectorAux[MAX];

struct listaAux{
	char id[25];     //Identificadors
	vectorAux datos; //Datos 
	int ocupadas;		
};

typedef listaAux Lista[MAX];


struct listas{

	Lista lista; //Datos 
	int ocupadas;		
};


//Usado para almacenar las variables

struct VariableAux{
	char nombreVariable[25];     //Identificadors
	analizador valor;
};

typedef VariableAux Variables[MAX];


struct variables{

	Variables variable; //Datos 
	int ocupadas;		
};


void iniciarListas(listas &l);
void crearLista (listas &l);
bool asignarNombreLista (listas &l, char nombreID[25]);
bool insertarDatoListas(listas &l, analizador dato);
bool insertarDatosSecuencia (listas &l, int inicio, int fin);
void valoresLista(listas &l);

void iniciarVariables(variables &v);
bool crearVariable (variables &v,char nombreVariable[25]);
bool asignarTipo(listas &l,variables &v,analizador a);
void valoresVariables(variables &v);

bool buscar (variables &v,analizador &a, char c_cadena[25]);
bool asignarValor (listas &l,variables &v, analizador nuevoValor, char c_cadena[25]);

bool primero (listas &l,char id[25],analizador &valor );
bool ultimo (listas &l,char id[25], analizador &valor);
bool enesimo (listas &l,char id[25], int n, analizador &valor);

bool buscarLista(listas &l,char nombreLista[25], listaAux &lista);

void escribir (analizador dato , fstream &f);
void saltoLinea( fstream &f);


void iniciarCPP(fstream &f);
void finalizarCPP(fstream &f);
#endif /* ANALIZADOR_H_ */

