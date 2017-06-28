/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author luca
 */
public class Cassa {
    private PagamentoStrategy pagamento;
    private int giorno=0;
    private int mese=0;
    private int anno=0;
    private int ore=0;
    private int minuti=0;
    private int secondi=0;
    private String data = null;
    private String ora = null;
    private int prezzo=0;
    private int prezzoOrario = 1;
    private int somma=0;
    private int ammount=0;

    public void setPagamento(PagamentoStrategy pagamento) {
        this.pagamento = pagamento;
    }
    
    public int calcolaImporto(Biglietto big){
        
        getDate();
        getHours();
       
        int orepermanenza=ore-big.getOre();
        int minpermanenza=minuti-big.getMinuti();
        int annipermanenza=anno-big.getAnno();
        int mesipermanenza=mese-big.getMese();
        int giornipermanenza=giorno-big.getGiorno();
        
        if(annipermanenza!=0){return prezzo=750*annipermanenza;}
        if(mesipermanenza!=0){return prezzo=100*mesipermanenza;}
        if(giornipermanenza>=7){return 20*(giornipermanenza/7);}
        
        if(minpermanenza==0){
            System.out.println("Ore di permanenza: "+orepermanenza);
            if(orepermanenza!=0){
                return prezzo=orepermanenza*prezzoOrario;
            }else{
                System.out.println("Ore di permanenza nulle, ritorno prezzo default 4,04 €");
                return prezzo=404;
            }
        }else{
            return prezzo=(orepermanenza+1)*prezzoOrario;
        }
    }
    
    private void getDate(){
        Calendar cal =  Calendar.getInstance();
        giorno = cal.get(Calendar.DATE);
        mese = cal.get(Calendar.MONTH) +1;
        anno = cal.get(Calendar.YEAR);
        data = giorno +"/"+ mese +"/"+ anno;
    }

    private void getHours(){
        Calendar cal = Calendar.getInstance();
        ore = cal.get(Calendar.HOUR);
        minuti = cal.get(Calendar.MINUTE);
        secondi = cal.get(Calendar.SECOND);
        ora = cal.get(Calendar.HOUR) + ":"+ cal.get(Calendar.MINUTE) + "." + cal.get(Calendar.SECOND);
    }
    
    //accetta solo banconote da 5      10     20     50     100
    public boolean transazione(int a, int b, int c, int d, int e,String metodo){
        if (metodo.equals("contanti")){
            this.pagamento = new ConcreteStrategyA();
        }
        else if (metodo.equals("carta")){
            this.pagamento = new ConcreteStrategyB();
        }
        else {
            System.out.println("altro");
        }
        boolean bool = pagamento.Behavior(a, b, c, d, e, this.prezzo);
        System.out.println("bool: "+bool);
        if (bool)
            this.ammount+=prezzo;
        return bool;
    }

    public int getSomma() {
        return somma;
    }

    public String getDataCassa(){
            return data;
    }

    public int getOre() {
        return ore;
    }

    public int getMinuti() {
        return minuti;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public int getPrezzoOrario() {
        return prezzoOrario = 1;
    }
}
