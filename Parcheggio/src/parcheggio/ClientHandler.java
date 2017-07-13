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
import java.net.Socket;


/**
 *
 * @author aench
 */
public class ClientHandler implements Runnable {
    
    private Socket socket;
    private Parcheggio parcheggio;
    
    public ClientHandler(Socket socket, Parcheggio parcheggio) {
        this.socket = socket;
        this.parcheggio = parcheggio;
    }
    
    /**
     * Viene avviata la conversazione con il client.
     * In base al messaggio ricevuto, viene eseguito un metodo diverso, implementato sull'interfaccia grafica.
     */   
    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            while (true) {
                String string = in.readLine();
                
                if (string.equals("hello")) {
                    out.println(parcheggio.Ingresso());
                    String posti = in.readLine();
                    if(posti.equals("posti")){
                        System.out.println("contaPostiLiberi:\t"+parcheggio.contaPostiLiberi());
                        out.println(parcheggio.contaPostiLiberi());
                    }
                    out.flush();
                    System.out.println(" --- biglietti attivi:");
                    parcheggio.stampaBigliettiAttivi();
                }
                else if (string.equals("Arrivederci")) {
                    String cod=in.readLine();
                    if(parcheggio.getBigliettoUscita(Integer.parseInt(cod))!=null){
                        String S=parcheggio.Uscita(Integer.parseInt(cod));
                        out.println(S);
                        out.flush();
                    } 
                    else {
                        out.println("Error!");
                        out.flush();
                    }
                }
                else if (string.equals("Pagamento")) {
                    try{
                    String s=in.readLine();
                    if(parcheggio.getBigliettoAttivo(Integer.parseInt(s))!=null){
                        String S=""+parcheggio.getCassa().calcolaImporto(parcheggio.getBigliettoAttivo(Integer.parseInt(s)));
                        out.println(S);
                        out.flush();
                    } else {
                        out.println("Biglietto non trovato tra quelli attivi");
                        out.flush();
                    }
                    }catch(NumberFormatException ex){
                        System.out.println("Errore: lettere invece che numeri!");
                        out.println("Biglietto non trovato tra quelli attivi");
                        out.flush();
                    }
                }
                else if (string.equals("Monetine")) {
                    String euro1 = in.readLine();
                    String euro2 = in.readLine();
                    String euro5 = in.readLine();
                    String euro10 = in.readLine();
                    String euro20 = in.readLine();
                    String codice = in.readLine();
                    String metodo = in.readLine();
                    try{
                    if(parcheggio.Pagamento(Integer.parseInt(euro1), Integer.parseInt(euro2), Integer.parseInt(euro5), Integer.parseInt(euro10), Integer.parseInt(euro20), Integer.parseInt(codice),metodo)){
                        out.println("pronto");
                        out.println(parcheggio.getBigliettoUscita(Integer.parseInt(codice)).getDataConvalida());
                        if(metodo.equals("contanti")){
                        out.println(parcheggio.getCassa().getResto());}
                        out.flush();
                    } else {
                        out.println("abort");
                        out.println("error: no date");
                        out.flush();
                    }
                    }catch(NumberFormatException ex){
                        System.out.println("Errore: lettere invece che numeri!");
                        out.println("abort");
                        out.println("error: no date");
                        out.flush();
                    }
                } 
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
