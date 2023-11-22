package com.company;


import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public class Aire {

    private int combinadas;
    private boolean permisoCombinado;


    public Aire() {
        this.combinadas = 0;
        this.permisoCombinado = false;

    }

    synchronized public void combinar(int id) {

        while (permisoCombinado) {
            try {
                wait();

            } catch (Exception e) {
                System.err.println(" No se ha pdido combinar Error permisoCombinar ");

            }
            ;
        }
        combinadas = id;
        permisoCombinado = true;
        notify();


    }

    synchronized public void combinarFin() {

        while (!permisoCombinado) {
            try {
                wait();
            } catch (Exception e) {
                System.err.println(" No se ha pdido combinar Error combinacionFin ");

            }
            ;
        }
        this.permisoCombinado = false;
        notify();
        System.out.println("Se ha combinado molecula");

    }


}
