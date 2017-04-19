/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;


import static java.lang.Math.floor;
import java.util.Calendar;

/**
 *
 * @author luca
 */
public class Biglietto {
    public static int contabiglietti;
    private int codice=0;
    private int giorno=0;
    private int mese=0;
    private int anno=0;
    private int ore=0;
    private int minuti=0;
    private int secondi=0;
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
    
//codice random puo capitare uguale
//    private int generaCodice(){
//        
//        int b = 10000; // numero massimo
//        double cod= floor(Math.random() * b);
//        codice=(int) cod;
//        return codice;
//    }
    
    private void getDate(){
        Calendar cal =  Calendar.getInstance();
        giorno =cal.get(Calendar.DATE);
        mese = cal.get(Calendar.MONTH) +1;
        anno =cal.get(Calendar.YEAR);
        
        data =  giorno +"/"+ mese +"/"+ anno;
    }

    private void getHours() {
        Calendar cal =  Calendar.getInstance();
        ore=cal.get(Calendar.HOUR);
        minuti=cal.get(Calendar.MINUTE);
        secondi=cal.get(Calendar.SECOND);
        
        ora = cal.get(Calendar.HOUR) + ":"+ cal.get(Calendar.MINUTE) + "." + cal.get(Calendar.SECOND);
    }

    public int getCodice() {
        return codice;
    }

    public int getGiorno() {
        return giorno;
    }

    public int getMese() {
        return mese;
    }

    public int getAnno() {
        return anno;
    }

    public int getOre() {
        return ore;
    }

    public int getMinuti() {
        return minuti;
    }

    public int getSecondi() {
        return secondi;
    }

    public void setConvalida(boolean x){
        convalida.setConvalidato(x);
    }
    
    public void setDataConvalida(String data){
        convalida.setDataConvalida(data);
    }

    public String getData() {
        return data;
    }
    
    public void setOreEMinutiConvalida(int o, int m){
        convalida.setOre(o);
        convalida.setMinuti(m);
    }
    
    @Override
    public String toString() {
        return "Biglietto{" + " codice=" + codice + ", data=" + data + ", ora=" + ora + " "+ '}';
    }

    
}
