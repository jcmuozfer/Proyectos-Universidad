#include <stdlib.h>
#include <stdio.h>
#include "arbol.h"
#include "cola.h"

//
// Reserva de memoria para un nuevo nodo de árbol binario
//
Arbol creaNodo(tipoInfo info)
{
  tipoNodo *nuevo;

  if ((nuevo = (tipoNodo *)malloc(sizeof(tipoNodo))) == NULL)
    return NULL;
  else
  {
    nuevo->info = info;
    nuevo->izq = NULL;
    nuevo->der = NULL;
    return nuevo;
  }
}

//
// Recorrido en amplitud o por niveles: necesita una cola de punteros a nodos de árbol binario!!!
//

void amplitud(Arbol raiz)
{
  cola_t *c = cola_crear();
  tipoNodo *nodo;
  nodo = raiz;
  if (raiz != NULL)
    cola_encolar(c, nodo);
  while (!cola_esta_vacia(c))
  {
    nodo = (Arbol)cola_desencolar(c);
    printf(" %c ", nodo->info);
    if (nodo->izq != NULL)
      cola_encolar(c, nodo->izq);
    if (nodo->der != NULL)
      cola_encolar(c, nodo->der);
  }
}
//
// Recorridos en profundidad "recursivos"
//
void preOrden(Arbol raiz)
{
  if (raiz != NULL)
  {
    printf("%c ", raiz->info);
    preOrden(raiz->izq);
    preOrden(raiz->der);
  }
}
void enOrden(Arbol raiz)
{
  if (raiz != NULL)
  {
    enOrden(raiz->izq);
    printf("%c ", raiz->info);
    enOrden(raiz->der);
  }
}
void postOrden(Arbol raiz)
{
  if (raiz != NULL)
  {
    postOrden(raiz->izq);
    postOrden(raiz->der);
    printf("%c ", raiz->info);
  }
}

int altura(Arbol raiz)
{
  if (raiz == NULL)
  {
    return 0;
  }
  else
  {
    int alturaIzq = altura(raiz->izq);
    int alturaDer = altura(raiz->der);
    if (alturaIzq > alturaDer)
    {
      return alturaIzq + 1;
    }
    else
    {
      return alturaDer + 1;
    }
  }
}
int numNodos(Arbol raiz)
{
  if (raiz == NULL)
  {
    return 0;
  }
  else
  {
    return 1 + numNodos(raiz->izq) + numNodos(raiz->der);
  }
}

int sustituye(Arbol raiz, tipoInfo x, tipoInfo y)
{
  int contador = 0;
  if (raiz != NULL)
  {
    if (raiz->info == x)
    {
      raiz->info = y;
      contador++;
    }
    contador += sustituye(raiz->izq, x, y);
    contador += sustituye(raiz->der, x, y);
  }
  return contador;
}
int numNodosHoja(Arbol raiz)
{
  if (raiz == NULL)
  {
    return 0;
  }
  else if (raiz->izq == NULL && raiz->der == NULL)
  {
    return 1;
  }
  else
  {
    return numNodosHoja(raiz->izq) + numNodosHoja(raiz->der);
  }
}

int numNodosInternos(Arbol raiz)
{
  if (raiz == NULL || (raiz->izq == NULL && raiz->der == NULL))
  {
    return 0;
  }
  else
  {
    return 1 + numNodosInternos(raiz->izq) + numNodosInternos(raiz->der);
  }
}
int numHijoUnico(Arbol raiz)
{
  if (raiz == NULL || (raiz->izq == NULL && raiz->der == NULL))
  {
    return 0;
  }
  else if (raiz->izq == NULL)
  {
    return 1 + numHijoUnico(raiz->der);
  }
  else if (raiz->der == NULL)
  {
    return 1 + numHijoUnico(raiz->izq);
  }
  else
  {
    return numHijoUnico(raiz->izq) + numHijoUnico(raiz->der);
  }
}

Arbol buscarMax(Arbol raiz)
{
  if (raiz == NULL)
  {
    return NULL;
  }
  else if (raiz->der == NULL)
  {
    return raiz;
  }
  else
  {
    return buscarMax(raiz->der);
  }
}
Arbol buscarMin(Arbol raiz)
{
  if (raiz == NULL)
  {
    return NULL;
  }
  else if (raiz->izq == NULL)
  {
    return raiz;
  }
  else
  {
    return buscarMin(raiz->izq);
  }
}
int similares(Arbol r1, Arbol r2)
{
  if (r1 == NULL && r2 == NULL)
  {
    return 1;
  }
  else if (r1 != NULL && r2 != NULL)
  {
    return similares(r1->izq, r2->izq) && similares(r1->der, r2->der);
  }
  else
  {
    return 0;
  }
}
int equivalentes(Arbol r1, Arbol r2)
{
  if (r1 == NULL && r2 == NULL)
  {
    return 1;
  }
  else if (r1 != NULL && r2 != NULL)
  {
    return (r1->info == r2->info) && equivalentes(r1->izq, r2->izq) && equivalentes(r1->der, r2->der);
  }
  else
  {
    return 0;
  }
}
Arbol especular(Arbol raiz)
{
  if (raiz == NULL)
  {
    return NULL;
  }
  else
  {
    Arbol temp = especular(raiz->izq);
    raiz->izq = especular(raiz->der);
    raiz->der = temp;
    return raiz;
  }
}

int evaluar(Arbol a)
{

  if (a->info == NULL)
  {
    return 0;
  }
  if (a->izq != NULL && a->der != NULL)
  {
    return a->info - '0';
  }

  int izquierdo = evaluar(a->izq);
  int derecho = evaluar(a->der);
  switch (a->info)
  {
  case '+':
    return izquierdo + derecho;
  case '-':
    return izquierdo - derecho;
  case '*':
    return izquierdo * derecho;

  default:

    return 0;
  }
}
