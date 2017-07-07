/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern;

import java.util.ArrayList;

/**
 *
 * @author aench
 */
public abstract class Observable {
    
    private ArrayList<Observer> observers;
    
    public Observable() {
        observers = new ArrayList<>();
    }

//    public int getState() {
//        return 0;
//    }
//
//    public void setState(int state) {
//    }

    public void attach(Observer observer) {
        observers.add(observer);
    }
    public void detach(Observer observer) {
        observers.remove(observer);
    }
    
//    @Override
//    public void notifyObserver(){
//        for ( Observer observer : observers){
//            observer.update(this);
//        }
//    }
    
    public void notifyLibera(int codice){
        for ( Observer observer : observers){
            observer.libera(this, codice);
        }
    }
    
    public void notifyOccupa(int codice){
        for ( Observer observer : observers){
            observer.occupa(this, codice);
        }
    }
}
