//============================================================================
// Name        : algoritmos.h
// Author      : Juan Carlos Muñoz Fernández
// Version     : 2019/20
// Copyright   : Your copyright notice
// Description : implementación algoritmos del proyecto
//============================================================================



#include "Algoritmos.h"
int main(){
	Algoritmos a;
}

/****Métodos privados*****/
void Algoritmos::cargarBarrios() {

	Barrio *b;
	ifstream fEnt;
	string campo1, campo2, campo3, campo4, campo5;
	fEnt.open("Barrio.csv");
	if (fEnt.is_open()) {
		getline(fEnt, campo1); // leo la cabecera
		while (!fEnt.eof()) {
			getline(fEnt, campo1, ';');
			if (!fEnt.eof()){
				getline(fEnt, campo2, ';');
				getline(fEnt, campo3, ';');
				getline(fEnt, campo4, ';');
				getline(fEnt, campo5);


				b = new Barrio(campo1, stof(campo2), stof(campo3), stoi(campo4),campo5);
				lBarrios->insertar(b);

			}


		}
		fEnt.close();
	}
	else
		cout << "ERROR: fichero Barrio.csv no encontrado" << endl;
}
/******Métodos públicos****/

Algoritmos::Algoritmos() {
	lBarrios = new ListaPI <Barrio *>;
	cargarBarrios();
	run();
}
void Algoritmos::run() {
	Barrio *b;
	bool salir;
	int opcion;
	salir = false;
	string nombre,distrito;
	float area,perimetro;
	int codigo;



	while(!salir){
		cout << "1-. Insertar inicio"<<endl;
		cout << "2-. Insertar final "<<endl;
		cout << "3-. Mostrar "<<endl;
		cout << "4-. obtener último "<<endl;
		cout << "5-. buscar"<< endl;
		cout << "6-. eliminar"<< endl;
		cout << "7-. salir"<< endl;

		cin>>opcion;
		switch (opcion){
		case 1:
			cout<< "Introduce nombre "<<endl;
			cin>>nombre;
			cout<< "Introduce el área "<<endl;
			cin>> area;
			cout<< "Introduce el perímetro "<<endl;
			cin>>perimetro;
			cout<< "Introduce el código "<<endl;
			cin>> codigo;
			cout<< "Introduce distrtito "<<endl;
			cin>>distrito;
			b = new Barrio(nombre, area,perimetro,codigo,distrito);

			insertarInicio (b);



			break;
		case 2:
			cout<< "Introduce nombre "<<endl;
			cin>>nombre;
			cout<< "Introduce el área "<<endl;
			cin>> area;
			cout<< "Introduce el perímetro "<<endl;
			cin>>perimetro;
			cout<< "Introduce el código "<<endl;
			cin>> codigo;
			cout<< "Introduce distrtito "<<endl;
			cin>>distrito;
			b = new Barrio(nombre, area,perimetro,codigo,distrito);
			insertarFinal  (b);
			break;
		case 3:

			mostrar();

			break;
		case 4:
			obtenerUltimo (b);

			break;
		case 5:
			cout<< "Introduzca el nombre del barrio del qse quiere obtener información"<<endl;
			cin>>nombre;
			if(buscar(nombre, b)){
				lBarrios->consultar(b);
				b->mostrar();

			}
			else{
				cout<< "No se ha encontrado barrio con nombre :"<< nombre<<endl;

			}

			break;
		case 6:
			cout<<"Introduzca información del Barrio del que se desea eliminar información"<<endl;
			cin>>nombre;
			eliminar(nombre);
			break;
		case 7:
			salir = true;
			break;
		}
	}
}


void Algoritmos::insertarInicio(Barrio *b) {

	lBarrios->moverInicio();
	if(lBarrios->enInicio()){

		lBarrios->insertar(b);
	}
	else{
		cout <<"Error al poner pi al inicio"<<endl;
	}

}

void Algoritmos::insertarFinal(Barrio *b) {


	lBarrios->moverFinal();
	if(lBarrios->enFin()){

		lBarrios->insertar(b);
	}
	else{
		cout <<"Error al poner pi al inicio"<<endl;
	}

}

void Algoritmos::mostrar() {
	Barrio *b;

	lBarrios->moverInicio();
	if(lBarrios->enInicio()){
		while(!lBarrios->finLista()){
			lBarrios->consultar(b);
			b->mostrar();
			lBarrios->avanzar();

		}


	}
	else{
		cout <<"Error al poner pi al inicio"<<endl;
	}

}



void Algoritmos::obtenerUltimo(Barrio *&b) {
	lBarrios->finLista();
	lBarrios->consultar(b);
	b->mostrar();

}



bool Algoritmos::buscar(string nombre, Barrio *&b) {
	lBarrios->moverInicio();
	bool enc;
	enc = false;

	while(!lBarrios->finLista()and !enc){
		lBarrios->consultar(b);
		if(nombre == b->getNombre() ){
			enc =  true;

		}
		else{
			lBarrios->avanzar();
		}

	}
	if(enc == true){
		lBarrios->consultar(b);
		b->mostrar();

	}

	return enc;
}

void Algoritmos::eliminar(string nombre) {
	lBarrios->moverInicio();
	bool enc;
	enc = false;
	Barrio *b;


	while(!lBarrios->finLista()and !enc){
		lBarrios->consultar(b);
		if(nombre == b->getNombre() ){
			enc =  true;

		}
		else{
			lBarrios->avanzar();
		}

	}
	if(enc == true){
		lBarrios->consultar(b);
		delete b;
		lBarrios->borrar();

	}
}
Algoritmos::~Algoritmos() {
	Barrio * b = NULL;
	lBarrios->moverInicio();
	while (!lBarrios->estaVacia()){
		lBarrios->consultar(b);
		delete b;
		lBarrios->borrar();
	}
	delete lBarrios;
}
