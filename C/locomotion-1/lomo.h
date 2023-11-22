#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <sys/sem.h>
#include <sys/msg.h>
#include <string.h>
#include <sys/shm.h>
#include <signal.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdbool.h>

#define NEGRO 0
#define ROJO 1
#define VERDE 2
#define AMARILLO 3
#define AZUL 4
#define MAGENTA 5
#define CYAN 6
#define BLANCO 7

#define TIPO_TRENNUEVO 1
#define TIPO_PETAVANCE 2
#define TIPO_AVANCE 3

#define TIPO_RESPPETAVANCETREN0 100
#define TIPO_RESPAVANCETREN0 200
#define TIPO_RESPTRENNUEVO 300

#define TIPO_COORDENADALIBRE 32768

struct mensaje
{
    long tipo;
    int tren;
    int x, y;
};

char const *usuario1 = "jmuozfer";
char const *usuario2 = "safernandez9";

int MAX_TREN = 99;
int MIN_TREN = 1;

struct ipcsSt
{
    int buzon;
    int semaforos;
    int numTrenes;
    pid_t *pidTrenes;
    int valorFin;
} ipcs;

int manejadoraEjecutada = 0;
int espera;
struct sigaction sigact;
sigset_t setAux;

struct mensaje estructuraMensaje;

int tamanoMensaje = sizeof(struct mensaje) - sizeof(long);

void pon_error(char *mensaje);

int LOMO_generar_mapa(char const *login1, char const *login2);
int LOMO_inicio(int ret, int semAforos, int buzOn,
                char const *login1, char const *login2);
void LOMO_espera(int y, int yn);
int LOMO_fin(void);