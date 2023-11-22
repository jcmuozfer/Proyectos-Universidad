package com.company;


public class Atomo extends Thread {

    private int id;  //0 si es oxígeno y 1 si es hidrógeno
    private Aire aire;


    public Atomo(int _id) {
        this.id = _id;
        this.aire = new Aire();
    }

    public void run() {

        aire.combinar(id);
        aire.combinarFin();


    }

}
