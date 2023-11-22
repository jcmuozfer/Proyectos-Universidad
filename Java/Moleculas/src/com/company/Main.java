package com.company;

public class Main {

    public static void main(String[] args) {

        Atomo aire1 = new Atomo(0);
        Atomo aire2 = new Atomo(0);
        Atomo aire3 = new Atomo(1);
        Atomo aire4 = new Atomo(0);
        Atomo aire5 = new Atomo(1);
        Atomo aire6 = new Atomo(0);

        Thread a1  = new Thread(aire1);
        Thread a2  = new Thread(aire2);
        Thread a3  = new Thread(aire3);
        Thread a4  = new Thread(aire4);
        Thread a5  = new Thread(aire5);
        Thread a6  = new Thread(aire6);


        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
        a6.start();

    }
}
