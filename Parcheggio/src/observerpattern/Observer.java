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

    public void update(Observable observable);
    public void updateOccupa(Observable observable, int codice);
    public void updateLibera(Observable observable, int codice);
    
}