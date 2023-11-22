//============================================================================
// Name        : algoritmos.cpp
// Author      : Juan Carlos Muñoz Fernández
// Version     : 2019/20
// Copyright   : Your copyright notice
// Description : Implementación de los algoritmos del proyecto
//============================================================================

#include "Algoritmos.h"

int main() {

	Algoritmos a;

	return 0;
}

Algoritmos::Algoritmos() {

	pBarrios = new Pila<Barrio *> ();
	cargarBarrios();
	run();
}
void Algoritmos::run() {
	Barrio * b = nullptr;
	string nombre;
	mostrar();
	cout <<"____________ nº de elementos _________________"<<endl;
	cout <<"El nº de barrios son 78 y nos da "<< numElementos()<<endl;

	cout <<"____________ barrio del fondo _________________"<<endl;
	getFondo (b);
	cout << "El Barrio del fondo es Argentina y nos da:" <<endl;
	b->mostrar();


	cout <<"____________ Insertar barrio en el fondo _________________"<<endl;
	b = new Barrio ("XXXXXXX", 23.43, 12, 10, "Centro");
	insertarFondo(b);


	cout <<"____________ barrio del fondo _________________"<<endl;
	getFondo (b);
	cout << "El Barrio del fondo es XXXXXXX y nos da:" <<endl;
	b->mostrar();


	cout <<"_______ barrio de un distrito _________________"<<endl;


	ListaPI<Barrio *> *lista = new ListaPI<Barrio *>;
	nombre  = "Norte";

	//mostrar la lista devuelta
	getListaBarrios(lista,nombre);
	// eliminar la lista devuelta
	delete lista;

	cout <<"____________ fichero barrio de un distrito _________________"<<endl;
	escribirFichero("Sur");
	escribirFichero("Norte");
	escribirFichero("Oeste");

}

/****Métodos privados*****/

void Algoritmos::cargarBarrios(){
	Barrio *b;

	ifstream fEnt;
	string linea, barrio, distrito, area, perimetro, codigo;
	fEnt.open("Barrio.csv");
	if (fEnt.is_open()) {
		getline(fEnt, linea); // leo la cabecera
		//rdfs_label;om_area;om_perimetro;om_tieneCodigoBarrio;om_perteneceADistrito
		while (!fEnt.eof()) {
			getline(fEnt, barrio, ';');
			if (!fEnt.eof()) {
				getline(fEnt, area, ';');
				getline(fEnt, perimetro, ';');
				getline(fEnt, codigo, ';');
				getline(fEnt, distrito);
				b = new Barrio(barrio, atof(area.c_str()),
						atof(perimetro.c_str()), atoi(codigo.c_str()),
						distrito);
				insertar(b);

			}
		}

	} else
		cout << "ERROR: fichero Barrio.csv no encontrado" << endl;
}



void Algoritmos::insertar(Barrio *b) {
	pBarrios->apilar (b);

}


void Algoritmos::insertarFondo(Pila<Barrio*> *pB, Barrio *b) {
	Barrio *aux;

	if (!pB->vacia()) {
		pBarrios->cima(aux);
		pBarrios->desapilar();
		insertarFondo(pB, b);
		pBarrios->apilar(aux);
	}
	else
		pB->apilar(b);

}

void Algoritmos::insertarFondo(Barrio *b){
	if (!pBarrios->vacia())
		insertarFondo(pBarrios, b);

}

void Algoritmos::mostrar (Pila <Barrio *> *pB){
	Barrio *b = NULL;

	if (!pB->vacia()) {
		pB->cima(b);
		// donde ponemos en mostrar el barrio
		// opción 1
		b->mostrar();
		pB->desapilar();

		mostrar(pB); // llamada recursiva
		// opcion 2
		//b->mostrar();
		pB->apilar(b); // apilo los datos para no perder la pila
	}
}

void Algoritmos::mostrar(){
	if (!pBarrios->vacia())
		mostrar(pBarrios);

}

int Algoritmos::numElementos(Pila<Barrio*> *pB) {
	Barrio *b = NULL;
	int cont = 0;
	if (!pB->vacia()) {
		pB->cima(b);
		pB->desapilar();

		cont = 1 + numElementos(pB); // llamada recursiva

		pB->apilar(b);

	}
	return cont;
}



int Algoritmos::numElementos() {
	int total = 0;
	if (!pBarrios->vacia())
		total = numElementos(pBarrios);
	return total;
}

void Algoritmos::getFondo(Pila<Barrio*> *pB, Barrio *&b) {
	Barrio *aux;

	if (!pB->vacia()) {
		pB->cima(aux);
		b = aux;
		pB->desapilar();

		getFondo(pB, b);

		pB->apilar(aux);

	}

}

void Algoritmos::getFondo(Barrio *&b) {

	if (!pBarrios->vacia()){
		getFondo(pBarrios, b);
	}

}

Algoritmos::~Algoritmos() {
	Barrio *b;

	if (pBarrios != NULL) {

		while (!pBarrios->vacia()) {
			pBarrios->cima(b);
			pBarrios->desapilar();
			delete b;
		}
		delete pBarrios;

	}
}

void Algoritmos::getListaBarrios(ListaPI<Barrio *> *&lista,string distrito) {
	Barrio *b=NULL;


	Pila<Barrio*> *aux =  new Pila <Barrio *>;
	while(!pBarrios->vacia()){
		pBarrios->cima(b);
		if(b->getDistrito() == distrito){
			lista->insertar(b);

			b->mostrar();

		}

		aux->apilar(b);
		pBarrios->desapilar();

	}
	while(!aux->vacia()){
		aux->cima(b);
		pBarrios->apilar(b);
		aux->desapilar();

	}

	delete aux;

}

void Algoritmos::escribirFichero(Pila<Barrio*> *pB,string nombre) {
	string n;
	float a;
	float p;
	int c;
	string d;
	ofstream f;
	Barrio *b =NULL;

	f.open(nombre, ios::app);
	if(f.is_open()){
		if (!pB->vacia()) {
			pB->cima(b);
			n = b->getNombre();
			p = b->getPerimetro();
			a = b->getArea();
			c = b->getCodigo();
			d = b->getDistrito();

			if(b->getDistrito() == nombre){


				f<<n <<" - "<<a <<" - "<< p<<" - "<<c<<" - "<<d<<endl;

			}

			pB->desapilar();
			escribirFichero(pB,nombre);
			pB->apilar(b);

		}

	}

	f.close();

}

void Algoritmos::escribirFichero(string nombre){
	if (!pBarrios->vacia())
		escribirFichero(pBarrios,nombre);
}
