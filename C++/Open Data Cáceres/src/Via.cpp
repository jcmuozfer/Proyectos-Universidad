//============================================================================
// Name        : Via.cpp
// Author      : Juan Carlos Muñoz Fernández
// Version     : 2019/20
// Copyright   : Your copyright notice
// Description : Implementacion de la clase vía
//============================================================================

#include "Via.h"

Via::Via(string tipo,string nombre,float longitud,int codigoV,int codigoB) {

	this->tipoVia=tipo;
	this->nombreVia = nombre;
	this->longitudVia = longitud;
	this->codigoVia=codigoV;
	this->codigoBVia=codigoB;


}

int Via::getCodigoBVia() const {
	return codigoBVia;
}

void Via::setCodigoBVia(int codigoBVia) {
	this->codigoBVia = codigoBVia;
}

int Via::getCodigoVia() const {
	return codigoVia;
}

void Via::setCodigoVia(int codigoVia) {
	this->codigoVia = codigoVia;
}

float Via::getLongitudVia() const {
	return longitudVia;
}

void Via::setLongitudVia(float longitudVia) {
	this->longitudVia = longitudVia;
}

const string& Via::getNombreVia() const {
	return nombreVia;
}

void Via::setNombreVia(const string &nombreVia) {
	this->nombreVia = nombreVia;
}

const string& Via::getTipoVia() const {
	return tipoVia;
}

void Via::mostrarVia() {
	cout<<"Tipo de Via: " <<	this->tipoVia<<" Nombre de Via: "<<this->nombreVia<< " Longitud Via:  "<<	this->longitudVia<<" Codigo Via: "<<this->codigoVia<<" Codigo Barrio: "<<this->codigoBVia<<endl;
}

void Via::setTipoVia(const string &tipoVia) {
	this->tipoVia = tipoVia;
}

Via::~Via() {

}




