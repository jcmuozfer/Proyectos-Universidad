/*
 * grafos.c
 *
 *  Created on: 21/04/2014
 *      Author: MJ Polo
 */
#include <stdio.h>
#include <stdlib.h>
#include "cola.h"
#include "grafos.h"
/**********************************************
/ Inicia correctamente directorio de vertices *
***********************************************/
void iniciar(tipoGrafo *g)
{
  int i;
  g->orden = 0;
  for (i = 0; i < N; i++)
  {
    g->directorio[i].alcanzado = 0;
    g->directorio[i].gradoEntrada = 0;
    g->directorio[i].ordenTop = 0;
    g->directorio[i].distancia = INF;
    g->directorio[i].peso = INF;
    g->directorio[i].anterior = -1;
    g->directorio[i].lista = NULL;
  }
}
void profundidadMejorado(int v_inicio, tipoGrafo *g)
{
}
void amplitudMejorado(int v_inicio, tipoGrafo *g)
{
}
/* Ejercicio 2*/

int buscarVerticeGradoCeroNoOrdenTop(tipoGrafo *g)
{
  int i;
  for (i = 0; i < g->orden; i++)
  {
    if (g->directorio[i].gradoEntrada == 0 && g->directorio[i].ordenTop == 0)
    {
      return i; // se encontró un vértice de grado cero
    }
  }
  return -1; // no se encontró ningún vértice de grado cero
}

int ordenTop1(tipoGrafo *grafo)
{

  int orden;
  arco *p;

  int v, w;

  // iniciar(grafo);

  for (orden = 1; orden < grafo->orden; orden++)
  {

    v = buscarVerticeGradoCeroNoOrdenTop(grafo);
    if (v == -1)
      printf("Erro:grafo cíclio ");
    else
    {
      grafo->directorio[v].ordenTop = orden;

      p = grafo->directorio[v].lista;
      while (p != NULL)
      {
        w = p->v;
        grafo->directorio[w].gradoEntrada = grafo->directorio[w].gradoEntrada - 1;
        p = p->sig;
      }
    }
  }
}
int ordenTop2(tipoGrafo *grafo)
{

  int i, v, w;
  pArco ptr;

  // Paso 1: Calcular el grado de entrada de todos los vértices
  for (i = 0; i < grafo->orden; i++)
  {
    grafo->directorio[i].gradoEntrada = 0;
  }
  for (i = 0; i < grafo->orden; i++)
  {
    ptr = grafo->directorio[i].lista;
    while (ptr != NULL)
    {
      grafo->directorio[ptr->v].gradoEntrada++;
      ptr = ptr->sig;
    }
  }

  // Paso 2: Insertar todos los vértices con grado de entrada cero en la cola
  // (inicialmente vacía)
  int cola[N], frente = 0, final = 0;
  for (i = 0; i < grafo->orden; i++)
  {
    if (grafo->directorio[i].gradoEntrada == 0)
    {
      cola[final++] = i;
    }
  }

  // Paso 3: Mientras la cola no esté vacía
  while (frente != final)
  {
    // Paso 3.1: Se suprime un vértice de la cola: v
    v = cola[frente++];

    // Paso 3.2: Se decrementan los grados de todos los vértices adyacentes a v
    ptr = grafo->directorio[v].lista;
    while (ptr != NULL)
    {
      w = ptr->v;
      grafo->directorio[w].gradoEntrada--;
      // Paso 3.3: Si el grado de entrada de algún vértice se convierte en cero,
      // se inserta en la cola
      if (grafo->directorio[w].gradoEntrada == 0)
      {
        cola[final++] = w;
      }
      ptr = ptr->sig;
    }

    // Paso 3.4: La ordenación topológica coincide con el orden en que los vértices
    // van saliendo de la cola
    grafo->directorio[v].ordenTop = frente;
  }
}
/******************************************************************************/
/* Recorrido en PROFUNDIDAD de un grafo. ¡CUIDADO! Depende del vertice inicial y del tipo de grafo */
/*********************************************************************************/
void profundidad(int v_inicio, tipoGrafo *grafo)
{
  int w;
  pArco p;
  printf("%d ", v_inicio);
  grafo->directorio[v_inicio].alcanzado = 1;
  p = grafo->directorio[v_inicio].lista;
  while (p != NULL)
  {
    w = p->v;
    if (!grafo->directorio[w].alcanzado)
      profundidad(w, grafo);
    p = p->sig;
  }
}
/************************************************************************************************/
/* Recorrido en AMPLITUD de un grafo. ¡CUIDADO! Depende del vertice inicial y del tipo de grafo */
/************************************************************************************************/
void amplitud(int v_inicio, tipoGrafo *grafo)
{
  int w;
  pArco p;
  Cola c;

  colaCreaVacia(&c);
  colaInserta(&c, v_inicio);
  while (!colaVacia(&c))
  {
    w = colaSuprime(&c);
    if (!grafo->directorio[w].alcanzado)
    {
      printf("%d ", w);
      grafo->directorio[w].alcanzado = 1;
      p = grafo->directorio[w].lista;
      while (p != NULL)
      {
        w = p->v;
        colaInserta(&c, w);
        p = p->sig;
      }
    }
  }
}
/**********************************************************************************************/
/* Función auxiliar para ver el contenido de la estructura que representa un grafo en memoria */
/**********************************************************************************************/
void verGrafo(tipoGrafo *g)
{
  int i;
  pArco p;

  printf("\nGrafo  (Orden %d)\n\n", g->orden);
  printf("       alc gEnt oTop dist peso ant \n");
  printf("     +----+----+----+----+----+----+\n");

  for (i = 1; i <= g->orden; i++)
  {
    printf("  %2d | %2d | %2d | %2d |", i, g->directorio[i].alcanzado,
           g->directorio[i].gradoEntrada, g->directorio[i].ordenTop);
    if (g->directorio[i].distancia == INF)
      printf("  * |");
    else
      printf(" %2d |", g->directorio[i].distancia);
    if (g->directorio[i].peso == INF)
      printf("  * |");
    else
      printf(" %2d |", g->directorio[i].peso);
    printf(" %2d |", g->directorio[i].anterior);
    p = g->directorio[i].lista;
    while (p != NULL)
    {
      printf(" ->%2d", p->v); // Grafos no ponderados
      // printf(" ->%2d, %2d", p->v, p->peso); // Grafos ponderados
      p = p->sig;
    }
    printf("\n");
  }
  printf("     +----+----+----+----+----+----+\n\n");
}
