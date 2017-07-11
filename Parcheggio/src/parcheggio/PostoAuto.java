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

    /**
     * Getter del numeroPosto.
     * @return numeroPosto
     */
    public int getNumeroPosto() {
        return numeroPosto;
    }

    /**
     * Setter del numeroPosto.
     * @param numeroPosto 
     */
    public void setNumeroPosto(int numeroPosto) {
        this.numeroPosto = numeroPosto;
    }

    /**
     * Verifica se il posto sia occupato o meno.
     * @return occupato
     */
    public boolean isOccupato() {
        return occupato;
    }
    /**
     * Setter dell'attributo occupato del posto.
     * @param occupato 
     */
    public void setOccupato(boolean occupato) {
        this.occupato = occupato;
    }
  
}
