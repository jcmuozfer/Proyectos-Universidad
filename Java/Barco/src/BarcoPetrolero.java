public class BarcoPetrolero extends Barcos {

    static final int capacidadPetroleo = 3000;
    static final int capacidadAgua = 5000;
    private int petroleo;
    private int agua;
    private ZonaCarga carga;

    public BarcoPetrolero(Puerta puerta, int id, TorreDeControl _Control, ZonaCarga _carga) {
        super(1, puerta, id, _Control);
        this.carga = _carga;
        this.agua = 0;
        this.petroleo = 0;
    }

    public  int getCapacidadAgua() {
        return capacidadAgua;
    }

    public  int getCapacidadPetroleo() {
        return capacidadPetroleo;
    }

    public int getAgua() {
        return agua;
    }

    public int getPetroleo() {
        return petroleo;
    }

    public void setAgua(int agua) {
        this.agua = agua;
    }

    public void setPetroleo(int petroleo) {
        this.petroleo = petroleo;
    }

    @Override
    public void run() {

        getControl().permisoEntrada(this);
        getPuerta().entrar(this);
        getControl().finEntrada(this);

        while (getPetroleo() != 3000)
            carga.rellenarBarcoPetroleo(this);


            carga.rellenarBarcoAgua(this);


        if (getPetroleo() == getCapacidadPetroleo())
            System.out.println("El barco petrolero " + getId() + " ha sido rellenado de petroleo satisfactoriamente tiene: " + getPetroleo());
        if (getAgua() == 5000)
            System.out.println("El barco petrolero " + getId() + " ha sido rellenado de agua satisfactoriamente tiene: " + getAgua());

        getControl().permisoSalida(this);
        getPuerta().salir(this);
        getControl().finSalida(this);
    }

}



