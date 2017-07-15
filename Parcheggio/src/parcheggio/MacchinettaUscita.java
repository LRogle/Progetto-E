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
public class MacchinettaUscita{
    
    private int giorno=0;
    private int mese=0;
    private int anno=0;
    private int ore=0;
    private int minuti=0;
    private int secondi=0;
    private String data;
    private String ora;
    
    /**
     * Viene ricevuto in ingresso il biglietto, preleva la data e l'ora attuale.
     * Verifica se il biglietto è stato convalidato; in caso affermativo, si verifica che la data attuale sia corrispondente a quella del biglietto.
     * L’uscita del veicolo dal parcheggio deve avvenire entro 15 minuti dal momento della convalida. 
     * In tal caso, i controlli vengono effettuati con successo; 
     * altrimenti, senza aver ricevuto una conferma, non è possibile l'uscita dal parcheggio.
     * @param B
     * @return true, se i controlli sul biglietto hanno esito positivo, altrimenti false
     */
    public boolean controllaBiglietto(Biglietto B){
        getDate();
        getHours();
        if(B.convalida.isConvalidato()){
            if(B.convalida.getDataConvalida().equals(data)){
                int annipermanenza=anno-B.convalida.getYear();
                int mesipermanenza=mese-B.convalida.getMonth();
                    if(mesipermanenza<0){
                        mesipermanenza=12+mesipermanenza;
                        annipermanenza--;
                    }
                int giornipermanenza=giorno-B.convalida.getDay();
                    if(giornipermanenza<0){
                        giornipermanenza=28+giornipermanenza;
                        mesipermanenza--;
                    }
                int orepermanenza=ore-B.convalida.getOre();
                    if(orepermanenza<0){
                        orepermanenza=12+orepermanenza;
                        giornipermanenza--;
                    }
                int minpermanenza=minuti-B.convalida.getMinuti();
                    if(minpermanenza<0){
                        minpermanenza=60+minpermanenza;
                    }

                int minutitotali = (annipermanenza*(12*28*1440))+(mesipermanenza*(28*1440))+(giornipermanenza*1440)+(orepermanenza*60)+(minpermanenza);
                
                if(minutitotali<=15){
                    System.out.println("Grazie. Arrivederci!");
                    return true;
                }else{
                    System.out.println("Problema. Permanenza eccesiva dopo il pagamento");
                return false;
                } 
            }
        }else{
            System.out.println("Biglietto non convalidato, andare a pagare");
            return false;
        }    
        return false;
    }
    
    private void getDate(){
        Calendar cal = Calendar.getInstance();
        giorno = cal.get(Calendar.DATE);
        mese = cal.get(Calendar.MONTH)+1;
        anno = cal.get(Calendar.YEAR);
        data =  giorno +"/"+ mese +"/"+ anno;
    }

    private void getHours() {
        Calendar cal = Calendar.getInstance();
        ore=cal.get(Calendar.HOUR);
        minuti=cal.get(Calendar.MINUTE);
        secondi=cal.get(Calendar.SECOND);
        ora = cal.get(Calendar.HOUR) + ":"+ cal.get(Calendar.MINUTE) + "." + cal.get(Calendar.SECOND);
    }
    
}
