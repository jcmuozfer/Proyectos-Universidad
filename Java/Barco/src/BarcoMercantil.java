public class BarcoMercantil extends Barcos {

    private ZonaDescarga descarga;

    public BarcoMercantil(int _direccion, Puerta puerta, int id, TorreDeControl _Control, int azucar, int harina, int sal) {
        super(_direccion, puerta, id, _Control);
        this.descarga = new ZonaDescarga(azucar, sal, harina);
    }


    @Override
    public void run() {


        if (getDireccion() == 0) {
            getControl().permisoSalida(this);
            getPuerta().salir(this);
            getControl().finSalida(this);

        } else {
            getControl().permisoEntrada(this);
            getPuerta().entrar(this);
            getControl().finEntrada(this);

            while (descarga.getCarga()[0] != 0 || descarga.getCarga()[1] != 0
                    || descarga.getCarga()[2] != 0) {

                descarga.gruaBarco();
                descarga.cogerObjeto();
            }

        }
    }
}
