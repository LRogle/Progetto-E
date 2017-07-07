///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package GUI;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JTextArea;
//import observerpattern.Observable;
//import observerpattern.Observer;
//
///**
// *
// * @author aench
// */
//public class FinestraSemaforo extends JFrame implements Observer {
//    
//    private JPanel panelCenter;
//    private JTextArea text;
//    private int numPostiLiberi;
//
//    public FinestraSemaforo() {
//        super("Semaforo");
//        this.setVisible(true);
//        this.setSize(100, 100);
//        this.setLocation(0, 600);
//        this.setBackground(Color.gray);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        initComponent();
//        add(panelCenter,BorderLayout.CENTER);
//    }
//    
//    private void initComponent() {
//        panelCenter = new JPanel();
//        text = new JTextArea();
//        text.setText(String.valueOf(this.getState()));
//        text.setEditable(false);
//        panelCenter.add(text);
//  
//    }
//
//    @Override
//    public void setState(int state) {
//        numPostiLiberi = state;
//    }
//
//    @Override
//    public int getState() {
//        return numPostiLiberi;
//    }
//    
////    public void update(Observable observable) {
//////        setState(observable.getState());
////        //System.out.println("stato: "+this.getState());
////        text.setText(String.valueOf(this.getState()));
////        if (this.getState()==0) {
////            text.setBackground(Color.red);
////        } else if (this.getState()<0) {
////            System.out.println("ERRORE!");
////        } else {
////            text.setBackground(Color.green);
////        }
////    }
//
//    @Override
//    public void occupa(Observable observable) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void libera(Observable observable) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//}
