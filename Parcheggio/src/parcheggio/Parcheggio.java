/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;

import static java.lang.Math.floor;
import java.util.ArrayList;
import java.util.Scanner;
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
    
    public Biglietto Ingresso(){
        if(contaPostiLiberi()!=0){ 
            Biglietto B=MI.erogaBiglietto();
            BigliettiAttivi.add(B);
            occupaPosto();
            nOccupati++;
            this.notifyObserver();
            return B;}
        else
            return null;
    }
    
    //INGRESSO PER GRAFICA
    public int IngressoGUI(){
        if(contaPostiLiberi()!=0){ 
            Biglietto B=MI.erogaBiglietto();
            BigliettiAttivi.add(B);
            occupaPosto();
            nOccupati++;
            this.notifyObserver();
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
    
    public void Pagamento(int cod){
        try{
            C.calcolaImporto(getBigliettoAttivo(cod));
            System.out.println("-----\ttransazione");
            int euro;
            int cent50;
            int cent20;
            int cent10;
            int cent5;
            Scanner scanner = new Scanner(System.in);
            for (;;) {
                System.out.println("Inserisci importo:");
                System.out.print("1 €: ");
                euro = scanner.nextInt();
                System.out.print("50 cent: ");
                cent50 = scanner.nextInt();
                System.out.print("20 cent: ");
                cent20 = scanner.nextInt();
                System.out.print("10 cent: ");
                cent10 = scanner.nextInt();
                System.out.print("5 cent: ");
                cent5 = scanner.nextInt();
                if (C.transazione(cent5, cent10, cent20, cent50, euro)) {
                    break;
                }
            }
            getBigliettoAttivo(cod).setConvalida(true);
            getBigliettoAttivo(cod).setDataConvalida(C.getDataCassa());
            getBigliettoAttivo(cod).setOreEMinutiConvalida(C.getOre(), C.getMinuti());
            System.out.println(getBigliettoAttivo(cod).convalida.toString());
            BigliettiUscita.add(getBigliettoAttivo(cod));
            BigliettiAttivi.remove(getBigliettoAttivo(cod));
        } catch(NullPointerException e) { 
            System.out.println("biglietto non trovato per il pagamento");
        }
    }
    
    public boolean PagamentoGUI(int cent5, int cent10, int cent20, int cent50, int euro, int cod){
        try{
            if (C.transazione(cent5, cent10, cent20, cent50, euro)){
                //pagamento andato a buon fine
                getBigliettoAttivo(cod).setConvalida(true);
                getBigliettoAttivo(cod).setDataConvalida(C.getDataCassa());
                getBigliettoAttivo(cod).setOreEMinutiConvalida(C.getOre(), C.getMinuti());
                BigliettiUscita.add(getBigliettoAttivo(cod));
                BigliettiAttivi.remove(getBigliettoAttivo(cod));
                return true;
            }else{ 
                //pagamento errato
                return false;
            }  
        }catch(NullPointerException e) { 
            System.out.println("biglietto non trovato per il pagamento");
            return false;
        }
    }

    public void decrementaOccupati() {
        liberaPosto();
        nOccupati--;
        if(nOccupati<0)
            System.out.println("Abbiamo un problema i posti occupati non possono essere < 0");
        this.notifyObserver();
    }
    
    public void liberaPosto(){
        for(PostoAuto PA : PostiAuto){
            if(PA.isOccupato())
                PA.setOccupato(false);
        }
    }
    
//in uscita si deve:
               
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
    
    private int postoRandom(){
        int b = nMaxParcheggi; 
        double cod= floor(Math.random() * b);
        int postoRandom=(int) cod;
        return postoRandom;
    }
    
    private void occupaPosto(){
        for(PostoAuto PA : PostiAuto){
            if(PA.getNumeroPosto()==postoRandom())
                PA.setOccupato(true);
        }
    }
    
    @Override
    public int getState() {
        return this.contaPostiLiberi();
    }
    
}
