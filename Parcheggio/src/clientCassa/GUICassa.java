/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientCassa;

import GUI.*;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import parcheggio.Parcheggio;

/**
 *
 * @author Gabri
 */
public class GUICassa extends JFrame{
    JPanel Pagamento;
    JPanel panelMonete;
    JPanel panelTesto;
    
    JTextField testo = new JTextField("BENVENUTO");
    JLabel biglietto=new JLabel("INSERISCI CODICE");
    JButton bottone = new JButton("CONFERMA CODICE");

    JLabel uno = new JLabel("\t1 euro");
    JLabel cinquanta = new JLabel("\t50 cent");
    JLabel venti = new JLabel("\t20 cent");
    JLabel dieci = new JLabel("\t10 cent");
    JLabel cinque = new JLabel("\t5 cent");
    JButton bottonepaga = new JButton("PAGA ORA");
    
    JTextField codice =new JTextField();
    JTextField a5 = new JTextField("0");
    JTextField a4 = new JTextField("0");
    JTextField a3 = new JTextField("0");
    JTextField a2 = new JTextField("0");
    JTextField a1 = new JTextField("0");
    
    String codicebiglietto;
    BufferedReader in;
    PrintWriter out;
    
    public GUICassa( PrintWriter out, BufferedReader in) throws Exception{
        this.in = in;
        this.out = out;
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLayout(new GridLayout(3,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InitComponent();
    }

    public void InitComponent(){
        InitpanelPagamento();
        InitpanelMonete();
        InitpanelTesto();
    }

    public void InitpanelPagamento(){
        
        Pagamento = new JPanel();
        Pagamento.setLayout(new GridLayout(3,1));
        Pagamento.add(biglietto);
        Pagamento.add(codice);
        Pagamento.add(bottone);
                
        bottone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s= codice.getText();
                codicebiglietto = s;
                out.println("Pagamento");
                out.println(s);
                String prezzo;
                try {
                    prezzo = in.readLine();
                    if(prezzo.equals("Biglietto non trovato tra quelli attivi")){
                        testo.setText(prezzo);
                    }else{
                    testo.setText("PAGARE:\t"+prezzo);
                    bottonepaga.enable();
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(GUICassa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.add(Pagamento);
    }
    
    public void InitpanelMonete(){
        
        panelMonete = new JPanel();
        panelMonete.setLayout(new GridLayout(2,5));
        panelMonete.add(uno);
        panelMonete.add(cinquanta);
        panelMonete.add(venti);
        panelMonete.add(dieci);
        panelMonete.add(cinque);
        panelMonete.add(a5);//1€
        panelMonete.add(a4);//50
        panelMonete.add(a3);//20
        panelMonete.add(a2);//10
        panelMonete.add(a1);//5cent
        this.add(panelMonete);
    }

    public void InitpanelTesto() {
        testo.setVisible(true);
        testo.setEditable(false);
        panelTesto = new JPanel();
        panelTesto.setLayout(new GridLayout(2,1));
        panelTesto.add(bottonepaga);
        panelTesto.add(testo);
//        bottonepaga.disable();
        bottonepaga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                out.println("Monetine");
                out.println(a1.getText());
                out.println(a2.getText());
                out.println(a3.getText());
                out.println(a4.getText());
                out.println(a5.getText());
                out.println(codicebiglietto);
                
                String dataconvalida;
                try {
                    String controllo = in.readLine();
                    dataconvalida = in.readLine();
                    if(controllo.equals("pronto")){
                        testo.setText("Pagamento avvenuto correttamente, il biglietto è stato convalidato in data: "+dataconvalida);
                    }else if (controllo.equals("abort")){
                        testo.setText("Non è stato possibile completare il pagamento e convalidare il biglietto");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(GUICassa.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        });
        this.add(panelTesto);
    }
} 
    

