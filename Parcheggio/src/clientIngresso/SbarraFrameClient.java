/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientIngresso;

import GUI.*;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author luca
 */
public class SbarraFrameClient extends JFrame{
    private JPanel panel;
    private Sbarra sbarra = new Sbarra();
    
    public SbarraFrameClient() {
        this.setTitle("Sbarra Ingresso");
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocation(600, WIDTH);
        this.setLayout(new GridLayout(1,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.sbarra= new Sbarra();
        this.add(sbarra);
    }
    
    public void apri(){
        this.sbarra.setAperta(true);
        this.sbarra.repaint();
    }
    
    public void chiudi(){
        this.sbarra.setAperta(false);
        this.sbarra.repaint();
    }
    
    public void setVisibile(boolean x){
        this.setVisible(x);
    }
    
}
