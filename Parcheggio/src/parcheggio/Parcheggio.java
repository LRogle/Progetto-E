/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;

import java.util.ArrayList;

/**
 *
 * @author luca
 */
public class Parcheggio {
    
    private int nOccupati=0;
    private int nMaxParcheggi=20;
    ArrayList<Biglietto> BigliettiAttivi = new ArrayList();
    ArrayList<Biglietto> BigliettiUscita = new ArrayList();
    ArrayList<Biglietto> RegistroBiglietti = new ArrayList();
    MacchinettaIngresso MI = new MacchinettaIngresso();
    Cassa C = new Cassa();
    MacchinettaUscita MU = new MacchinettaUscita();
    
    
    public int displayPostiLiberi(){
        int liberi=0;
        liberi = nMaxParcheggi - nOccupati;
        return liberi;
    }
    
    public Biglietto Ingresso(){
        if(displayPostiLiberi()!=0){ 
            Biglietto B=MI.erogaBiglietto();
            BigliettiAttivi.add(B);
            nOccupati++;
            return B;}
        else
            return null;
    }
    
    public void stampaBigliettiAttivi(){
        for (Biglietto BigliettiAttivi1 : BigliettiAttivi) {
            System.out.println(BigliettiAttivi1.toString());
        }
    }
    
    public void stampaBigliettiUscita(){
        for (Biglietto BigliettiUscita1 : BigliettiUscita) {
            System.out.println(BigliettiUscita1.toString());
        }
    }
    
    public void stampaRegistroBiglietti(){
        for (Biglietto Biglietti : RegistroBiglietti) {
            System.out.println(Biglietti.toString());
        }
    }
    
    //Metodo per la ricerca del biglietto quando si inserisce il codice(biglietto) nella cassa
    public Biglietto getBigliettoAttivo(int cod){
        for(Biglietto BigliettiAttivi1 : BigliettiAttivi){
            if(BigliettiAttivi1.getCodice()==cod)
                return BigliettiAttivi1;
        }
        System.out.println("biglietto non trovato tra gli attivi");
        return null;
    }
    
    public Biglietto getBigliettoUscita(int cod){
        for(Biglietto BigliettiAttivi1 : BigliettiUscita){
            if(BigliettiAttivi1.getCodice()==cod)
                return BigliettiAttivi1;
        }
        System.out.println("biglietto non trovato tra quelli in uscita");
        return null;
    }
    
    
    public void Pagamento(int cod){
        try{
            C.calcolaImporto(getBigliettoAttivo(cod));
            System.out.println("-----\ttransazione");
        if(C.transazione(4, 4, 4, 4, 4)){
            getBigliettoAttivo(cod).setConvalida(true);
            getBigliettoAttivo(cod).setDataConvalida(C.getDataCassa());
            getBigliettoAttivo(cod).setOreEMinutiConvalida(C.getOre(), C.getMinuti());
            System.out.println(getBigliettoAttivo(cod).convalida.toString());
            BigliettiUscita.add(getBigliettoAttivo(cod));
            BigliettiAttivi.remove(getBigliettoAttivo(cod));
            
            //PRIMA AVEVO MESSO LA RIMOZIONE DEL BIGLIETTO DAGLI ATTIVI QUI, SUBITO DOPO IL PAGAMENTO QUINDI ORA È IN USCITA
            //se voglio metterlo qua incontro un errore perche in uscita non posso cercare il biglietto tra gli attivi e 
            //quindi dovrei utilizzare un altra lista apposta per i biglietti pagati in attesa di uscita dal parcheggio
            //abbastanza inutile? no guardare main
        }
        }catch(NullPointerException e){ System.out.println("biglietto non trovato per il pagamento"); }
    }

    public void decrementaOccupati() {
        this.nOccupati = nOccupati--;
        if(nOccupati<0){System.out.println("Abbiamo un problema i posti occupati non possono essere < 0");}
        
    }
//in uscita si deve:
//                      -   (alzare la sbarra) da fare con interfaccia                  (DA FARE)                 
//                      -   liberare il postoauto                                       (DA FARE)
    public String Uscita(int cod){
        if(MU.controllaBiglietto(getBigliettoUscita(cod))){
            decrementaOccupati();
            RegistroBiglietti.add(getBigliettoUscita(cod));
            BigliettiUscita.remove(getBigliettoUscita(cod));
            return "Grazie. Arrivederci";}
        else{
            return "Errore in uscita";
        }
    }
    
    
    
    
    
    
    
    
}
