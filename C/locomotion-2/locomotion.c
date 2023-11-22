// LIBRERIAS
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/sem.h>
#include <sys/msg.h>
#include <sys/shm.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <signal.h>
#include <errno.h>
#include "locomotion.h"

// DEVELOPERS NEIMS.
#define usuario1 ""
#define usuario2 ""

#define tamMensaje sizeof(struct mensaje) - sizeof(long)

// Definimos una macro para facilitar la creación de mensajes con objeto de señalar las coordenadas libres del recorrido.
#define TIPO_COORDLIBERADA 32768 /* 1 << sizeof(long)*8-1 */
#define TIPO_COORDS(x, y) TIPO_COORDLIBERADA | ((~0 & (x << 8)) | y)

// Tamaño (intuitivo) del recorrido
#define MATX 80
#define MATY 20

// Macros para mensajes para comunicarse con la librería
#define ENVIAR_MENSAJE(tipo_msg)                       \
    msg.tipo = tipo_msg;                               \
    if (msgsnd(ipcs.buzon, &msg, tamMensaje, 0) == -1) \
    {                                                  \
        perror("Msgsnd: ");                            \
        manejadora(666);                               \
        return 21;                                     \
    }

#define RECIBIR_MENSAJE(tipo_msg)                                \
    if (msgrcv(ipcs.buzon, &msg, tamMensaje, tipo_msg, 0) == -1) \
    {                                                            \
        perror("Msgrcv: ");                                      \
        manejadora(666);                                         \
        return 22;                                               \
    }

// Estructura para guardar todos los IPCs y valores necesarios de manera global y poder comunicarse entre trenes y manejadora.
struct ipcsSt
{
    int sem;
    int buzon;
    int numTrenes;
    pid_t *pidTrenes;
    int lomoRet; // Valor retornado por LOMO_fin
} ipcs;

// Usaremos esta estructura para los mensajes de coordenadas libres, para aliviar la carga de mensajes reduciendo su tamaño a 0
struct msj
{
    long tipo;
};

int tren2(void);

void manejadora(int);

int main(int argc, char *argv[])
{

    char buffer[100];
    int estadoWait;
    int i, j; // iteradores
    struct msj men;

    struct sigaction sigactionSt;
    sigset_t set1, set2;

    pid_t pidHijo;

    // Enmascaramos todas
    sigfillset(&set1);

    // Enmascaramos todas menos sigint
    sigfillset(&set2);
    sigdelset(&set2, SIGINT);

    // Bloqueamos TODAS LAS SEÑALES.
    if (sigprocmask(SIG_SETMASK, &set1, NULL) == -1)
    {
        perror("Sigprogmask1: ");
        return 40;
    }

    // Cambiamos la acción por defecto de SIGINT delegándola a la manejadora.
    sigactionSt.sa_handler = manejadora;
    sigactionSt.sa_flags = 0;
    sigfillset(&sigactionSt.sa_mask); // En la manejadora están todas enmascaradas

    if (sigaction(SIGINT, &sigactionSt, NULL) == -1)
    {
        perror("sigaction: ");
        return 32;
    }

    // definimos ipcs a -1 para que nos ayude luego a la hora de borrarlos.
    ipcs.sem = -1;
    ipcs.buzon = -1;

    if (argc == 2 && strcmp(argv[1], "--mapa") == 0)
    {
        if (LOMO_generar_mapa(usuario1, usuario2) == -1)
        {
            fprintf(stderr, "Error generando mapa\n");
        }
        return 1;
    }
    else if (argc == 3)
    { // en caso de parámetros incorrectos acabarán siendo 0 según la función atoi

        ipcs.numTrenes = atoi(argv[2]);

        // Comprobamos que el numero de trenes sea correcto
        if (ipcs.numTrenes < 1 || ipcs.numTrenes > 100)
        {
            printf("Numero de trenes incorrecto [1-100]\n");
            return 31;
        }

        // Creamos el semáforo
        if ((ipcs.sem = semget(IPC_PRIVATE, 1, IPC_CREAT | 0666)) == -1)
        {
            perror("Semget: ");
            return 1;
        }

        // Creamos el buzón
        if ((ipcs.buzon = msgget(IPC_PRIVATE, IPC_CREAT | 0666)) == -1)
        {
            perror("Msgget: ");
            manejadora(0);
            return 2;
        }

        // Reservamos memoria para guardar los pids de los hijos
        if ((ipcs.pidTrenes = malloc(sizeof(pid_t) * ipcs.numTrenes)) == NULL)
        {
            perror("Malloc: ");
            manejadora(0);
            return 21;
        }

        // Enviamos mensajes para indicar que todas las posiciones están libres
        for (i = 0; i < MATX; i++)
        {
            for (j = 0; j < MATY; j++)
            {
                men.tipo = TIPO_COORDS(i, j);
                if (msgsnd(ipcs.buzon, &men, 0, 0) == -1)
                {
                    perror("Msgsnd: ");
                    manejadora(0);
                    return 21;
                }
            }
        }

        // Bloqueamos todas las señales MENOS sigint
        if (sigprocmask(SIG_SETMASK, &set2, NULL) == -1)
        {
            perror("Sigprogmask2: ");
            return 40;
        }

        // Le indicamos a la librería que empezamos la simulación
        if (LOMO_inicio((atoi(argv[1]) >= 0 ? atoi(argv[1]) : 20), ipcs.sem, ipcs.buzon, usuario1, usuario2) == -1)
        {
            fprintf(stderr, "LOMO_inicio ha fallado.\n");
            manejadora(0);
            return 4;
        }

        // Volvemos a bloquear todas las señales
        if (sigprocmask(SIG_SETMASK, &set1, NULL) == -1)
        {
            perror("Sigprogmask3: ");
            return 40;
        }

        // Creación de los hijos
        for (i = 0; i < ipcs.numTrenes; i++)
        {
            pidHijo = fork();
            switch (pidHijo)
            {
            case -1:
                perror("Fork: ");
                manejadora(-i);
                return 7;
            case 0: // Hijo.
                // Desbloqueamos SIGTERM para que el hijo pueda morir más adelante
                sigfillset(&set2);
                sigdelset(&set2, SIGTERM);
                if (sigprocmask(SIG_SETMASK, &set2, NULL) == -1)
                {
                    perror("Sigprogmask1: ");
                    return 40;
                }
                return tren2();
            default:
                ipcs.pidTrenes[i] = pidHijo;
            }
        }

        // Desbloqueamos SIGINT otra vez
        if (sigprocmask(SIG_SETMASK, &set2, NULL) == -1)
        {
            perror("Sigprogmask4: ");
            return 40;
        }

        // Esperamos por la defunción de cada uno de los hijos (R.I.P. †)
        for (i = 0; i < ipcs.numTrenes; i++)
        {
            if (wait(&estadoWait) == -1)
            {
                // En caso de que el WAIT se corte por recibir una señal SIGINT que salta a la manejadora; detectamos el error de interrupción (EINTR) y lo ignoramos; volviendo al bucle.
                if (errno == EINTR)
                {
                    i--;
                    continue;
                }
                sprintf(buffer, "[WAIT]Error al manejar la muerte del hijo con pid %d[%d] (%d, %d): ", ipcs.pidTrenes[i], i, estadoWait, WEXITSTATUS(estadoWait));
                perror(buffer);
            }
        }

        // devolvemos el valor contrario al que devolvió la librería LOMO (porque lo pone en el enunciado.)
        return -ipcs.lomoRet;
    }
    else
    { // Argumentos incorrectos
        printf("Uso: %s --mapa      | Imprime el mapa asociado\n     %s vel nTrenes | Funcionar a vel velocidad con nTrenes trenes\n", argv[0], argv[0]);
        return 0;
    }
}

