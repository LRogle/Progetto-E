/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import parcheggio.Parcheggio;

/**
 *
 * @author Gabri
 */


/**
 *
 * @author Gabri
 */
public class CassaGui extends JFrame{

    private Parcheggio P;
    JPanel Pagamento;
    JPanel panelMonete;
    JPanel panelTesto;
    
    JTextArea testo = new JTextArea("BENVENUTO");
    JLabel biglietto=new JLabel("INSERISCI CODICE");

    JLabel uno = new JLabel("\t1 euro");
    JLabel cinquanta = new JLabel("\t50 cent");
    JLabel venti = new JLabel("\t20 cent");
    JLabel dieci = new JLabel("\t10 cent");
    JLabel cinque = new JLabel("\t5 cent");
    
    JTextField codice =new JTextField();
    JTextField a5 = new JTextField();
    JTextField a4 = new JTextField();
    JTextField a3 = new JTextField();
    JTextField a2 = new JTextField();
    JTextField a1 = new JTextField();

    
    
    public CassaGui(Parcheggio P) throws Exception{
        this.P= P;
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLayout(new GridLayout(6,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InitComponent();
    }

    public void InitComponent() {
        InitpanelPagamento();
        InitpanelMonete();
        InitpanelTesto();
    }

    public void InitpanelPagamento(){
        
        Pagamento = new JPanel();
        Pagamento.setLayout(new GridLayout(2,2));
        Pagamento.add(biglietto);
        Pagamento.add(codice);
        String s= codice.getText();
        if (s.equals(""))
            s = "0";
        testo.setText(P.Calcolo(Integer.parseInt(s)));
        this.add(Pagamento);
       
    }
    
    public void InitpanelMonete(){
        
        panelMonete = new JPanel();
        panelMonete.setLayout(new GridLayout(2,4));
        panelMonete.add(uno);
        panelMonete.add(cinquanta);
        panelMonete.add(venti);
        panelMonete.add(dieci);
        panelMonete.add(cinque);
        panelMonete.add(a5);
        panelMonete.add(a4);
        panelMonete.add(a3);
        panelMonete.add(a2);
        panelMonete.add(a1);
        this.add(panelMonete);
    }

    public void InitpanelTesto() {
        testo.setEditable(false);
        panelTesto = new JPanel();
        panelTesto.add(testo);
        this.add(panelTesto);
    }
}
    

