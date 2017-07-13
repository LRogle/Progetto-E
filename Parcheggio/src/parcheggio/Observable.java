/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;

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
    
    /**
     * Aggiunge un osservatore alla lista degli osservatori.
     * @param observer 
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }
    
    /**
     * Rimuove un osservatore alla lista degli osservatori.
     * @param observer 
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }
    

    /**
     * Notifica l'osservatore che viene invocato il metodo updateLibera().
     * @param codice 
     */
    public void notifyLibera(int codice){
        for ( Observer observer : observers){
            observer.updateLibera(this, codice);
        }
    }
    
    /**
     *Notifica l'osservatore che viene invocato il metodo notifyLibera(). 
     * @param codice 
     */
    public void notifyOccupa(int codice){
        for ( Observer observer : observers){
            observer.updateOccupa(this, codice);
        }
    }
}
