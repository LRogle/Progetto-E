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
    
    //funzione che deve essere utilizzata quando il conducente inserisce il codice [biglietto] 
    //e poi preme il bottone per verificare se è convalidato 
    public boolean controllaBiglietto(Biglietto B){
        getDate();
        getHours();
        if(B.convalida.isConvalidato()){
            //controllare il tempo dopo il pagamento                      
            //supponiamo che il tempo per uscire sia 15 minuti 
            if(B.convalida.getDataConvalida().equals(data)){
                if(minuti-B.convalida.getMinuti()<=15){   
                    System.out.println("Grazie. Arrivederci!");
                    return true;
                }
            }else{
                System.out.println("Problema. Permanenza eccesiva dopo il pagamento");
                return false;
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
