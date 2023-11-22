//============================================================================
// Name        : algoritmos.cpp
// Author      : Profesores de la asignatura EDI
// Version     : 2019/20
// Copyright   : Your copyright notice
// Description : Implementación de los algoritmos del proyecto
//============================================================================



#include "algoritmos.h"


// ******************** PUBLIC OPERATIONS ********************


int main(){
	Algoritmos algoritmo;

}

Algoritmos::Algoritmos() {

	cout << "Programming Project v1.00 (EDI)." << endl;
	cout << "           Author: Iván Izquierdo Lázaro y Juan Carlos Muñoz Fernández." << endl;
	cout << "           Date:   April 5th, 2020." << endl;
	this -> lBarrios = new ListaPI< Barrio*> ();
	this->lBares =  new ListaPI< Bar*> ();
	this->aBares = new BSTree<KeyValue<string, Bar*>> ();


	cargarDatos();
	run();


}


void Algoritmos::cargarDatos() {

	Barrio *b;
	cargarBarrios(b);
	cargarBares();

}

void Algoritmos::cargarBarrios(Barrio *&b) {

	ifstream fEnt;
	string camp[5];

	fEnt.open("Barrio.csv",ios::in);

	int i;
	if (fEnt.is_open()) {

		getline(fEnt, camp[0]);

		while (!fEnt.eof()) {
			for(i=0;i<4;i++)
				getline(fEnt, camp[i], ';');
			getline(fEnt, camp[4]);
			if (!fEnt.eof()) {


				Barrio *a = new Barrio(camp[0], atof(camp[1].c_str()), atof(camp[2].c_str()), atoi(camp[3].c_str()),camp[4]);
				lBarrios->insertar(a);

			}
		}
		fEnt.close();
		cargarVias(b);
	}

	else{
		cout << "ERROR: fichero Barrio.csv no encontrado" << endl;
	}


}


void Algoritmos::cargarVias(Barrio *&b) {
	bool enc = false;

	ifstream v;
	int i;
	string camp[5];

	v.open("Via.csv");


	if (v.is_open()) {

		getline(v, camp[0]);

		while (!v.eof()) {
			for(i=0;i<4;i++)
				getline(v, camp[i], ';');
			getline(v, camp[4]);
			if (!v.eof()) {


				Via *v = new Via(camp[0], camp[1],atof( camp[2].c_str()), atoi(camp[3].c_str()),  atoi(camp[4].c_str()));
				lBarrios->moverInicio();
				enc = false;

				while(!lBarrios->finLista() and !enc){

					lBarrios->consultar(b);
					if(b->getCodigoBarrio()==atoi(camp[4].c_str())){
						b->insertarVia(v);
						enc = true;
					}
					lBarrios->avanzar();
				}
			}

		}
	}
	else{
		cout <<"Error al cargar Vias"<<endl;
	}

	v.close();
}


void Algoritmos::cargarBares() {
	ifstream fEnt;
	string cad[10];
	Bar *a;
	int i;
	fEnt.open("Bar.csv");
	if (fEnt.is_open()) {

		getline(fEnt, cad[0]);

		while (!fEnt.eof()) {
			for(i=0;i<9;i++)
				getline(fEnt, cad[i], ';');
			getline(fEnt, cad[9]);
			if (!fEnt.eof()) {
				a = new Bar(cad[0], atoi(cad[1].c_str()), cad[2],cad[3], cad[4], atoi(cad[5].c_str()),atoi(cad[6].c_str()),atoi(cad[7].c_str()),cad[8],cad[9]);
				lBares->insertar(a);
				insertarBar(a);
			}
		}
		fEnt.close();
	}

	else{

		cout << "ERROR: fichero Barrio.csv no encontrado" << endl;
	}
}


void  Algoritmos::insertarBar(Bar *b) {
	KeyValue<string, Bar*> pair (b->getNombreBar(), b);
	aBares->insert(pair);
}


