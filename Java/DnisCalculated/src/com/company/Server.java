package com.company;

import pcd.util.TextIO4GUI;

import java.io.*;
import java.net.*;

public class Server {

    /**
     * Handshake string. Each end of the connection sends this  string to the
     * other just after the connection is opened.  This is done to confirm that
     * the program on the other side of the connection is a CLChat program.
     */
    static final String HANDSHAKE = "CLChat";


    public static String calculatedLetterDNI(String DNI) {
        String letra = "ERROR";
        int selectionLetter = Integer.parseInt(DNI);
        selectionLetter = selectionLetter % 23;

        switch (selectionLetter) {
            case 0:
                letra = "T";
                break;
            case 1:
                letra = "R";
                break;
            case 2:
                letra = "W";
                break;
            case 3:
                letra = "A";
                break;
            case 4:
                letra = "G";
                break;
            case 5:
                letra = "M";
                break;
            case 6:
                letra = "Y";
                break;
            case 7:
                letra = "F";
                break;
            case 8:
                letra = "P";
                break;
            case 9:
                letra = "D";
                break;
            case 10:
                letra = "X";
                break;
            case 11:
                letra = "B";
                break;
            case 12:
                letra = "N";
                break;
            case 13:
                letra = "J";
                break;
            case 14:
                letra = "Z";
                break;
            case 15:
                letra = "S";
                break;
            case 16:
                letra = "Q";
                break;
            case 17:
                letra = "V";
                break;
            case 18:
                letra = "H";
                break;
            case 19:
                letra = "L";
                break;
            case 20:
                letra = "C";
                break;
            case 21:
                letra = "K";
                break;
            case 22:
                letra = "E";
                break;
        }
        return letra;
    }

    public static void main(String[] args) {

        int port;  //Puerto por el cual el servidor escucha

        ServerSocket listener; // Para escuchar conexión remota
        Socket connection; // Socket para la conexión con cliente

        BufferedReader incoming; //Recibir datos del cliente
        PrintWriter outgoing;    //Enviar datos al cliente
        String mesaageOut;       //String para enviar mensajes al cliente
        String messageIn;        //string para recibir información del cliente

        TextIO4GUI TextIO = new TextIO4GUI("DNI Letter Server");

        if (args.length == 0)
            port = 9875; //Establecemos puerto por defecto
        else {
            try {
                port = Integer.parseInt(args[0]);
                if (port < 0 || port > 65535)
                    throw new NumberFormatException(); // Si el puerto no se encuentra entre los puertos establecidos lanza una excepcion

            } catch (NumberFormatException e) {
                TextIO.putln("Ilegal port number, " + args[0]);
                return;
            }

        }

        TextIO.putln("This is the DNI Letter Server");
        TextIO.putln("> All incoming petition are shown bellow");


// Esperamos una conexion con servidor. Cuando llega, cierra el listener. Crea los stream de comunicacion y comienza comunicacion
        int i = 1;
        while (i < 10) {
            try {
                TextIO.putln("Listening on port " + port + "\n");
                listener = new ServerSocket(port);  //Establece conexión por el puerto indicado
                connection = listener.accept(); // Pone el conector en modo servidor y espera conexion entrante
                listener.close(); //Cierra el listener
                incoming = new BufferedReader(new InputStreamReader(connection.getInputStream())); // Se inicializa para recibir datos
                outgoing = new PrintWriter(connection.getOutputStream()); // Se inicializa para emviar datos
                outgoing.println(HANDSHAKE); // Envia HANDSHAKE
                outgoing.flush();
                messageIn = incoming.readLine();  //recibe el HANDSHAKE  del cliente
                if (!HANDSHAKE.equals(messageIn)) throw new Exception("Connected program is not a CLChat!");


            } catch (Exception e) {
                TextIO.putln("An error occurred while opening connection.");
                TextIO.putln(e.toString());
                return;
            }

            //Intercamvia mensajes con la otra conexión  hasta que se cierre la conexión. Este programa servidor espera el
            //primer mensaje del cliente. Despues que, se intercambien mensajes ida y vuelta.

            try {


                TextIO.putln("Nueva conexión " + i + " desde la dirección : " + connection.getInetAddress());
                messageIn = incoming.readLine(); // Espera al DNI
                if (messageIn.length() == 8) {
                    TextIO.putln("[" + i + "] Recived petition for " + messageIn);
                    String soluction = calculatedLetterDNI(messageIn);
                    TextIO.putln("[" + i + "] Calculated letter from " + messageIn + " is " + soluction);

                    mesaageOut = soluction; //Para enviar la solucion
                    outgoing.println(mesaageOut);
                    outgoing.flush();
                    if (outgoing.checkError()) throw new IOException("Error occurred while transmitting message.");
                    connection.close();
                    TextIO.putln("[" + i + "] Task done...Conection " + i + " disconecting");
                } else {
                    connection.close();
                    TextIO.putln("Error: Tamaño del DNI incorrecto");
                    TextIO.putln("[" + i + "] Task not done...Conection " + i + " disconecting...");
                }
                i++;


            } catch (Exception e) {
                TextIO.putln("Sorry, an error has occurred.  Connection lost.");
                TextIO.putln("Error:  " + e);
                System.exit(1);
            }
        }
    }

}
