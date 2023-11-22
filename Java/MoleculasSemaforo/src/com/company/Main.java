package com.company;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Semaphore Atomo = new Semaphore(1);
        for (int i=0;i<4;i++)
            new AtomoH(i,Atomo).start();
        for (int i=0;i<2;i++)
            new AtomoO (i,Atomo).start();
    }
}