void Algoritmos::run() {

	string  tipoC, nombre;
	int total;
	bool salir;
	int opcion;
	salir = false;
	Via *v;

	vector vi;


	while(!salir){

		ListaPI <Bar *>	*lBaresAux  =  new ListaPI< Bar*> ();
		ListaPI <Bar *>	*lBaresAuxSub  =  new ListaPI< Bar*> ();
		Cola <Bar *> *CBares =  new Cola< Bar*> ();

		cout << "0-. Salir"<< endl;

		cout<<"------PRIMER PARTE PROYECTO---------------------------------------------------------------------------------------------------"<<endl;

		cout << "1-. Mostrar lista Vias perteneciente a un Barrio (Algoritmo 1)"<<endl;
		cout << "2-. Devuelve vía con mayor longuitud (Algoritmo 2)"<<endl;
		cout << "3-. Devuelve un Cola de Bares según la comida que sirve (Algoritmo 3) "<<endl;
		cout << "4-. Distrito con mayor número de barrios con su respectivo número (Algoritmo 4) "<<endl;

		cout<<"------SEGUNDA PARTE PROYECTO---------------------------------------------------------------------------------------------------"<<endl;

		cout << "5-. Genera un fichero con los nombres de los bares de forma inversa (Algoritmo 1)"<<endl;
		cout << "6-. Genera un fichero con todos los bares de una determinada via (Algoritmo 2) "<< endl;
		cout << "7-. Dado un bar, devuelve la vía a la que pertenece  (Algoritmo 3) "<< endl;
		cout << "8-. Devuelve una lista ordenada por capacidad los bares que comiencen por una determinada subcadena (Algoritmo 4)"<< endl;
		cout << "9-. Procesa un archivo de texto que contiene las actualizaciones que modifican las estructuras de datos (Algoritmo 5)"<< endl;
		cout << "10-. Devuelve una lista de bares que sirven un determinado tipo de comida y su capacidad sea superior a la dada (Algoritmo 6)"<< endl;
		cout << "11-. Devuelve el Barrio que mas bares tiene (Algoritmo 7)"<< endl;
		cout << "12-. Pruebas(Realizarse antes de utilizar el algoritmo 5 que modifica las estructuras de datos)"<< endl;

		cin>>opcion;
		switch (opcion){

		case 0:

			salir = true;
			break;

		case 1:
			cout<<"Introduzca el nombre del Barrio que se quiere obtener sus vias "<<endl;

			cin.ignore();
			getline(cin,nombre);
			mostrarVias( nombre, total);

			cout << "El Barrio: "<<nombre<<" contiene : "<<total<<" vías"<<endl;

			break;


		case 2:
			cout<< "La via con mayor longitud es: "<<endl;
			viaMayorLongitud(v);
			break;


		case 3:
			cout<< "Introduce tipo de comida"<<endl;
			cin.ignore();
			getline(cin,tipoC);
			tipoComida (tipoC,CBares,total);

			break;

		case 4:

			distritoM(vi,nombre,total);

			break;
		case 5:

			ficheroInverso();

			break;

		case 6:
			cin.ignore();
			ficheroBarV();

			break;
		case 7:

			viaDeBar();

			break;
		case 8:
			cin.ignore();
			listaBarSub(lBaresAuxSub);


			break;
		case 9:

			actualizarFichero();

			break;
		case 10:
			cin.ignore();
			listaComidaaBar(lBaresAux);

			break;
		case 11:

			masBares(nombre,total);

			break;
		case 12:
			cout<<"Comienzo de las pruebas "<<endl;
			pruebasPrimeraParte();
			pruebasSegundaParte();
			cout<<"Fin de las pruebas "<<endl;
			break;
		default:
			cout << "Número tecleado no corresponde con ninguna opción"<<endl;
		}
		delete lBaresAux;
		delete CBares;
		delete lBaresAuxSub;
	}


}


void Algoritmos::mostrarVias(string nombreBarrio, int &i) {

	bool enc;
	enc = false;
	Barrio *b;
	i = 0;

	lBarrios->moverInicio();

	while(!lBarrios->finLista()and !enc){

		lBarrios->consultar(b);
		b->MoverInicioVia();


		if(b->getNombreBarrio() == nombreBarrio){

			enc = true;

			if(!b->estaVaciaVia()){
				b->mostrarBarrio();
				b->recorrerVia(i);
			}
			else{
				cout<<"No hay vías"<<endl;

			}
		}

		else{
			lBarrios->avanzar();
		}
	}

	if(!enc){
		cout <<"No se ha encontrado Barrio"<<endl;

	}

}


void Algoritmos::viaMayorLongitud(Via *&mV) {


	float longitud;
	longitud = 0.0;
	Barrio *Br;
	lBarrios->moverInicio();

	while(!lBarrios->finLista()){

		lBarrios->consultar(Br);
		Br->buscarLarga(longitud,mV);
		lBarrios->avanzar();

	}

	mV->mostrarVia();
}


