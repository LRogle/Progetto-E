/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operatore;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import parcheggio.Server;

/**
 *
 * @author luca
 */
public class GUIOperatoreLogin extends JFrame {
    
    private int password;
    
    private final ArrayList<Server> observers;
    private boolean connected;
    
    private JPanel panel1;    //password
    private final JTextField testo = new JTextField("");
    private JPanel panel2;  //testo
    
    public GUIOperatoreLogin(Server server){
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
        this.setTitle("Finestra Login Operatore");
        this.observers = new ArrayList<>();
        observers.add(server);
        this.setVisible(true);
        this.setSize(500, 200);
        this.setBackground(Color.gray);
        this.setLayout(new GridLayout(2,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponent();
    }
    
    private void initComponent() {
        initPanel1();
        initPanel2();
    }
    
    private void initPanel1() {
        
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3,1));
        
        JLabel label = new JLabel("Inserire password:");
        JTextField text = new JTextField();
        text.setSize(10, 5);
        JButton bottone = new JButton("Accedi");
        bottone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = text.getText();
                if (s.hashCode()==password) {
                    testo.setText("Benvenuto operatore!");
                    notifyObservers();
                }
                else {
                    testo.setText("Password errata!");
                }
            }
        });
        
        panel1.add(label);
        panel1.add(text);
        panel1.add(bottone);
        
        this.add(panel1);
    }

    private void initPanel2() {
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,1));
        testo.setVisible(true);
        testo.setEditable(false);
        panel2.add(testo);
        
        this.add(panel2);
        
    }
    
    public void quit(){
        this.setVisible(false);
    }
    
    private void notifyObservers() {
        for (Server server : observers) {
            server.update();
        }
    }
    
}

