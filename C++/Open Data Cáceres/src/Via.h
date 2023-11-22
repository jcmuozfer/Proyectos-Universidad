//============================================================================
// Name        : Via.h
// Author      : Juan Carlos Muñoz Fernández
// Version     : 2019/20
// Copyright   : Your copyright notice
// Description : Definición de la clase Via
//============================================================================



#ifndef VIA_H_
#define VIA_H_
#include <iostream>
#include <string>
#include "Bar.h"
#include "listapi.h"
using namespace std;


class Via {

	string tipoVia;
	string nombreVia;
	float longitudVia;
	int codigoVia;
	int codigoBVia;

public:




	/* PRE: Contructor parametrizado de la clase vía
	 * POST: Crea un objeto con la información introducidad por los parámetros
	 * PARAM:string tipo,string nombre,float longitud,int codigoV,int codigoB
	 * COMPLEJIDAD:O(1)
	 */
	Via(string tipo,string nombre,float longitud,int codigoV,int codigoB);


	/* PRE: Debe de estar creado un objeto de la clase vía
	 * POST: Imprime por pantalla la informacón del objeto.
	 * COMPLEJIDAD: O(1)
	 */
	void mostrarVia();


	/* PRE: Debe de estar creado un objeto de la clase vía
	 * POST: Devuleve el código deL Barrio al que pertenece la Vía
	 * COMPLEJIDAD: O(1)
	 */
	int getCodigoBVia() const;


	/* PRE: Debe de estar creado un objeto de la clase vía
	 * POST: Modifica la información del código del barrio al que pertenece la vía
	 * PARAM: int codigoBVia
	 * COMPLEJIDAD: O(1)
	 */
	void setCodigoBVia(int codigoBVia);


	/* PRE: Debe de estar creado un objeto de la clase vía
	 * POST: Devuleve el código de la Vía
	 * COMPLEJIDAD: O(1)
	 */
	int getCodigoVia() const;


	/* PRE: Debe de estar creado un objeto de la clase vía
	 * POST: Modifica la información del código de la vía
	 * PARAM: int codigoVia
	 * COMPLEJIDAD: O(1)
	 */
	void setCodigoVia(int codigoVia);


	/* PRE: Debe de estar creado un objeto de la clase vía
	 * POST: Devuleve la longuitud de la Vía
	 * COMPLEJIDAD: O(1)
	 */
	float getLongitudVia() const;


	/* PRE: Debe de estar creado un objeto de la clase vía
	 * POST: Modifica la información de la longuitud de la vía
	 * PARAM: float longitudVia
	 * COMPLEJIDAD: O(1)
	 */
	void setLongitudVia(float longitudVia);


	/* PRE: Debe de estar creado un objeto de la clase vía
	 * POST: Devuleve el nombre de la Vía
	 * COMPLEJIDAD: O(1)
	 */
	const string& getNombreVia() const;


	/* PRE: Debe de estar creado un objeto de la clase vía
	 * POST: Modifica la información del nombre de la vía
	 * PARAM: string &nombreVia
	 * COMPLEJIDAD: O(1)
	 */
	void setNombreVia(const string &nombreVia);


	/* PRE: Debe de estar creado un objeto de la clase vía
	 * POST: Devuleve el tipo de la Vía
	 * COMPLEJIDAD: O(1)
	 */
	const string& getTipoVia() const;


	/* PRE: Debe de estar creado un objeto de la clase vía
	 * POST: Modifica la información del tipo de la vía
	 * PARAM: string &tipoVia
	 * COMPLEJIDAD: O(1)
	 */
	void setTipoVia(const string &tipoVia);


	/* PRE: Debe de estar creado un objeto de la clase vía
	 * POST: Elimina el objeto creado
	 * COMPLEJIDAD: O(1)
	 */
	virtual ~Via();


};

#endif /* VIA_H_ */