void Algoritmos::tipoComida(string tipoC, Cola <Bar *>	*&CBares, int &i ) {

	Bar *b;
	bool enc;
	enc = false;

	i = 0;


	lBares->moverInicio();


	while(!lBares->finLista()){

		lBares->consultar(b);
		if(tipoC == b->getComidaBar()){

			enc = true;

			CBares->encolar(b);
			b->mostrar();
			i++;

		}

		lBares->avanzar();

	}
	if(!enc){

		cout<< "No se ha encontrado el tipo de comida indicado"<<endl;

	}
	else{

		cout <<"Número total de restaurante "<<i<<endl;

	}

}


void Algoritmos::distritoM( vector &v, string &nombre,int &m) {
	string di;
	Barrio *b;
	int i,pos;
	int mayor;
	int MAX=8;
	mayor=0;
	bool enc;
	for(i=0;i<MAX;i++){
		v[i].cont=0;
		v[i].distrito=" ";
	}
	lBarrios->moverInicio();
	lBarrios->consultar(b);
	di=b->getDistritoBarrio();
	i=0;
	v[i].cont++;
	v[i].distrito=di;
	lBarrios->avanzar();
	while(!lBarrios->finLista()){
		lBarrios->consultar(b);
		di=b->getDistritoBarrio();
		enc=false;
		i=0;
		while(enc==false){
			if(di==v[i].distrito){
				enc=true;
				pos=i;
			}
			if(v[i].distrito==" "){
				enc=true;
				pos=i;
			}
			i++;
		}
		if(enc==true){
			v[pos].cont++;
			v[pos].distrito=di;
		}

		lBarrios->avanzar();
	}
	i=0;
	for(i=0;i<MAX;i++){
		if(v[i].cont>mayor){
			nombre=v[i].distrito;
			m=v[i].cont;
			mayor=v[i].cont;
		}
	}


	cout << "El distrito con mayor numeros de  barrios es: "<< nombre<< " con un total de "<< m <<" barrios" << endl;


}


void Algoritmos::ficheroInverso() {
	cout<<"Escribiendo un fichero en orden inverso..."<<endl;
	fstream f;
	Pila<BSTree<KeyValue<string, Bar*> > *> *pA = new Pila<BSTree<KeyValue<string, Bar*> > *> ();
	BSTree<KeyValue<string, Bar*> > *aux = aBares;
	Bar *b;
	f.open("FicheroInverso.txt", ios::app);
	while (!pA->vacia() || aux !=	nullptr) {

		while(aux !=nullptr){
			pA->apilar(aux);
			aux = aux->right();
		}

		pA->cima(aux);
		pA->desapilar();
		b =aux->root().value();
		f<<b->getNombreBar()<<";"<< b->getCapacidadBar()<<";"<< b->getSirveBar();
		f<<";"<<b->getComidaBar()<<";"<< b->getTelefonoBar()<<";"<<b->getCodigoPbAar();
		f<<";"<< b->getCodigoVBar()<< ";"<< b->getPortalBar()<< ";"<< b->getAperturaBar();
		f<<";"<< b->getCierreBar()<<endl;
		aux = aux->left();

	}
	delete pA;
	delete aux;
	f.close();
}


void Algoritmos::viaDeBar() {
	string nombre, nombreVia, tipo , barrio;
	Bar *b;
	if(!aBares->empty()){
		cout<<"Introduce el nombre del bar del que se quiere obtener información"<<endl;
		cin.ignore();
		getline(cin,nombre);
		if(viaDeBar(aBares, nombre,b, nombreVia, tipo, barrio )){
			cout<<"Bar a buscar: "<<nombre<<endl;
			cout<<nombre<<", capacidad "<<b->getCapacidadBar()<<" , sirve comida "<< b->getSirveBar();
			cout<<", tipo de comida "<<b->getComidaBar()<< ", "<<tipo<<" "<<nombreVia<<", barrio "<< barrio<<endl;

		}
		else
			cout<< "No se ha encontrado el bar "<<nombre<<endl;
	}
	else
		cout <<"Error en los datos del arbol"<<endl;
}


