/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;


import java.util.Calendar;

/**
 *
 * @author luca
 */
public class Biglietto {
    public static int contabiglietti;
    private int codice;
    private int giorno;
    private int mese;
    private int anno;
    private int ore;
    private int minuti;
    private int secondi;
    private String data;
    private String ora;
    Convalida convalida= new Convalida();
    
    public Biglietto() {
        codice = incrementaBiglietti();
        getDate();
        getHours();
    }
    
    private static int incrementaBiglietti(){
        contabiglietti++;
        return contabiglietti;
    }
    
    public void getDate(){
        Calendar cal = Calendar.getInstance();
        giorno = cal.get(Calendar.DATE);
        mese = cal.get(Calendar.MONTH) +1;
        anno = cal.get(Calendar.YEAR);
        data =  giorno +"/"+ mese +"/"+ anno;
    }

    public void getHours() {
        Calendar cal = Calendar.getInstance();
        ore = cal.get(Calendar.HOUR);
        minuti = cal.get(Calendar.MINUTE);
        secondi = cal.get(Calendar.SECOND);
        ora = cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + "." + cal.get(Calendar.SECOND);
    }

    /**
     * Getter del codice del biglietto.
     * @return codice biglietto
     */
    public int getCodice() {
        return codice;
    }
    
    /**
     * Getter del giorno di erogazione del biglietto.
     * @return giorno di erogazione
     */
    public int getGiorno() {
        return giorno;
    }

    /**
     * Getter del mese di erogazione del biglietto.
     * @return mese di erogazione.
     */
    public int getMese() {
        return mese;
    }

    /**
     * Getter dell'anno di erogazione del biglietto.
     * @return anno di erogazione
     */
    public int getAnno() {
        return anno;
    }

    /**
     * Getter dell'ora di erogazione del biglietto.
     * @return ora di erogazione
     */
    public int getOre() {
        return ore;
    }

    /**
     * Getter del minuto di erogazione del biglietto.
     * @return minuto di erogazione
     */
    public int getMinuti() {
        return minuti;
    }

    /**
     * Getter del secondo di erogazione del biglietto.
     * @return secondi di erogazione.
     */
    public int getSecondi() {
        return secondi;
    }

    /**
     * Setter della convalida del biglietto.
     * @param x 
     */
    public void setConvalida(boolean x){
        convalida.setConvalidato(x);
    }
    
    /**
     * Setter della data di convalida del biglietto.
     * @param data 
     */
    public void setDataConvalida(String data, int day, int month, int year){
        convalida.setDay(day);
        convalida.setMonth(month);
        convalida.setYear(year);
        convalida.setDataConvalida(data);
    }

    /**
     * Getter della data di convalida del biglietto.
     * @return data di convalida
     */
    public String getDataConvalida(){
        return convalida.getDataConvalida();
    }
    
    /**
     * Getter della data di erogazione del biglietto.
     * @return data di erogazione
     */
    public String getData() {
        return data;
    }
    
    /**
     * Setter dei minuti e delle ore di convalida del biglietto.
     * @param o
     * @param m 
     */
    public void setOreEMinutiConvalida(int o, int m){
        convalida.setOre(o);
        convalida.setMinuti(m);
    }
    
    @Override
    public String toString() {
        return "Biglietto{" + " codice=" + codice + ", data=" + data + ", ora=" + ora + " "+ '}';
    }
}
