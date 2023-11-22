#include <stdlib.h>
#include <stdio.h>
#include "monticulo.h"

void iniciaMonticulo(Monticulo *m)
{
    m->tamanno = 0;
}
int vacioMonticulo(Monticulo *m)
{
    if (m->tamanno == 0)
        return 1;
    else
        return 0;
}
int insertar(tipoElemento x, Monticulo *m)
{
    m->elemento[0].clave = 0;

    if (m->tamanno >= MAXIMO)
    {
        printf("ERROR: No se puede insertar debido a que se supera el tamaño del montículo\n");
        return 0;
    }
    else
    {
        int hueco = m->tamanno;
        while (hueco > 1 && m->elemento[hueco / 2].clave > x.clave)
        {
            m->elemento[hueco] = m->elemento[hueco / 2];
            hueco = hueco / 2;
        }

        m->elemento[hueco] = x;
        m->tamanno = m->tamanno + 1;
    }
    return 1;
}

int eliminarMinimo(Monticulo *m)
{
    int i = 0, hijo;
    tipoElemento minimo;
    if (vacioMonticulo(m))
    {

        printf("ERROR: No se puede eliminar debido a que el montúculo esta vacio");
        return -1;
    }
    else
    {

        minimo = m->elemento[1];
        tipoElemento ultimo = m->elemento[m->tamanno];

        int hueco = 1;
        int finFiltrado = 0;

        while (2 * hueco <= m->tamanno && !finFiltrado)
        {
            hijo = 2 * hueco;

            if (hijo != m->tamanno)
            {

                if (m->elemento[hijo + 1].clave < m->elemento[hijo].clave)

                    hijo = hijo + 1;
            }

            if (m->elemento[hijo].clave < ultimo.clave)
            {
                m->elemento[hueco] = m->elemento[hijo];
                hueco = hijo;
            }
            else
                finFiltrado = 1;
        }

        m->elemento[hueco] = ultimo;
        m->tamanno--;
        return minimo.clave;
    }
}

int esMonticulo(Monticulo m)
{

    int i = 1;
    while (i < m.tamanno)
    {
        if (m.elemento[i].clave < m.elemento[2 * i].clave || m.elemento[i].clave < m.elemento[2 * i + 1].clave)
        {
            return 0;
        }

        i++;
    }

    return 1;
}

void recorrerMonticulo(Monticulo m)
{
    printf("El tamaño del móntóculo: %d\n", m.tamanno - 1);

    for (int i = 0; i < m.tamanno; i++)
    {

        printf("%i", m.elemento[i].clave);
        printf(" ");
    }
    printf("\n");
}

void decrementarClave(int pos, tipoClave cantidad, Monticulo *m)
{

    int valorAux = m->elemento[pos].clave;
    valorAux = valorAux - cantidad;

    if (valorAux < 0)
    {
        printf("ERROR: No se puede decrementar, debido a que obtendría valor negativo");
    }
    else
    {

        tipoElemento monticuloAux = m->elemento[pos];
        monticuloAux.clave = valorAux;
        int finBucle = 1;
        while (pos / 2 <= m->tamanno && finBucle)
        {

            if (monticuloAux.clave < m->elemento[pos / 2].clave)
            {
                printf("Valor nuevo: %d\n", monticuloAux.clave);

                m->elemento[pos] = m->elemento[pos / 2];
                m->elemento[pos / 2] = monticuloAux;
            }
            else
                finBucle = 0;
        }
    }
}

void incrementarClave(int pos, tipoClave cantidad, Monticulo *m)
{

    int posAux = pos;
    int finFiltrado = 0;
    m->elemento[pos].clave = m->elemento[pos].clave + cantidad;
    while (2 * posAux <= m->tamanno && !finFiltrado)
    {
        int hijo = 2 * posAux;

        if (m->elemento[hijo + 1].clave < m->elemento[hijo].clave)
        {
            hijo = hijo + 1;
        }
        if (m->elemento[hijo].clave < m->elemento[posAux].clave)
        {

            m->elemento[posAux] = m->elemento[hijo];
            posAux = hijo;
        }
        else
        {
            finFiltrado = 1;
        }
    }
}