void Algoritmos::ficheroBarV() {
	fstream f;
	int cod,acu;
	string nombreVia ,tipoVia;
	acu=0;
	cout<<"Introduce el tipo de la via(calle,Avda,...)..."<<endl;

	getline(cin,tipoVia);
	cout<<"Introduce el nombre de la calle..."<<endl;

	getline(cin,nombreVia);

	f.open("BaresVia.txt",ios::app);
	if(!aBares->empty()){
		cod=buscarCodigoVia(nombreVia,tipoVia);
		ficheroBarVP(aBares,f,cod,acu);
		cout<<"Nº de bares: "<<acu<<endl;
	}
	else{
		cout<<"Error con aBares"<<endl;
	}
	f.close();
}


void Algoritmos::listaBarSub(ListaPI<Bar*> *&lBaresAux) {
	bool enc = false;
	string cadena;
	Bar *b;
	cout<<"Introduce la subcadena a buscar..."<<endl;

	getline(cin,cadena);
	if(lBaresAux->estaVacia()){

		lBaresAux->moverInicio();
		listaBarSub(aBares,lBaresAux,cadena,enc);
		lBaresAux->moverInicio();
		while(!lBaresAux->finLista()){
			lBaresAux->consultar(b);
			b->mostrar();
			lBaresAux->avanzar();
		}

		if(enc == false){
			cout<< "No se ha encontrado Bares que empiecen por "<<cadena<<endl;
		}
	}else{
		cout<< "Error: Lista no se encuentra vacia"<<endl;
	}


}


void Algoritmos::actualizarFichero() {

	string accion;
	string c;
	fstream f;
	f.open ("actualizaciones.txt");
	cout<<"Modificando las estructuras de datos relativas a los bares...."<<endl;
	getline(f,accion);
	while(!f.eof()){

		getline(f,accion,'#');
		getline(f,c);

		if(accion == "A"){
			altaFichero(f, atoi(c.c_str()));
		}

		if(accion == "B"){
			bajafichero(f, atoi(c.c_str()));
		}

		if(accion == "M"){
			modificarFichero(f, atoi(c.c_str()));
		}
	}

	f.close();

}


void Algoritmos::listaComidaaBar(ListaPI<Bar*> *&lBaresAux) {
	string comida;
	int capacidad;
	if(!aBares->empty()){
		cout<<"Introduce el tipo de comida del bar..."<<endl;
		getline(cin,comida);
		cout<<"Introduce la capacidad minima del bar..."<<endl;
		cin>>capacidad;
		listaComidaaBar(aBares,lBaresAux,comida,capacidad);
	}

}


void Algoritmos::masBares(string &nombre, int &m) {
	cout<<"Buscando....."<<endl;
	Cola <Bar *>*CBares= new Cola <Bar *>();
	masBaresBarrio(CBares,nombre, m);
	cout << "Barrio con más bares: "<<nombre<<",nº de bares "<<m<<endl;
	ficheroBaresBarrio(CBares);
	delete CBares;
}


