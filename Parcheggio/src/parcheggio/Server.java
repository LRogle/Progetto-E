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
        ServerSocket serverSocket1 = new ServerSocket(8887);
        Socket socket1 = serverSocket1.accept();
        ServerSocket serverSocket2 = new ServerSocket(8886);
        Socket socket2 = serverSocket.accept();
        System.out.println("Connesso.");
        
        System.out.println("Creo un parcheggio:");
        Parcheggio parcheggio = new Parcheggio();
        System.out.println("Parcheggio creato.");
        System.out.println("");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
        PrintWriter out1 = new PrintWriter(socket1.getOutputStream(), true);
        BufferedReader in2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
        PrintWriter out2 = new PrintWriter(socket2.getOutputStream(), true);
        
        for (;;) {
//          System.out.println("Attendo messaggio client:");
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
            
            String string1 = in1.readLine();
            if (string1.equals("Arrivederci")) {
                String cod=in1.readLine();
                    if(parcheggio.getBigliettoUscita(Integer.parseInt(cod))!=null){
                        String S=parcheggio.Uscita(Integer.parseInt(cod));
                        out1.println(S);
                    }           
            }
            
            String string2 = in2.readLine();
        
        }

    }
}
