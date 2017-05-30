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
        
        for (;;) {
//            out.println("Buongiorno vuole entrare nel parcheggio? (y/n)");
//            //System.out.println("Attendo messaggio client:");
            String string = in.readLine();
            //System.out.println(string);
            if (string.equals("hello")) {
                out.println(parcheggio.IngressoGUI());
                if(in.readLine().equals("posti")){
                    out.println(parcheggio.contaPostiLiberi());
                }
                System.out.println(" --- biglietti attivi:");
                parcheggio.stampaBigliettiAttivi();
            }
            else if (string.equals("n")) {
                out.println("Arrivederci!");
            }
            else if (string.equals("exit")) {
                out.println("exit");
                break;
            }
            else {
                out.println("Error: Invalid input!");
            }
        }
        
        parcheggio.Pagamento(1);
        
    }

}
