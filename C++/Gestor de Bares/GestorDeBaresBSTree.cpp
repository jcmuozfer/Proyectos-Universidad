//============================================================================
// Name        : algoritmos.cpp
// Author      : Juan Carlos Muñoz Fernández
// Version     : 2019/20
// Copyright   : Your copyright notice
// Description : Implementación de los algoritmos del proyecto
//============================================================================

#include <fstream>
#include <iostream>
#include <iomanip>

#include "algoritmos.h"

using namespace std;

// MAIN function
int main() {

	Algoritmos algoritmos;

}

// ******************** PRIVATE OPERATIONS ********************

void Algoritmos::run() {
	//mostrarBares();
	Bar *b;
	cout<<"______________ bares a la izquierda de la raíz_________________"<<endl;

	mostrarIzquierda();
	cout<<"______________ bares a la derecha de la raíz_________________"<<endl;
	mostrarDerecha();

	cout<<"______________ Algoritmo de búsqueda________________"<<endl;
	string nombre = "La Chicha";
	if (buscarBar(nombre, b)){
		cout << "Bar encontrado"<<endl;
		b->mostrar();
	} else
		cout << nombre<< " no encontrado"<<endl;

	nombre = "Casa Pepa";
	if (buscarBar(nombre, b)){
		cout << "Bar encontrado"<<endl;
		b->mostrar();
	} else
		cout << nombre<< " no encontrado"<<endl;



	cout<<"______________ Algoritmo es hoja_________________"<<endl;
	nombre = "La Chicha";
	if (estaEnHoja(nombre) == true)
		cout << nombre <<" Si esta en hoja"<<endl;
	else
		cout << nombre <<" No esta en hoja"<<endl;
	nombre = "100 Montaditos";
	if (estaEnHoja(nombre) == true)
		cout << nombre <<" Si esta en hoja"<<endl;
	else
		cout <<nombre << " No esta en hoja"<<endl;
	nombre = "Zeri’s Coffee Roaster";
	if (estaEnHoja(nombre) == true)
		cout << nombre <<" Si esta en hoja"<<endl;
	else
		cout <<nombre << " No esta en hoja"<<endl;

	nombre = "Zeppelin";
	if (estaEnHoja(nombre) == true)
		cout << nombre <<" Si esta en hoja"<<endl;
	else
		cout <<nombre << " No esta en hoja"<<endl;


	cout <<"______________ Algoritmo padre_________________"<<endl;
	nombre = "La Chicha";
	Bar *bPadre = NULL;
	padre(nombre, bPadre);
	if (bPadre != NULL)
		cout << "El nodo padre de "<< nombre<< " es "<< bPadre->getNombre()<<endl;
	else
		cout << nombre << " no tiene padre"<<endl;
	nombre = "Camelot Cafés y Tapas";
	bPadre = NULL;
	padre(nombre, bPadre);
	if (bPadre != NULL)
		cout << "El nodo padre de " << nombre << " es " << bPadre->getNombre()
		<< endl;
	else
		cout << nombre << " no tiene padre" << endl;

	nombre = "Las Claras";
	bPadre = NULL;
	padre(nombre, bPadre);
	if (bPadre != NULL)
		cout << "El nodo padre de " << nombre << " es " << bPadre->getNombre()
		<< endl;
	else
		cout << nombre << " no tiene padre" << endl;

	cout<< " ______________ Algoritmo nivel de un nodo_________________"<<endl;
	nombre = "La Chicha";
	int level = 0;
	nivel(nombre, level);
	cout << nombre << " se encuentra en el nivel " << level << endl;

	nombre = "Camelot Cafés y Tapas";
	level = 0;
	nivel(nombre, level);
	cout << nombre << " se encuentra en el nivel " << level << endl;

	nombre = "Las Claras";
	level = 0;
	nivel(nombre, level);
	cout << nombre << " se encuentra en el nivel " << level << endl;

	nombre = "Zeppelin";
	level = 0;
	nivel(nombre, level);
	cout << nombre << " se encuentra en el nivel " << level << endl;
	cout<< " ______________ Algoritmo que devuelve un subarbol________________"<<endl;

	BSTree<KeyValue<string, Bar*> > *subAbb;
	nombre = "San Juan";
	subArbol(nombre, subAbb);
	cout << "__________ Mostrando subárbol _________"<< nombre<<endl;
	mostrarBares(subAbb);


	nombre = "Mastropiero";
	subArbol(nombre, subAbb);
	cout << "__________ Mostrando subárbol _________"<< nombre<<endl;
	mostrarBares(subAbb);
	cout<< " ______________ Algoritmo copia de árbol_________________"<<endl;
	copiar();
}

