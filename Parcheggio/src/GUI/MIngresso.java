/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import parcheggio.Parcheggio;

/**
 *
 * @author luca
 */
public class MIngresso extends JFrame{
    private Parcheggio P;
    private JPanel panel1;    //bottone,codice biglietto erogato
    private JPanel panel2;    //decidere per la sbarra il semaforo e i posti liberi
    private SbarraChiusa SC = new SbarraChiusa(); 
    private SbarraAperta SA = new SbarraAperta(); 
    private Sbarra S;
    private JTextField postiliberi = new JTextField(); 
    
    
    public MIngresso(Parcheggio parcheggio){
        this.P=parcheggio;
        this.setVisible(true);
        this.setSize(500, 500);
        this.setBackground(Color.gray);
        this.setLayout(new GridLayout(2,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponent();
        S = new Sbarra(false);
    }

    private void initComponent() {
        initPanel1();
        initPanel2();
    }

    private void initPanel1() {
        JButton button = new JButton("BIGLIETTO");
        JTextField text = new JTextField();
        

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,2));
        panel1.add(button);
        panel1.add(text);
        text.setName("Codice");
        text.setEditable(false);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int ing = P.IngressoGUI();
                text.setText("CODICE BIGLIETTO:\t"+ing+"");
                if(ing!=0){
                    S.setVisibile(false);
                    S = new Sbarra(true);
//                    try {          
//                            Thread.sleep(2500);    // il parametro in input è il tempo espresso in millesimi
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(MIngresso.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    S = new Sbarra(false);
                    postiliberi.setText("POSTI LIBERI:\t"+P.contaPostiLiberi()+"");
                }else{
                    text.setText(null);
                    S.setVisibile(false);
                    S = new Sbarra(false);}
            }
        });
        this.add(panel1);
    }

    public void initPanel2() {
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,1));
        panel2.add(postiliberi);
        postiliberi.setEditable(false);
        this.add(panel2);
        
    }
    
    
}
