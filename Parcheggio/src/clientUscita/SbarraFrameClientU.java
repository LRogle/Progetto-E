/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientUscita;

import clientIngresso.*;
import GUI.*;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author luca
 */
public class SbarraFrameClientU extends JFrame{
    private JPanel panel;
    private Sbarra SA = new Sbarra();
    private SbarraChiusa SC = new SbarraChiusa();

    public SbarraFrameClientU() {
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocation(600, WIDTH);
        this.setLayout(new GridLayout(1,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.SA= new Sbarra();
        this.add(SA);
    }
    
    public void apri(){
        this.SA.setAperta(true);
        this.SA.repaint();
    }
    
    public void chiudi(){
        this.SA.setAperta(false);
        this.SA.repaint();
    }
    
    public void setVisibile(boolean x){
        this.setVisible(x);
    }
    
}
