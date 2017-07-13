/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientIngresso;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author luca
 */
public class SbarraFrameClient extends JFrame{
    private JPanel panel;
    private SbarraClient sbarra = new SbarraClient();
    
    /**
     * Viene creata la rappresentazione grafica della sbarra che permette l'ingresso al parcheggio.
     */
    public SbarraFrameClient() {
        this.setTitle("Sbarra Ingresso");
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocation(600, WIDTH);
        this.setLayout(new GridLayout(1,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.sbarra= new SbarraClient();
        this.add(sbarra);
    }
    
    /**
     * Apertura della sbarra.
     */
    public void apri(){
        this.sbarra.setAperta(true);
        this.sbarra.repaint();
    }
    
    /**
     * Chiusura della sbarra.
     */
    public void chiudi(){
        this.sbarra.setAperta(false);
        this.sbarra.repaint();
    }

    
}
