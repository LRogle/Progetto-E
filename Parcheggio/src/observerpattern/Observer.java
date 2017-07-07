/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern;

/**
 *
 * @author aench
 */
public interface Observer {

    public boolean getStato();
    public void setState(boolean state);
    public void update(Observable observable);
    public void occupa(Observable observable, int codice);
    public void libera(Observable observable, int codice);
}