/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import parcheggio.Parcheggio;

/**
 *
 * @author Gabri
 */
public class TestCassa {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        Parcheggio p=new Parcheggio();
                p.Ingresso();
        CassaGui POORCODOOO= new CassaGui(p);

    }
    
}
