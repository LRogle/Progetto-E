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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author cl418739
 */
public class GUIUscita extends JFrame {
    private JPanel panel1;   
   
    private SbarraClient S;
    private PrintWriter out;
    private BufferedReader in;
     
    public GUIUscita (PrintWriter out,BufferedReader in){
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
        
    }

    private void initPanel1() {
        JButton button = new JButton("USCITA");
        JTextField text = new JTextField();
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,2));
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String cod=text.getText();
                out.println("Arrivederci");
                out.println(cod);
                try {
                    String s =in.readLine();
                    if(s.equals("Grazie. Arrivederci")){
                        S.setVisibile(false);      
                        S = new SbarraClient(true);
                    }else{
                     S.setVisibile(false);   
                     S = new SbarraClient(false); 
                    }
                } catch (IOException ex) {
                    Logger.getLogger(GUIUscita.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
            this.add(panel1);
        
    }



    
}
