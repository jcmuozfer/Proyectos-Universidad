#include "lomo.h"

long calcularCoordenadas(int x, int y)
{
    long coordenada = 0;
    coordenada |= x;                    // colocar el valor de x en coords
    coordenada <<= 8;                   // desplazar x 8 bits a la izquierda
    coordenada |= y;                    // colocar el valor de y en coords
    coordenada |= TIPO_COORDENADALIBRE; // establecer el bit más alto en 1 para indicar que la coordenada está liberada
    return coordenada;
}

void manejadora()
{
    if (!manejadoraEjecutada)
    {
        manejadoraEjecutada = 1;

        switch (ipcs.valorFin = LOMO_fin())
        {
        case -1:
            fprintf(stderr, "La ejecución se ha finalizado con algún error\n");
            break;
        case -2:
            fprintf(stderr, "La ejecución se ha finalizado con algún accidente\n");
            break;
        case 0:
            fprintf(stderr, "La ejecución se ha finalizado con éxito!!\n");
            break;

        default:
            fprintf(stderr, "No se que coño esta pasando!!\n");

            break;
        }

        if (ipcs.buzon != -1 && msgctl(ipcs.buzon, IPC_RMID, NULL) == -1)
            perror("Error: no se ha podido liberar el buzon");

        if (ipcs.semaforos != -1 && semctl(ipcs.semaforos, 0, IPC_RMID) == -1)
            perror("Error: no se ha podido liberar el semáforo");

        for (int i = 0; i < ipcs.numTrenes; i++)
            if (kill(ipcs.pidTrenes[i], SIGTERM) == -1)
                perror("Error: no se ha podido matar el hijo: " + i);
    }
}

void enviarMensaje(long tipoMensajeEnvio)
{
    if (!manejadoraEjecutada)
    {
        estructuraMensaje.tipo = tipoMensajeEnvio;
        if (msgsnd(ipcs.buzon, &estructuraMensaje, tamanoMensaje, 0) == -1)
        {
            perror("Error: No se ha podido enviar el mensaje de tipo: " + estructuraMensaje.tipo);
            if (!manejadoraEjecutada)
                manejadora();
        }
    }
}

void recibirMensaje(long tipoMensajeRecibir)
{
    if (!manejadoraEjecutada)
    {
        if (msgrcv(ipcs.buzon, &estructuraMensaje, tamanoMensaje, tipoMensajeRecibir, 0) == -1)
        {
            perror("Error: No se ha podido recibir el mensaje de tipo");
            if (!manejadoraEjecutada)
                manejadora();
        }
    }
}

void inicializarVariables()
{

    if ((ipcs.semaforos = semget(IPC_PRIVATE, 1, IPC_CREAT | 0666)) == -1)
    {
        perror("Error: No se ha podido crear el semáforo");

        if (!manejadoraEjecutada)
            ;
    }

    if ((ipcs.buzon = msgget(IPC_PRIVATE, IPC_CREAT | 0666)) == -1)
    {
        perror("Error: No se ha podido crear el buzon");
        if (!manejadoraEjecutada)
            manejadora();
    }

    if ((ipcs.pidTrenes = malloc(sizeof(pid_t) * ipcs.numTrenes)) == NULL)
    {
        perror("Error: Al reservar memoria para lo id de los trenes");
        if (!manejadoraEjecutada)
            manejadora();
    }

    if (signal(SIGINT, manejadora) == SIG_ERR)
    {
        perror("Error: al realizar la operación signal");
        if (!manejadoraEjecutada)
            manejadora();
    }

    for (int i = 0; i < 80; i++)
    {
        for (int j = 0; j < 20; j++)
        {
            estructuraMensaje.tipo = calcularCoordenadas(i, j);
            if (msgsnd(ipcs.buzon, &estructuraMensaje, 0, 0) == -1)
            {
                perror("Error: Al liberal todas las posiciones del tablero");
                if (!manejadoraEjecutada)
                    manejadora();
            }
        }
    }
}

