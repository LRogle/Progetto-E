/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio.observerpattern;

import parcheggio.observerpattern.Observable;

/**
 *
 * @author aench
 */
public abstract class Observer {

    public int getState() {
        return -1;
    }

    public void setState(int state) {
    }
    
    
    public void update(Observable observable){
        setState(observable.getState());
    }
}
