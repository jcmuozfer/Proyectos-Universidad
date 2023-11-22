/**
 * NOMBRE: Juan Carlos Muñoz Fernández

 * GRUPO: PB2
 */
#include "dispersion.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Lee el contenido del fichero hash organizado mediante el método de DISPERSIÓN según los criterios
// especificados en la práctica. Se leen todos los cubos completos tengan registros asignados o no. La
// salida que produce esta función permite visualizar el método de DISPERSIÓN

int leeHash(char *fichHash)
{
  FILE *f;
  tipoCubo cubo;
  regConfig regC;
  int j, nCubo = 0, densidadOcupacion;

  f = fopen(fichHash, "rb");
  fread(&regC, sizeof(regConfig), 1, f);
  fread(&cubo, sizeof(cubo), 1, f);
  while (!feof(f))
  {
    for (j = 0; j < C; j++)
    {
      if (j == 0)
        printf("Cubo %2d (%2d reg. ASIGNADOS)", nCubo, cubo.numRegAsignados);
      else if ((j == 1) && cubo.desbordado)
        printf("DESBORDADO\t\t");
      else
        printf("\t\t\t");
      if (j < cubo.numRegAsignados)
        printf("\t%s %s %s %s %s\n", cubo.reg[j].dni, cubo.reg[j].nombre, cubo.reg[j].ape1, cubo.reg[j].ape2,
               cubo.reg[j].provincia);
      else
        printf("\n");
    }
    nCubo++;
    fread(&cubo, sizeof(cubo), 1, f);
  }
  fclose(f);
  printf("ORGANIZACIÓN MÉTODO DISPERSIÓN:\n\t %d CUBOS y %d CUBOS DESBORDE con capacidad %d\n",
         regC.nCubos, regC.nCubosDes, C);
  printf("\t Contiene %d registros de los cuales se han desbordado %d:\n", regC.numReg, regC.numRegDes);
  densidadOcupacion = 100 * regC.numReg / ((regC.nCubos + regC.nCubosDes) * C);
  printf("Densidad ACTUAL de ocupación: %d \n\t(MÍNIMA permitida %d  MÁXIMA permitida %d)\n",
         densidadOcupacion, regC.densidadMin, regC.densidadMax);
  if (densidadOcupacion > regC.densidadMax)
  {
    printf("No se respeta la densidad máxima de ocupacion\n");
    return -3;
  }
  if (densidadOcupacion < regC.densidadMin)
  {
    printf("No se respeta la densidad mínima de ocupacion\n");
    return -4;
  }
  if ((densidadOcupacion > regC.densidadMin) && (densidadOcupacion < regC.densidadMax))
    return 0;

  return -1;
}
void creaHvacio(char *fichHash, regConfig *reg)
{
  FILE *fHash;
  tipoCubo cubo;
  int numCubos = reg->nCubos + reg->nCubosDes;
  int i;

  memset(&cubo, 0, sizeof(cubo)); // Vaciamos el cubo

  fHash = fopen(fichHash, "wb"); // Crea en escritura binaria
  if (fHash == NULL)
  {
    printf("Error al crear hash vacio");
    return; // Salir de la función si hay error
  }

  fwrite(reg, sizeof(regConfig), 1, fHash); // Escribir la información de regConfig

  for (i = 0; i < numCubos; i++)
    fwrite(&cubo, sizeof(cubo), 1, fHash); // Escribir un cubo vacío en el archivo

  fclose(fHash);
}

void desborde(FILE *fHash, tipoAlumno *reg, regConfig *regC)
{
  int nCuboDesAct = regC->nCuboDesAct;

  int posDesb = regC->nCubos + nCuboDesAct;
  tipoCubo cuboDesb;

  if (fseek(fHash, (posDesb * sizeof(cuboDesb)) + sizeof(regConfig), SEEK_SET) != 0)
  {
    printf("Error al mover el cursor.\n");
  }
  while (fread(&cuboDesb, sizeof(cuboDesb), 1, fHash))
  {

    // Comprobamos que se pueda asignar un elemento
    if (cuboDesb.numRegAsignados < C)
    {
      cuboDesb.reg[cuboDesb.numRegAsignados] = *reg;
      cuboDesb.numRegAsignados++;

      if (fseek(fHash, -sizeof(cuboDesb), SEEK_CUR) != 0)
      {
        printf("Error al buscar en el archivo de hash.\n");
      }
      if (fwrite(&cuboDesb, sizeof(cuboDesb), 1, fHash) != 1)
      {
        printf("Error al escribir datos en el archivo de hash.\n");
      }
      return;
    }
  }

  memset(&cuboDesb, 0, sizeof(cuboDesb)); // Vaciamos el cubo

  fwrite(&cuboDesb, sizeof(cuboDesb), 1, fHash); // Escribir un cubo vacío en el archivo
  cuboDesb.reg[0] = *reg;
  cuboDesb.numRegAsignados++;
  if (fseek(fHash, -sizeof(cuboDesb), SEEK_CUR) != 0)
    printf("Error al buscar en el archivo de hash.\n");
  if (fwrite(&cuboDesb, sizeof(cuboDesb), 1, fHash) != 1)
    printf("Error al escribir datos en el archivo de hash.\n");

  regC->nCuboDesAct++;
}

