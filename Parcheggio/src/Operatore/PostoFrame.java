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
import observerpattern.Observable;
import observerpattern.Observer;

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
        this.setSize(500, 500);
        this.setLocation(600, WIDTH);
        this.setLayout(new GridLayout(1,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initPanel();
        initComponent();
        this.add(panel);
 
    }
    
    public void initPanel(){
        panel = new JPanel();
        panel.setLayout(new GridLayout(5,4));
    }
    
    public void initComponent(){
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
    
    public void occupa(int rand, int codice){
        while(!PC[rand].isLibero()){
        PC[rand]=PC[postoRandom()];
        }
        this.PC[rand].setLibero(false);
        this.PC[rand].setCodice(codice);
        this.PC[rand].repaint();
    }
    
    private int postoRandom(){
        int b = 20; 
        double cod= floor(Math.random() * b);
        int postoRandom=(int) cod;
        return postoRandom;
    }

    @Override
    public void occupaObserver(Observable observable, int codice) {
        occupa(postoRandom(), codice);
    }

    @Override
    public void liberaObserver(Observable observable, int codice) {
        libera(codice);
    }

    @Override
    public void setState(boolean state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Observable observable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getStato() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
