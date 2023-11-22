package com.company;

import java.util.concurrent.*;

public class AtomoO extends Thread {
    int quienSoy;
    Semaphore Oxigeno;

    public AtomoO (int _quienSoy, Semaphore _Oxigeno) {
        quienSoy = _quienSoy;
        Oxigeno = _Oxigeno;
    }

    public void run () {
        while (true) {
            try {
                Oxigeno.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Se ha formado agua con "+quienSoy );
            Oxigeno.release();
            try {Thread.sleep (1000);} catch (Exception e) {e.printStackTrace();}
        }
    }
}