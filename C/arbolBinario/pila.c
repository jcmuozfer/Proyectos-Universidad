#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include "pila.h"

int pilaCreaVacia(Pila *p)
{
    // Inicia o crea la pila p como una pila vacía, sin ningún elemento
    Pila p1 = &p;
    if (p == NULL)
        return -2;
    else if (NULL == (p1 = (tipoCelda *)malloc(sizeof(tipoCelda))))
        return -1;
    else
    {
        p1->sig = NULL;
        return 0;
    }
}

int pilaVacia(Pila *p)
{
    if (p == NULL)
        return 1;
    else
        return 0;
}

int pilaInserta(Pila *p, tipoElemento elemento)
{
    // Añade el elemento x en la posición a continuación del
    // tope o cima pasando a ser este el nuevo tope o cima de la pila
    Pila nuevaPosicion = &p;
    if (pilaVacia(p))
        return -1;
    if (NULL == (nuevaPosicion->sig = malloc(sizeof(tipoCelda))))
        return -2;
    // Hace que el último elemento sea el que se acaba de añadir
    nuevaPosicion = nuevaPosicion->sig;
    nuevaPosicion->elemento = elemento;
    return 0;
}

tipoElemento pilaSuprime(Pila *p)
{
    // Elimina el elemento del tope o cima de la pila.
    // Devuelve el valor almacenado en esa posición.
    // En este caso la operación tope(p) no se utiliza
    Pila nuevaPosicion = &p;
    tipoElemento valor = nuevaPosicion->elemento;
    if (pilaVacia(p))
        return -1;
    // Sólo se suprime p, ya que el anterior a p estará ahora apuntando a NULL en su sig
    free(nuevaPosicion);
    return 0;
}