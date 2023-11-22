

import java.util.concurrent.locks.*;

public class ZonaDescarga {

    private boolean plataforma = false;
    private int carga[];
    private Lock m = new ReentrantLock();
    private Condition okGrua[] = new Condition[3];

    private BarcoMercantil barco;
    private int id;


    public ZonaDescarga(int azucar, int sal, int harina) {
        this.carga = new int[3];
        this.carga[0] = azucar;
        this.carga[1] = sal;
        this.carga[2] = harina;

        for (int i = 0; i < 3; i++) {
            okGrua[i] = m.newCondition();
        }


    }

    public void gruaBarco() {
        try {
            m.lock();
            while (plataforma) {
                okGrua[id].await();
            }
            int elementoEscoger;
            boolean enc = false;

            while (!enc) {
                elementoEscoger = (int) Math.floor(Math.random() * (3 - 0 + 1) + 0);

                switch (elementoEscoger) {
                    case 1:
                        if (carga[0] != 0) {
                            id = 0;
                            System.out.println("La grua del barco ha dejado azucar");
                            enc = true;
                            plataforma = true;
                        }
                        break;
                    case 2:
                        if (carga[1] != 0) {
                            id = 1;
                            System.out.println("La grua del barco ha dejado sal");
                            enc = true;
                            plataforma = true;
                        }
                        break;
                    case 3:
                        if (carga[2] != 0) {
                            id = 2;
                            System.out.println("La grua del barco ha dejado harina");
                            enc = true;
                            plataforma = true;
                        }
                        break;
                }
            }
            carga[id] = carga[id] - 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            m.unlock();
        }

    }


    public void cogerObjeto() {

        try {
            m.lock();

            switch (id) {

                case 0:
                    System.out.println("La grua de haria ha recogido azucar");
                    break;
                case 1:
                    System.out.println("La grua de haria ha recogido sal");
                    break;
                default:
                    System.out.println("La grua de haria ha recogido harina");
                    break;
            }
            okGrua[id].signal();
            plataforma = false;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            m.unlock();
        }

    }


    public int[] getCarga() {
        return carga;
    }
}


