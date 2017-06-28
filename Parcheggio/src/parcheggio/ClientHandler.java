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
    
    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            // leggo e scrivo sulla connessione finche' non ricevo "quit"
            while (true) {
                String string = in.readLine();
                
                if (string.equals("hello")) {
                    out.println(parcheggio.IngressoGUI());
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
                    String s=in.readLine();
                    if(parcheggio.getBigliettoAttivo(Integer.parseInt(s))!=null){
                        String S=""+parcheggio.getCassa().calcolaImporto(parcheggio.getBigliettoAttivo(Integer.parseInt(s)));
                        out.println(S);
                        out.flush();
                    } else {
                        out.println("Biglietto non trovato tra quelli attivi");
                        out.flush();
                    }
                }
                else if (string.equals("Monetine")) {
                    String cinqueCent = in.readLine();
                    String dieciCent = in.readLine();
                    String ventiCent = in.readLine();
                    String cinquantaCent = in.readLine();
                    String euro = in.readLine();
                    String codice = in.readLine();
                    String metodo = in.readLine();
                    if(parcheggio.PagamentoGUI(Integer.parseInt(cinqueCent), Integer.parseInt(dieciCent), Integer.parseInt(ventiCent), Integer.parseInt(cinquantaCent), Integer.parseInt(euro), Integer.parseInt(codice),metodo)){
                        out.println("pronto");
                        out.println(parcheggio.getBigliettoUscita(Integer.parseInt(codice)).getDataConvalida());
                        out.flush();
                    } else {
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