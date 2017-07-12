/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientUscita;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author luca
 */
public class SbarraFrameClientU extends JFrame{
    private JPanel panel;
    private SbarraClientU sbarra = new SbarraClientU();


    public SbarraFrameClientU() {
        this.setTitle("Sbarra Uscita");
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocation(600, WIDTH);
        this.setLayout(new GridLayout(1,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.sbarra= new SbarraClientU();
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
    
    
}