void Algoritmos::cargarBares() {
	string cad[10];
	Bar *bar;
	int i;
	ifstream f("Bar.csv");
	if (f.is_open()) {
		getline(f, cad[0]); // leer cabecera
		// nombre;capacidad_personas;sirve_comida;Tipo_Comida;
		//teléfono;código_postal;código_vía;portal;hora_apertura;hora_cierre
		while (!f.eof()) {
			for (i = 0; i < 9; i++)
				getline(f, cad[i], ';');
			getline(f, cad[9]);
			if (!f.eof()) {
				bar = new Bar(cad[0], atoi(cad[1].c_str()), cad[2],
						cad[3], cad[4], cad[5],
						atoi(cad[6].c_str()), atoi(cad[7].c_str()), cad[8], cad[9]);
				insertarBar(bar);
			}
		}
	}	else {
		cout << "ERROR: fichero Bar.csv no encontrado" << endl;
	}
}




// ******************** PUBLIC INTERFACE ********************

Algoritmos::Algoritmos() {

	cout << "Programming Project v1.00 (EDI)." << endl;
	cout << "           Author: Juan Carlos Muñoz Fernández." << endl;
	cout << "           Date:   March 8th, 2020." << endl;


	aBares   = new BSTree<KeyValue<string, Bar*>> ;
	cargarBares();
	run();
}


void Algoritmos::insertarBar(Bar *b) {

	KeyValue<string, Bar*> pair	(b->getNombre(), b);
	aBares->insert(pair);
}

void Algoritmos::root(BSTree<KeyValue<string, Bar*> > *abb, Bar *&b) {
	KeyValue<string, Bar *> pair = abb->root();
	b = pair.value();
}

void Algoritmos::mostrarDerecha() {
	int n;
	if (!aBares->empty())
		if (aBares->right() != NULL)
			n =mostrarBares(aBares->right());
	cout << "Nº de bares a la derecha de la raíz " << n <<endl;
}

void Algoritmos::mostrarIzquierda() {
	int n;
	if (!aBares->empty())
		if (aBares->right() != NULL)
			n = mostrarBares(aBares->left());
	cout << "Nº de bares a la izquierda de la raíz " <<n<<endl;


}

bool Algoritmos::buscarBar(BSTree<KeyValue<string, Bar*>> *abb, string nombre, Bar *&b) {
	bool enc  = false;
	BSTree<KeyValue<string, Bar*>> *auxiliar;
	if(!abb->empty()){
		KeyValue< string, Bar*> auxiliar2 (nombre, b);
		if(auxiliar2 < abb->root()){
			auxiliar=abb->left();
			if(auxiliar != NULL){
				enc = buscarBar(auxiliar,nombre, b);
			}
		}
		if(auxiliar2 > abb->root()){

			auxiliar=abb->right();
			if(auxiliar != NULL){
				enc = buscarBar(auxiliar,nombre, b);
			}
		}
		if(auxiliar2 == abb->root()){
			enc = true;
			b=abb->root().value();
		}
	}
	return enc;
}

bool Algoritmos::buscarBar(string nombre, Bar *&b) {
	bool enc = false;
	if (!aBares->empty())
		enc = buscarBar(aBares, nombre, b);
	return enc;

}

void Algoritmos::eliminar(string nombre) {

	aBares->remove(nombre);
}
int Algoritmos::mostrarBares(BSTree<KeyValue<string, Bar*>> *abb) {
	int cont = 0;
	Bar *b;
	if (!abb->empty()){
		if(abb->left() != NULL)
			cont = cont +mostrarBares(abb->left());
		//  b = abb->root().value();
		root(abb, b);
		b->mostrar();

		cont ++;
		if(abb->right() != NULL)
			cont = cont + mostrarBares(abb->right());
	}
	return cont;
}
void Algoritmos::mostrarBares(){
	int cont= 0;
	if (!aBares->empty())
		cont = mostrarBares(aBares);
	cout <<"Nº de Bares en el árbol "<< cont<< endl;


}

int Algoritmos::numElementos(BSTree<KeyValue<string, Bar*>> *abb) {


	int cuantos = 0;

	if (abb !=NULL) {
		cuantos = 1 + numElementos(abb->left()) + numElementos (abb->right());

	}
	return cuantos;

}

int Algoritmos::numElementos() {

	int n = 0;

	if (!aBares->empty()) {

		n = this->numElementos(aBares);
	}

	return n;

}

bool Algoritmos::estaEnHoja(string nombre,BSTree<KeyValue<string, Bar*> > *abb) {
	bool esHoja;

	BSTree<KeyValue<string, Bar*>> *auxiliar;
	if(!abb->empty()){
		KeyValue< string, Bar*> auxiliar2 (nombre);
		if(auxiliar2 < abb->root()){

			auxiliar=abb->left();
			if(auxiliar != NULL){
				esHoja = estaEnHoja(nombre, auxiliar);

			}
		}


		if(auxiliar2 > abb->root()){

			auxiliar=abb->right();
			if(auxiliar != NULL){
				esHoja = estaEnHoja(nombre, auxiliar);

			}
		}
		else{
			if(abb->left() == NULL)
				if(abb->left() == NULL)
					esHoja = true;

		}
	}


	return esHoja;
}