int creaHash(char *fichEntrada, char *fichHash, regConfig *regC)
{
  FILE *fEntrada, *fHash;
  tipoCubo cubo;
  tipoAlumno alumno;
  int numCubos = regC->nCubos + regC->nCubosDes;
  int i, numCubo;

  if (numCubos <= 0)
  {
    printf("Error: el número de cubos es menor o igual a cero\n");
    return -5;
  }

  fEntrada = fopen(fichEntrada, "rb");
  if (fEntrada == NULL)
  {
    perror("Error al abrir el fichero de entrada");
    return -1;
  }

  creaHvacio(fichHash, regC);

  fHash = fopen(fichHash, "r+b");
  if (fHash == NULL)
  {
    perror("Error al abrir el fichero hash");
    return -2;
  }

  while (fread(&alumno, sizeof(alumno), 1, fEntrada))
  {
    numCubo = atoi(alumno.dni) % regC->nCubos;
    if (fseek(fHash, (numCubo * sizeof(cubo)) + sizeof(regConfig), SEEK_SET) != 0)
    {
      printf("Error al buscar en el archivo de hash.\n");
      return -2;
    }
    if (fread(&cubo, sizeof(cubo), 1, fHash) != 1)
    {
      perror("Error al leer el cubo");
      return -2;
    }
    regC->numReg++;
    if (cubo.numRegAsignados < C)
    {
      cubo.reg[cubo.numRegAsignados] = alumno;
      cubo.numRegAsignados++;
      if (fseek(fHash, -sizeof(cubo), SEEK_CUR) != 0)
      {
        printf("Error al buscar en el archivo de hash.\n");
        return -2;
      }
      if (fwrite(&cubo, sizeof(cubo), 1, fHash) != 1)
      {
        printf("Error al escribir datos en el archivo de hash.\n");
        return -2;
      }
    }
    else
    {
      regC->numRegDes++;
      cubo.desbordado = 1;
      if (fseek(fHash, -sizeof(cubo), SEEK_CUR) != 0)
      {
        printf("Error al buscar en el archivo de hash.\n");
        return -2;
      }
      if (fwrite(&cubo, sizeof(cubo), 1, fHash) != 1)
      {
        printf("Error al escribir datos en el archivo de hash.\n");
        return -2;
      }

      desborde(fHash, &alumno, regC);
    }
  }

  if (fseek(fHash, 0, SEEK_SET) != 0)
  {
    printf("Error al mover el cursor.\n");
    return -2;
  }
  if (fwrite(regC, sizeof(regConfig), 1, fHash) != 1) // Escribir la información de regConfig
  {
    printf("Error al escribir el registro de configuración en el fHash.\n");
    return -2;
  }
  fclose(fEntrada);
  fclose(fHash);
  int densidadOcupacion = 100 * regC->densidadMax / ((regC->nCubos + regC->nCubosDes) * C);
  if (densidadOcupacion < regC->densidadMin)
    return -4;
  if (densidadOcupacion > regC->densidadMax)
    return -3;
  return 0;
}

