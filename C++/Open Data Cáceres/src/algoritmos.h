//============================================================================
// Name        : algoritmos.h
// Author      : Profesores de la asignatura EDI
// Version     : 2019/20
// Copyright   : Your copyright notice
// Description : clase para realizar algoritmos del proyecto
//============================================================================


#ifndef ALGORITMOS_H_
#define ALGORITMOS_H_
#include <fstream>
#include <iostream>
#include <string.h>
#include "listapi.h"
#include "bstree.h"
#include "Barrio.h"
#include "cola.h"
#include "pila.h"





using namespace std;


struct contador{
	int cont;
	string distrito;
};
typedef contador vector[8];

class Algoritmos {





	/* PRE: lBarrios y lVias deben de estar cargados
	 * POST: Dado el codigoVia, busca la vía al que pertenece ese código ademas del barrio al que pertenece,
	 *       Devuelve nombreVia, tipo y barrio
	 * COMPLEJIDAD: O(n)
	 */
	void buscarVia(int codigoVia,string &nombreVia,string &tipo,string &barrio);


	/* PRE: lBarrios y lVias deben de estar cargados
	 * POST: Devuelve el Barrio con más bares contenido en nombre y el numero de bares en cont
	 * COMPLEJIDAD: O(n³)
	 */
	void masBaresBarrio (Cola <Bar *>	*&CBares, string &nombre,int &cont);


	/* PRE: lBares deben de estar cargados
	 * POST: Crea una cola con los bares de una via(CBares) y devuelve el número de Bares que hay en cont.
	 * COMPLEJIDAD: O(n²)
	 */
	void contarBaresVia(BSTree<KeyValue<string, Bar*> > *abb,Via *&v,Cola <Bar *>	*&CBares,int &cont);


	/* PRE: CBares debe contener información útil
	 * POST: Crea un fichero con la información de la Cola de Bares
	 * COMPLEJIDAD: O(n)
	 */
	void ficheroBaresBarrio(Cola <Bar *> *&CBares);


	/* PRE: abb debe de contener un arbol con bares
	 * POST: Dado de el código de la Vía (codigo), escribe en un fichero, además de mostrar por pantalla
	 *		 los bares que hay en la vía y el número total de bares(acu)
	 * COMPLEJIDAD: O(n)
	 */
	void ficheroBarVP(BSTree<KeyValue<string, Bar*>> *abb,fstream &f,int codigo,int &acu);


	/* PRE: b debe contener el bar a insertar
	 * POST: Inserta los bares ordenados en lBaresAux, según su capacidad. De mayor a menor capacidad
	 * COMPLEJIDAD: O(n)
	 */
	void insertarCapacidad(ListaPI<Bar*> *&lBaresAux,Bar *b);


	/*
	 * PRE: TipoVia debe tener la información sobre el tipo de la vía y nombreVia la información del Nombre
	 *		 de la vía
	 * POST:Dado nombreVia y tipoVia devuelve el código de la vía en caso de existir dicha via
	 * COMP:O(n²)
	 */
	int buscarCodigoVia(string nombreVia,string tipoVia );


	/*
	 * PRE:	abb debe contener un arbol con los bares de aBares
	 * POST: Dado el nombre del Bar (nombre), devuelve el un puntero del bar con su información ,la vía a
	 *       la que pertence además del barrio donde se ubica.
	 * COMP:O(log_2 n)
	 */
	bool viaDeBar(BSTree<KeyValue<string, Bar*>> *abb,string nombre,Bar *&b, string &nombreVia,string &tipo,
			string &barrio);


	/*
	 * PRE:abb debe de estar inicializado con información util
	 * POST: Realiza un recorrido de abb inOrden y almacena los bares que comienzan con la subcadena(cadena) en lbaresAux,
	 *       ordenados de mayor a menor capacidad. Además devuelve si se ha encontrado un nombre con la subcadena(enc).
	 * COMP:O(n²)
	 */
	void listaBarSub(BSTree<KeyValue<string, Bar*> > *abb,ListaPI <Bar *> *&lBaresAux,string cadena,bool &enc);