void Algoritmos::pruebasPrimeraParte(){
	string nombreBarrio, tipoC,nombre;
	int i;
	Via *v;
	vector vi;
	Cola <Bar *> *CBares =  new Cola< Bar*> ();
	bool res = false;
	bool resul = false;
	cout <<"______________ Algoritmo Mostrar vias de un Barrio (Algoritmo 1)__________________________________"<<endl;
	nombreBarrio = "El Vivero";
	mostrarVias( nombreBarrio, i);

	if(i!=10){
		res = true;
		resul = true;
		cout<<"Error Algoritmo 1, al mostrar El Vivero"<<endl;
	}

	nombreBarrio = "Canovas";
	mostrarVias( nombreBarrio, i);

	if(i!=18){
		res = true;
		resul = true;
		cout<<"Error Algoritmo 1, al mostrar Canovas"<<endl;
	}

	if(!res){

		cout <<"Éxito al realizar las pruebas del Algoritmo 1"<<endl;
	}
	cout <<"______________ Algoritmo vía más larga (Algoritmo 2)__________________________________"<<endl;
	res = false;
	viaMayorLongitud(v);

	if(v->getTipoVia() != "Ctra"){
		res = true;
		resul = true;
		cout << "Error Algorimo 2, al obtener tipo vía"<<endl;
	}

	if(v->getNombreVia() != "De Badajoz"){
		res = true;
		resul = true;
		cout << "Error Algorimo 2, al obtener nombre vía"<<endl;
	}


	if(!res){

		cout <<"Éxito al realizar las pruebas del Algoritmo 2"<<endl;
	}



	cout <<"______________ Algoritmo Bares de una determinada comida (Algoritmo 3)__________________________________"<<endl;
	res = false;
	tipoC = "CHINA";
	tipoComida (tipoC,CBares,i );

	if(i != 6){
		res = true;
		resul = true;
		cout << "Error Algoritmo 3, Tipo de comida: CHINA"<<endl;
	}
	tipoC = "BURGUER";
	tipoComida (tipoC,CBares,i );

	if(i != 8){
		res = true;
		resul = true;
		cout << "Error Algoritmo 3, Tipo de comida: BURGUER"<<endl;
	}
	tipoC = "ITALIANA";
	tipoComida (tipoC,CBares,i );

	if(i != 10){
		res = true;
		resul = true;
		cout << "Error Algoritmo 3, Tipo de comida: ITALIANA"<<endl;
	}

	if(!res){
		cout <<"Éxito al realizar las pruebas del Algoritmo 3"<<endl;
	}


	cout <<"______________ Algoritmo distrito con más barrios (Algoritmo 4)__________________________________"<<endl;
	res = false;
	distritoM(vi,nombre,i);
	if( nombre != "Centro" or i != 29 ){
		cout<<"Error Algoritmo 4, distrito con más barrios"<<endl;
	}
	if(!res){
		cout <<"Éxito al realizar las pruebas del Algoritmo 4"<<endl;
	}
	if(!resul){
		cout <<"ÉXITO AL REALIZAR LAS PRUEBAS DE LA 1ª PARTE DEL PROYECTO"<<endl;
	}

	delete CBares;
}


