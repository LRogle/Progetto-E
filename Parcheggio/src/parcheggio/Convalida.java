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
public class Convalida {
    private String dataConvalida = null;
    private boolean convalidato = false;
    private int ore=0;
    private int minuti=0;
    private int secondi=0;

    public String getDataConvalida() {
        return dataConvalida;
    }

    public void setDataConvalida(String dataConvalida) {
        this.dataConvalida = dataConvalida;
    }

    public boolean isConvalidato() {
        return convalidato;
    }

    public void setConvalidato(boolean convalidato) {
        this.convalidato = convalidato;
    }

    public int getOre() {
        return ore;
    }

    public void setOre(int ore) {
        this.ore = ore;
    }

    public int getMinuti() {
        return minuti;
    }

    public void setMinuti(int minuti) {
        this.minuti = minuti;
    }

    public int getSecondi() {
        return secondi;
    }

    public void setSecondi(int secondi) {
        this.secondi = secondi;
    }
    
    @Override
    public String toString() {
        return "Convalida{" + "dataConvalida=" + dataConvalida + ", convalidato=" + convalidato + '}';
    }
    
    
    
}