	/*
	 * PRE:abb debe de estar inicializado con información util
	 * POST: Devuelve una lista de bares(lBaresAux), que sirve una determinada comida(coomida) y con una
	 * 		 capacidad superior a la dada(capacidad).
	 * COMP:O(log n)
	 */
	void listaComidaaBar(BSTree<KeyValue<string, Bar*>> *abb,ListaPI <Bar *> *&lBaresAux, string comida,
			int capacidad);


	/*
	 * PRE:f debe tener información de bares a dar de baja
	 * POST: Da de baja 'i' bares en lbares y aBares, lo cuales se indican en f
	 * COMP:O(n²)
	 */
	void bajafichero( fstream &f, int i);


	/*
	 * PRE:f debe tener información de bares a dar de baja
	 * POST: Modifica'i' bares en lbares y aBares, lo cuales se indican en f además
	 * 		de contener la información para modificar
	 * COMP:O(n³)
	 */
	void modificarFichero(fstream &f, int i);


	/*
	 * PRE:f debe tener información de bares a dar de baja
	 * POST: Da de alta 'i' bares en lbares y aBares, lo cuales se indican en f además
	 * 		de contener la información nueva
	 * COMP:O(n²)
	 */
	void altaFichero(fstream &f, int i);


	/*
	 * PRE:aBares inicializado con valor útil
	 * POST: Elimina de aBares el nombre indicado(nombre)
	 * COMP:O(n)
	 */
	void eliminarBarLista(string nombre) ;


	/*
	 * PRE:abb debe de estar inicializado con información útil
	 * POST: Modifica el bar indicado por b->getnombreBar(), con la información que contine b en abb.
	 * COMP:O(log_2 n)
	 */
	void modificarBarAbb(BSTree<KeyValue<string, Bar*>> *abb, Bar *b);


	/*
	 * PRE:lBares debe de estar inicializado con información útil
	 * POST:Modifica el bar indicado por b->getnombreBar(), con la información que contine b en lBares
	 * COMP:O(n)
	 */
	void modificarBarLista(Bar *b);




public:
	ListaPI <Barrio*> *lBarrios;
	ListaPI <Bar *>	*lBares ;
	BSTree<KeyValue<string, Bar*> > *aBares;


	/* PRE: Debe de existir el fichero "Barrio.csv"
	 * POST: Almacena la información del fichero en un objetos de la clase Barrio en una lista de punto de
	 * interés
	 * COMPLEJIDAD: O(n²)
	 */
	void cargarBarrios(Barrio *&b);


	/* PRE: Debe de existir el fichero "Via.csv"
	 * POST: Almacena la información del fichero en un objetos de la clase via en una lista de punto de interés
	 *      dentro de su barrio correspondiente
	 * COMPLEJIDAD: O(n)
	 */
	void cargarVias(Barrio *&b);


	/* PRE: Debe de existir el fichero "Bar.csv"
	 * POST: Almacena la información del fichero en un objetos de la clase Bar en una lista de punto de interés.
	 * COMPLEJIDAD: O(n)
	 */
	void cargarBares();


	/*
	 * PRE: b debe conterner información útil
	 * POST: Inserta un nuevo Bar en el arbol binario aBares ordenado por nombre
	 * COMP:O(1)
	 */
	void insertarBar(Bar *b) ;


	/*
	 * PRE: Se Deben cumplir las precondiciones de los módulos de cargarBarrios y cargaBares
	 * POST: Carga la información en estructura de datos
	 * COMPLEJIDAD: O(n)
	 */
	void cargarDatos();


	/* PRE: Los datos debe de estar cargados
	 * POST:  Realiza el algoritmo indicado por el usuario
	 * COMPLEJIDAD: O(n)
	 */
	void run ();

	/*
	 * PRE: Reserva memoria para las listas
	 * POST: Carga los datos y ejecuta el programa
	 * COMP: O(1)
	 */
	Algoritmos();


