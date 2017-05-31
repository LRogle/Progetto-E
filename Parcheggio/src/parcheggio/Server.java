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
        ServerSocket serverSocket = new ServerSocket(8888);//ingresso
        Socket socket = serverSocket.accept();
        System.out.println("Connected 1");
        ServerSocket serverSocket1 = new ServerSocket(8886);//uscita
        Socket socket1 = serverSocket1.accept();
        System.out.println("Connected 2");
        ServerSocket serverSocket2 = new ServerSocket(8887);//cassa
        Socket socket2 = serverSocket2.accept();
        System.out.println("Connected 3");
        
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
            System.out.println("Post in1.readLine() reached!");
            if (string1.equals("Arrivederci")) {
                String cod=in1.readLine();
                    if(parcheggio.getBigliettoUscita(Integer.parseInt(cod))!=null){
                        String S=parcheggio.Uscita(Integer.parseInt(cod));
                        out1.println(S);
                    }           
            }
            
            String string2 = in2.readLine();
            
            if (string2.equals("Pagamento")) {
                String s=in2.readLine();
                    if(parcheggio.getBigliettoAttivo(Integer.parseInt(s))!=null){
                        String S=""+parcheggio.getCassa().calcolaImporto(parcheggio.getBigliettoAttivo(Integer.parseInt(s)));
                        out2.println(S);
                    }else{
                        out2.println("Biglietto non trovato tra quelli attivi");
                    }
            }
            
            if (string2.equals("Monetine")){
                String cinqueCent = in2.readLine();
                String dieciCent = in2.readLine();
                String ventiCent = in2.readLine();
                String cinquantaCent = in2.readLine();
                String euro = in2.readLine();
                String codice = in2.readLine();
                if(parcheggio.PagamentoGUI(Integer.parseInt(cinqueCent), Integer.parseInt(dieciCent), Integer.parseInt(ventiCent), Integer.parseInt(cinquantaCent), Integer.parseInt(euro), Integer.parseInt(codice))){
                    out2.println("pronto");
                    out2.println(parcheggio.getBigliettoUscita(Integer.parseInt(codice)).getDataConvalida());
                }else{
                    out2.println("abort");
                }
                
                
            }
            
        }

    }
}
