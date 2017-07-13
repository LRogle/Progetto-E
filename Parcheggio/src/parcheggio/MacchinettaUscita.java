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
     * Verifica se è stato convalidato, se è stato convalidato, verifico che la data attuale siano corrispondenti con quella del biglietto.
     * Nel caso in cui il tempo successivo al pagamento sia minore di 15 minuti, i controlli vengono effettuati con successo.
     * Altrimenti, non è possibile l'uscita dal parcheggio, senza aver ricevuto una conferma.
     * @param B
     * @return true, se i controlli sul biglietto hanno esito positivo, altrimenti false
     */
    public boolean controllaBiglietto(Biglietto B){
        getDate();
        getHours();
        if(B.convalida.isConvalidato()){
            if(B.convalida.getDataConvalida().equals(data)){
                if((minuti-B.convalida.getMinuti())<=15){
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
