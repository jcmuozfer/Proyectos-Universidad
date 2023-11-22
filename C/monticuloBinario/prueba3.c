#include <stdlib.h>
#include <stdio.h>
#include "monticulo.h"
int main(void)
{
    Monticulo m;
    tipoElemento elemento;

    iniciaMonticulo(&m);
    elemento.informacion = 0;
    elemento.clave = 5;
    insertar(elemento, &m);
    elemento.clave = 8;
    insertar(elemento, &m);
    elemento.clave = 18;
    insertar(elemento, &m);
    elemento.clave = 9;
    insertar(elemento, &m);
    elemento.clave = 13;
    insertar(elemento, &m);
    elemento.clave = 21;
    insertar(elemento, &m);
    elemento.clave = 33;
    insertar(elemento, &m);
    elemento.clave = 12;
    insertar(elemento, &m);
    elemento.clave = 31;
    insertar(elemento, &m);
    elemento.clave = 18;
    insertar(elemento, &m);
    elemento.clave = 37;
    insertar(elemento, &m);
    elemento.clave = 35;
    insertar(elemento, &m);
    elemento.clave = 41;
    insertar(elemento, &m);
    elemento.clave = 39;
    insertar(elemento, &m);
    elemento.clave = 43;
    insertar(elemento, &m);
    elemento.clave = 45;
    insertar(elemento, &m);
    elemento.clave = 39;
    insertar(elemento, &m);
    elemento.clave = 44;
    insertar(elemento, &m);
    elemento.clave = 35;
    insertar(elemento, &m);
    elemento.clave = 31;
    insertar(elemento, &m);
    elemento.clave = 47;
    insertar(elemento, &m);
    elemento.clave = 44;
    insertar(elemento, &m);
    elemento.clave = 47;
    insertar(elemento, &m);
    elemento.clave = 50;
    insertar(elemento, &m);
    elemento.clave = 38;
    insertar(elemento, &m);

    recorrerMonticulo(m);

    printf("\n");
    eliminarMinimo(&m);
    recorrerMonticulo(m);

    printf("\n");
    /*
    decrementarClave(6,10,&m);

    recorrerMonticulo(m);*/
}
