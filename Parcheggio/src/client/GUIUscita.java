/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.swing.JFrame;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
