/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;

import observerpattern.Observer;

/**
 *
 * @author aench
 */
public class Semaforo extends Observer {
    
    private int numPostiLiberi;

    @Override
    public void setState(int state) {
        numPostiLiberi = state;
    }

    @Override
    public int getState() {
        return numPostiLiberi;
    }
    
    
}
