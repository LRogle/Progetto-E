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
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author angelo
 */
public class Client {
    
    public Client() throws IOException {
       
       Scanner scanner = new Scanner(System.in);
       System.out.println("Inserire indirizzo IP del sever:");
       String ip = scanner.nextLine();
       Socket clientSocket = new Socket(ip,8888);
       System.out.println("Se leggi questa riga vuol dire che sei connesso senza problemi!");
    }
    
    public static void main(String args[]) throws IOException {
        System.out.println("Creo client e lo connetto a server");
        Client client = new Client();
    }
}