int tren2(void)
{

    int idTren, xPos = 0, yPos = 0, /*xPrev = 0,*/ yPrev = 0;
    struct mensaje msg;
    struct msj men;

    // Notificamos a la librería el comienzo de las andaduras de cada hijo.
    ENVIAR_MENSAJE(TIPO_TRENNUEVO)

    // Recibimos la respuesta de la librería y guardamos la id del tren
    RECIBIR_MENSAJE(TIPO_RESPTRENNUEVO)

    idTren = msg.tren;

    while (1)
    { // Bucle infinito.

        // Enviamos una petición de avance
        ENVIAR_MENSAJE(TIPO_PETAVANCE)

        // Esperamos la respuesta del tipo de tren correcto
        RECIBIR_MENSAJE(TIPO_RESPPETAVANCETREN0 + idTren)

        yPrev = yPos;
        xPos = msg.x;
        yPos = msg.y;

        // Cuando esté libre la posición a la que quiere moverse, lo movemos
        if (msgrcv(ipcs.buzon, &men, 0, TIPO_COORDS(xPos, yPos), 0) == -1)
        {
            perror("Msgrcv: ");
            manejadora(666);
            return 22;
        }

        // Avanzamos
        msg.tren = idTren;
        ENVIAR_MENSAJE(TIPO_AVANCE)

        // Esperamos la respuesta de avance
        RECIBIR_MENSAJE(TIPO_RESPAVANCETREN0 + idTren)

        if (msg.x != -1)
        {
            // se libera {msg.x, msg.y}
            // Mandamos el mensaje de que se ha liberado {msg.x, msg.y}
            men.tipo = TIPO_COORDS(msg.x, msg.y);
            if (msgsnd(ipcs.buzon, &men, 0, 0) == -1)
            {
                perror("Msgsnd: ");
                manejadora(666);
                return 21;
            }
        }

        // Ahora que nos hemos movido, esperamos.
        LOMO_espera(yPrev, yPos);

    } // FIN WHILE
}

// Manejadora para la señal SIGINT
void manejadora(int sigid)
{

    char buffer[20];
    int i, hijosCreados;

    // Indicamos a la librería que ha concluido la simulación
    ipcs.lomoRet = LOMO_fin();
    if (ipcs.lomoRet == -1)
    {
        fprintf(stderr, "Ha habido algun error durante la simulacion\n");
    }
    else if (ipcs.lomoRet == -2)
    {
        fprintf(stderr, "Ha habido accidentes. La hemos cagao'\n");
    }

    // Según el valor de sigid recibido por el parámetro de la función, obtenemos el número de procesos hijos que hemos de destruir sin piedad.
    if (sigid <= 0)
    {
        hijosCreados = -sigid;
    }
    else
    {
        hijosCreados = ipcs.numTrenes;
    }

    for (i = 0; i < hijosCreados; i++)
    {
        if (kill(ipcs.pidTrenes[i], SIGTERM) == -1)
        { // Filicidio del hijo con PID ipcs.pidTrenes[ i ]
            sprintf(buffer, "Kill (%d): ", ipcs.pidTrenes[i]);
            perror(buffer);
        }
    }

    // Liberamos los mecanismos IPCs restantes: buzón de mensajes y semáforo.
    if (ipcs.buzon != -1 && msgctl(ipcs.buzon, IPC_RMID, NULL) == -1)
    {
        perror("No se pudo borrar la cola de mensajes: ");
    }

    if (ipcs.sem != -1 && semctl(ipcs.sem, 0, IPC_RMID) == -1)
    {
        perror("No se pudo borrar el semaforo wey ");
    }
}
