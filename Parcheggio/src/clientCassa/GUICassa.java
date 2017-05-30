/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientCassa;

import clientIngresso.SbarraClient;
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
import javax.swing.JTextField;

/**
 *
 * @author luca
 */
class GUICassa extends JFrame{
    private JPanel panelCodice;
    private JPanel panelMonete;
    private JPanel panelTesto;
    
    private SbarraClient S;
    private JTextField postiliberi = new JTextField(); 
    private PrintWriter out;
    private BufferedReader in;
    
    JLabel       cinquanta =  new JLabel("\t50 cent");
    JLabel       venti =      new JLabel("\t20 cent");
    JLabel       dieci =      new JLabel("\t10 cent");
    JLabel       cinque =     new JLabel("\t5 cent");
    JTextField   a1 =         new JTextField();
    JTextField   a2 =         new JTextField();
    JTextField   a3 =         new JTextField();
    JTextField   a4 =         new JTextField();
    
    public GUICassa(PrintWriter out,BufferedReader in){
        this.out=out;
        this.in=in;
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLayout(new GridLayout(3,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponent();
        S = new SbarraClient(false);
    }

    private void initComponent() {
        InitpanelCodice();
        InitpanelMonete();
        InitpanelTesto();
    }

    public void InitpanelMonete(){
        
        panelMonete = new JPanel();
        panelMonete.setLayout(new GridLayout(2,4));
        panelMonete.add(cinquanta);
        panelMonete.add(venti);
        panelMonete.add(dieci);
        panelMonete.add(cinque);
        panelMonete.add(a1);
        panelMonete.add(a2);
        panelMonete.add(a3);
        panelMonete.add(a4);
        this.add(panelMonete);
    }

    private void InitpanelCodice() {
        
    }

    private void InitpanelTesto() {
        
    }
    
    
}

