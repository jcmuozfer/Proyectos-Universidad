#include <stdlib.h>
#include <stdio.h>
#include "monticulo.h"

int main(void)
{
  Monticulo m;
  tipoElemento elemento;
  int i, n = 10;

  iniciaMonticulo(&m);
  elemento.informacion = 0;

  i = insertar(elemento, &m);

  while (m.tamanno < n)
  {
    elemento.clave = rand() % 100;
    printf("%d ", elemento.clave);
    i = insertar(elemento, &m);
  }
  printf("\n");

  recorrerMonticulo(m);
  decrementarClave(6, 10, &m);

  recorrerMonticulo(m);
}
