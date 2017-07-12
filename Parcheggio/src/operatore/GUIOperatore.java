/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operatore;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.floor;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import parcheggio.Observable;
import parcheggio.Observer;
import parcheggio.Parcheggio;

/**
 *
 * @author luca
 */
public class GUIOperatore extends JFrame implements Observer {
    
    private final Parcheggio parcheggio;
    private JPanel panel1;
    private JTextField testo;
    private JPanel panel2;
    private JPanel panel3;
    private final PostoComponent PC[] = new PostoComponent[20];
    private int password;

    public GUIOperatore(Parcheggio parcheggio) throws IOException {
        this.parcheggio = parcheggio;
        this.setTitle("Parcheggio");
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocation(600, WIDTH);
        this.setLayout(new GridLayout(3,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initPanel1();
        initComponentPanel1();
        this.add(panel1);
        initPanel2();
        initPanel3();
        Scanner input = null;
        try {
            input = new Scanner(new File("./File/password"));
        } catch(FileNotFoundException ex){
            System.err.println("Errore nell'apertura del file: password");
        }
        if (input!=null){
            if (input.hasNextLine()){
                String riga = input.nextLine();
                System.out.println(riga);
                this.password=Integer.parseInt(riga);
            }
        }
 
    }
    
    private void initPanel1(){
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(5,4));
    }
    
    private void initPanel2(){
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2,1));
        
        testo = new JTextField();
        testo.setVisible(true);
        testo.setEditable(false);
        int soldi = parcheggio.getCassa().getAmmount();
        if (soldi==0) {
            testo.setText("Non ci sono soldi nella cassa.");
        }
        else {
            testo.setText("Ci sono "+soldi+"Euro nella cassa");
        }
        
        JButton bottone = new JButton("Ritira denaro");
        bottone.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int tmp = parcheggio.getCassa().ritira();
                if (tmp==0) {
                    testo.setText("Non ci sono soldi nella cassa");
                }
                else {
                    testo.setText("Sono stati ritirati "+tmp+"Euro");
                }
            }
        });
        panel2.add(bottone);
        panel2.add(testo);
        this.add(panel2);
    }
    
    private void initPanel3(){
        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(5,1));
        JLabel label1 = new JLabel("Password attuale:");
        JTextField passwordVecchia = new JTextField();
        JLabel label2 = new JLabel("Password nuova:");
        JTextField passwordNuova = new JTextField();
        JButton passwordButton = new JButton("Cambia Password");
        passwordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner input = null;
                try {
                input = new Scanner(new File("./File/password"));
                } catch(FileNotFoundException ex){
                    System.err.println("Errore nell'apertura del file: password");
                }
                if (input!=null){
                    if (input.hasNextLine()){
                        String riga = input.nextLine();
                        System.out.println(riga);
                        password=Integer.parseInt(riga);
                    }
                }
                String vecchia = passwordVecchia.getText();
                if (vecchia.hashCode()==password){
                    PrintWriter output = null;
                    try{
                        output=new PrintWriter("./File/password");
                    } catch(FileNotFoundException ex) {
                        System.err.println("Errore nell'apertura del file password");
                        testo.setText("Errore nell'apertura del file password");
                    }
                    output.println(passwordNuova.getText().hashCode());
                    output.close();
                    testo.setText("Complimenti, la vecchia password e' stata aggiornata.");
                        
                }
                else {
                    testo.setText("Password vecchia non corrisponde.");
                }
            }
        });
        panel3.add(label1);
        panel3.add(passwordVecchia);
        panel3.add(label2);
        panel3.add(passwordNuova);
        panel3.add(passwordButton);
        this.add(panel3);
    }
    
    private void initComponentPanel1(){
        for(int i=0; i<20;i++){
            PC[i]=new PostoComponent();
        }
        for(int i=0; i<20;i++){
            panel1.add(PC[i]);
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
