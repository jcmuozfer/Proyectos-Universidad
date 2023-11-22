public class Puerta {

    int X;

    public Puerta(int id) {

        this.X = id;
    }

    public void entrar(Barcos barco) {

        System.out.println("El barco " + barco.getId() + " entra");
        //System.out.println("El barco " + barco.getId() + " entra");
        //System.out.println("El barco " + barco.getId() + " entra");


    }

    public void salir(Barcos barco) {

        System.out.println("El barco " + barco.getId() + " sale");
        // System.out.println("El barco " + barco.getId() + " sale");
        //System.out.println("El barco " + barco.getId() + " sale");


    }

}
