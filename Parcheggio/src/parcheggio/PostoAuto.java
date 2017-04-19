/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;

/**
 *
 * @author luca
 */
public class PostoAuto {
    private int numeroPosto;
    private boolean occupato = false;

    public PostoAuto(int numeroPosto) {
        this.numeroPosto = numeroPosto;
    }

    @Override
    public String toString() {
        return "PostoAuto{" + "numeroPosto=" + numeroPosto + ", occupato=" + occupato + '}';
    }

    public int getNumeroPosto() {
        return numeroPosto;
    }

    public void setNumeroPosto(int numeroPosto) {
        this.numeroPosto = numeroPosto;
    }

    public boolean isOccupato() {
        return occupato;
    }

    public void setOccupato(boolean occupato) {
        this.occupato = occupato;
    }
    
    
    
    
}
