/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientCassa;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Gabri
 */
public class GUICassa extends JFrame{
    JPanel Pagamento;
    JPanel panelMonete;
    JPanel panelMetodo;
    JPanel panelTesto;
    
    JButton carta = new JButton("CARTA");
    
    JTextField testo = new JTextField("BENVENUTO");
    JLabel biglietto=new JLabel("INSERISCI CODICE");
    JButton bottone = new JButton("CONFERMA CODICE");

    JLabel uno = new JLabel("\t20 €");
    JLabel cinquanta = new JLabel("\t10 €");
    JLabel venti = new JLabel("\t5 €");
    JLabel dieci = new JLabel("\t2 €");
    JLabel cinque = new JLabel("\t1 €");
    JButton bottonepaga = new JButton("PAGA ORA");
    
    JTextField codice =new JTextField("");
    JTextField a5 = new JTextField("0");
    JTextField a4 = new JTextField("0");
    JTextField a3 = new JTextField("0");
    JTextField a2 = new JTextField("0");
    JTextField a1 = new JTextField("0");
    
    String codicebiglietto="";
    BufferedReader in;
    PrintWriter out;
    
    int minutilimite;
    
    public GUICassa( PrintWriter out, BufferedReader in) throws Exception{
        this.setTitle("Cassa");
        this.in = in;
        this.out = out;
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLayout(new GridLayout(4,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InitComponent();
    }

    public void InitComponent(){
        InitpanelPagamento();
        InitpanelMonete();
        InitpanelMetodo();
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
                    testo.setText("prima devi inserire il codice!");
                }
                else {
                minutilimite=getMinutiAttuali()+5;
                out.println("Pagamento");
                out.println(s);
                String prezzo;
                try {
                    prezzo = in.readLine();
                    if(prezzo.equals("Biglietto non trovato tra quelli attivi")){
                        testo.setText(prezzo);
                    }else{
                    testo.setText("PAGARE:\t"+prezzo+"€");
                    bottonepaga.enable();
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(GUICassa.class.getName()).log(Level.SEVERE, null, ex);
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
        panelMonete.add(a5);//1€
        panelMonete.add(a4);//2€
        panelMonete.add(a3);//5€
        panelMonete.add(a2);//10€
        panelMonete.add(a1);//20€
        this.add(panelMonete);
    }

    private void InitpanelMetodo(){
        panelMetodo = new JPanel();
        panelMetodo.setLayout(new GridLayout(1,1));
        panelMetodo.add(carta);
        carta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (codicebiglietto.equals("")) {
                    testo.setText("prima devi inserire il codice!");
                }
                else {
                    if(getMinutiAttuali()>minutilimite){
                        testo.setText("Biglietto non convalidato, tempo scaduto. Riprovare");
                    } else {
                        out.println("Monetine");
                        out.println(a1.getText());
                        out.println(a2.getText());
                        out.println(a3.getText());
                        out.println(a4.getText());
                        out.println(a5.getText());
                        out.println(codicebiglietto);
                        out.println("carta");
                        AzzeraMonete();
                        String dataConvalida;
                        String resto;
                        try {
                            String controllo = in.readLine();
                            dataConvalida = in.readLine();
                            resto = in.readLine();
                            
                        if(controllo.equals("pronto")){
                            testo.setText("Pagamento avvenuto correttamente, il biglietto è stato convalidato in data: "+dataConvalida);
                        } else if (controllo.equals("abort")){
                            
                            testo.setText("Non è stato possibile completare il pagamento e convalidare il biglietto");
                        }
                        } catch (IOException ex) {
                            Logger.getLogger(GUICassa.class.getName()).log(Level.SEVERE, null, ex);
                        }   
                    }
                }  
            }
        });
        this.add(panelMetodo);
    }
    
    public void InitpanelTesto() {
        testo.setVisible(true);
        testo.setEditable(false);
        panelTesto = new JPanel();
        panelTesto.setLayout(new GridLayout(2,1));
        panelTesto.add(bottonepaga);
        panelTesto.add(testo);
//        bottonepaga.disable();
        bottonepaga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (codicebiglietto.equals("")) {
                    testo.setText("prima devi inserire il codice!");
                }
                else {
                    if (codicebiglietto.equals("")) {
                    testo.setText("prima devi inserire il codice!");
                    }else {
                        out.println("Monetine");
                        out.println(a1.getText());
                        out.println(a2.getText());
                        out.println(a3.getText());
                        out.println(a4.getText());
                        out.println(a5.getText());
                        out.println(codicebiglietto);
                        out.println("contanti");
                        AzzeraMonete();
                        String dataConvalida;
                        String resto;
                        try {
                            String controllo = in.readLine();
                            dataConvalida = in.readLine();
//                            resto=in.readLine();
                            if(controllo.equals("pronto")){
                                testo.setText("Pagamento avvenuto correttamente, il biglietto è stato convalidato in data: "+dataConvalida);
                            }else if (controllo.equals("abort")){
                                testo.setText("Non è stato possibile completare il pagamento e convalidare il biglietto");
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(GUICassa.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                    }
                }
            }
        });
        this.add(panelTesto);
    }
    
    private int getMinutiAttuali(){
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.MINUTE);
    }
    
    private void AzzeraMonete(){
        a1.setText("0");
        a2.setText("0");
        a3.setText("0");
        a4.setText("0");
        a5.setText("0");
    }
}
