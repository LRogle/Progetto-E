/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author angelo
 */
public class Client {
    
    public Client() throws IOException {
       /*
       // vorrei avere l'indirizzo ip da terminale, ma non trova il carattere \n per qualche motivo
       Process p = Runtime.getRuntime().exec("ifconfig | grep \"192\" ; echo -e \"\n\" ");
       BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
       System.out.println(in.readLine());
       in.close();
       */
       Socket clientSocket = new Socket("192.168.0.113",8888);
    }
    
    public static void main(String args[]) throws IOException {
        System.out.println("Creo client e lo connetto a server");
        Client client = new Client();
    }
}