int avanzarTren()
{

    long mensajeTipo;
    int posX = 0, posY = 0, prevY = 0;

    enviarMensaje(TIPO_TRENNUEVO);
    recibirMensaje(TIPO_RESPTRENNUEVO);

    int idHijoTren = estructuraMensaje.tren;
    bool bucleInfinito = true;

    while (bucleInfinito)
    {

        enviarMensaje(TIPO_PETAVANCE);
        recibirMensaje(TIPO_RESPPETAVANCETREN0 + idHijoTren);

        prevY = posY;
        posX = estructuraMensaje.x;
        posY = estructuraMensaje.y;

        if (msgrcv(ipcs.buzon, &mensajeTipo, 0, calcularCoordenadas(posX, posY), 0) == -1)
            perror("Error: al comprobar la posición a al que se desea mover el tren ");

        estructuraMensaje.tren = idHijoTren;
        enviarMensaje(TIPO_AVANCE);
        recibirMensaje(TIPO_RESPAVANCETREN0 + idHijoTren);

        if (estructuraMensaje.x != -1)
        {
            mensajeTipo = calcularCoordenadas(estructuraMensaje.x, estructuraMensaje.y);
            if (msgsnd(ipcs.buzon, &mensajeTipo, 0, 0) == -1)
            {
                perror("Error:al liberar posición ocupada por lel tren");
                if (!manejadoraEjecutada)
                    manejadora();
            }
        }

        LOMO_espera(prevY, posY);
    }

    return 0;
}

void ejecucionLocomotion(int retardo)
{
    if (sigprocmask(SIG_SETMASK, &setAux, NULL) == -1)
    {
        perror("Error: Al bloquear todas las señales, exceltp SIGINT(Ctrl+C)");
        exit(-1);
    }

    if (LOMO_inicio(retardo, ipcs.semaforos, ipcs.buzon, usuario1, usuario2))
    {
        perror("Error: La función LOMO_inicio ha fallado");
        if (!manejadoraEjecutada)
            manejadora();
    }
    if (ipcs.numTrenes <= 0)
    {

        perror("Error: no hay trenes suficientes para ejecutar el programa");
        if (!manejadoraEjecutada)
            manejadora();
    }

    int idHijo;
    for (int i = 0; i < ipcs.numTrenes; i++)
    {
        idHijo = fork();
        switch (idHijo)
        {
        case -1:
            perror("Error: No se ha podido crear el hijo: " + i);
            if (!manejadoraEjecutada)
                manejadora();
            break;
        case 0:
            sigfillset(&setAux);
            sigdelset(&setAux, SIGTERM);
            if (sigprocmask(SIG_SETMASK, &setAux, NULL) == -1)
            {
                perror("Error: al poner el conjunto de señales bloqueadas según set");
                exit(-1);
            }
            avanzarTren();
            break;

        default:
            ipcs.pidTrenes[i] = idHijo;
            break;
        }
    }

    if (sigprocmask(SIG_SETMASK, &setAux, NULL) == -1)
    {
        perror("Error: Al bloquear todas las señales, excelto SIGINT(Ctrl+C)");
        exit(-1);
    }

    for (int i = 0; i < ipcs.numTrenes; i++)
    {
        if (wait(&espera) == -1)
        {
            if (errno == EINTR)
            {
                i--;
                continue;
            }
        }
    }
}

int main(int argc, char *argv[])

{

    switch (argc)
    {
    case 2: // lomo --mapa

        if (strcmp(argv[1], "--mapa") == 0)
        {

            if (LOMO_generar_mapa(usuario1, usuario2) == -1)
            {
                perror("Error: No se ha podido generar el mapa");
                exit(-1);
            }
        }

        break;
    case 3: // lomo retardo nTrenes
        int retardo = atoi(argv[1]);

        if (retardo >= 0)
        {
            int cantTren = atoi(argv[2]);
            if (cantTren >= MIN_TREN && cantTren <= MAX_TREN)
            {

                ipcs.numTrenes = cantTren;
            }
            else
            {
                perror("Error:  La cantidad de trenes no se encuentran entre 0 y 100");
                exit(-1);
            }

            sigact.sa_handler = manejadora;
            sigact.sa_flags = 0;
            sigfillset(&sigact.sa_mask); // En la manejadora están todas enmascaradas

            if (sigaction(SIGINT, &sigact, NULL) == -1)
            {
                perror("sigaction: ");
                return 32;
            }

            inicializarVariables();

            ejecucionLocomotion(retardo);
        }
        else
            perror("Error paso de parámetros, retardo");
        exit(-1);
        break;

    default:
        perror("Parámetros introducidos no son válidos");
        exit(-1);

        break;
    }
    return 0;
}
