//============================================================================
// Name        : Bar.h
// Author      : Juan Carlos Muñoz Fernández
// Version     : 2019/20
// Copyright   : Your copyright notice
// Description : Definición de la clase Bar
//============================================================================

#ifndef BAR_H_
#define BAR_H_
#include <iostream>
#include <string>
using namespace std;




class Bar {

	string nombreBar;
	int capacidadBar;
	string sirveBar;
	string comidaBar;
	string telefonoBar;
	int codigoPBar;
	int codigoVBar;
	int portalBar;
	string aperturaBar;
	string cierreBar;

public:

	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Elimina el objeto creado
	 * COMPLEJIDAD: O(1)
	 */
	~Bar();

	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Imprime por pantalla la informacón del objeto.
	 * COMPLEJIDAD: O(1)
	 */
	void mostrar();



	/* PRE: Contructor parametrizado de la clase Bar
	 * POST: Crea un objeto con la información introducidad por los parámetros
	 * PARAM:string nombre,int capacidad,string sirve,string comida,string telefono,int codigoP,int codigoV,int portal,string apertura,string cierre
	 * COMPLEJIDAD:O(1)
	 */
	Bar(string nombre,int capacidad,string sirve,string comida,string telefono,int codigoP,int codigoV,int portal,string apertura,string cierre);


	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Devuleve la hora de apertura del Bar
	 * COMPLEJIDAD: O(1)
	 */
	const string& getAperturaBar() const;


	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Modifica la información sobre la apertura del Bar
	 * PARAM: int codigoBVia
	 * COMPLEJIDAD: O(1)
	 */
	void setAperturaBar(const string &aperturaBar);


	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Devuleve la capacidad Bar
	 * COMPLEJIDAD: O(1)
	 */
	int getCapacidadBar() const;


	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Modifica la información sobre la capacidad del Bar
	 * PARAM: int codigoBVia
	 * COMPLEJIDAD: O(1)
	 */
	void setCapacidadBar(int capacidadBar);


	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Devuleve la hora de cierra del Bar
	 * COMPLEJIDAD: O(1)
	 */
	const string& getCierreBar() const;


	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Modifica la información sobre la hora de cierre del Bar
	 * PARAM: int codigoBVia
	 * COMPLEJIDAD: O(1)
	 */
	void setCierreBar(const string &cierreBar);


	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Devuleve codigo postal del Bar
	 * COMPLEJIDAD: O(1)
	 */
	int getCodigoPbAar() const;


	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Modifica la información sobre el código postal del Bar
	 * PARAM: int codigoBVia
	 * COMPLEJIDAD: O(1)
	 */
	void setCodigoPbAar(int codigoPbAar);


	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Devuleve el codigo de la via donde se ubica el Bar
	 * COMPLEJIDAD: O(1)
	 */
	int getCodigoVBar() const;


	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Modifica la información del codigo de la via donde se ubica Bar
	 * PARAM: int codigoBVia
	 * COMPLEJIDAD: O(1)
	 */
	void setCodigoVBar(int codigoVBar);


	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Devuleve la comida que sirve el Bar
	 * COMPLEJIDAD: O(1)
	 */
	const string& getComidaBar() const;


	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Modifica la información de la comida que sirve el Bar
	 * PARAM: string &comidaBar
	 * COMPLEJIDAD: O(1)
	 */
	void setComidaBar(const string &comidaBar);


	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Devuleve la hora de apertura del Bar
	 * COMPLEJIDAD: O(1)
	 */
	const string& getNombreBar() const;


	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Modifica la información del nombre del Bar
	 * PARAM: string &nombreBar
	 * COMPLEJIDAD: O(1)
	 */
	void setNombreBar(const string &nombreBar);


	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Devuleve el portal del Bar
	 * COMPLEJIDAD: O(1)
	 */
	int getPortalBar() const;


	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Modifica la información del portal del Bar
	 * PARAM: int portalBar
	 * COMPLEJIDAD: O(1)
	 */
	void setPortalBar(int portalBar);


	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Devuleve si sirve o no comida el bar
	 * COMPLEJIDAD: O(1)
	 */
	const string& getSirveBar() const;


	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Modifica la información sobre si el bar sirve comida o no
	 * PARAM: string &sirveBar
	 * COMPLEJIDAD: O(1)
	 */
	void setSirveBar(const string &sirveBar);


	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Devuleve el teléfono del Bar
	 * COMPLEJIDAD: O(1)
	 */
	const string& getTelefonoBar() const;


	/* PRE: Debe de estar creado un objeto de la clase Bar
	 * POST: Modifica la información del teléfono del Bar
	 * PARAM: string &telefonoBar
	 * COMPLEJIDAD: O(1)
	 */
	void setTelefonoBar(const string &telefonoBar);

	void modificarBar(Bar *b);
};

#endif /* BAR_H_ */