	/*
	 * PRE: Debe de estar cargado los datos y debe existir nombreBarrio
	 * POST: Muestra las vía indicado que se encuentren en la lista del Barrio que correspondan con el
	 * 		 nombre indicado (nombreBarrio), además el número de vías que hay(i)
	 * COMP: O(n)
	 */
	void mostrarVias(string nombreBarrio,  int &i);


	/*
	 * PRE: Debe de estar cargado los datos
	 * POST: Devuelve la vía con mayor longuitud en mV
	 * COMP: O(n)
	 */
	void viaMayorLongitud(Via *&mV);


	/*
	 * PRE: Debe de estar cargado los datos y debe existir tipoC
	 * POST: Devuelve una cola de bares(CBares) que sirva el tipo de comida que se corresponda con tipoC,
	 * 		además los muestra por pantalla y el numero de bares que se han encontrado (i)
	 * COMP: O(n)
	 */
	void tipoComida( string tipoC, Cola <Bar *>	*&CBares, int &i);


	/*
	 * PRE: Debe de estar cargado los datos
	 * POST: Devuelve el distrito con mayor número de Barrio en nombre y el número total de Barrios que
	 * 		lo compone en i
	 * COMP: O(n²)
	 */
	void distritoM (vector &v, string &nombre,int &m);


	/*
	 * DESCRIPCIÓN:Metodo publico que realiza una llamada a su metodo privado. Genera un archivo de tipo texto con los nombres de los bares en orden alfabético inverso.
	 * COMP:O(n)
	 */
	void ficheroInverso();


	/*
	 * DESCRIPCIÓN:Metodo publico que realiza una llamada a su metodo privado. Genera un fichero de texto con todos los bares de una determinada vía dado
	 * 				su nombre completo
	 * COMP:O(1)
	 */
	void ficheroBarV();


	/*
	 * DESCRIPCIÓN:Metodo publico que realiza una llamada a su metodo privado. Dado el nombre de un bar, devolve sus datos completos y el nombre de la vía en la que se
	 * 				encuentra.
	 * COMP:O(1)
	 */
	void viaDeBar();


	/*
	 * DESCRIPCIÓN:Metodo publico que realiza una llamada a su metodo privado. Devuelve una lista ordenada por capacidad de todos los bares cuyo nombre comience por una
	 * 				determinada subcadena
	 * COMP:O(1)
	 */
	void listaBarSub(ListaPI<Bar*> *&lBaresAux);


	/*
	 * DESCRIPCIÓN:Metodo publico que realiza una llamada a su metodo privado. Procesar un fichero con distintas operaciones sobre bares, las cuales modifican lBares y aBares
	 * COMP:O(n)
	 */
	void actualizarFichero();


	/*
	 * DESCRIPCIÓN:Metodo publico que realiza una llamada a su metodo privado. Devuelve una lista con los bares que sirvan un determinado tipo de comida y cuya capacidad sea
	 *  			superior a una capacidad dada.
	 * COMP:O(1)
	 */
	void listaComidaaBar(ListaPI <Bar *> *&lBaresAux);


	/*
	 * DESCRIPCIÓN:Metodo publico que realiza una llamada a su metodo privado. Devuelve el barrio que más bares tiene, y escribe sus bares en un fichero de texto
	 * COMP:O(1)
	 */
	void masBares (string &nombre,int &m);


	/*
	 * DESCRIPCIÓN: Realiza las pruebas de la 1ª Parte del Proyecto, para comprobar su correcto funcionamiento
	 * COMP:O(1)
	 */
	void pruebasPrimeraParte();


	/*
	 * DESCRIPCIÓN: Realiza las pruebas de la 2ª Parte del Proyecto, para comprobar su correcto funcionamiento
	 * COMP:O(1)
	 */
	void pruebasSegundaParte();

	/*
	 * DESCRIPCIÓN: Destructor de la clase algoritmos.
	 * COMP:O(1)
	 */
	~Algoritmos();

};

#endif /* ALGORITMOS_H_ */
