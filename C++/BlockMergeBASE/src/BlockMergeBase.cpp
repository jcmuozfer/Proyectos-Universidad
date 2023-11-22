//============================================================================
// Name        : BlockMerge.cpp
// Author      : Juan Carlos MUñoz Fernández
// Version     : 1.0
// Copyright   : Your copyright notice
// Description : Juego Block Merge
//============================================================================

#include "entorno.h"

#include <iostream>
using namespace std;

#include "Pruebas_Casillas.h"
#include "Pruebas_Tablero.h"
#include "TAD_Casilla.h"
#include "TAD_Tablero.h"
#include "Juego.h"


int main() {
	int vm;
	pruebaCasilla();
	prueba_Tablero();
	Juego j;

	if(	iniciarJuego(j)){
		gestionar(j,vm);
		acabar(j,vm);
	}
	else{
		cout << "ERROR AL INICIAR JUEGO"<<endl;
	}



	return 0;
}
