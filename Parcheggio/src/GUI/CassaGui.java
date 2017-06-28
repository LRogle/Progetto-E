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
public class CassaGui extends JFrame{

    private Parcheggio P;
    JPanel Pagamento;
    JPanel panelMonete;
    JPanel panelTesto;
    
    JTextField testo = new JTextField("BENVENUTO");
    JLabel biglietto=new JLabel("INSERISCI CODICE");
    JButton bottone = new JButton("CONFERMA CODICE");

    JLabel uno = new JLabel("\t1 euro");
    JLabel cinquanta = new JLabel("\t50 cent");
    JLabel venti = new JLabel("\t20 cent");
    JLabel dieci = new JLabel("\t10 cent");
    JLabel cinque = new JLabel("\t5 cent");
    JButton bottonepaga = new JButton("PAGA ORA");
    
    JTextField codice =new JTextField("");
    JTextField a5 = new JTextField("0");
    JTextField a4 = new JTextField("0");
    JTextField a3 = new JTextField("0");
    JTextField a2 = new JTextField("0");
    JTextField a1 = new JTextField("0");
    
    String codicebiglietto = "";
    
    
    public CassaGui(Parcheggio P) throws Exception{
        this.P= P;
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLayout(new GridLayout(3,1));
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
        Pagamento.setLayout(new GridLayout(3,1));
        Pagamento.add(biglietto);
        Pagamento.add(codice);
        Pagamento.add(bottone);
                
        bottone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s= codice.getText();
                codicebiglietto = s;
                if (codicebiglietto.equals("")) {
                    testo.setText("Codice non valido");
                }else {
                    if(P.getBigliettoAttivo(Integer.parseInt(s))!=null){
                    testo.setText("PAGARE:\t"+P.getCassa().calcolaImporto(P.getBigliettoAttivo(Integer.parseInt(s))));
                    }
                }
            }
        });
        this.add(Pagamento);
    }
    
    public void InitpanelMonete(){
        
        panelMonete = new JPanel();
        panelMonete.setLayout(new GridLayout(2,5));
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
        testo.setVisible(true);
        testo.setEditable(false);
        panelTesto = new JPanel();
        panelTesto.setLayout(new GridLayout(2,1));
        panelTesto.add(bottonepaga);
        panelTesto.add(testo);
        bottonepaga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (codicebiglietto.equals("")) {
                    testo.setText("prima devi inserire il codice!");
                }else {
                    if(P.PagamentoGUI(Integer.parseInt(a1.getText()), Integer.parseInt(a2.getText()), Integer.parseInt(a3.getText()), Integer.parseInt(a4.getText()), Integer.parseInt(a5.getText()), Integer.parseInt(codicebiglietto),"contanti")){
                        testo.setText("Pagamento avvenuto correttamente, il biglietto è stato convalidato in data: "+P.getBigliettoUscita(Integer.parseInt(codicebiglietto)).getDataConvalida());
                    }else{
                        testo.setText("Non è stato possibile completare il pagamento e convalidare il biglietto");
                    }
                }
            }
        });
        this.add(panelTesto);
    }
} 
    

