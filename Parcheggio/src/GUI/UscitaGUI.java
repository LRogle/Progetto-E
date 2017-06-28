/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import clientUscita.*;
import clientIngresso.*;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import parcheggio.Parcheggio;

/**
 *
 * @author cl418739
 */
public class UscitaGUI extends JFrame {
    
    private Parcheggio parcheggio;
    private JPanel panel1;   
    private JPanel panel2; 
    
    
    private JTextArea textsotto = new JTextArea();
    
    private SbarraFrame S;
    String cod= "";
    
     
    public UscitaGUI (Parcheggio p) throws InterruptedException{
        this.parcheggio= p;
        this.setVisible(true);
        this.setSize(500, 500);
        this.setBackground(Color.gray);
        this.setLayout(new GridLayout(2,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponent();
        S = new SbarraFrame();
    }

    private void initComponent() {
        initPanel1();
        initPanel2();
    }

    private void initPanel1() {
        JButton button = new JButton("USCITA");
        JTextField text = new JTextField();
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,2));
        panel1.add(text);
        panel1.add(button);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                cod = text.getText();
                if(cod.equals("")){
                    textsotto.setText("Codice non valido");
                }else{
                if(parcheggio.getBigliettoUscita(Integer.parseInt(cod))!=null){
                        String s= parcheggio.Uscita(Integer.parseInt(cod));
                    if(s.equals("Grazie. Arrivederci")){
                        textsotto.setText("Grazie. Arrivederci");
                        S.apri();
                        Timer timer = new Timer(1000, new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                S.chiudi();
                            }
                        });
                        timer.start();
                    } else {
                        textsotto.setText("Mancato pagamento o tempo scaduto");
                    }
                
                }else{
                    textsotto.setText("Codice non trovato tra i biglietti in uscita");
                }
                }
            }
        });
        this.add(panel1);
    }

    private void initPanel2() {
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,1));
        panel2.add(textsotto);
        textsotto.setEditable(false);
        this.add(panel2);
    }

    
}
