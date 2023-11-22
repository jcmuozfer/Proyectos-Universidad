public class TorreDeControl {

    private int entrando;
    private int saliendo;
    private int turno;

    public TorreDeControl(int preferencia ) {
        this.entrando = 0;
        this.saliendo = 0;
        this.turno = preferencia;
    }

    synchronized public void permisoEntrada(Barcos barco) {
        while (saliendo != 0 || turno != 1  )
            try {
                wait();
            } catch (InterruptedException e) {

            }
        entrando++;
        System.out.println("Barco " + barco.getId() + " tiene permiso para entrar");


    }

    synchronized public void permisoSalida(Barcos barco) {
        while (entrando != 0 )
            try {
                wait();
            } catch (InterruptedException e) {

            }

        saliendo++;
        System.out.println("Barco " + barco.getId() + " tiene permiso para salir");


    }

     synchronized public void finEntrada(Barcos barco) {
        entrando--;
        if(entrando == 0){

            notifyAll();

        }
    }

    synchronized public void finSalida(Barcos barco) {
        saliendo--;
        turno = 0;
        if(saliendo ==0){

            notifyAll();
        }
    }

}
