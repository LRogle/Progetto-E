/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author angelo
 */
public class Server {
    
    public static void main(String args[]) throws IOException {
        
        System.out.println("Creo server in ascolto:");
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        System.out.println("Connesso.");
        
        System.out.println("Creo un parcheggio:");
        Parcheggio parcheggio = new Parcheggio();
        System.out.println("Parcheggio creato.");
        System.out.println("");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        
        System.out.println("Attendo messaggio client:");
        String string = in.readLine();
        if (string.equals("y")) {
            out.write("Entra!");
        }
        else if (string.equals("n")) {
            out.write("Arrivederci!");
        }
        else if (string.equals("exit")) {
            out.write("exit");
        }
        else {
            out.write("Error: Invalid input!");
        }
        
    }
}
