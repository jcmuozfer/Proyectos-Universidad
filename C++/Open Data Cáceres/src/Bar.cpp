//============================================================================
// Name        : Bar.cpp
// Author      : Juan Carlos Muñoz Fernández
// Version     : 2019/20
// Copyright   : Your copyright notice
// Description : Implementacion de la clase Bar
//============================================================================

#include "Bar.h"

Bar::Bar(string nombre,int capacidad,string sirve,string comida,string telefono,int codigoP,int codigoV,int portal,string apertura,string cierre) {

	this->nombreBar=nombre;
	this->capacidadBar=capacidad;
	this->sirveBar=sirve;
	this->comidaBar=comida;
	this->telefonoBar = telefono;
	this->codigoPBar=codigoP;
	this->codigoVBar=codigoV;
	this->portalBar=portal;
	this->aperturaBar=apertura;
	this->cierreBar=cierre;
}





Bar::~Bar() {

}

void Bar::mostrar() {
	cout<< "Nombre Bar: "<< 	this->nombreBar<<" Capacidad del Bar:   " <<	this->capacidadBar<< " Sirve:   "<<this->sirveBar<<" Tipo Comida:  "<<	this->comidaBar<<" TLF:  "<<	this->telefonoBar << " Codigo:  "<<this->codigoPBar<<" Codigo Via:  "<<this->codigoVBar<<" Portal:  "<<	this->portalBar<<" Apertura:   "<<	this->aperturaBar<< " Hora de cierre:  "<<this->cierreBar<<endl;
}

const string& Bar::getAperturaBar() const {
	return aperturaBar;
}

void Bar::setAperturaBar(const string &aperturaBar) {
	this->aperturaBar = aperturaBar;
}

int Bar::getCapacidadBar() const {
	return capacidadBar;
}

void Bar::setCapacidadBar(int capacidadBar) {
	this->capacidadBar = capacidadBar;
}

const string& Bar::getCierreBar() const {
	return cierreBar;
}

void Bar::setCierreBar(const string &cierreBar) {
	this->cierreBar = cierreBar;
}

int Bar::getCodigoPbAar() const {
	return codigoPBar;
}

void Bar::setCodigoPbAar(int codigoPbAar) {
	codigoPBar = codigoPbAar;
}

int Bar::getCodigoVBar() const {
	return codigoVBar;
}

void Bar::setCodigoVBar(int codigoVBar) {
	this->codigoVBar = codigoVBar;
}

const string& Bar::getComidaBar() const {
	return comidaBar;
}

void Bar::setComidaBar(const string &comidaBar) {
	this->comidaBar = comidaBar;
}

const string& Bar::getNombreBar() const {
	return nombreBar;
}

void Bar::setNombreBar(const string &nombreBar) {
	this->nombreBar = nombreBar;
}

int Bar::getPortalBar() const {
	return portalBar;
}

void Bar::setPortalBar(int portalBar) {
	this->portalBar = portalBar;
}

const string& Bar::getSirveBar() const {
	return sirveBar;
}

void Bar::setSirveBar(const string &sirveBar) {
	this->sirveBar = sirveBar;
}

const string& Bar::getTelefonoBar() const {
	return telefonoBar;
}

void Bar::setTelefonoBar(const string &telefonoBar) {
	this->telefonoBar = telefonoBar;
}
void Bar::modificarBar(Bar *b) {

	setCapacidadBar(b->getCapacidadBar());
	setSirveBar(b->getSirveBar());
	setComidaBar(b->getComidaBar());
	setTelefonoBar(b->getTelefonoBar());
	setCodigoPbAar(b->getCodigoPbAar()) ;
	setCodigoVBar(b->getCodigoVBar());
	setPortalBar(b->getPortalBar());
	setAperturaBar(b->getAperturaBar()) ;
	setCierreBar(b->getCierreBar());
	}