bool Algoritmos::estaEnHoja(string nombre) {
	bool esHoja = false;
	Bar *auxiliar;
	if (!aBares -> empty())
		if(buscarBar( nombre, auxiliar))
			esHoja = estaEnHoja(nombre, aBares);
	return esHoja;
}

void Algoritmos::padre(BSTree<KeyValue<string, Bar*> > *abb, string nombre,Bar *&bPadre) {


	BSTree<KeyValue<string, Bar*>> *auxiliar;


	if(!abb->empty()){
		KeyValue< string, Bar*> auxiliar2 (nombre);
		if(auxiliar2 != abb->root()){
			if(auxiliar2 < abb->root()){

				bPadre = abb->root().value();
				auxiliar=abb->left();
				if(auxiliar != NULL){
					padre(auxiliar,nombre,bPadre);

				}
			}


			if(auxiliar2 > abb->root()){

				bPadre = abb->root().value();
				auxiliar=abb->right();
				if(auxiliar != NULL){
					padre(auxiliar,nombre,bPadre);

				}
			}
		}
	}
}


void Algoritmos::padre(string nombre, Bar *&bPadre) {
	if (!aBares->empty())
		if(buscarBar( nombre, bPadre))
			bPadre = NULL;
	padre(aBares, nombre, bPadre);
}

void Algoritmos::nivel(BSTree<KeyValue<string, Bar*> > *abb, string nombre,
		int &level) {


	BSTree<KeyValue<string, Bar*>> *auxiliar;


	if(!abb->empty()){
		KeyValue< string, Bar*> auxiliar2 (nombre);
		if(auxiliar2 != abb->root()){
			level++;
		}
		if(auxiliar2 != abb->root()){
			if(auxiliar2 < abb->root()){


				auxiliar=abb->left();
				if(auxiliar != NULL){
					nivel(auxiliar,nombre,level);

				}
			}


			if(auxiliar2 > abb->root()){


				auxiliar=abb->right();
				if(auxiliar != NULL){
					nivel(auxiliar,nombre,level);

				}
			}
		}
	}
}

void Algoritmos::nivel(string nombre, int &level) {
	level = 0;
	Bar *auxiliar;

	if (!aBares->empty())
		if(buscarBar( nombre, auxiliar))
			nivel(aBares, nombre, level);
}

void Algoritmos::copiar(BSTree<KeyValue<string, Bar*> > *abb,
		BSTree<KeyValue<string, Bar*> > *&abbCopia) {

	BSTree<KeyValue<string, Bar*>> *auxiliar;

	if(!abb->empty()){

		abbCopia->insert(abb->root());
		auxiliar=abb->left();
		if(auxiliar != NULL){
			copiar(auxiliar,abbCopia);

		}
		auxiliar=abb->right();
		if(auxiliar != NULL){
			copiar(auxiliar,abbCopia);

		}
	}

}
void Algoritmos::copiar() {
	BSTree<KeyValue<string, Bar*> > *abbCopia = new BSTree < KeyValue<string, Bar*> >();
	if(!aBares->empty()){
		copiar(aBares,abbCopia);
		mostrarBares(abbCopia);
		delete abbCopia;
	}
	else{
		cout <<"No hay datos para realizar la copia"<<endl;
	}
}

void Algoritmos::subArbol(BSTree<KeyValue<string, Bar*> > *abb, string nombre,
		BSTree<KeyValue<string, Bar*> > *&subAbb) {
	//Bar *broot;
	if(buscarB( abb, nombre,subAbb) == false){
		cout << "El bar "<<nombre<< " no tiene subarbol"<<endl;
	}
}

void Algoritmos::subArbol(string nombre,BSTree<KeyValue<string, Bar*> > *&subAbb) {
	subAbb=NULL;
	if (!aBares->empty()){
		subArbol(aBares, nombre, subAbb);
	}
}

bool Algoritmos::buscarB(BSTree<KeyValue<string, Bar*> > *abb, string nombre,
		BSTree<KeyValue<string, Bar*> > *&b) {
	bool encontrado  = false;
	Bar *bauxiliar2 = NULL;
	BSTree<KeyValue<string, Bar*>> *auxiliar;

	if(!abb->empty()){
		KeyValue< string, Bar*> auxiliar2 (nombre, bauxiliar2);

		if(auxiliar2 < abb->root()){
			auxiliar=abb->left();
			if(auxiliar != NULL){
				encontrado = buscarB(auxiliar,nombre, b);
			}
		}
		if(auxiliar2 > abb->root()){

			auxiliar=abb->right();
			if(auxiliar != NULL){
				encontrado = buscarB(auxiliar,nombre, b);
			}
		}else{
			if(auxiliar2 == abb->root()){
				encontrado = true;
				b=abb;
			}
		}
	}
	return encontrado;
}

Algoritmos::~Algoritmos() {

	Bar *bar = NULL;
	while (!aBares->empty()){
		root(aBares, bar);
		aBares->remove(aBares->root());
		delete bar;
	}

	delete aBares;
}
