
package com.company;

import java.util.concurrent.*;

public class AtomoH extends Thread  {
    static Semaphore mutex = new Semaphore (1);
    Semaphore Oxigeno;
    static int HidrogenoTotal = 0;
    int quienSoy;

    public AtomoH (int _quienSoy, Semaphore _Oxigeno) {
        quienSoy = _quienSoy;
        Oxigeno = _Oxigeno;
    }

    public void run () {
        while (true) {
            try {
                mutex.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            HidrogenoTotal++;
            if (HidrogenoTotal ==2) {
                try {
                    Oxigeno.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            mutex.release();
            try {
                Thread.currentThread().sleep(1);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            try {
                Thread.currentThread().sleep(1);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            System.out.println("Hidrogeno esperando a formar agua..."+quienSoy );
            try {
                mutex.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            HidrogenoTotal--;
            if (HidrogenoTotal == 0)
                Oxigeno.release();
            mutex.release();
            try {Thread.sleep (1000);} catch (Exception e) {e.printStackTrace();}
        }
    }
}
