import java.util.concurrent.Semaphore;

public class ZonaCarga {

    private int contenedorPetroleo[];
    private int contenedorAuga;
    private Semaphore[] semaforoPetroleo;
    private Semaphore semaforoAgua;
    private Semaphore semaforoTanque;
    private int cont;


    public ZonaCarga() {
        this.contenedorAuga = 1000;
        this.contenedorPetroleo = new int[5];
        this.semaforoPetroleo = new Semaphore[5];
        for (int i = 0; i < 5; i++) {
            semaforoPetroleo[i] = new Semaphore(1);
            contenedorPetroleo[i] = 1000;

        }
        this.semaforoAgua = new Semaphore(1);
        this.semaforoTanque = new Semaphore(0);
        cont = 0;
    }

    public void rellenarTanques() {
        try {
            semaforoTanque.acquire();

        } catch (Exception e) {
        }
        int j;
        System.out.println("Se estan rellenando los tanques...");
        for (j = 0; j < contenedorPetroleo.length; j++) {
            contenedorPetroleo[j] = 1000;
            semaforoPetroleo[j].release();
        }
        System.out.println("Se han rellenando todos los tanques");


    }

    public void setContenedorPetroleo(int id,int contenedorPetroleo) {
        this.contenedorPetroleo[id] = contenedorPetroleo;
    }

    public void rellenarBarcoPetroleo(BarcoPetrolero barco) {
        try {
            this.semaforoPetroleo[barco.getId()].acquire();

        } catch (InterruptedException e) {
        }

        int petroleoFinal = barco.getPetroleo() + contenedorPetroleo[barco.getId()];
        setContenedorPetroleo(barco.getId(),0);
        barco.setPetroleo(petroleoFinal);
        System.out.println("Barco Petrolero " + barco.getId() + " carga gasoil, tiene " + barco.getPetroleo() + " de Gasoil acumulados.");

        boolean enc = true; //Suponemos que todos los tanques están vacíos
        for (int i = 0; i < contenedorPetroleo.length && enc; i++) {
            if (contenedorPetroleo[i] != 0)
                enc = false;

        }
        if (enc) {
            this.semaforoTanque.release();
            rellenarTanques();
        }
    }

    public void rellenarBarcoAgua(BarcoPetrolero barco) {
        try {
            semaforoAgua.acquire();
        } catch (Exception e) {
        }
        while (barco.getAgua() != barco.getCapacidadAgua()) {
            int aguaFinal = contenedorAuga + barco.getAgua();
            barco.setAgua(aguaFinal);
            System.out.println("Se esta rellenado el barco " + barco.getId() + " con " + contenedorAuga + " litro de agua. Tiene " + barco.getAgua() + " litro de agua acumulados en el tanque");
        }

        if (barco.getAgua() == 5000) {
            semaforoAgua.release();
        }


    }


}