tipoAlumno *busquedaHash(FILE *f, char *dni, int *nCubo, int *nCuboDes, int *posReg, int *error)
{
  int numCubo;
  tipoCubo cubo;
  regConfig regC;
  tipoAlumno *alumno = NULL;

  int existe = 0;
  int errorAux = 0;

  if (fseek(f, 0, SEEK_SET) != 0)
  {
    printf("Error al mover el cursor.\n");
    *error = -2;
  }

  if (fread(&regC, sizeof(regConfig), 1, f) != 1)
  {
    printf("Error al leer el archivo de configuración.\n");
    *error = -2;
  }

  numCubo = atoi(dni) % regC.nCubos;

  if (fseek(f, 0, SEEK_SET) != 0)
  {
    printf("Error al mover el cursor.\n");
    *error = -2;
  }
  if (fseek(f, (numCubo * sizeof(cubo)) + sizeof(regConfig), SEEK_SET) != 0)
  {
    printf("Error al mover el cursor.\n");
    *error = -2;
  }
  else if (fread(&cubo, sizeof(cubo), 1, f) != 1)
  {
    perror("Error al leer el cubo en busqueda de hash");
    *error = -2;
  }
  else
  {
    // Comprobamos si está en el cubo
    for (int i = 0; i < cubo.numRegAsignados; i++)
    {
      if (strcmp(cubo.reg[i].dni, dni) == 0)
      {
        alumno = (tipoAlumno *)malloc(sizeof(tipoAlumno));
        if (alumno == NULL)
        {
          perror("Error al reservar memoria para el alumno");
          exit(1);
        }
        existe = 1;

        *nCubo = numCubo;
        *nCuboDes = -1;
        *posReg = i;
        *error = errorAux;
        memcpy(alumno, &cubo.reg[i], sizeof(tipoAlumno));

        return alumno;
      }
    }

    // Si no está en el cubo, buscamos en el desbordamiento
    if (cubo.desbordado == 1)
    {
      // Recorremos todos los desbordados hasta encontrar el que es
      int posDesb = regC.nCubos;
      int numCuboDes = 0;

      if (fseek(f, (posDesb * sizeof(cubo)) + sizeof(regConfig), SEEK_SET) != 0)
      {
        printf("Error al mover el cursor.\n");
        *error = -2;
      }
      else
      {
        while (fread(&cubo, sizeof(cubo), 1, f))
        {
          for (int i = 0; i < cubo.numRegAsignados; i++)
          {
            if (strcmp(cubo.reg[i].dni, dni) == 0)
            {
              alumno = (tipoAlumno *)malloc(sizeof(tipoAlumno));
              if (alumno == NULL)
              {
                perror("Error al reservar memoria para el alumno");
                exit(1);
              }
              existe = 1;

              *nCubo = numCubo;
              *nCuboDes = numCuboDes;
              *posReg = i;
              *error = errorAux;
              memcpy(alumno, &cubo.reg[i], sizeof(tipoAlumno)); // Copiamos la información del alumno encontrado en el cubo a la nueva estructura

              return alumno;
            }
          }
          numCuboDes++;
        }
      }
    }

    if (existe == 0)
    {
      *error = -1;
    }
  }
  return alumno;
}

int modificarReg(char *fichero, char *dni, char *provincia)
{
  FILE *f;
  tipoCubo cubo;
  regConfig regC;
  int nCubo = 0, nCuboDes = 0, posReg = 0, error = -1;
  unsigned long posAlumno = -1;

  f = fopen(fichero, "r+b");
  tipoAlumno *alumno = busquedaHash(f, dni, &nCubo, &nCuboDes, &posReg, &error);

  if (error >= 0) // El usuario existe
  {

    if (nCuboDes == -1) // Esta en el cubo
    {
      posAlumno = (nCubo * sizeof(cubo)) + sizeof(regConfig);
    }
    else // Esta en el cubo de desborde
    {
      if (fseek(f, 0, SEEK_SET) != 0)
      {
        printf("Error al mover el cursor.\n");
        error = -2;
      }
      if (fread(&regC, sizeof(regConfig), 1, f) != 1)
      {
        printf("Error al leer el registro de configuración.\n");
        error = -2;
      }
      posAlumno = ((regC.nCubos + nCuboDes) * sizeof(cubo)) + sizeof(regConfig);
    }

    if (fseek(f, posAlumno, SEEK_SET) != 0) // Colocamos el cursor para obtener el cubo a modificar
    {
      printf("Error al mover el cursor.\n");
      error = -2;
    }
    if (fread(&cubo, sizeof(tipoCubo), 1, f) != 1) // Obtenemos el cubo
    {
      printf("Error al leer el cubo.\n");
      error = -2;
    }
    strncpy(cubo.reg[posReg].provincia, " ", sizeof(cubo.reg[posReg].provincia));       // Borramos la anterior provincia
    strncpy(cubo.reg[posReg].provincia, provincia, sizeof(cubo.reg[posReg].provincia)); // Escribimos en el cubo la provincia actual

    if (fseek(f, -sizeof(tipoCubo), SEEK_CUR) != 0) // Colocamos el cursor
    {
      printf("Error al mover el cursor.\n");
      error = -2;
    }
    if (fwrite(&cubo, sizeof(tipoCubo), 1, f) != 1) // Actualizamos el cubo
    {
      printf("Error al leer el cubo.\n");
      error = -2;
    }
  }

  fclose(f);

  return error;
}

