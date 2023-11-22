//============================================================================
// Name        : Barrio.cpp
// Author      : Juan Carlos Muñoz Fernández
// Version     : 2019/20
// Copyright   : Your copyright notice
// Description : Implementacion de la clase Barrio
//============================================================================

#include "Barrio.h"

Barrio::Barrio(string nombreBarrio,float areaBarrio,float perimetroBarrio,int codigoBarrio,string distritoBarrio) {

	this->nombreBarrio=nombreBarrio;
	this->areaBarrio = areaBarrio;
	this->perimetroBarrio = perimetroBarrio;
	this->codigoBarrio = codigoBarrio;
	this->distritoBarrio=distritoBarrio;
	this->lV= new ListaPI< Via*> ();

}

float Barrio::getAreaBarrio() const {
	return areaBarrio;
}

void Barrio::setAreaBarrio(float areaBarrio) {
	this->areaBarrio = areaBarrio;
}

int Barrio::getCodigoBarrio() const {
	return codigoBarrio;
}

void Barrio::setCodigoBarrio(int codigoBarrio) {
	this->codigoBarrio = codigoBarrio;
}

const string& Barrio::getDistritoBarrio() const {
	return distritoBarrio;
}

void Barrio::setDistritoBarrio(const string &distritoBarrio) {
	this->distritoBarrio = distritoBarrio;
}

const string& Barrio::getNombreBarrio() const {
	return nombreBarrio;
}

void Barrio::setNombreBarrio(const string &nombreBarrio) {
	this->nombreBarrio = nombreBarrio;
}

float Barrio::getPerimetroBarrio() const {
	return perimetroBarrio;
}

void Barrio::setPerimetroBarrio(float perimetroBarrio) {
	this->perimetroBarrio = perimetroBarrio;
}



Barrio::~Barrio() {
	// TODO Auto-generated destructor stub
}

void Barrio::mostrarBarrio() {


	cout<<this->nombreBarrio<<" Área = "<<	this->areaBarrio<<" Perímetro = "<<	this->perimetroBarrio<<" Código = "<<	this->codigoBarrio <<" Distrito = "<<this->distritoBarrio<<endl;

}

void Barrio::recorrerVia(int &i) {


	i = 0;
	Via *v;

	lV->moverInicio();

	while(!lV->finLista()){

		lV->consultar(v);
		v->mostrarVia();
		lV->avanzar();

		i++;

	}
	;

}

void Barrio::buscarLarga(float &longitud,Via *&v) {

	Via *aux;
	lV->moverInicio();
	while(!lV->finLista()){

		lV->consultar(aux);

		if(aux->getLongitudVia()>longitud){

			longitud = aux->getLongitudVia();
			v = aux;

		}

		lV->avanzar();

	}
}

void Barrio::insertarVia(Via *&v) {
	lV->insertar(v);
}

void Barrio::consultarVia(Via *&v) {
	lV->consultar(v);
}

void Barrio::avanzarVia() {
	lV->avanzar();
}

void Barrio::MoverInicioVia() {
	lV->moverInicio();
}

bool Barrio::estaVaciaVia() {
	return lV->estaVacia();
}

bool Barrio::finListaVia() {
	return lV->finLista();
}

void Barrio::borrarVia() {
	return lV->borrar();
}

void Barrio::eliminarListaVia() {
	Via *v = NULL;
	while(!lV->estaVacia()){
		lV->consultar(v);
		delete v;
		lV->borrar();
	}
	delete lV;
}
void Barrio::buscarVia(string nombre, string tipo, int &codigo) {

	bool enc = false;
	Via *aux;
	lV->moverInicio();
	while(!lV->finLista() and !enc){

		lV->consultar(aux);

		if(aux->getNombreVia()== nombre and aux->getTipoVia() == tipo){
			enc = true;
			codigo= aux->getCodigoVia();
		}

		lV->avanzar();

	}

}
bool Barrio::buscarNombreVia(string &nombre,string &tipo, int codigo) {

	bool enc = false;
	Via *aux;
	lV->moverInicio();
	while(!lV->finLista() and !enc){

		lV->consultar(aux);

		if(aux->getCodigoVia()== codigo){
			enc = true;
			nombre= aux->getNombreVia();
			tipo = aux->getTipoVia();
		}

		lV->avanzar();

	}
return enc;
}


