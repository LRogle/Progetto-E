/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author luca
 */
public class GUIIng extends JFrame{
    private JPanel panel1;    //bottone,codice biglietto erogato
    private JPanel panel2;    //decidere per la sbarra il semaforo e i posti liberi
    private SbarraChiusaClient SC = new SbarraChiusaClient(); 
    private SbarraApertaClient SA = new SbarraApertaClient(); 
    private SbarraClient S;
    private JTextField postiliberi = new JTextField(); 
    private PrintWriter out;
    private BufferedReader in;
    
    public GUIIng(PrintWriter out,BufferedReader in){
        this.out=out;
        this.in=in;
        this.setVisible(true);
        this.setSize(500, 500);
        this.setBackground(Color.gray);
        this.setLayout(new GridLayout(2,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponent();
        S = new SbarraClient(false);
    }

    private void initComponent() {
        initPanel1();
        initPanel2();
    }

    private void initPanel1() {
        JButton button = new JButton("BIGLIETTO");
        JTextField text = new JTextField();
        

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,2));
        panel1.add(button);
        panel1.add(text);
        text.setName("Codice");
        text.setEditable(false);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                out.println("hello");//All'azione del pulsante mandiamo un messaggio in codice per il server in modo che capisce
                try {                // che ci siamo connessi. Tutto questo serve per far si che il server ci invierà i dati 
                    String cod = in.readLine(); // da far leggere al client(numero posti, codice biglietto).
                    text.setText("CODICE BIGLIETTO:\t"+cod); //cod biglietto
                
                out.println("posti");
                
                    try {
                        String posti = in.readLine();// Abbiamo 
                        postiliberi.setText("POSTI LIBERI:\t"+posti);// numro posti
                        
                        if(Integer.parseInt(posti)!=0){// verifica sul numero posti ancora disponibili
                            S.setVisibile(false);      
                            S = new SbarraClient(true);// apertura sbarra 
//                    try {          
//                            Thread.sleep(2500);    // il parametro in input è il tempo espresso in millesimi
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(MIngresso.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    S = new Sbarra(false);
                        
                        }else{
                            text.setText("Posti Esauriti");
                        S.setVisibile(false);   
                        S = new SbarraClient(false); // chiusura sbarra
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(GUIIng.class.getName()).log(Level.SEVERE, null, ex);
                    }    
                
                } catch (IOException ex) {
                    Logger.getLogger(GUIIng.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        this.add(panel1);
    }

    public void initPanel2() {
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,1));
        panel2.add(postiliberi);
        postiliberi.setEditable(false);
        this.add(panel2);
        
    }
    
    
}
