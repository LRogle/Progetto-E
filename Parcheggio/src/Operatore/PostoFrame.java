/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operatore;

import java.awt.GridLayout;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.IOException;
import static java.lang.Math.floor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import parcheggio.Observable;
import parcheggio.Observer;

/**
 *
 * @author luca
 */
public class PostoFrame extends JFrame implements Observer {
    private JPanel panel;
    private PostoComponent PC[] = new PostoComponent[20];

    public PostoFrame() throws IOException {
        this.setTitle("Parcheggio");
        this.setVisible(true);
        this.setSize(1000, 1000);
        this.setLocation(600, WIDTH);
        //this.setLayout(new GridLayout(1,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initPanel();
        initComponent();
        this.add(panel);
 
    }
    
    private void initPanel(){
        panel = new JPanel();
        panel.setLayout(new GridLayout(5,4));
    }
    
    private void initComponent(){
        for(int i=0; i<20;i++){
            PC[i]=new PostoComponent();
        }
        for(int i=0; i<20;i++){
            panel.add(PC[i]);
        }
    }
    
    public void libera(int codice){
        for(int i=0;i<20;i++){
            if(PC[i].getCodice()==codice){
                this.PC[i].setLibero(true);
                this.PC[i].repaint();
            }
        }
    }
    
    public void occupa(int codice){
        while (true) {
            int tmp = postoRandom();
            if (PC[tmp].isLibero()) {
                this.PC[tmp].setLibero(false);
                this.PC[tmp].setCodice(codice);
                this.PC[tmp].repaint();
                break;
            }
        }
        
    }
    
    private int postoRandom(){
        int b = 20; 
        double cod= floor(Math.random() * b);
        int postoRandom=(int) cod;
        return postoRandom;
    }

    @Override
    public void updateOccupa(Observable observable, int codice) {
        occupa(codice);
    }

    @Override
    public void updateLibera(Observable observable, int codice) {
        libera(codice);
    }

    @Override
    public void update(Observable observable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