void Algoritmos::pruebasSegundaParte() {
	string nombreBar,nombreVia,tipo,comida, nombre , barrio;
	bool enc = true;

	int total;
	ListaPI <Bar *>	*lBaresAux  =  new ListaPI< Bar*> ();
	ListaPI <Bar *>	*lBaresAuxSub  =  new ListaPI< Bar*> ();
	Bar *b;
	cout <<"______________ Algoritmo Nombres de Bares orden Inverso (Algoritmo 1)______________________________"<<endl;
	cout<<"Revisar el fichero y comprobar que esten ordenados de la Z-A"<<endl;
	ficheroInverso();

	cout<<endl;
	cout <<"______________ Algoritmo Fichero de bares de una vía (Algoritmo 2)_________________________________"<<endl;
	cout<<endl;

	cout<<"Si se introuce Calle Pizzaro se deberian de mostrar 8 bares"<<endl;
	cout<<"Si se introuce Calle Argentina se deberian de mostrar 4 bares"<<endl;
	cout<<"Si se introuce Calle Doctor Fleming se deberian de mostrar 12 bares"<<endl;

	ficheroBarV();

	cout<<endl;
	cout <<"______________ Algoritmo Información Bar (Algoritmo 3)_____________________________________________"<<endl;
	cout<<endl;

	nombre = "Puerta de Mérida";
	viaDeBar(aBares, nombre,b, nombreVia, tipo, barrio );
	if(b->getCapacidadBar() != 17){
		enc = false;
		cout <<"Error Algoritmo 3, obtener Capacidad"<<endl;
	}
	if(b->getSirveBar() != "SI"){
		enc = false;
		cout <<"Error Algoritmo 3, obtener si el bar sirve"<<endl;
	}
	if(b->getComidaBar() != "MEDITERRÁNEA"){
		enc = false;
		cout <<"Error Algoritmo 3, obtener comida Bar"<<endl;
	}
	if(tipo != "Calle"  and nombreVia != "Puerta De Merida" ){
		enc = false;
		cout <<"Error Algoritmo 3, obtener via"<<endl;
	}


	nombre = "ZRRCUS";
	viaDeBar(aBares, nombre,b, nombreVia, tipo, barrio );
	if(b->getCapacidadBar() != 400){
		enc = false;
		cout <<"Error Algoritmo 3, obtener Capacidad"<<endl;
	}
	if(b->getSirveBar() != "NO"){
		enc = false;
		cout <<"Error Algoritmo 3, obtener si el bar sirve"<<endl;
	}
	if(b->getComidaBar() != ""){
		enc = false;
		cout <<"Error Algoritmo 3, obtener comida Bar"<<endl;
	}
	if(tipo != "Avda"  and nombreVia != "Ruta De La Plata" ){
		enc = false;
		cout <<"Error Algoritmo 3, obtener via"<<endl;
	}
	if(enc){
		cout<<"Éxito al realizar la prueba del Algoritmo 3"<<endl;
	}
	cout<<endl;
	cout <<"______________ Algoritmo Busqueda bar (Algoritmo 4)________________________________________________"<<endl;
	cout<<endl;

	cout<<"Si se introuce 'Bur' se deberian de mostrar 4 bares"<<endl;
	cout<<"Si se introuce 'Burger' se deberian de mostrar 3 bares"<<endl;
	cout<<"Si se introuce 'La T' se deberian de mostrar 10 bares"<<endl;
	cout<<"Si se introuce 'Al' se deberian de mostrar 10 bares"<<endl;
	cout<<endl;

	listaBarSub(lBaresAuxSub);

	cout<<endl;
	cout <<"______________ Algoritmo Procesar Fichero para modificar Listas (Algoritmo 5)______________________"<<endl;
	cout<<endl;
	cout<< "Se debería de añadir 5 bares con tipo de comida TAPAS"<<endl;
	cout<< "Se debería de haber modificado la informaciónd de Homarus y el Corral "<<endl;
	cout<<"Se debría haber borrado Vadepizza y Hornos 25"<<endl;
	cout<<"Pa comprobar estos datos comprobar la diferencia a través del menu de opciones"<<endl;
	actualizarFichero();

	cout<<endl;
	cout <<"______________ Algoritmo Bares que sirven una comida (Algoritmo 6)_________________________________"<<endl;
	cout<<endl;

	cout<<"Si se introuce 'TAPAS', con capacidad en el bar de 60 personas se deberian de mostrar 5 bares"<<endl;
	cout<<"Si se introuce 'MEDITERRÁNEA', con capacidad en el bar de 80 personas se deberian de mostrar 10 bares"<<endl;
	cout<<endl;

	listaComidaaBar(lBaresAux);

	cout<<endl;
	cout <<"______________ Algoritmo Barrio con más Bares (Algoritmo 7)________________________________________"<<endl;
	cout<<endl;
	enc = true;
	masBares(nombreBar,total);


	if(nombreBar != "Canovas"){

		enc = false;
		cout <<"Error prueba Algoritmo 7,al obtener el nombre del barrio con más bares"<<endl;
	}
	if(total != 52){ //SON 52 PORQUE SE REALIZA TRAS LAS ACTUALIZACIONES, sin actualizaciones devuelve 51
		enc = false;
		cout <<"Error prueba Algoritmo 7,al obtener el numero de bares"<<endl;
	}
	if(enc){
		cout<<"Éxito al realizar la prueba del Algoritmo 7"<<endl;
	}
	delete lBaresAux;
	delete lBaresAuxSub;

}


Algoritmos::~Algoritmos() {

	Barrio *b = NULL;
	Bar *B = NULL;

	lBarrios->moverInicio();

	while(!lBarrios->estaVacia()){

		lBarrios->consultar(b);
		b->eliminarListaVia();
		delete b;
		lBarrios->borrar();

	}

	delete lBarrios;

	lBares->moverInicio();

	while(!lBares->estaVacia()){

		lBares->consultar(B);
		aBares->remove(B->getNombreBar());
		delete B;
		lBares->borrar();
	}

	delete lBares;

	delete aBares;

}


// ******************** PRIVATE OPERATIONS ********************

int Algoritmos::buscarCodigoVia(string nombreVia,string tipoVia) {
	int codigo;
	Barrio *B;
	lBarrios->moverInicio();
	while(!lBarrios->finLista()){
		lBarrios->consultar(B);
		B->buscarVia(nombreVia,tipoVia,codigo);
		lBarrios->avanzar();
	}

	return codigo;
}


void Algoritmos::ficheroBarVP(BSTree<KeyValue<string, Bar*> > *abb,fstream &f,int codigo,int &acu) {

	KeyValue<string,Bar*> pair;
	Bar *b;
	if (!abb->empty()) {
		pair=abb->root();
		b=pair.value();
		if (b->getCodigoVBar() == codigo) {

			f<<b->getNombreBar()<<" pax:"<<b->getCapacidadBar()<<" ; "<<b->getSirveBar()<<" ; "<<b->getComidaBar()<<endl;
			acu++;
			b->mostrar();

		}

		if (abb->left() != NULL){

			ficheroBarVP(abb->left(),f,codigo,acu);
		}if(abb->right()!=NULL){
			ficheroBarVP(abb->right(),f,codigo,acu);
		}
	}
}


