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
    
    //accetta solo              1      2     5       10     20
    public boolean transazione(int a, int b, int c, int d, int e, String metodo){
        if (metodo.equals("contanti")){
            this.pagamento = new ConcreteStrategyA();
            int somma= (a*1)+(b*2)+(c*5)+(d*10)+(e*20);
            setResto(somma-prezzo);
            System.out.println("Resto: " + getResto() + "€");
            
        }
        else if (metodo.equals("carta")){
            this.pagamento = new ConcreteStrategyB();
        }
        else {
            System.out.println("altro");
        }
        boolean bool = pagamento.Behavior(a, b, c, d, e, this.prezzo);
        if (bool){
            this.ammount+=prezzo;
            System.out.println("\nAmmontare nella cassa:" + ammount);
        }
        return bool;
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

    public int getResto() {
        return resto;
    }

    public void setResto(int resto) {
        this.resto = resto;
    }
    
    


    
    
    

}
