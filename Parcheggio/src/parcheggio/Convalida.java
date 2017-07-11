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

    /**
     * Getter della dataConvalida.
     * @return dataConvalida
     */
    public String getDataConvalida() {
        return dataConvalida;
    }

    /**
     * Setter della dataConvalida.
     * @param dataConvalida 
     */
    public void setDataConvalida(String dataConvalida) {
        this.dataConvalida = dataConvalida;
    }

    /**
     * Verifica se il biglietto sia convalidato o meno.
     * @return convalidato
     */
    public boolean isConvalidato() {
        return convalidato;
    }

    /**
     * Setter della convalida del biglietto.
     * @param convalidato 
     */
    public void setConvalidato(boolean convalidato) {
        this.convalidato = convalidato;
    }
    
    /**
     * Getter delle ore dell'orario di convalida.
     * @return ore
     */
    public int getOre() {
        return ore;
    }

    /**
     * Setter delle ore dell'orario di convalida.
     * @param ore 
     */
    public void setOre(int ore) {
        this.ore = ore;
    }

    /**
     * Getter dei minuti dell'orario di convalida.
     * @return minuti
     */
    public int getMinuti() {
        return minuti;
    }

    /**
     * Setter dei minuti dell'orario di convalida.
     * @param minuti 
     */
    public void setMinuti(int minuti) {
        this.minuti = minuti;
    }

    /**
     * Getter dei secondi di convalida.
     * @return secondi
     */
    public int getSecondi() {
        return secondi;
    }

    /**
     * Setter dei secondi di convalida.
     * @param secondi 
     */
    public void setSecondi(int secondi) {
        this.secondi = secondi;
    }
    
    @Override
    public String toString() {
        return "Convalida{" + "dataConvalida=" + dataConvalida + ", convalidato=" + convalidato + '}';
    }
    
}