void Algoritmos::masBaresBarrio(Cola <Bar *>	*&CBares, string &nombre, int &mCont) {

	int cont;
	mCont = 0;
	lBarrios->moverInicio();
	Barrio *b;
	Via *via;

	while (!lBarrios->finLista()){
		Cola <Bar *> *cAux;
		cAux = new Cola <Bar *>();
		lBarrios->consultar(b);
		b->MoverInicioVia();
		cont = 0;
		while(!b->finListaVia()){

			b->consultarVia(via);
			contarBaresVia(aBares,via,cAux, cont);
			b->avanzarVia();
		}
		if(cont>mCont){
			nombre = b->getNombreBarrio();
			mCont = cont;
			CBares->~Cola();
			CBares =cAux;
		}
		lBarrios->avanzar();
	}
}


void Algoritmos::contarBaresVia(BSTree<KeyValue<string, Bar*> > *abb,Via *&v,Cola <Bar *>	*&CBares,int &cont) {


	BSTree<KeyValue<string, Bar*> > *aux ;
	Bar *b;

	if(!abb->empty()){

		aux = abb->left();

		if(aux != NULL){
			contarBaresVia(aux,v,CBares, cont);
		}

		b =abb->root().value();
		if(v->getCodigoVia() == b->getCodigoVBar()){
			CBares->encolar(b);
			cont ++;
		}
		aux = abb->right();
		if(aux != NULL){
			contarBaresVia(aux,v,CBares, cont);

		}

	}

}


bool Algoritmos::viaDeBar(BSTree<KeyValue<string, Bar*>> *abb,string nombre,Bar *&b, string &nombreVia,string &tipo, string &barrio) {
	int codigo;
	bool enc;
	enc = false;
	BSTree<KeyValue<string, Bar*>> *aux;
	if(!abb->empty()){
		KeyValue< string, Bar*> Aux (nombre);
		if(Aux < abb->root()){

			aux=abb->left();
			if(aux != NULL){
				enc = viaDeBar(aux,nombre,b,nombreVia, tipo, barrio);

			}
		}

		if(Aux > abb->root()){
			aux=abb->right();
			if(aux != NULL){
				enc = viaDeBar(aux,nombre,b,nombreVia, tipo, barrio);

			}
		}
		else{
			if(Aux == abb->root()){
				b = abb->root().value();
				codigo = b->getCodigoVBar();
				buscarVia(codigo, nombreVia, tipo, barrio);
				enc = true;

			}
		}
	}
	return enc;
}


void Algoritmos::buscarVia(int codigoVia,string &nombreVia,string &tipo,string &barrio) {


	Barrio *b;
	bool enc;
	enc = false;
	lBarrios->moverInicio();

	while(!lBarrios->finLista() and !enc){

		lBarrios->consultar(b);

		if(b->buscarNombreVia(nombreVia,tipo,codigoVia)){
			enc =  true;
			barrio = b->getNombreBarrio();
		}
		else
			lBarrios->avanzar();

	}
	if(!enc){

		cout<< "No se ha encontrado via con el codigo "<< codigoVia<<endl;

	}

}


void Algoritmos::listaBarSub(BSTree<KeyValue<string, Bar*> > *abb,ListaPI <Bar *> *&lBaresAux, string cadena, bool &enc) {


	Bar *broot;
	string n;
	string nuevo;

	if (!abb->empty()) {

		if (abb->left() != NULL)
			listaBarSub(abb->left(),lBaresAux,cadena,enc);

		KeyValue<string,Bar*> pair= abb->root();
		broot=pair.value();
		nuevo=broot->getCapacidadBar();
		n=broot->getNombreBar();

		if (abb->root().key().rfind(cadena)==0) {
			enc = true;
			insertarCapacidad(lBaresAux,broot);
		}

		if(abb->right()!=NULL)
			listaBarSub(abb->right(),lBaresAux,cadena,enc);


	}
}


