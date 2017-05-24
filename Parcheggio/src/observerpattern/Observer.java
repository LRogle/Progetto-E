/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern;

import observerpattern.Observable;

/**
 *
 * @author aench
 */
public interface Observer {

    public int getState();
    public void setState(int state);
    public void update(Observable observable);

}