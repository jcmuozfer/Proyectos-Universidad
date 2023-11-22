#include "conjuntos.h"
#include <stdio.h>

// void crea(particion P)
// {
// #ifdef TAMANNO
// #undef ALTURA
// #undef ARBITRARIO
// #endif
// #ifdef ALTURA
// #undef TAMANNO
// #undef ARBITRARIO
// #endif
// #ifdef ARBITRARIO
// #undef TAMANNO
// #undef ALTURA
// #endif

//     int i;

// #ifdef TAMANNO
//     for (i = 0; i < MAXIMO; i++)
//         C[i] = -1;
// #endif
// #ifdef ALTURA
//     for (i = 0; i < MAXIMO; i++)
//         C[i] = -1;
// #endif
// #ifdef ARBITRARIO
//     for (i = 0; i < MAXIMO; i++)
//         C[i] = i;
// #endif
// }

void crea(particion P)
{

    for (int i = 0; i < MAXIMO; i++)
    {
        P[i] = i;
    }
}

tipoConjunto buscar(tipoElemento x, particion P)
{

    if (P[x] == x)
        return x;
    else
    {
        P[x] = buscar(P[x], P);
        return P[x];
    }
}

int unir(tipoConjunto x, tipoConjunto y, particion P)
{

    x = buscar(x, P);
    y = buscar(y, P);

    if (x == y)
    {
        return 0;
    }
    else
    {
        P[y] = x;
        return 1;
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
