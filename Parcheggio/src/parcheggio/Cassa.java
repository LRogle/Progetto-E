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
    private int ammount=0;
    private int resto=0;

    

    public int ritira(){
        int tmp = this.ammount;
        ammount = 0;
        return tmp;
    }

    public int getAmmount() {
        return ammount;
    }
    
    public void setPagamento(PagamentoStrategy pagamento) {
        this.pagamento = pagamento;
    }
   
    /**
     * Vengono calcolati i minuti, le ore, i giorni, i mesi e gli anni di permanenza utilizzando la data e l'ora attuale.
     * In base al risultato ottenuto e alle opportune verifiche sul tempo di permanenza, vengono applicate le tariffe fissate dalla tabella allegata alla documentazione.
     * @param big
     * @return prezzo calcolato
     */
    public int calcolaImporto(Biglietto big){
        
        getDate();
        getHours();
        prezzo=0;
       
        int orepermanenza=ore-big.getOre();
        int minpermanenza=minuti-big.getMinuti();
        int annipermanenza=anno-big.getAnno();
        int mesipermanenza=mese-big.getMese();
        int giornipermanenza=giorno-big.getGiorno();
        
        int minutitotali = (giornipermanenza*1440)+(orepermanenza*60)+(minpermanenza);
        
        if(minutitotali<=10){
            System.out.println("sosta minore di 10 minuti, convalida gratuita");
            prezzo=0;  
        }else{
            
        if(minutitotali>=(60*24*7)){   
            prezzo = prezzo + 50*((minutitotali)/(60*24*7));
            minutitotali = minutitotali - (60*24*7);
        }
        if(minutitotali>=60*24){   
            prezzo = prezzo + (minutitotali/(60*24))*15;
            minutitotali = minutitotali - (60*24);
        }
        if(minutitotali>=60*10){   
            prezzo = prezzo + 10;
        }
        else if(minutitotali>=60*5){   
            prezzo = prezzo + 5;
        }
        else if(minutitotali>=60*2){   
            prezzo = prezzo + 2;
        }
        else if(minutitotali>=60){   
            prezzo = prezzo + 1;
        }
        else if(minutitotali>10 && minutitotali<60){
            prezzo = prezzo + 1;  
        }
        }
        
        return prezzo;
        
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
    
    /**
     * In base al metodo di pagamento scelto, viene implementata una delle due strategie di pagamento.
     * Nel caso dell'utilizzo del pagamento in contanti, è prevista l'erogazione del resto.
     * In caso il pagamento venga effettuato correttamente, l'importo del biglietto viene aggiunto all'ammontare della cassa.
     * @param a
     * @param b
     * @param c
     * @param d
     * @param e
     * @param metodo
     * @return true, in caso in cui la transazione abbia esito positivo, oppure false,
     */
    public boolean transazione(int a, int b, int c, int d, int e, String metodo){
        if (metodo.equals("contanti")){
            this.pagamento = new ConcreteStrategyA();
            int somma= (a*1)+(b*2)+(c*5)+(d*10)+(e*20);
            setResto(somma-prezzo);
            
        }
        else if (metodo.equals("carta")){
            this.pagamento = new ConcreteStrategyB();
        }
        else {
            System.out.println("altro");
        }
        boolean bool = pagamento.Behavior(a, b, c, d, e, this.prezzo);
        if (bool){
            if(pagamento instanceof ConcreteStrategyA){
                System.out.println("Resto: " + getResto() + "€");
            }
            this.ammount+=prezzo;
            System.out.println("\nAmmontare nella cassa:" + ammount);
        }
        return bool;
    }

    /**
     * Getter della data registrata dalla cassa.
     * @return data registrata dalla cassa
     */
    public String getDataCassa(){
            return data;
    }

    /**
     * Getter dell'ora attuale.
     * @return 
     */
    public int getOre() {
        return ore;
    }

    /**
     * Getter del minuto attuale.
     * @return 
     */
    public int getMinuti() {
        return minuti;
    }

    /**
     * Getter del prezzo del biglietto.
     * @return prezzo del biglietto
     */
    public int getPrezzo() {
        return prezzo;
    }

    /**
     * Setter del prezzo del biglietto.
     * @param prezzo 
     */
    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * Getter dell'eventuale resto erogato.
     * @return resto erogato
     */
    public int getResto() {
        return resto;
    }

    /**
     * Setter dell'eventuale resto erogato.
     * @param resto 
     */
    public void setResto(int resto) {
        this.resto = resto;
    }

}
