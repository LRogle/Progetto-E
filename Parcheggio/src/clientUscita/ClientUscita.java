/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientUscita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author angelo
 */
public class ClientUscita {
    
    public static void main(String args[]) throws IOException {
       
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserire indirizzo IP del sever:");
        String ip = scanner.nextLine();
        Socket socket = new Socket(ip,8888);
        System.out.println("Connesso al sever.");
       
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        GUIUscita GU = new GUIUscita(out, in);
        
        if(socket.isConnected()){
        System.out.println("OK");}
            
    }
}