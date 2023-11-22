
public class Barcos implements Runnable{
    private int direccion;
    private Puerta puerta;
    private int id;
    private TorreDeControl control;


    public Barcos(int _direccion, Puerta puerta, int id, TorreDeControl _Control) {

        this.direccion = _direccion; // 0 sale, 1 entra
        this.puerta = puerta;
        this.id = id;
        this.control = _Control;

    }

    public int getDireccion() {
        return direccion;
    }

    public Puerta getPuerta() {
        return puerta;
    }

    public int getId() {
        return id;
    }

    public TorreDeControl getControl() {
        return control;
    }

    public void setControl(TorreDeControl control) {
        this.control = control;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPuerta(Puerta puerta) {
        this.puerta = puerta;
    }

    public void run() {


        if (direccion == 0) {
            control.permisoSalida(this);
            puerta.salir(this);
            control.finSalida(this);


        } else {
            control.permisoEntrada(this);
            puerta.entrar(this);
            control.finEntrada(this);

        }

    }


}
