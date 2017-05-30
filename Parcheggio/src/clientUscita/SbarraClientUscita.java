/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientUscita;

import clientIngresso.*;
import GUI.*;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author luca
 */
public class SbarraClientUscita extends JFrame{
    private JPanel panel;
    private SbarraAperta SA = new SbarraAperta();
    private SbarraChiusa SC = new SbarraChiusa();
    

    public SbarraClientUscita(boolean x) {
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocation(600, WIDTH);
        this.setLayout(new GridLayout(1,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(x)
            panel = SA.functionMain();
        else
            panel = SC.functionMain();
        this.add(panel);
    }
    
    public void setVisibile(boolean x){
        this.setVisible(x);
    }


    
    
}
