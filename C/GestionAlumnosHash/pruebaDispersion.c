/**
 * NOMBRE: Juan Carlos Muñoz Fernández
 * GRUPO: PB2
 */

#include "dispersion.h"
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <stdlib.h>

int main()
{

      char ficheroHash[100];
      char ficheroEntrada[100];
      strcpy(ficheroHash, "alumnos.hash");
      strcpy(ficheroEntrada, "alumnos.dat");

      int i, numRegDes;
      FILE *f;
      int nCubo, nCuboDes, posReg, error, resultado = 0;
      tipoAlumno *reg;
      char dni[10], provincia[11];
      regConfig *regC = malloc(sizeof(regConfig));

      regC->nCubos = 10;      // N�mero de cubos en el area prima
      regC->nCubosDes = 4;    // N�mero de cubos area de desborde
      regC->nCuboDesAct = 0;  // N�mero del primer cubo desborde con espacio para m�s registros
      regC->densidadMin = 40; // M�xima densidad de ocupaci�n permitida
      regC->densidadMax = 75; // M�nima densidad de ocupaci�n permitida
      regC->numReg = 0;       // N�mero total de registros en el archivo
      regC->numRegDes = 0;    // N�mero de registros desbordados

      int res = creaHash(ficheroEntrada, ficheroHash, regC);

      switch (res)
      {
      case 0:
            printf("Proceso ha finalizado correctamente. Además, la densidad de ocupación se encuentra dentro de los límites. \n");
            break;
      case -1:
            printf("Se ha producido un error con el fichero de entrada. \n");
            break;
      case -2:
            printf("Se ha producido un error con el fichero de salida. \n");
            break;
      case -3:
            printf("Se supera la densidad máxima. \n");
            break;
      case -4:
            printf("Se reduce la densidad mínima. \n");
            break;
      case -5:
            printf("Ha finalizado con algún error durante el proceso. \n");
            break;
      }
      i = leeHash(ficheroHash);

      // B�squeda de registros
      f = fopen(ficheroHash, "rb");

      strcpy(dni, "7389298"); // Existe en el are PRIMA
      reg = (busquedaHash(f, dni, &nCubo, &nCuboDes, &posReg, &error));

      if (error < 0)
            printf("No existe alumno con dni %s\n", dni);
      else
      {
            if (nCuboDes != -1) // Esta desbordado
            {
                  printf("Registro encontrado en el CUBO DESBORADO %d en la posicion: %d, debería estar en el cubo: %d", nCuboDes, posReg, nCubo);
                  printf("\t %s %s %s %s %s\n", reg->dni, reg->nombre, reg->ape1, reg->ape2, reg->provincia);
            }
            else
            {
                  printf("Registro encontrado en el CUBO %d, posicion %d", nCubo, posReg);
                  printf("\t %s %s %s %s %s\n", reg->dni, reg->nombre, reg->ape1, reg->ape2, reg->provincia);
            }
      }
      strcpy(dni, "7219752"); // Existe en el area De
      reg = (busquedaHash(f, dni, &nCubo, &nCuboDes, &posReg, &error));

      if (error < 0)
            printf("No existe alumno con dni %s\n", dni);
      else
      {
            if (nCuboDes != -1) // Esta desbordado
            {
                  printf("Registro encontrado en el CUBO DESBORADO %d en la posicion: %d, debería estar en el cubo: %d", nCuboDes, posReg, nCubo);
                  printf("\t %s %s %s %s %s\n", reg->dni, reg->nombre, reg->ape1, reg->ape2, reg->provincia);
            }
            else
            {
                  printf("Registro encontrado en el CUBO %d, posicion %d", nCubo, posReg);
                  printf("\t %s %s %s %s %s\n", reg->dni, reg->nombre, reg->ape1, reg->ape2, reg->provincia);
            }
      }
      strcpy(dni, "33333333"); // Existe en el area De DESBORDE
      reg = (busquedaHash(f, dni, &nCubo, &nCuboDes, &posReg, &error));

      if (error < 0)
            printf("No existe alumno con dni %s\n", dni);
      else
      {
            if (nCuboDes != -1) // Esta desbordado
            {
                  printf("Registro encontrado en el CUBO DESBORADO %d en la posicion: %d, debería estar en el cubo: %d", nCuboDes, posReg, nCubo);
                  printf("\t %s %s %s %s %s\n", reg->dni, reg->nombre, reg->ape1, reg->ape2, reg->provincia);
            }
            else
            {
                  printf("Registro encontrado en el CUBO %d, posicion %d", nCubo, posReg);
                  printf("\t %s %s %s %s %s\n", reg->dni, reg->nombre, reg->ape1, reg->ape2, reg->provincia);
            }
      }
      strcpy(dni, "11543192"); // Existe en el area De DESBORDE
      reg = (busquedaHash(f, dni, &nCubo, &nCuboDes, &posReg, &error));

      if (error < 0)
            printf("No existe alumno con dni %s\n", dni);
      else
      {
            if (nCuboDes != -1) // Esta desbordado
            {
                  printf("Registro encontrado en el CUBO DESBORADO %d en la posicion: %d, debería estar en el cubo: %d", nCuboDes, posReg, nCubo);
                  printf("\t %s %s %s %s %s\n", reg->dni, reg->nombre, reg->ape1, reg->ape2, reg->provincia);
            }
            else
            {
                  printf("Registro encontrado en el CUBO %d, posicion %d", nCubo, posReg);
                  printf("\t %s %s %s %s %s\n", reg->dni, reg->nombre, reg->ape1, reg->ape2, reg->provincia);
            }
      }

      strcpy(dni, "123456789"); // No existe
      reg = (busquedaHash(f, dni, &nCubo, &nCuboDes, &posReg, &error));

      if (error < 0)
            printf("No existe alumno con dni %s\n", dni);
      else
      {
            if (nCuboDes != -1) // Esta desbordado
            {
                  printf("Registro encontrado en el CUBO DESBORADO %d en la posicion: %d, debería estar en el cubo: %d", nCuboDes, posReg, nCubo);
                  printf("\t %s %s %s %s %s\n", reg->dni, reg->nombre, reg->ape1, reg->ape2, reg->provincia);
            }
            else
            {
                  printf("Registro encontrado en el CUBO %d, posicion %d", nCubo, posReg);
                  printf("\t %s %s %s %s %s\n", reg->dni, reg->nombre, reg->ape1, reg->ape2, reg->provincia);
            }
      }

      fclose(f);

      // Prueba de modificarReg
      strcpy(provincia, "CÁCERES");
      strcpy(dni, "7453920");
      resultado = modificarReg(ficheroHash, dni, provincia);

      if (resultado < 0)
            printf("No existe alumno con dni %s\n", dni);
      else
      {
            printf("Se ha modificado el alumno con DNI: %s, a provincia: %s \n", dni, provincia);
      }
      strcpy(dni, "71493016");
      resultado = modificarReg(ficheroHash, dni, provincia);

      if (resultado < 0)
            printf("No existe alumno con dni %s\n", dni);
      else
      {
            printf("Se ha modificado el alumno con DNI: %s, a provincia: %s \n", dni, provincia);
      }
      strcpy(dni, "13929272");
      resultado = modificarReg(ficheroHash, dni, provincia);

      if (resultado < 0)
            printf("No existe alumno con dni %s\n", dni);
      else
      {
            printf("Se ha modificado el alumno con DNI: %s, a provincia: %s \n", dni, provincia);
      }
      strcpy(dni, "6859236");
      resultado = modificarReg(ficheroHash, dni, provincia);

      if (resultado < 0)
            printf("No existe alumno con dni %s\n", dni);
      else
      {
            printf("Se ha modificado el alumno con DNI: %s, a provincia: %s \n", dni, provincia);
      }
      strcpy(dni, "12312389");
      resultado = modificarReg(ficheroHash, dni, provincia);

      if (resultado < 0)
            printf("No existe alumno con dni %s\n", dni);
      else
      {
            printf("Se ha modificado el alumno con DNI: %s, a provincia: %s \n", dni, provincia);
      }

      strcpy(dni, "22874843");
      resultado = modificarReg(ficheroHash, dni, provincia);

      if (resultado < 0)
            printf("No existe alumno con dni %s\n", dni);
      else
      {
            printf("Se ha modificado el alumno con DNI: %s, a provincia: %s \n", dni, provincia);
      }

      strcpy(dni, "12515152");
      resultado = modificarReg(ficheroHash, dni, provincia);

      if (resultado < 0)
            printf("No existe alumno con dni %s\n", dni);
      else
      {
            printf("Se ha modificado el alumno con DNI: %s, a provincia: %s \n", dni, provincia);
      }

      strcpy(dni, "2894123");
      resultado = modificarReg(ficheroHash, dni, provincia);

      if (resultado < 0)
            printf("No existe alumno con dni %s\n", dni);
      else
      {
            printf("Se ha modificado el alumno con DNI: %s, a provincia: %s \n", dni, provincia);
      }

      strcpy(dni, "33333333");
      resultado = modificarReg(ficheroHash, dni, provincia);

      if (resultado < 0)
            printf("No existe alumno con dni %s\n", dni);
      else
      {
            printf("Se ha modificado el alumno con DNI: %s, a provincia: %s \n", dni, provincia);
      }

      strcpy(dni, "11543192");
      resultado = modificarReg(ficheroHash, dni, provincia);

      if (resultado < 0)
            printf("No existe alumno con dni %s\n", dni);
      else
      {
            printf("Se ha modificado el alumno con DNI: %s, a provincia: %s \n", dni, provincia);
      }

      i = leeHash(ficheroHash);

      // Fin de B�squeda
}

