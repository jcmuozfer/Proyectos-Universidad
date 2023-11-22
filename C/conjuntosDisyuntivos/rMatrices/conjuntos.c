#include "conjuntos.h"
#include <stdio.h>
/// Incluir aqui las funciones que implementan las tres operaciones básicas
/// en la representación de CONJUNTOS DISJUNTOS mediante MATRICES
/// ......................................................................

void crea(particion P)
{

    for (int i = 0; i < MAXIMO; i++)
        P[i] = 0;
}

tipoConjunto buscar(tipoElemento x, particion P)
{

    if (P[x] == 0)
        return x;
    else
        return buscar(P[x], P);
}

int unir(tipoConjunto x, tipoConjunto y, particion P)
{
    x = buscar(x, P);
    y = buscar(y, P);

    if (x == y)
    {             // Los conjuntos ya están unidos
        return 0; // No se hace nada y se devuelve 0
    }
    else
    {
        P[y] = x; // La raíz del conjunto y se convierte en la raíz del conjunto x
        return 1; // Se realizó la unión y se devuelve 1
    }
}

void verParticion(particion P)
{
    int i;
    printf("\n");
    for (i = 0; i < MAXIMO; i++)
        printf("|%2d", P[i]);
    printf("| contenido  vector\n");
    for (i = 0; i < MAXIMO; i++)
        printf("---");
    printf("\n");
    for (i = 0; i < MAXIMO; i++)
        printf(" %2d", i);
    printf("  índices vector\n\n");
}
