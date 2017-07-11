/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;

import static java.lang.Math.floor;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import observerpattern.Observable;

/**
 *
 * @author luca
 */
public class Parcheggio extends Observable {
    
    private int nOccupati;
    private final int nMaxParcheggi;
    private final ArrayList<Biglietto> BigliettiAttivi;
    private final ArrayList<Biglietto> BigliettiUscita;
    private final ArrayList<Biglietto> RegistroBiglietti;
    private final MacchinettaIngresso MI;
    private final Cassa C;
    private final MacchinettaUscita MU;
    private final ArrayList<PostoAuto> PostiAuto;
    
    public Parcheggio(){
        super();
        nOccupati=0;
        nMaxParcheggi=20;
        BigliettiAttivi = new ArrayList();
        BigliettiUscita = new ArrayList();
        RegistroBiglietti = new ArrayList();
        PostiAuto = new ArrayList();
        MI = new MacchinettaIngresso();
        C = new Cassa();
        MU = new MacchinettaUscita();
        aggiungiPostiAuto();
    }
    
    public void aspetta(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Parcheggio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void aggiungiPostiAuto(){
        for(int i=1;i<=nMaxParcheggi;i++){
            PostiAuto.add(new PostoAuto(i));
        }
    }
    
    public Cassa getCassa() {
        return this.C;
    }
    
    public int contaPostiLiberi(){
        int liberi = nMaxParcheggi - nOccupati;
        System.out.println("Totale parcheggi:\t"+nMaxParcheggi+"\tparcheggi occupati:\t"+nOccupati);
        return liberi;
    }
    /**
     * La macchinetta d'ingresso,nel caso in cui ci siano posti liberi, eroga un biglietto che si aggiunge alla lista degli attivi.
     * Viene occupato un posto, quindi cresce il numero di posti occupati e viene lanciata una notifica che certifica che il posto è stato occupato.
     * @return codice del biglietto erogato
     */
   public int Ingresso(){
        if(contaPostiLiberi()!=0){ 
            Biglietto B=MI.erogaBiglietto();
            BigliettiAttivi.add(B);
            occupaPosto();
            nOccupati++;
            this.notifyOccupa(B.getCodice());
            System.out.println("codice: "+B.getCodice());
            return B.getCodice();
        }
        else
            return 0;
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
    
    /**
     * Se la transazione() è andata a buon fine, si convalida il biglietto corrisponde al codice immesso, viene settata la data e l'ora di convalida
     * ed il biglietto viene aggiunto alla lista dei biglietti in uscita.
     * Conseguentemente, il biglietto viene rimosso dalla lista degli attivi.
     * @param cent5
     * @param cent10
     * @param cent20
     * @param cent50
     * @param euro
     * @param cod
     * @param metodo
     * @return true, se il pagamento va a buon fine, oppure false
     */
    public boolean Pagamento(int cent5, int cent10, int cent20, int cent50, int euro, int cod, String metodo){
        try{
            if (C.transazione(cent5, cent10, cent20, cent50, euro, metodo)){
                getBigliettoAttivo(cod).setConvalida(true);
                getBigliettoAttivo(cod).setDataConvalida(C.getDataCassa());
                getBigliettoAttivo(cod).setOreEMinutiConvalida(C.getOre(), C.getMinuti());
                BigliettiUscita.add(getBigliettoAttivo(cod));
                BigliettiAttivi.remove(getBigliettoAttivo(cod));
                return true;
            }else{ 
                return false;
            }  
        }catch(NullPointerException e) { 
            System.out.println("biglietto non trovato per il pagamento");
            return false;
        }
    }
/**
 * Libera un posto attraverso il metodo liberaPosto(). Viene diminuito il numero dei posti occupati e gestisce il caso in cui i posti occupati siano minori di 0.
 */
    public void decrementaOccupati() {
        liberaPosto();
        nOccupati--;
        if(nOccupati<0){
            System.out.println("Abbiamo un problema i posti occupati non possono essere < 0");
        }
    }
   /**
    * Facendo un controllo sull'ArrayList di posti auto, viene liberato il primo posto che risulta essere occupato.
    */ 
    public void liberaPosto(){
        for(PostoAuto PA : PostiAuto){
            if(PA.isOccupato())
                PA.setOccupato(false);
        }
    }
    
    /**
     * Controllando che il codice inserito corrisponda ad uno di quelli dei biglietti in uscita, viene chiamata la funzione decrementaOccupati(),
     * che libera il posto. Il biglietto viene aggiunto alla lista dei codici utilizzati nel corso della giornata e poi viene rimosso dalla lista dei biglietti in uscita.
     * Viene inviata una notifica con il codice del biglietto corrispondente.
     * @param cod
     * @return messaggio di avvenuta uscita
     */
    public String Uscita(int cod){
        if(MU.controllaBiglietto(getBigliettoUscita(cod))){
            decrementaOccupati();
            RegistroBiglietti.add(getBigliettoUscita(cod));
            BigliettiUscita.remove(getBigliettoUscita(cod));
            this.notifyLibera(cod);
            return "Grazie. Arrivederci";}
        else{
            return "Errore in uscita";
        }
    }
    
    /**
     * Viene scelto un numero a caso tra 0 e 20 che rappresenta il numero di posto che verrà occupato.
     * @return postoRandom
     */
    private int postoRandom(){
        int b = nMaxParcheggi; 
        double cod= floor(Math.random() * b);
        int postoRandom=(int) cod;
        return postoRandom;
    }
    
    /**
     *  Facendo un controllo sull'ArrayList di posti auto, viene occupato un posto random che risulta essere libero.
     */
    private void occupaPosto(){
        for(PostoAuto PA : PostiAuto){
            if(!(PA.isOccupato()) && PA.getNumeroPosto()==postoRandom())
                PA.setOccupato(true);
        }
    }
    
}
