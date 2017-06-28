/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import parcheggio.Parcheggio;

/**
 *
 * @author luca
 */
public class testGUI {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws Exception {
        
        Parcheggio parcheggio = new Parcheggio();
        IngressoGUI G = new IngressoGUI(parcheggio);
        //FinestraSemaforo finestraSemaforo = new FinestraSemaforo();
        //parcheggio.attach(finestraSemaforo);
        //parcheggio.notifyObserver();
        CassaGui GC= new CassaGui(parcheggio);
        UscitaGUI GU = new UscitaGUI(parcheggio);
    }
    
}
