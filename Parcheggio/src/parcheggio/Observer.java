/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;

/**
 *
 * @author aench
 */
public interface Observer {

    public void updateOccupa(int codice);
    public void updateLibera(int codice);
    
}