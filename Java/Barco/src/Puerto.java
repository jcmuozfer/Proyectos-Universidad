public class Puerto {


    public static void main(String[] args) {

        TorreDeControl control = new TorreDeControl(1);// si introduces 1 da preferencia a los que sale, si introduces 0 a nadie
        Puerta puerta = new Puerta(1);
        ZonaCarga carga = new ZonaCarga();


        BarcoMercantil barco1 = new BarcoMercantil(1, puerta, 5, control,4,4,4);

        //Problema el barco petrolero siempre tiene que tener los identificadores del 0-5 por que usamos el getId para los semaforos
        BarcoPetrolero barco2 = new BarcoPetrolero(puerta, 0, control,carga);
        BarcoPetrolero barco3 = new BarcoPetrolero(puerta, 1, control,carga);
        BarcoPetrolero barco4 = new BarcoPetrolero(puerta, 2, control,carga);
        BarcoPetrolero barco5 = new BarcoPetrolero(puerta, 3, control,carga);
        BarcoPetrolero barco6 = new BarcoPetrolero(puerta, 4, control,carga);


        Thread b1 = new Thread(barco1);
        Thread b2 = new Thread(barco2);
        Thread b3 = new Thread(barco3);
        Thread b4 = new Thread(barco4);
        Thread b5 = new Thread(barco5);
        Thread b6 = new Thread(barco6);


        b1.start();
        b2.start();
        b3.start();
        b4.start();
        b5.start();
        b6.start();
    }

}