void Algoritmos::listaComidaaBar(BSTree<KeyValue<string, Bar*> > *abb,ListaPI <Bar *> *&lBaresAux, string comida, int capacidad) {

	KeyValue<string,Bar*> pair;
	Bar *b;
	string n,sirve,com;
	if (!abb->empty()) {
		pair=abb->root();
		b=pair.value();
		if (b->getComidaBar() == comida and b->getCapacidadBar()>capacidad) {
			lBaresAux->insertar(b);
			b->mostrar();

		}

		if (abb->right() != NULL){
			listaComidaaBar(abb->right(),lBaresAux,comida,capacidad);
		}if(abb->left()!=NULL){
			listaComidaaBar(abb->left(),lBaresAux,comida,capacidad);
		}
	}
}


void Algoritmos::insertarCapacidad(ListaPI<Bar*> *&lBaresAux, Bar *b) {
	bool enc=false;
	int cap;
	Bar *Baux;
	lBaresAux->moverInicio();
	while(!lBaresAux->finLista() && !enc){
		lBaresAux->consultar(Baux);
		cap=Baux->getCapacidadBar();
		if(cap<b->getCapacidadBar()){
			enc=true;
		}else{
			lBaresAux->avanzar();
		}
	}
	lBaresAux->insertar(b);
}


void Algoritmos::ficheroBaresBarrio(Cola<Bar*> *&CBares) {

	Bar *b = NULL;
	fstream f;
	f.open("BaresBarrio.txt", ios::app);

	while(!CBares->vacia()){
		CBares->primero(b);
		f<< b->getNombreBar()<< "   pax " <<b->getCapacidadBar()<<" "<<b->getSirveBar()<<" "<<b->getComidaBar()<<endl;

		CBares->desencolar();
	}

	f.close();

}


void Algoritmos::bajafichero( fstream &f, int i) {

	string nombre;
	while(i != 0){
		getline (f, nombre);
		aBares->remove(nombre);
		eliminarBarLista(nombre);

		i--;
	}
}


void Algoritmos::eliminarBarLista(string nombre) {
	lBares->moverInicio();
	bool enc = false;
	Bar *aux;

	while(!lBares->finLista() and !enc){

		lBares->consultar(aux);
		if(aux->getNombreBar() == nombre){
			enc = true;
			lBares->consultar(aux);
			lBares->borrar();
			delete aux;

		}else{
			lBares->avanzar();
		}
	}
}


void Algoritmos::modificarFichero(fstream &f, int i) {

	int c;
	string cad[10];

	while(i != 0){
		for(c = 0;c<9;c++){

			getline(f, cad[c],';');
		}
		getline (f, cad[9]);
		Bar *b = new Bar(cad[0], atoi(cad[1].c_str()), cad[2], cad[3], cad[4], atoi(cad[5].c_str()),atoi(cad[6].c_str()),atoi(cad[7].c_str()), cad[8],cad[9]);

		modificarBarAbb(aBares, b);
		modificarBarLista(b);

		i--;
	}

}


void Algoritmos::modificarBarAbb(BSTree<KeyValue<string, Bar*> > *abb, Bar *b) {

	Bar *aux;
	KeyValue<string, Bar*> pair = abb->root();
	aux = pair.value();
	if(!abb->empty()) {
		if(aux->getNombreBar() == b->getNombreBar()){
			pair.value()->modificarBar(b);

		}else{
			if(b->getNombreBar()<aux->getNombreBar()){
				if(abb->left() != NULL){
					modificarBarAbb(abb->left(), b);

				}else{
					if(abb->right() != NULL){
						modificarBarAbb(abb->right(), b);

					}
				}

			}

		}

	}

}


void Algoritmos::modificarBarLista(Bar *b) {
	lBares->moverInicio();
	bool enc = false;
	Bar *aux;

	while(!lBares->finLista() and !enc){

		lBares->consultar(aux);
		if(aux->getNombreBar() == b->getNombreBar()){
			enc = true;

		}else{
			lBares->avanzar();
		}
	}
	if(enc == true){

		lBares->consultar(aux);
		aux->modificarBar(b);
	}

}


void Algoritmos::altaFichero( fstream &f, int i) {

	int c;
	string cad[10];

	while(i != 0){
		for(c = 0;c<9;c++){

			getline(f, cad[c],';');
		}
		getline (f, cad[9]);

		Bar *b = new Bar(cad[0], atoi(cad[1].c_str()), cad[2], cad[3], cad[4], atoi(cad[5].c_str()),atoi(cad[6].c_str()),atoi(cad[7].c_str()), cad[8],cad[9]);
		lBares->insertar(b);
		insertarBar(b);
		i--;
	}
}

