/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author angelo
 */
public class Server {
    
    public Server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
    }
    
    public static void main(String args[]) throws IOException {
        System.out.println("Creo server in ascolto:");
        Server server = new Server();
    }
}
