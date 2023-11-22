#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "conjuntos.h"

/// Incluir aqui las funciones que implementan las tres operaciones básicas
/// en la representación de CONJUNTOS DISJUNTOS mediante LISTAS
/// ......................................................................
tipoCelda *creaNodo(tipoElemento x)
{
  tipoCelda *n;

  if (NULL == (n = malloc(sizeof(tipoCelda))))
    return NULL;

  n->elemento = x;
  n->sig = NULL;

  return n;
}

tipoCelda *localiza(tipoElemento x, tipoLista l)
{
  tipoCelda *p;

  p = l.primero;
  while (p != NULL && p->elemento != x)
    p = p->sig;

  return p;
}

void crea(particion P)
{
  int i;
  for (i = 0; i < MAXIMO; i++)
    P[i].primero = P[i].ultimo = creaNodo(i);
}

tipoConjunto buscar(tipoElemento x, particion P)
{
  int i;

  for (i = 0; i < MAXIMO; i++)
  {
    if (NULL != localiza(x, P[i]))
      return i;
  }
  return -1;
}

int unir(tipoConjunto x, tipoConjunto y, particion P)
{

  x = buscar(x, P);
  y = buscar(y, P);

  if (x < 0 || x >= MAXIMO || y < 0 || y >= MAXIMO)
    return -1;

  P[x].ultimo->sig = P[y].primero;
  P[x].ultimo = P[y].ultimo;
  P[y].primero = P[y].ultimo = NULL;

  return 1;
}

void verParticion(particion P)
{
  int i;
  tipoCelda *aux;
  for (i = 0; i < MAXIMO; i++)
  {
    aux = P[i].primero;
    if (aux != NULL)
      printf("\n\nClase equivalencia representante %d: ", i);
    while (aux != NULL)
    {
      printf("%d ", aux->elemento);
      aux = aux->sig;
    }
  }
}

void verClaseEquivalencia(tipoElemento x, particion P)
{
  int representante;
  tipoCelda *aux;

  representante = buscar(x, P);
  printf("\n\nClase de Equivalencia de %d cuyo representante es %d: ", x, representante);
  aux = P[representante].primero;
  while (aux)
  {
    printf(" %d ", aux->elemento);
    aux = aux->sig;
  }
  printf("\n\n");
}
