/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;

import operatore.GUIOperatore;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import operatore.GUIOperatoreLogin;

/**
 *
 * @author angelo
 */
public class Server {
    
    private final int port;
    private final Parcheggio parcheggio;
    private final GUIOperatore PF;
    private final GUIOperatoreLogin login;
    private final ArrayList<ClientHandler> listaClientHandlers;

    /**
     * Viene creato un nuovo parcheggio ed assegnato un operatore.
     * @param port
     * @throws IOException 
     */
    public Server(int port) throws IOException {
        this.listaClientHandlers = new ArrayList<>();
        this.port = port;
        System.out.println("Creo un parcheggio:");
        this.parcheggio = new Parcheggio();
        this.login = new GUIOperatoreLogin(this);
        this.PF = new GUIOperatore(parcheggio);
        PF.setVisible(false);
        parcheggio.attach(PF);
        System.out.println("Parcheggio creato.");
        System.out.println("");
    }
    
    /**
     * Nasconde la finestra di login.
     */
    public void update(){
        this.login.quit();
        this.PF.setVisible(true);
    }
    
    /**
     * Permette di iniziare la comunicazione con i client.
     * @throws IOException 
     */
    public void startServer() throws IOException {
        ExecutorService executor = Executors.newCachedThreadPool();
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println(e.getMessage()); // porta non disponibile
            return;
        }
        System.out.println("Server ready");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(socket,parcheggio);
                this.listaClientHandlers.add(handler);
                executor.submit(handler);
            } catch (IOException e) {
                for (ClientHandler clientHand : listaClientHandlers){
                    
                }
                break;
            }
        }
    }
    
    public static void main(String args[]) throws IOException {
        Server server = new Server(8888);
        server.startServer();
    }
    
}
