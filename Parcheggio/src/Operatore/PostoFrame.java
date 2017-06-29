/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operatore;

import java.awt.GridLayout;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.floor;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author luca
 */
public class PostoFrame extends JFrame{
    private JPanel panel;
    private PostoComponent PC[] = new PostoComponent[20];
    
    BufferedReader in;
    PrintWriter out;

    public PostoFrame(PrintWriter out, BufferedReader in) throws IOException {
        this.setTitle("Parcheggio");
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocation(600, WIDTH);
        this.setLayout(new GridLayout(1,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.in=in;
        this.out=out;
        initPanel();
        initComponent();
        this.add(panel);
        
//        funziona bisogna fare cambiare colore quando entra e esce una macchina dal parcheggio usando Client e Server     
//        occupa(postoRandom());

//        for(;;){
//            String operazione = in.readLine();
//            if(operazione.equals("occupa")){
//                occupa(postoRandom());
//            } 
//            if(operazione.equals("libera")){
//                libera(postoRandom());
//            } 
//        }
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
    
    public void libera(int n){
        while(PC[n].isLibero()){
        PC[n]=PC[postoRandom()];
        }
        this.PC[n].setLibero(true);
        this.PC[n].repaint();
        
    }
    
    public void occupa(int n){
        while(!PC[n].isLibero()){
        PC[n]=PC[postoRandom()];
        }
        this.PC[n].setLibero(false);
        this.PC[n].repaint();
    }
    
    public void setVisibile(boolean x){
        this.setVisible(x);
    }

    
    
    private int postoRandom(){
        int b = 20; 
        double cod= floor(Math.random() * b);
        int postoRandom=(int) cod;
        return postoRandom;
    }
    
}
