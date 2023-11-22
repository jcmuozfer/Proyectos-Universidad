//============================================================================
// Name        : Barrio.h
// Author      : Juan Carlos Muñoz Fernández
// Version     : 2019/20
// Copyright   : Your copyright notice
// Description : Definición de la clase Barrio
//============================================================================

#ifndef BARRIO_H_
#define BARRIO_H_
#include <iostream>
#include<string>
#include "Via.h"
#include "listapi.h"
using namespace std;

class Barrio {

	string nombreBarrio;
	float areaBarrio;
	float perimetroBarrio;
	int codigoBarrio;
	string distritoBarrio;
	ListaPI<Via*> *lV;

public:




	/* PRE: Contructor parametrizado de la clase Barrio
	 * POST: Crea un objeto con la información introducidad por los parámetros
	 * PARAM: string nombreBarrio,float areaBarrio,float perimetroBarrio,int codigoBarrio,string distritoBarrio
	 * COMPLEJIDAD:O(1)
	 */
	Barrio(string nombreBarrio,float areaBarrio,float perimetroBarrio,int codigoBarrio,string distritoBarrio);


	/* PRE: Debe de estar creado un objeto de la clase Barrio
	 * POST: Devuleve el área del Barrio
	 * COMPLEJIDAD: O(1)
	 */
	float getAreaBarrio() const;


	/* PRE: Debe de estar creado un objeto de la clase Barrio
	 * POST: Modifica la información del área del barrio
	 * PARAM: float areaBarrio
	 * COMPLEJIDAD: O(1)
	 */
	void setAreaBarrio(float areaBarrio);


	/* PRE: Debe de estar creado un objeto de la clase Barrio
	 * POST: Devuleve el código del Barrio
	 * COMPLEJIDAD: O(1)
	 */
	int getCodigoBarrio() const;


	/* PRE: Debe de estar creado un objeto de la clase Barrio
	 * POST: Modifica el código del barrio
	 * PARAM: int codigoBarrio
	 * COMPLEJIDAD: O(1)
	 */
	void setCodigoBarrio(int codigoBarrio);


	/* PRE: Debe de estar creado un objeto de la clase Barrio
	 * POST: Devuleve el Distrito del Barrio
	 * COMPLEJIDAD: O(1)
	 */
	const string& getDistritoBarrio() const;


	/* PRE: Debe de estar creado un objeto de la clase Barrio
	 * POST: Modifica el distrito del barrio
	 * PARAM: string &distritoBarrio
	 * COMPLEJIDAD: O(1)
	 */
	void setDistritoBarrio(const string &distritoBarrio);


	/* PRE: Debe de estar creado un objeto de la clase Barrio
	 * POST: Devuleve el nombre del Barrio
	 * COMPLEJIDAD: O(1)
	 */
	const string& getNombreBarrio() const;


	/* PRE: Debe de estar creado un objeto de la clase Barrio
	 * POST: Modifica el nombre del barrio
	 * PARAM: string &nombreBarrio
	 * COMPLEJIDAD: O(1)
	 */
	void setNombreBarrio(const string &nombreBarrio);


	/* PRE: Debe de estar creado un objeto de la clase Barrio
	 * POST: Devuleve el perímetro del Barrio
	 * COMPLEJIDAD: O(1)
	 */
	float getPerimetroBarrio() const;


	/* PRE: Debe de estar creado un objeto de la clase Barrio
	 * POST: Modifica el perímetro del barrio
	 * PARAM: float perimetroBarrio
	 * COMPLEJIDAD: O(1)
	 */
	void setPerimetroBarrio(float perimetroBarrio);


	/* PRE: Debe de estar creado un objeto de la clase Barrio
	 * POST: Imprime por pantalla la informacón del objeto.
	 * COMPLEJIDAD: O(1)
	 */
	void mostrarBarrio();


	/* PRE: Debe de estar creado un objeto de la clase Barrio
	 * POST: Reccore las vía que se encuentran en el barrio, mostrandolas por pantalla
	 * y devolviendo en i el número total de vías
	 * COMPLEJIDAD: O(n)
	 */
	void recorrerVia(int &i);


	/* PRE: Debe de estar creado un objeto de la clase Barrio
	 * POST: Busca la vía más larga de las vías que posee el vector ,
	 * devuelve en longuitud la longuitud máxima de la vía y en v la información de la vía
	 * COMPLEJIDAD: O(n)
	 */
	void buscarLarga(float &longitud,Via *&v);


	/* PRE: Lista clase vía creada, v debe de tener información útil
	 * POST: Crea un nuevo objeto de la clase vía introduciendo la información de v
	 * COMPLEJIDAD: O(1)
	 */
	void insertarVia(Via *&v);


	/* PRE: Lista clase vía creada
	 * POST: Devuelve la información deseada del objeto de la clase vía
	 * COMPLEJIDAD: O(1)
	 */
	void consultarVia(Via *&v);


	/* PRE:Lista clase vía creada
	 * POST: Puntero apunta al siguiente objeto
	 * COMPLEJIDAD: O(1)
	 */
	void avanzarVia();


	/* PRE: Lista clase vía creada
	 * POST: EL puntero de la lista de punto de interes se coloca al inicio de la lista
	 * COMPLEJIDAD: O(n)
	 */
	void MoverInicioVia();


	/* PRE: Lista clase vía creada
	 * POST: Devuelve true si la lista esta vacía y false en caso contrario
	 * COMPLEJIDAD: O(n)
	 */
	bool estaVaciaVia();


	/* PRE: Lista clase vía creada
	 * POST: Devuelve true si el puntero se encuentra en el final de la lista y false en caso contrario
	 * COMPLEJIDAD: O(n)
	 */
	bool finListaVia();


	/* PRE: Lista clase vía creada
	 * POST: Elimina el objeto de la clave vía
	 * COMPLEJIDAD: O(n)
	 */
	void borrarVia();


	void eliminarListaVia();

	void buscarVia(string nombre,string tipo, int &codigo);
	bool buscarNombreVia(string &nombre,string &tipo, int codigo);
	virtual ~Barrio();



};

#endif /* BARRIO_H_ */
