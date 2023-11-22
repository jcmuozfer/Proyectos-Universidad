package com.company;

import pcd.util.TextIO4GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    /**
     * Handshake string. Each end of the connection sends this  string to the
     * other just after the connection is opened.  This is done to confirm that
     * the program on the other side of the connection is a CLChat program.
     */
    static final String HANDSHAKE = "CLChat";


    public static void main(String[] args) {
        String computer;  //Ordenador donde esta el servidor puede ser una IP o nombre de dominio

        int port;   //Puerto por el que se va a conectar al servidor

        Socket connection;  //Para comunicacion con el servidor
        BufferedReader incoming; //Recibir datos del cliente
        PrintWriter outgoing;    //Enviar datos al cliente
        String mesaageOut;       //String para enviar mensajes al cliente
        String messageIn;        //string para recibir información del cliente


        TextIO4GUI TextIO = new TextIO4GUI("DNI Letter Client"); //Titulo del chat

        //Primero se obtine el ordenador, se obtine ip y puerto, sino se usa el predeterminado

        if (args.length == 0) {
            TextIO.putln("Usage:  java SimpleClient <computer-name> [<port>]");
            return;
        }
        computer = args[0];

        if (args.length == 0)
            port = 1728; //Establecemos puerto por defecto
        else {
            try {
                port = Integer.parseInt(args[1]);
                if (port < 0 || port > 65535)
                    throw new NumberFormatException(); // Si el puerto no se encuentra entre los puertos establecidos lanza una excepcion

            } catch (NumberFormatException e) {
                TextIO.putln("Ilegal port number, " + args[0]);
                return;
            }

        }

        //Abre una conexion con el servidor. crea los stream para la comunicación.

        try {
            TextIO.putln("This is the DNI Letter Client");
            TextIO.putln("Write your DNI number to calculate the corresponding letter");
            TextIO.put("> ");
            mesaageOut = TextIO.getlnString();
            TextIO.putln("Connecting to " + computer + " on port " + port);
            connection = new Socket(computer, port);
            incoming = new BufferedReader(new InputStreamReader(connection.getInputStream())); // Se inicializa para recibir datos

            outgoing = new PrintWriter(connection.getOutputStream()); // Se inicializa para emviar datos
            outgoing.println(HANDSHAKE); // Envia HANDSHAKE
            outgoing.flush();
            messageIn = incoming.readLine();  //recibe el HANDSHAKE  del cliente

            if (!HANDSHAKE.equals(messageIn)) throw new Exception("Connected program is not a CLChat!");

            TextIO.putln("... connected to "+ connection);
            outgoing.println(mesaageOut);
            outgoing.flush();
            if (outgoing.checkError()) throw new IOException("Error occurred while transmitting message.");

            TextIO.putln("Waiting for response from server...");
            messageIn = incoming.readLine();
            TextIO.putln("The letter calculated for "+mesaageOut+" is " + messageIn);
            connection.close();

        } catch (Exception e) {
            TextIO.putln("An error occurred while opening connection.");
            TextIO.putln(e.toString());
            return;
        }

    }
}
